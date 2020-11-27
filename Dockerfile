FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk --no-cache add curl


ARG JAR_FILE=target/*.jar


# set a directory for the app
WORKDIR /actions

# copy all the files to the container
COPY ${JAR_FILE} app.jar

# install dependencies
RUN apk update

ENTRYPOINT ["java","-jar","/app.jar"]
