from .models import *
from .schemas import *
from sqlalchemy.orm import scoped_session


def crud_get_city_by_name(db: scoped_session, name: str):
    pass


def crud_get_city(db: scoped_session, city: str):
    pass


def crud_get_cities(db: scoped_session, skip: int, limit: int):
    return 'a'


def crud_get_data(db: scoped_session, city: str, skip: int, limit: int):
    if city:
        return db.query(Data).filter(Data.city.has(province=city))
    return db.query(Data).offset(skip).limit(limit).all()


def crud_create_city_data(db: scoped_session, data: CreateData, city_id):
    db_data = Data(**data.dict(), city_id=city_id)
    db.add(db_data)
    db.commit()
    return db_data
