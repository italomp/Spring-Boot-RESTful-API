# API-RESTful-using-spring-boot
This CRUD API uses spring boot, JPA/Hibernate, H2 Database and REST principles. It has 4 routes and a exception handler <br>
general for to handle the exceptions thrown by the @Controllers and return custom error messages. <br>
<br>

## Endpoints:
**1 - Create Product:** http://localhost:8080/api/v1/product/<br>
    This route receives a request of the post type that contains a product objetct and <br>
    returns a ResposnseEntity with http status or with error message.<br>
<br>
    
**2 - Find Product:** http://localhost:8080/api/v1/product/{id} <br>
    This route receives a request of the get type with url and product id and returns a ResponseEntity <br>
    that contains the product that has the id sent in the url or with error message.<br>
<br>
    
**3 - Update Product:** http://localhost:8080/api/v1/product/<br>
    This route receives a request of the put type that contains a product updated <br>
    and returns a ResposnseEntity with http status.<br>
<br>

**4 - Delete Produt:** http://localhost:8080/api/v1/product/{id}<br>
    This route receives a request of the delete type with url and product id and returns a ResponseEntity <br>
    that contains the product that has the id sent in the url.<br>
    
## Author
Italo Modesto Pereira <br>
LinkedIn: https://www.linkedin.com/in/italo-modesto-aa7749120/

