#language:es
Característica: Yo como cliente deseo un api que me permita realizar la creacion de usuarios

  @CreateUser
  Escenario: Validar la creacion de un usuario
    Dado que el 'usuario' realiza la conexion con el API de reqresin
    Cuando el realiza la creacion del usuario en la direccion '/users'
      | name     | job               |
      | John Doe | Automation Senior |
    Entonces el deberia obtener un estado 201 de creacion
    Y debera visualizar la informacion del usuario creado


  @CreateUser
  Escenario: Validar la creacion y consulta de un usuario
    Dado que el 'usuario' realiza la conexion con el API de reqresin
    Cuando el realiza la creacion del usuario en la direccion '/users'
      | name     | job               |
      | John Doe | Automation Senior |
    Y se consulta el id del usuario creado en la direccion '/users/'
    Entonces el deberia obtener un estado 200 de peticion exitosa
