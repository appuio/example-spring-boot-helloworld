# Spring Boot APPUiO Example

This is a Spring Boot Example Application

## How to deploy

### Create New OpenShift Project

```bash
$ oc new-project example-spring-boot
```

### Docker Build on APPUiO - Create Application and expose Service

```bash
$ oc new-app https://github.com/appuio/example-spring-boot-helloworld.git --strategy=docker --name=appuio-spring-boot-ex

$ oc expose service appuio-spring-boot-ex
```

### Image from DockerHub

Take the pre built image from Dockerhub

```bash
$ oc new-app appuio/example-spring-boot
```
