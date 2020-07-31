FROM carsharing/alpine-oraclejdk8-bash

VOLUME /tmp
ADD pa-eureka-center-0.0.1-SNAPSHOT.jar
RUN sh -c 'touch /pa-eureka-center-0.0.1-SNAPSHOT.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/pa-eureka-center-0.0.1-SNAPSHOT.jar"]