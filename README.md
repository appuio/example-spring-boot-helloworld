# Spring Boot APPUiO Example

This is a Spring Boot Example Application

## How to deploy

### Create New OpenShift Project

```bash
oc new-project example-spring-boot
```

### Docker Build on APPUiO - Create Application and expose Service

```bash
oc new-app https://github.com/appuio/example-spring-boot-helloworld.git --strategy=docker --name=appuio-spring-boot-ex

oc expose service appuio-spring-boot-ex
```

### Image from DockerHub

Take the pre built image from Dockerhub

```bash
oc new-app appuio/example-spring-boot
```

## Local Build and Test

### Gradle

Build application with gradle:

```bash
./gradlew clean build
```

Run application with gradle:

```bash
./gradlew bootRun
```

### Container

Build Image with buildah:

```bash
buildah bud -t example-spring-boot-helloworld .
```

Run Image with podman:

```bash
podman run -ti -p 8080:8080 -p 9000:9000 localhost/example-spring-boot-helloworld:latest
```

## Endpoints

* Application: <http://localhost:8080>
* Health: <http://localhost:9000/health>
* Prometheus: <http://localhost:9000/prometheus>
