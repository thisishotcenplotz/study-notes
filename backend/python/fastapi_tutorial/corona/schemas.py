from pydantic import BaseModel


class City(BaseModel):
    id: int
    province: str
    country: str


class ReadCity(City):
    pass


class CreateCity(City):
    pass


class Data(BaseModel):
    pass


class ReadData(Data):
    pass

class CreateData(Data):
    pass
