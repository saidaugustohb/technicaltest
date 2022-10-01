#language:es
Característica: Yo como cliente deseo un api que me permita visualizar los usuarios paginados

  @SeeAllUser
  Esquema del escenario: : Consultar usuarios paginados
    Dado que el 'usuario' realiza la conexion con el API de reqresin
    Cuando el consulta los usuarios en la pagina <page> en la direccion '/users?page='
    Entonces el deberia obtener un estado 200 de peticion exitosa
    Y debera visualizar la informacion de los usuarios

    Ejemplos:
    |page|
    |1   |
    |2   |

  @SeeAllUser
  Escenario: : Consultar pagina sin usuarios
    Dado que el 'usuario' realiza la conexion con el API de reqresin
    Cuando el consulta los usuarios en la pagina 999 en la direccion '/users?page='
    Entonces el deberia obtener un estado 200 de peticion exitosa
    Y no se debe visualizar ningun usuario

