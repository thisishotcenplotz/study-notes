from sqlalchemy import Column, String, Integer, BigInteger, Date, DateTime, ForeignKey, func
from sqlalchemy.orm import relationship, DeclarativeBase


class Base(DeclarativeBase):
    pass


class City(Base):
    __tablename__ = 'city'
    id = Column(Integer, primary_key=True, index=True, autoincrement=True)
    province = Column(String(100), unique=True, nullable=False, comment='省、省辖市')
    country = Column(String(100), nullable=False)
    country_code = Column(String(100), nullable=False)
    country_population = Column(BigInteger, nullable=False)
    data = relationship('Data', back_populates='city')

    created_at = Column(DateTime, server_default=func.now())
    updated_at = Column(DateTime, server_default=func.now(), onupdate=func.now())


class Data(Base):
    __tablename__ = 'data'
    id = Column(Integer, primary_key=True, index=True, autoincrement=True)
    city_id = Column(Integer, ForeignKey('city.id'))
    date = Column(Date, nullable=False)
    confirmed = Column(BigInteger, default=0, nullable=False)
    death = Column(BigInteger, default=0, nullable=False)
    recovered = Column(BigInteger, default=0, nullable=False)
    city = relationship('City', back_populates='data')

    created_at = Column(DateTime, server_default=func.now())
    updated_at = Column(DateTime, server_default=func.now(), onupdate=func.now())

# engine = get_engine()
# Base.metadata.create_all(engine)
