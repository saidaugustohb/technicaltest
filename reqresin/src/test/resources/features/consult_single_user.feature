#language:es
Característica: Yo como cliente deseo un api que me permita visualizar un solo usuario por id

  @ConsultUser
  Escenario: : Consultar usuario por id
    Dado que el 'usuario' realiza la conexion con el API de reqresin
    Cuando el consulta el usuario con id 2 en la direccion '/users/'
    Entonces el deberia obtener un estado 200 de peticion exitosa
    Y debera visualizar la informacion del usuario consultado



