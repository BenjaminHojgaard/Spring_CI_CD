FROM adoptopenjdk/openjdk11:alpine-jre
RUN apk --no-cache add curl


ARG JAR_FILE=target/*.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# set a directory for the app
WORKDIR /actions

# copy all the files to the container
COPY ${JAR_FILE} app.jar

# install dependencies
RUN apk update
RUN apk add adoptopenjdk/openjdk11:alpine-jre

# run the command
CMD ["java", "-jar", "actions-0.0.1.jar"]
