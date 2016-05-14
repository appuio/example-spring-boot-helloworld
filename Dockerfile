FROM openshift/base-centos7

MAINTAINER Thomas Philipona <philipona@puzzle.ch>

EXPOSE 8080


LABEL io.k8s.description="Example Spring Boot App" \
      io.k8s.display-name="APPUiO Spring Boot App" \
      io.openshift.expose-services="8080:http" \
      io.openshift.tags="builder,springboot" \
      io.openshift.s2i.destination="/opt/s2i/destination"
      
# Install Java
RUN INSTALL_PKGS="tar unzip bc which lsof java-1.8.0-openjdk java-1.8.0-openjdk-devel" && \
    yum install -y --enablerepo=centosplus $INSTALL_PKGS && \
    rpm -V $INSTALL_PKGS && \
    yum clean all -y && \
    mkdir -p /opt/s2i/destination
    
ADD gradlew /tmp/
ADD build.gradle /tmp/
ADD src /tmp/

RUN /tmp/.gradlew build

RUN cp -a  /tmp/build/libs/springboots2idemo*.jar /opt/app-root/springboots2idemo.jar

CMD java -jar /opt/app-root/springboots2idemo.jar