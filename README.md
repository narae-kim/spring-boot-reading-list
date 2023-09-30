# Reading List
A simple web application to add and display a book list for a reader.

This is a toy project to replicate an example from _Spring Boot in Action_ by Craig Walls.

It is implemented in Java 17 and Spring Boot 3.1.4.


## Application
It is a simple web application to add a book list and display them for a reader.

Once the application is running in local, access the URL: http://localhost:8080/readingList/{reader}


## Actuator
To test Actuator, modify `application.yml` to expose the endpoints by updating `management.endpoints` block.

The endpoints can then be tested via terminal or a web browser.

### Example
  - with overriden base path with the prefix of "inspect"
      - `$ curl http://localhost:8080/inspect/health`
      - URL: http://localhost:8080/inspect/health

  - default endpoints with the prefix of "actuator"
    - `$ curl http://localhost:8080/actuator/health`
    - URL: http://localhost:8080/actuator/health
    

### Predefined endpoints
[Spring Boot Actuator Web API Documentation](https://docs.spring.io/spring-boot/docs/3.1.4/actuator-api/htmlsingle/)


## Reference: 
[Spring Boot in Action by Craig Walls](https://www.google.ie/books/edition/Spring_Boot_in_Action/9CiPrgEACAAJ?hl=en)
