from fastapi import APIRouter, Depends, Header, HTTPException
from typing import Optional

tutorial5 = APIRouter()
"""
FastAPI 的依赖注入系统

    `依赖注入`是指在编程中，为保证代码成功运行，先导入或声明其所需要的`依赖`，如子函数、数据库连接等
    
    - 提高代码的复用
    - 共享数据库连接
    - 增强安全、认证和角色管理
"""

"""
Dependencies 创建、导入和声明依赖
"""


async def common_parameters(q: Optional[str] = None, page: int = 1, limit: int = 100):
    return {'q': q, 'page': page, 'limit': limit}


@tutorial5.get('/dependency01')
async def dependency01(commons: dict = Depends(common_parameters)):
    return commons


@tutorial5.get('/dependency02')
def dependency02(commons: dict = Depends(common_parameters)):
    return commons


"""
Classes as Dependencies 类作为依赖项
"""
fake_item_db = [{'item_name': 'foo'}, {'item_name': 'Bar'}, {'item_name': 'Baz'}]


class CommonQuery:
    def __init__(self, q: Optional[str] = None, page: int = 1, limit: int = 100):
        self.q = q
        self.page = page
        self.limit = limit


@tutorial5.get('/classes_as_dependencies/a')
async def classes_as_dependencies_a(commons: CommonQuery = Depends(CommonQuery)):
    response = dict()
    if commons.q:
        response.update({'q': commons.q})
    items = fake_item_db[commons.page:commons.page + commons.limit]
    response['items'] = items
    return response


@tutorial5.get('/classes_as_dependencies/b')
async def classes_as_dependencies_b(commons: CommonQuery = Depends()):
    pass


@tutorial5.get('/classes_as_dependencies/c')
async def classes_as_dependencies_c(commons=Depends(CommonQuery)):
    pass


"""
Sub-dependencies 子依赖
"""


def query(q: Optional[str] = None):
    return q


def sub_query(q: str = Depends(query), last_query: Optional[str] = None):
    if not q:
        return last_query
    return q


@tutorial5.get('/sub_dependency')
async def sub_dependency_3(final_query: str = Depends(sub_query, use_cache=True)):
    """
    use_cache 默认是true， 表示当多个依赖有一个共同的子依赖时，每次去请求只会调用子依赖一次，多次调用将从缓存中获取，从而提高响应性能
    :param final_query:
    :return:
    """
    return {'result': final_query}


"""
Dependencies in path operation decorators 路径操作装饰中的多依赖
"""


async def verify_token(x_token: str = Header(...)):
    """
    没有返回值的子依赖
    :param x_token:
    :return:
    """
    if x_token != 'fake-super-secret-token':
        raise HTTPException(status_code=400, detail='X-key header invalid')
    return x_token


async def verify_key(x_key: str = Header(...)):
    """

    :param x_key:
    :return:
    """
    if x_key != 'fake-super-secret-key':
        raise HTTPException(status_code=400, detail='X-Key header invalid')
    return x_key


@tutorial5.get('/dependency_in_path_operation', dependencies=[Depends(verify_key), Depends(verify_token)])
async def dependency_in_path_operation():
    return [{'user': 'user1'}, {'user': 'user2'}]


"""
Global Dependencies 全局依赖
"""

# tutorial5 = APIRouter(dependencies=[Depends(verify_token),Depends(verify_key)])
# or run.py
# app = FastAPI(
#     title='FastAPI Tutorial and Coronavirus Tracker API Docs',
#     description='FastAPI Tutorial and Coronavirus Interfaces',
#     version='1.0.0',
#     docs_url='/oops/yo/docs',
#     dependencies=[Depends(verify_token),Depends(verify_key)]
# )


"""
Dependencies with yield 带yield的依赖
用伪代码方式展示
"""


async def get_db():
    db = "db_connection"
    try:
        yield db
    finally:
        db.endswith('db_close')


async def dependency_a():
    dep_a = "generate_dep_a"
    try:
        yield dep_a
    finally:
        dep_a.endswith('db_close')


async def dependency_b(dep_a=Depends(dependency_a)):
    dep_b = 'generate_dep_b()'
    try:
        yield dep_b
    finally:
        dep_b.endswith(dep_a)


async def dependency_c(dep_b=Depends(dependency_b)):
    dep_c = 'generate_dep_b'
    try:
        yield dep_c
    finally:
        dep_c.endswith(dep_b)
