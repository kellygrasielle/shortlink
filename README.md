SpringBoot Gradle MVC application with Thymeleaf

## BUILD and RUN:

You can create a executable jar using: ./gradlew bootJar

The executable jar is located in the build/libs directory and you can run it by executing the following command

java -jar build/libs/bankamerica-1.0-SNAPSHOT.jar

Another way to run the application is by executing the following Gradle command:

./gradlew bootRun

This command will run the Spring Boot application on the default port 8080 directly. 

After a successful startup you can open your browser and access http://localhost:8080 and you should see the Login page e in the browser.

## USERS
username: jonna
password: password
role: USER

username: soumitra
password: password
rolle: ADMIN

## TODO
JUNIT test
Register validation 

