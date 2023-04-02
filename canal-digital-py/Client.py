import json

class Client:

    def __init__(self, codigo, identificacion, nombre, canal):
        self.codigo = codigo
        self.identificacion = identificacion
        self.nombre = nombre
        self.canal = canal

    def to_dict(self):
        return {
            'codigo': self.codigo,
            'identificacion': self.identificacion,
            'nombre': self.nombre,
            'canal': self.canal
        }
      
clients = [
    Client(100, 100, "cli py", 1),
    Client(101, 101, "clic py", 1)
]