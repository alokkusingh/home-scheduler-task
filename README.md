# Home Scheduler Task 
Home Stack Scheduler Task

## Build
### Build base Image
GraalVM CE 22.3.0 ARMx64 builder image
   ```shell
   docker buildx build --platform linux/arm64 --build-arg GRAALVM_VERSION=22.3.0 --build-arg JAVA_VERSION=java17 -t alokkusingh/graalvm-ce:22.3.0-java17-arm64 --output=type=docker -f Dockerfile.ol8-java17 .
   ```
   ```shell
   docker push alokkusingh/graalvm-ce:22.3.0-java17-arm64 
   ```
### Build Application image
   ```shell
   docker build --progress=plain -f Dockerfile.native -t alokkusingh/home-scheduler-task:latest -t alokkusingh/home-scheduler-task:1.0.0 .
   ```
   ```shell
   docker push alokkusingh/home-scheduler-task:latest
   ```
   ```shell
   docker push alokkusingh/home-scheduler-task:1.0.0
   ```
   ```shell
   docker run -d -p 8082:8082 --rm --name home-scheduler-task alokkusingh/home-scheduler-task
   ```
### Manual commands - go inside and run binary manually
```shell
docker run -it --entrypoint /bin/bash -p 8082:8082 --rm --name home-scheduler-task alokkusingh/home-scheduler-task
```
```shell
.\home-scheduler-service --java.security.egd=file:/dev/urandom --spring.profiles.active=prod 
```
```shell
docker run -p 8082:8082 --rm --name home-scheduler-task alokkusingh/home-scheduler-task --java.security.egd=file:/dev/urandom --spring.profiles.active=prod
```