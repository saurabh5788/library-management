# library-management

## Running Application on local Machine
```
mvnw clean install -DskipTests
```
With H2
```
java -jar target\library-0.0.1-SNAPSHOT.jar --spring-profiles-active=h2
```

With MySQL
```
java -jar target\library-0.0.1-SNAPSHOT.jar --spring-profiles-active=mysql
```

API Docs : http://localhost:8080/swagger-ui.html