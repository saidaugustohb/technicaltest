#language:es
Característica: Yo como cliente deseo un api que me permita realizar la actualizacion de usuarios

  @UpdateUser
  Esquema del escenario: : Validar la actualizacion de un usuario
    Dado que el 'usuario' realiza la conexion con el API de reqresin
    Cuando el actualiza el usuario con el id <id> direccion '/users/'
      | name   | job   |
      | <name> | <job> |
    Entonces el deberia obtener un estado 200 de solicitud exitosa
    Cuando el consulta el usuario con id <id> en la direccion '/users/'
    Entonces el debera encontrar el usuario consultado obteniendo un estado 200

    Ejemplos:
      | id  | name     | job               |
      | 220 | John Doe | Automation Senior |
      | 2   | John Doe | Automation Senior |
