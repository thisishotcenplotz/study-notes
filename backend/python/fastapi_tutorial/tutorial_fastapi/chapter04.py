from fastapi import APIRouter, status, Form, File, UploadFile, HTTPException
from pydantic import BaseModel, EmailStr
from typing import Optional, List, Union

tutorial4 = APIRouter()

"""
Response Model 响应模式
"""


class UserIn(BaseModel):
    username: str
    password: str
    email: EmailStr
    mobile: str = '10086'
    address: str = None
    full_name: Optional[str] = None


class UserOut(BaseModel):
    username: str
    email: EmailStr
    mobile: str = '10086'
    address: str = None
    full_name: Optional[str] = None


users = {
    'user1': {
        'username': 'user11',
        'password': '123456',
        'email': 'usr1@example.com',
        'address': '690 Moris Rd Kent,OH 44240',
        'full_name': 'Der Hotcenplotz'
    },
    'user2': {
        'username': 'user22',
        'password': '123456789',
        'email': 'usr2@example.com',
        'mobile': '(330)-593-1258',
        'address': '201 Wilson Ave Kent,OH 44240',
        'full_name': 'The Greatest Robber'
    }
}


@tutorial4.post('/response_model', response_model=UserOut, response_model_exclude_unset=True)
async def response_model(user: UserIn):
    print(user.password)
    return users['user2']


@tutorial4.post('/response_model/attributes', response_model=Union[UserIn, UserOut])
async def response_model_attributers(user: UserIn):
    return user


"""
Response Status Codes 响应状态码
"""


@tutorial4.post('/status_code', status_code=status.HTTP_200_OK)
async def status_code():
    return {
        'status_code': 200
    }


@tutorial4.post('/status_code/a', status_code=status.HTTP_200_OK)
async def status_code():
    return {
        'status_code': status.HTTP_200_OK
    }


"""
Form Data 表单数据处理
"""


@tutorial4.post('/login')
async def login(user: str = Form(...), password: str = Form(...)):
    return {
        'user_name': user
    }


"""
Request Files 单文件、多文件上传及参数详解
"""


@tutorial4.post('/file')
async def files_(file: List[bytes] = File(...)):
    return {
        'file_size': len(file)
    }


@tutorial4.post('/upload_files')
async def upload_files(files: List[UploadFile] = File(...)):
    """
    使用UploadFile类的优势
    1.文件储存在内存中，使用的内存达到阈值后，将被保存在磁盘中
    2.适合于图片、视频大文件
    3.FastAPI 可以帮我们获取上传文件的元数据，如文件名、创建时间等等。
    4.有文件对象的异步接口
    5.上传的文件是Python文件对象，可以使用write(),read(),seek(),close()等操作。
    :param file:
    :return:
    """
    for file in files:
        contents = await file.read()
        print(contents)
    return {'filename': files[0].filename, 'content_type': files[0].content_type}


"""
【见run.py】FastAPI 项目静态文件配置
"""

"""
Path Operation Configuration 路径操作配置
"""


@tutorial4.post(
    '/path_operation_configuration',
    response_model=UserOut,
    tags=['path', 'operation', 'configuration'],
    summary='This is a summary',
    description='This is the description',
    response_description='This is the response description',
    # deprecated=True,
    status_code=status.HTTP_200_OK
)
async def path_operation_configuration(user: UserIn):
    """

    :param user:
    :return:
    """
    return user.dict()


"""
【见run.py】FastAPI 应用常见配置项
"""

"""
Handling Errors 错误处理
"""


@tutorial4.get('/http_exception')
async def http_exception_handling(city: str):
    if city != 'Beijing':
        raise HTTPException(status_code=404, detail='City Not found!@', headers={'X-Error': 'Error'})
    return city
