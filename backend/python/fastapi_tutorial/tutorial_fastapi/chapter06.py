from fastapi import APIRouter, Depends, HTTPException, status
from pydantic import BaseModel
from typing import Optional
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm
from passlib.context import CryptContext
import jose
from jose.exceptions import JWTError
from datetime import datetime, timedelta

tutorial6 = APIRouter()
"""
OAuth2.0 的授权模式

1. 授权码授权模式(Authorization Code Grant)

2. 隐式授权模式(Implicit Grant)

3. 密码授权模式(Resource Owner Password Credentials Grant)
    - 本章节将展示次方法。其他方法不做讲解

4. 客户端凭证授权模式(Client Credentials Grant)
"""

"""
OAuth2 密码模式和 FastAPI 的 OAuth2PasswordBearer

- OAuth2PasswordBearer 是接受URL参数的一个类：客户端会向该URL发送username和password参数，然后得到一个token值
- OAuth2PasswordBearer 并不会创建响应的URL路径操作，只是知名客户端用来请求Token的URL地址
  当请求到来的时候，FastAPI会检查请求的Authorization头信息，如果没有找到Authorization头信息，或者头信息内容不是 Bearer token，它会返回401状态码（UNAUTHORIZED）
"""
oauth2_schema = OAuth2PasswordBearer(tokenUrl='/c6/token')


@tutorial6.get('/oauth2_password_bearer')
async def oauth2_password_bearer(token: str = Depends(oauth2_schema)):
    return {'token': token}


"""
基于 Password 和Bearer token 的 OAuth2 认证
"""
fake_user_db = {
    'john': {
        'username': 'john',
        'full_name': 'John Snow',
        'email': 'johnsnow@example.com',
        'hashed_password': 'fakehashedpassword',
        'disabled': False
    },
    'alice': {
        'username': 'alice',
        'full_name': 'Alice Wonderson',
        'email': 'alicewonderson@example.com',
        'hashed_password': 'fakehashedsecret',
        'disabled': True
    }
}


def fake_hash_password(password: str):
    return 'fakehashed' + password


class User(BaseModel):
    username: str
    full_name: Optional[str]
    email: Optional[str]
    disabled: Optional[bool]


class UserInDB(User):
    hashed_pass: str


def get_user(db, username: str):
    if username in db:
        user_dict = db[username]
        return UserInDB(**user_dict)


def fake_decode_token(token: str):
    user = get_user(fake_user_db, token)
    return user


def get_current_user(token: str = Depends(oauth2_schema)):
    user = fake_decode_token(token)
    if not user:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED
            , detail="Invalid authorization credentials"
            , headers={"WWW-Authenticate": 'Bearer'}
        )
    return user


def get_current_active_user(current_user: User = Depends(get_current_user)):
    if current_user.disabled:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST,
            detail="Inactivate User"
        )
    return current_user


@tutorial6.post('/token')
async def login(form_data: OAuth2PasswordRequestForm = Depends()):
    user_dict = fake_user_db.get(form_data.username)
    if not user_dict:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail='Incorrect Username and Password')

    user = User(**user_dict)
    hashed_password = fake_hash_password(form_data.password)

    if not hashed_password == user.password:
        pass
    return {'access_token': user.username, 'token_type': 'bearer token'}


@tutorial6.get('/users/me')
async def read_user_activation_status(current_user: User = Depends(get_current_active_user)):
    return current_user


"""
OAuth2 with Password (and hashing), Bearer with JWT tokens 开发基于 Json Web Tokens 的认证
Json Web Token 

1. Browser(POST/users/login with username and password) ---> Server
2. Server(Creates a JWT with a secret) 
3. Server(Returns the JWT to the Browser) ---> Browser
4. Browser(Sends the JWT on the Authorization Header) ---> Server
5. Server(Check JWT signature. Get user information from JWT)
6. Server(Sends response to the client) ---> Browser
"""

fake_user_db.update({
    "john snow": {
        'username': 'john snow',
        'full_name': 'John Snow',
        'email': 'johnsnow@example.com',
        'hashed_password': 'T3h8etU93wWb2S1sqgV1uaJlCPIJ/4YHDgC2u5GT7+k=',
        'disabled': False
    }
})

# 1. 可以先生成一个secret 可以；在 Linux下可以使用 openssl rand -hex 32
SECRET_KEY = 'a68a5d0d57ea86ae7728534a174d9702e71e864343bfaf94c2298a59ad09092d'
ALGORITHM = 'HS256'  # algorithm
ACCESS_TOKEN_EXPIRE_MINUTES = 30  # 访问令牌过期分钟


class Token(BaseModel):
    """
    The token which will return to the user
    """
    access_token: str
    token_type: str


pwd_context = CryptContext(schemes=['bcrypt'])
oauth2_schema_jwt = OAuth2PasswordBearer(tokenUrl='/jwt/token')


def verify_password(plain_password: str, hashed_password: str):
    """
    Verify Password
    :param plain_password:
    :param hashed_password:
    :return: either True or False
    """
    return pwd_context.verify(plain_password, hashed_password)


def jwt_get_user(db, username: str):
    if username in db:
        user_dict = db[username]
        return UserInDB(**user_dict)
    return None


def jwt_authenticate_user(db, username: str, password: str):
    user = jwt_get_user(db, username)
    if not user:
        return False
    if not verify_password(plain_password=password, hashed_password=user.hashed_pass):
        return False
    return user


def create_access_token(data: dict, expires_delta: Optional[timedelta] = None):
    to_encode = data.copy()

    if expires_delta:
        expire = datetime.utcnow() + expires_delta
    else:
        expire = datetime.utcnow() + timedelta(minutes=15)
    to_encode.update({
        "exp": expire
    })
    encoded_jwt = jose.jwt.encode(claims=to_encode, key=SECRET_KEY, algorithm=ALGORITHM)
    return encoded_jwt


@tutorial6.post('/jwt/token', response_model=Token)
async def login_for_access_token(form_data: OAuth2PasswordRequestForm = Depends()):
    user = jwt_authenticate_user(fake_user_db, form_data.username, password=form_data.password)
    if not user:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail='Incorrect username or password',
            headers={
                "WWW-Authenticate": "Bearer"
            }
        )
    access_token_expires = timedelta(minutes=ACCESS_TOKEN_EXPIRE_MINUTES)
    access_token = create_access_token(
        data={'sub': user.username},
        expires_delta=access_token_expires
    )
    return {
        'access_token': access_token,
        'token_type': 'bearer'
    }


async def jwt_get_current_user(token: str = Depends(oauth2_schema_jwt)):
    err = HTTPException(
        status_code=status.HTTP_401_UNAUTHORIZED,
        detail='Incorrect username or password',
        headers={
            "WWW-Authenticate": "Bearer"
        }
    )
    try:
        payload = jose.jwt.decode(token=token, key=SECRET_KEY, algorithms=[ALGORITHM])
        username = payload.get('sub')
        if username is None:
            raise err
    except JWTError:
        raise err
    user = jwt_get_user(db=fake_user_db, username=username)

    if user is None:
        raise err
    return user


async def jwt_get_current_active_user(current_user: User = Depends(jwt_get_user)):
    if current_user.disabled:
        raise HTTPException(status_code=status.HTTP_400_BAD_REQUEST, detail="Inactivate User")


@tutorial6.get('/jwt/users/me')
async def jwt_read_users_me(current_user: User = Depends(jwt_get_current_active_user)):
    return current_user
