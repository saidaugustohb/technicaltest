
# Prueba de codificación 

- El proyeto esta desarrollado en [Java](https://www.java.com/es/download/) con openjdk17, y con el gestor de dependecias de [gradle](https://gradle.org/install/) con la versión del gradlewrapper 7.5
- Para la ejecución de projecto se debe usar el gradlewrapper con el comando 

          gradlew bootRun
- El comando citado anteriormente, debe ser ejecutado sobre la ruta de [application](https://github.com/saidaugustohb/technicaltest/tree/develop/application) 

- La aplicacion quedara ejecutando sobre el puerto 8081  http://localhost:8081


# Para la ejecución del proyecto se debe aprovicionar el ambiente de la siguiente forma
- Iniciar la base de datos [Postgres](https://www.postgresql.org/) en un contenedor de Docker local 
    
        docker run -d --rm --name postgres -e POSTGRES_PASSWORD=toor4321 -p 5432:5432 postgres

- Crear la base de datos con algun cliente postgress ejemplo [DBeaver](https://dbeaver.io/download/)
  
        create database empresa OWNER = postgres;

- Crear la tabla en la base de datos

        CREATE TABLE employee (idempleado int NOT NULL PRIMARY KEY,nombre varchar NOT NULL,meses int NOT NULL,salario integer NOT NULL);

- Con  docker compose, ubicados en la ruta [application/docker-compose.yaml](https://github.com/saidaugustohb/technicaltest/blob/master/application/docker-compose.yaml) se configuro
[Kafka](https://kafka.apache.org/) en la maquina local ejecutando el comando 

       docker-compose up -d
    

- Instalamos la base de datos [DynamoDB](https://aws.amazon.com/es/dynamodb/) en un contenedor local

        docker run -d -p 8000:8000 --name my-dynamodb amazon/dynamodb-local

por defecto se genera la siguiente configuracion:

    database endpoint:    http://localhost:8000

    region:               us-east-1

    accessKey:            key

- Instalamos un administrador para DynamoDB:


        npm install -g dynamodb-admin

        set DYNAMO_ENDPOINT=http://localhost:8000

        dynamodb-admin


## API Reference

#### Get employe by month and salary from Postgresql

```http
  Post http://localhost:8081/views?month=0&salary=5000000
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `month` | `Integer` | **Required**.  |
| `salary` | `Integer` | **Required**. |

#### Get all item from DynamoDb

```http
  GET http://localhost:8081/getemployee
```



#### Create employee

```http
  Post http://localhost:8081/add
```

| Body | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `nombre` | `String` | **Required**.  |
| `meses` | `Integer` | **Required**. |
| `meses` | `Integer` | **Required**. |

      Body {"nombre" : "Said Augusto Herrera Berrocal",    "meses" : 1,    "salario" : 2000000}      

