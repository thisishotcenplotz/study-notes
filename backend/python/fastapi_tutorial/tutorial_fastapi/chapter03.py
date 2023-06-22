from datetime import date
from enum import Enum
from typing import Optional, List

from fastapi import APIRouter, Path, Query, Cookie, Header
from pydantic import BaseModel, Field

tutorial3 = APIRouter()

"""
Path parameters and Number Validations 路径参数盒数字验证
"""


class CityName(str, Enum):
    Beijing = 'Beijing'
    Shanghai = 'Shanghai'


@tutorial3.get('/path/parameters')
async def path_params01():
    return {'message': "this is a message"}


@tutorial3.get('/path/{parameters}')
async def path_params01(parameters: str):
    return {'message': "this is a message", 'param': parameters}


@tutorial3.get('/enum/{city}')
async def city_enum(city: CityName):
    if city == CityName.Shanghai:
        return {"city_name": city, "confirmed": 1490, "death": 17}
    if city == CityName.Beijing:
        return {"city_name": city, "confirmed": 2500, "death": 22}
    else:
        return {"city_name": city, "latest": 'unknown'}


@tutorial3.get('/files/{file_path:path}')
async def load_file(file_path: str):
    return f"The file path is {file_path}"


@tutorial3.get('/path_/{num}')
async def path_validation(
        num: int = Path(ge=1, le=10, title='your number', description='不可描述的。。。')
):
    return num


"""
Query Parameters and String Validations 查询参数和字符串验证
"""


@tutorial3.get('/query')
async def page_limit(page: int = 1, limit: Optional[int] = None):
    if limit:
        return {'page': page, 'limit': limit}
    return {'page': page}


@tutorial3.get('/query/bool/conversion')
async def type_conversion(param: bool = False):
    return param


@tutorial3.get('/query/validations')
async def type_validation(
        value: str = Query(..., max_length=16, min_length=8, regex='^a'),
        values: List[str] = Query(default=['v1', 'v2'], alias='test1234')
):
    return values, values


"""
Request body and Fields 请求体和字段
"""


class CityInfo(BaseModel):
    name: str = Field(..., example='Beijing')
    country: str = None
    country_code: str
    population: int = Field(default=800, title='国家的人口数量', ge=800)

    class Config:
        schema_extract = {
            'example': {
                'name': 'shanghai',
                'country': 'China',
                'country_code': 'CN',
                'population': 1400000000
            }
        }


@tutorial3.get('/request_body/city')
async def city_info(city: CityInfo):
    print(city.name, city.country)
    return city.dict()


"""
Request Body + Path parameters + Query parameters 多参数混合
"""


@tutorial3.get('/request_body/city/{name}')
async def mix_city_info(
        name: str,
        city1: CityInfo,
        city2: CityInfo,
        confirmed: int = Query(ge=0, description="确诊数量", default=0),
        death: int = Query(ge=0, description="死亡数量", default=0)

):
    if name == 'Shanghai':
        return {
            "Shanghai": {
                'confirmed': confirmed,
                'death': death
            }
        }
    return city1.dict(), city2.dict()


"""
Request Body - Nested Models 数据格式嵌套的请求体
"""


class Data(BaseModel):
    city: List[CityInfo] = None
    date: date
    confirmed: int = Field(ge=0, default=0, description='确诊人数')
    deaths: int = Field(ge=0, description='死亡人数', default=0)
    recovered: int = Field(ge=0, description='痊愈数', default=0)


@tutorial3.put('/request_body/nested')
async def nested_body(data: Data):
    return data


"""
Cookie and Headers 参数
"""


@tutorial3.get('/cookie')
async def with_cookie(
        cookie_id: Optional[str] = Cookie(None)
):
    return cookie_id


@tutorial3.get('/header')
async def with_header(
        user_agent: Optional[str] = Header(None, convert_underscores=True),
        x_token: List[str] = Header(None)
):
    """
    有些HTTP代理和服务器是不允许在请求头中带有下划线的，所以Header提供convert_underscores属性把下划线转化成中划线
    :param user_agent: convert_underscores=True 会把user_agent 编程user-agent
    :param x_token: 包含多个值得list
    :return:
    """
    return {
        'User-Agent': user_agent,
        'x_token': x_token
    }
