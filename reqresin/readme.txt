Instalamos Jenkins con docker
Linux
docker run -d -v $(pwd)/jenkins:/var/jenkins_home -p 50000:50000 -p 9080:9080 -e JENKINS_OPTS="--httpPort=9080" --name jenkinsTest jenkins/jenkins:lts
Windows
docker run -d -v C:\jenkins:/var/jenkins_home -p 50000:50000 -p 9080:9080 -e JENKINS_OPTS="--httpPort=9080" --name jenkinsTest jenkins/jenkins:lts

para monitorear los logs
docker logs -f jenkinsTest