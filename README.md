## Integración en linea - Microservicios
#### Paul Velasco
La empresa XYZ ha tenido un crecimiento constante, paso de tener una oficina a tener 20 oficinas en todo el país, además de abrir presencia en plataformas para masificar sus productos y atraer a más clientes utilizando Facebook y WhatsApp para empresas, en donde de igual manera ha tenido una gran acogida; utilizan la versión comercial en la nube del fabricante de Odoo, reduciendo los problemas de lentitud e intermitencia que tenían entre las diferentes oficinas, con la finalidad de gestionar de una manera adecuada a la gran cantidad de clientes que actualmente tiene la empresa, han utilizado el módulo de CRM con buenos resultados.

Por relaciones comerciales, la empresa paso a formar parte de un consorcio o grupo con la finalidad de generar negocios entre las empresas del grupo, por lo que dentro del grupo existen empresas especializadas para manejar perfiles de clientes en función de la preferencia de compra de los clientes.

La empresa XYZ ya tiene perfilado a sus clientes por medio del módulo del CRM
La empresa 123 es una empresa especializada en manejar clientes cuyo perfil de compras en linea, son clientes que realizan todas sus transacciones solamente por canales digitales.
La empresa ABC se especializa en manera clientes que si bien son abordados en linea, la compras y la transacción la prefieren realizar por canales presenciales como las oficinas.
Se necesita una solución en linea que permita pasar los clientes de la empresa XYZ a las empresas 123 y ABC en función del perfil del canal de compras del cliente, las empresas 123 y ABC utilizan sistemas de información o plataformas distintas, han logrado desarrollar un servicio web para recibir la información del cliente de la empresa XYZ, se han puesto de acuerdo para intercambiar la información en forma JSON.

Desarrolle una solución tipo prueba de concepto, que permita realizar un escenarios que simule el ambiente antes descrito, utilizando un framework de integración asi como un patrón de integración que permita transmitir la información de los clientes.

## Propósito
```
                                       --> Cliente canal 1  --> canal-digital-py
Cliente --> spring-camel-integration /
                                     \
                                       -->  Cliente canal 2 --> canal-efectivo-dotnet
```
### Iniciar Servicio 1 de Flask:
```
# cd canal-digital-py
# cd venv
# cd Scripts
# activate
# cd..
# cd..
# Flask --app main run
```
### EndPoints FLASK:
#### GET
- http://localhost:5000/clientes
- http://localhost:5000/cliente/100
#### POST
- http://localhost:5000/cliente
- {
    "codigo": 111,
    "identificacion": 111,
    "nombre": "cliente para FLASK",
    "canal": 1
}

### Iniciar Servicio 2 de DotNet
```
# cd canal-efectivo-dotnet\canal-efectivo-dotnet
# dotnet watch run --environment Development
```
### EndPoints en .NET:
#### GET
- http://localhost:9000/Client
- http://localhost:9000/Client/200
#### POST
- http:localhost:9000/Client
- {
    "codigo": 222,
    "identificacion": 222,
    "nombre": "cliente para DOTNET",
    "canal": 2
}

### Iniciar Servicio Integrador de Spring Camel
```
# cd spring-camel-integration
# mvn install
# mvn spring-boot:run
```
### EndPoints en Spring Camel JAVA:
#### GET CLIENTES DE FLASK
- http://localhost:8080/listaclientesflask
- http://localhost:8080/listaclienteflask/100

#### GET CLIENTES DE .NET
- http://localhost:8080/listaclientesdotnet
- http://localhost:8080/listaclientedotnet/200

#### POST
- En esta seccion dependiendo del canal se inserta la Data en FLASK (canal 1), DotNET (canal 2)
- http://localhost:8080/canal
- {
    "codigo": 222,
    "identificacion": 222,
    "nombre": "cliente para DOTNET",
    "canal": 2
}
- {
    "codigo": 111,
    "identificacion": 111,
    "nombre": "cliente para FLASK",
    "canal": 1
}
