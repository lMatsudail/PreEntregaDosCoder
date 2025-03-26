
## Caracteristicas

- Gestión de sucursales: Crear, listar, actualizar y eliminar sucursales.
- Gestión de empleados: Crear, listar, actualizar y eliminar empleados.
- Registrar la entrada y salida de empleados.
- Documentación de la API generada automáticamente con Swagger/OpenAPI.
- Página de error personalizada para manejar errores de manera amigable.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.2
- Spring Web
- Spring Data JPA
- Spring Boot Starter Thymeleaf
- H2 Database (base de datos en memoria)
- Springdoc OpenAPI (para la documentación de la API)
- Maven (gestión de dependencias)

## Config de aplication properties

spring.datasource.url=jdbc:h2:file:./data/coderEntrega
spring.datasource.driverClassName=org.h2.Drive  
spring.datasource.username=Mtsu  
spring.datasource.password=0128  
spring.database-platform=org.hibernate.dialect.H2Dialect  
spring.jpa.hibernate.ddl-auto=update  
spring.sql.init.mode=never  

## Autor
Este proyecto fue desarrollado por Jose Luis FLorez Casas como parte de la entrega final para el curso de programacion con java de  Coderhouse.
