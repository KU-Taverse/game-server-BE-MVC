# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Add a volume pointing to /tmp
VOLUME /tmp

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=build/libs/*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} app.jar

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]
#FROM openjdk:17-jdk
#
## build가 되는 시점에 JAR_FILE이라는 변수 명에 build/libs/*.jar 선언
## build/libs - gradle로 빌드했을 때 jar 파일이 생성되는 경로
#ARG JAR_FILE=build/libs/*.jar
#
## JAR_FILE을 app.jar로 복사
#COPY ${JAR_FILE} app.jar
#
## 운영 및 개발에서 사용되는 환경 설정을 분리
##ENTRYPOINT ["java", "-jar", "-Dspring.profiles.group=prod", "/app.jar"]
#ENTRYPOINT ["java", "-jar", "/app.jar"]
## docker build -f ./infra/docker/Dockerfile -t ji0513ji/game-server:latest .git
#
##docker rm -v $(docker ps --filter status=exited -q)
##docker rmi  $(docker images)
