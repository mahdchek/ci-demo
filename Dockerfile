FROM ubuntu
MAINTAINER Mahdi CHEKINI <me.chekini@gmail.com>
RUN apt-get update && apt-get install openjdk-11-jdk vim curl -y
WORKDIR /opt
ADD target/ci-*.jar ci.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/opt/ci.jar"]
