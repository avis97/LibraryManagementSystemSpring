# Library Management System
 This is a basically enterprises application as a library System. Admin can handle the application for issue 
 the Book with the student and also can handle the all details about student, book, library card and transaction with student and can change some details by using this application.
 This is a Spring Maven project I used MySql driver for handle the database and for Connect the Database I used 
 hibernate jdbc . I made some Rest APIs in this application for some operation by this GET/DELETE/PUT/PUSH methods.


### MAVEN SPRING DEPENDENCY
* MySql Driver.
* Soring JPA(hibernate)
* Lombook
* Spring web

### MODELS
* Author
* Student
* Books
* Card
* Transaction
### PACKAGE
* Models
* Controller
* Repositorys
* Services
* DTOs
* Exception
* Enum
* Converter

## Maping
AUTHOR TO BOOK --> ONE TO MANY.    
STUDENT TO BOOK -->  ONE TO MANY.   
STUDENT TO CARD --> ONE TO ONE   
CARD TO BOOK    --> ONE TO MANY   
BOOK TO TRANSACTION --> MANY TO ONE  
CARD TO TRANSACTION --> ONE TO MANY  

AUTHER AND STUDENT ARE PARENT HERE.



## Screenshot  

*SOME APIS IN SWAGGER MODELS->

![Screenshot (159)](https://user-images.githubusercontent.com/106426358/231953485-a07b8341-3787-4220-bd79-08d558defdec.png)


*ER MODELS

![Screenshot (146)](https://user-images.githubusercontent.com/106426358/231953548-4b019b54-6d33-4f4a-bdf0-49ec6b4372b4.png)
