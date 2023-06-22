from typing import List, Optional

from fastapi import APIRouter, Request

from fastapi.templating import Jinja2Templates
from .crud import *
from .schemas import *
from .database import *

corona_app = APIRouter()

templates = Jinja2Templates(directory='./templates')

corona_database = get_session()


@corona_app.get('/get_cities', response_model=List[ReadCity])
def get_cities(skip: int = 0, limit: int = 100, db=corona_database):
    cities = crud_get_cities(db, skip, limit)
    return cities


@corona_app.post('/create_data', response_model=ReadData)
def create_data_for_city(city: str, data: CreateData, db=corona_database):
    db_city = crud_get_city_by_name(db, city)
    data = crud_create_city_data(db, data, city_id=db_city.city_id)
    return data


@corona_app.get('/get_data')
async def get_data(city: Optional[str] = None, skip: Optional[int] = 0, limit: int = 100, db=corona_database):
    data = crud_get_data(db, city, skip, limit)
    return data


@corona_app.get('/')
def coronavirus(request: Request, city: str = None, skip: int = 0, limit: int = 100, db=corona_database):
    data = crud_get_data(db, city, skip, limit)
    return templates.TemplateResponse('home.html', {
        'request': request,
        'data': data,
        'sync_data_url': '/coronavirus/sync_data/jhu'
    })
