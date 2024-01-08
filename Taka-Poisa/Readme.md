
## About
This project is simply a demo demonstrating basic features which is only the tip of an iceberg.
This project might (and certainly does) have bugs, vulnerabilities or some other types of issues.
So, contributions are always welcome :)

I attempted to implement this small project using the principles of `Object-Oriented Programming (OOP)`.
Specifically, I applied the concept of `Loosely Coupled` design by utilizing interfaces.
I also applied the concept of `Singleton Pattern` in [ValidationUtil](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/java/com/imran/util/ValidationUtil.java) class. Each interface is designed to handle a single, specific task.
However, the implementation may not fully adhere to `OOP` principles.

In this project there have multiple packages in the [src/main](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/tree/main/Taka-Poisa/src/main) directory.

1. [java/com/imran](#1-javacomimran)
2. [resources](#2-resources)
3. [webapp](#3-webapp)

### 1. java/com/imran
- `annotations`: Holding customized annotation which is used in `DTO` classes.
- `domain`: Classes that store data in the database.
- `dto(Data Transfer Object)`: Classes or objects handling data communication with the client, sending and receiving information.
- `exceptions`: Classes for customized exceptions.
- `filter`: Objects Filtering every request from the client.
- `jdbc`: ConnectionPool object which is responsible to create connection with database, store connections to the pool.
- `repository`: Objects which are responsible for the `CRUD` operations.
- `services`: Business Logics.
- `util`: Validator Objects.
- `servlets`: Servlet objects which are responsible for receiving requests and sending responses.

### 2. resources
- `db.properties`: In this file, we configure the properties for our database connection.

### 3. webapp
- `images`: Images.
- `WEB-INF`: Web pages.

## Features Include
1. **Login And Registration.**
   ```md
   Users can create an account by providing a unique email and password. Subsequently,
   they can log in using the established credentials.
  
## Prerequisites
My device is equipped with:
```
Linux Operating System (Ubuntu 23.04 [lunar])
JDK - 11
Tomcat server 9.
Locally installed MySQL.
Compatible IDE, Intellij IDEA recommended for this project.
Gradle 7.2 (Build Tool)
```

## Database and Tables
**The database and table creation queries are provided in [Queries.ddl](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/Queries.ddl).**
- **Database name:** ``takaPoisa``
- **Tables name:**
    1. `users`
    

## Errors
- **During logged in URL links are not working**: It seems like there might be an issue with 
the URL links when users are logged in. When attempting to send a request
with a URL such as http://localhost:8080/home, the page appears blank.<br>
![image](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/blob/main/Taka-Poisa/screenshots/blank_signup_page.png?raw=true)
<br>I identified an issue where `username` was mistakenly typed instead of `firstName` on line number 55 in the `navigation.jsp` page.<br>
![image](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/blob/main/Taka-Poisa/screenshots/blank_page_sol_1_in_nav_page.png?raw=true)
<br>But another problem has arisen. The conundrum is that displaying 
the `firstName` of logged-in `user` in the right upper side behind the `Log out`
button. but it was not working, and it was look like the following picture<br>
![image](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/blob/main/Taka-Poisa/screenshots/logout_username_error.png?raw=true)
<br>It seems that the issue is related to the initialization of the `user` object.
When attempting to find a `user` with a given `email` using the `findByEmail()` 
method in the repository class, the `user` object is initialized only with 
`email` and `login_password`. To address this, a new constructor has been 
created to initialize a `user` with `User(firstName, lastName, email, login_password)`.
Now we can get the `firstName` of the `user`.

