FROM registry.access.redhat.com/ubi9/openjdk-11

LABEL org.opencontainers.image.authors="midcicd@puzzle.ch" \
      io.k8s.description="Example Spring Boot App" \
      io.k8s.display-name="APPUiO Spring Boot App" \
      io.openshift.expose-services="8080:http" \
      io.openshift.tags="builder,springboot"

EXPOSE 8080 9000

RUN mkdir -p /tmp/src/
ADD . /tmp/src/

RUN cd /tmp/src && sh gradlew build --no-daemon

RUN ln -s /tmp/src/build/libs/springboots2idemo*.jar /deployments/springboots2idemo.jar
