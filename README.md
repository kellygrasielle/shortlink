SpringBoot Gradle MVC application with Thymeleaf

## Application
The application has two screens:
1- The user inform the url or service and the system respond with the alias.

2- The user inform the alias and the system respond with the original service or path.

- The user can test as well if the service is working using by using the url composed by application path plus the alias. 
 - {application_path}/alias

## Implementation
- It was not used external libraries to generate the alias.
- The alias is create based on the link id that in this case is saved in a memory database.
- Language: Java 8
- Libraries: spring thymeleaf, spring data, h2database

## ToDo
- Functional tests were not put in place
- Redirection to external links with alias was not implemented (just the url is displayed)
- The algorithm to create the alias could be more harmonic restricting from create ones with just one character for example. 
- In this application Exceptions was not handled.

## cloud
- It was choose to deploy the application in Elastic beanstalk."
- It can be done using the console aws.
- In order to create the application in Elastic beanstalk It was necessary to upload
just the jar file found in the /build/libs. 
-  It is necessary add SERVER_PORT=5000 to Configure more options". 


## BUILD and RUN:

You can create a executable jar using: ./gradlew bootJar

The executable jar is located in the build/libs directory and you can run it by executing the following command

java -jar build/libs/bankamerica-1.0-SNAPSHOT.jar

Another way to run the application is by executing the following Gradle command:

./gradlew bootRun

This command will run the Spring Boot application on the default port 8080 directly. 

After a successful startup you can open your browser and access http://localhost:8080 and you should see the Login page e in the browser.



