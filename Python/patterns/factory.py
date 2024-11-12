from math import factorial


class Car():
    def get_name(self) -> str:
        return 'car'

class Track:
    def get_name(self) -> str:
        return 'track'

class ProduseTrancport:
    def create_transport(self, type: str) -> None:
        if type == 'car':
            return Car()
        elif type == 'track':
            return Track()

factory = ProduseTrancport()
car: Car = factory.create_transport('car')
track: Track = factory.create_transport('track')

print(car.get_name())
print(track.get_name())