# Chess Knight Min Moves Web Application ♟

> Application that count minimum number of chessknight moves 

## Libraries

- JDK 1.8
- Maven
- Spring Boot
- Junit


## Build & Deploy WAR for Tomcat with maven
mvn clean package

## API

 - **GET {endpoint}/hourse/rest/count**

Get minimum number of chess knight moves

@param width - width of field

@param height - height of field

@param startCell - cell where knight is start moves

@param endCell - cell where knight wants to move


## Test Deploy
http://93.186.255.195:8080/fix-knight-moves-1.0-SNAPSHOT/hourse/rest/count?width=10&height=14&start=B1&end=A1

## Algorithms
Breadth-first search without optimization and limit.
Can be improved with add limits to "wave propagation" and not consider cells upp and down rectangle where start and end are located.
And add limits that control "center line" in big rectangles where start and end are in diagonals.



