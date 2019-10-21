# Chess Knight Min Moves Web Application ♟

> Application that count minimum number of chessKnight moves

## Libraries

- JDK 1.8
- Maven
- Spring Boot
- Junit


## Build & Deploy WAR for Tomcat with maven
mvn clean package

to deploy it, dropping "target/hourse.war" into the $CATALINA_HOME\webapps directory of Tomcat
instance

## Run local with maven
mvn clean package spring-boot:run

## API

 - **GET {endpoint}/hourse/rest/count**
 - **GET {endpoint}/hourse/servlet/count**

Get minimum number of chess knight moves

@param width - width of field (ex. 1, 3)

@param height - height of field (ex. 1, 3)

@param startCell - cell where knight is start moves (ex. A1, BB3)

@param endCell - cell where knight wants to move (ex. A1, BB3)


## Test Deploy
http://93.186.255.195:8080/hourse/rest/count?width=10&height=14&start=B1&end=A4

http://93.186.255.195:8080/hourse/servlet/count?width=10&height=14&start=B1&end=A4

## Algorithms
Breadth-first search without optimization and limit.
Can be improved with add limits to "wave propagation" and not consider cells upp and down rectangle where start and end are located.
And add limits that control "center line" in big rectangles where start and end are in diagonals.



