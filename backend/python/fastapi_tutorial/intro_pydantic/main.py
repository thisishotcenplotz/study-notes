from datetime import datetime
from typing import List
from typing import Optional

from pydantic import BaseModel


class User(BaseModel):
    id: int
    name: str = "somebody"
    signUp_time: Optional[datetime] = str(datetime.now())
    friends: List[str] = []


data = {
    'id': 123,
    'name': 'george',
    'friends': ['1', '2', '3', 'a']
}

u = User(**data)
u.friends.append('33')
print(u.json())
print(u.dict())
print(u.copy())
print(u.parse_obj(data))
print(u.schema())
print(u.schema_json())
