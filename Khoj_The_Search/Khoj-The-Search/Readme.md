# Khoj The Search

## About
This project is simply a demo demonstrating basic features which is only the tip of an iceberg.
This project might (and certainly does) have bugs, vulnerabilities or some other types of issues.
So, contributions are always welcome :)

In this project there have multiple packages in the [src/main](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/tree/main/Khoj_The_Search/Khoj-The-Search/src/main) directory.

1. [java/com/imran](#1-javacomimran)
2. [resources](#2-resources)
3. [webapp](#3-webapp)

### 1. java/com/imran
- `annotations`: Holding customized annotation which is used in `DTO` classes.
- `domain`: classes/objects to store into the database. 
- `dto(Data Transfer Object)`: Objects that are responsible show the response result to the client.  
- `exceptions`: Classes for customized exceptions.
- `filter`: Object Filtering the every request from the client.
- `jdbc`: Object which is responsible to create connection with database.
- `repository`: Objects are responsible for the `CRUD` operations.
- `services`: Business Logics.
- `util`: Validator Objects.
- `web`: Servlet objects which are responsible for receiving requests and send responses.

### 2. resources
- `db.properties`: In this file we are set up the properties for our database.

### 3. webapp
- `images`: Holding images.
- `WEB-INF`: Holding web pages.

## Features include
1. Login And Registration.
   ```md
   Users can create an account by providing a unique username and password. Subsequently,
   they can log in using the established credentials.
   ```
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_signup.jpg?raw=true)
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_login.jpg?raw=true)
2. Searching single/multiple Integer numbers from the list of Integer numbers.
   ```md
   After logging in, users are redirected to the home page where they can input one or more integer values and specify one or more integer values as search criteria.
   A button labeled `Khoj` is provided. Upon entering valid input, users can initiate a search to determine whether the search values exist within the provided input values.
   The result, either `true` or `false`, will be displayed.
   ```
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_input_result.jpg?raw=true)
3. Rest Api.
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_rest_api.jpg?raw=true)
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_rest_api_1.jpg?raw=true)


## Prerequisites
What things I have installed in my Device:
```
Tomcat server 9.
Locally installed MySQL.
Compatible IDE, Intellij IDEA recommended for this project.
```

## Database and Tables
- **Database name:** ``khojTheSearch``
- **Tables name:** 
  1. `customer`
     ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_database1.jpg?raw=true)
  2. `user_values`
     ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_database2.jpg?raw=true)


## Arrived Quesions
- **Connection with database failed:** When we try to connect our database with The DataSource object
  it was not working properly. It was showing this error:

  ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/DatabaseError_1.jpg?raw=true)

  When we used `Connection Pool` from the Library `HikariCP` it is now working as much as good.
