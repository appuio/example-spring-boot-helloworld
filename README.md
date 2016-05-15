# Spring Boot APPUiO Example

This is a Spring Boot Example Application

## How to deploy

### Create New OpenShift Project
```
$ oc new-project example-spring-boot
```

### Create Application and expose Service
```
$ oc new-app https://github.com/appuio/example-spring-boot-helloworld.git --strategy=docker --name=appuio-spring-boot-ex

$ oc expose service appuio-spring-boot-ex
```
