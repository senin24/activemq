# activemq
Example Embedded ActiveMQ with Spring Boot apps

![Diagram](https://github.com/senin24/activemq/blob/master/EmbeddedActiveMQwithSpringBoot.png)

Compile and run Server:
```
cd server
mvn clean package spring-boot:repackage -Dmaven.test.skip=true
java -jar server-0.0.1-SNAPSHOT.jar
```

Compile and run some Workers:
```
cd worker
mvn clean package spring-boot:repackage -Dmaven.test.skip=true
java -jar worker-0.0.1-SNAPSHOT.jar
java -jar worker-0.0.1-SNAPSHOT.jar
...
java -jar worker-0.0.1-SNAPSHOT.jar
```
