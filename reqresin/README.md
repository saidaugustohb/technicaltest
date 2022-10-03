
# Prueba de automatizacion

- El proyeto esta desarrollado en [Java](https://www.java.com/es/download/) con el gestor de dependecias de [gradle](https://gradle.org/install/) con la versión del gradlewrapper 7.2
- Para la ejecución de projecto se debe usar el gradlewrapper con la tarea configurada en el [build.gradle](https://github.com/saidaugustohb/technicaltest/blob/master/reqresin/build.gradle) ***"gradlew clean runAParallelSuite"***
- El comando  de las pruebas citado anteriormente debe ser ejecutado sobre la ruta de [reqresin](https://github.com/saidaugustohb/technicaltest/tree/master/reqresin) 

- El resultado de las pruebas quedata en un index.html en la ruta reqresin/target/site/serenity


# Configuración adicionar para aprovisionar Jenkins
-Instalamos Jenkins con docker

**Linux**

***"docker run -d -v $(pwd)/jenkins:/var/jenkins_home -p 50000:50000 -p 9080:9080 -e JENKINS_OPTS="--httpPort=9080" --name jenkinsTest jenkins/jenkins:lts"***

**Windows**

***"docker run -d -v C:\jenkins:/var/jenkins_home -p 50000:50000 -p 9080:9080 -e JENKINS_OPTS="--httpPort=9080" --name jenkinsTest jenkins/jenkins:lts"***

**Nota:** Para monitorear los logs podemos ejecutar el commando

***"docker logs -f jenkinsTest"***