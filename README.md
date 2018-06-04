# login-register

Login and reggistration using Spring Security. <br><br>
All registered users can see list of employees but only admin can add new ones. <br>
User and Admin have different home page, and after login in they are redirect to this place.<br>
Tables in database are created from the schema.sql, data imported from data.sql. <br>
Used technologies: Spring Boot, Spring Security, Bootstrap <br><br>

To run application is obligatory to create spring_security database and change username and password in application.properties.
You also have to follow instructions in application.properties in JPA section, this is necessary to create tables from schema and import data. 
