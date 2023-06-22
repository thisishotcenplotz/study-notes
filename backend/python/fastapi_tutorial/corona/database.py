from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker, scoped_session, DeclarativeBase


def get_session():
    url = 'mysql+pymysql://root:abcd1234@localhost:3306/corona'
    engine = create_engine(url=url, pool_size=5, max_overflow=5, echo=True)
    session = scoped_session(sessionmaker(bind=engine))
    return session


def get_engine():
    url = 'mysql+pymysql://root:abcd1234@localhost:3306/corona'
    engine = create_engine(url=url, pool_size=5, max_overflow=5, echo=True)
    return engine


