#language:es
Característica: Yo como cliente deseo un api que me permita eliminar usuarios de mi sistema

  @DeleteUser
  Esquema del escenario: Validar la eliminacion de un usuario
    Dado que el 'cliente' realiza la conexion con el API de reqresin
    Cuando el elimina un usuario con el id <id> en la direccion '/users/'
    Entonces el deberia obtener un estado 204 sin contenido
    Cuando el consulta el usuario con id <id> en la direccion '/users/'
    Entonces al consultar el usuario este no debe existir retornando un estado 404

    Ejemplos:
    |id|
    | 8|
    |23|


