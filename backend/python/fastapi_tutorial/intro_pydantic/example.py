from datetime import date
from typing import List
from typing import Optional
from decimal import Decimal

from pydantic import BaseModel


class Sound(BaseModel):
    sound: str


class Dog(BaseModel):
    birthday: date = date.today()
    weight: Decimal = Optional[None]
    sound: List[Sound]


puppy = Dog(birthday=date.today(), weight=6.66, sound=[{"sound": "woof~~woof~"}, {'sound': 'ying ying ~~'}])

print(puppy.dict())
