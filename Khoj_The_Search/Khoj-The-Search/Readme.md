# Khoj The Search

## About
This project is a simple searching tool powered by Java JSP Servlet. In this project I handled some simple edge cases and trying to building a solid system architecture. 
This project is simply a demo demonstrating basic features which is only the tip of an iceberg.
This project might (and certainly does) have bugs, vulnerabilities or some other types of issues. So, contributions are always welcome

## Features include
1. Login And Registration.
   ```
   A user can create a account with a unique Username and password, then he/she can login.
   ```
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/webapp/images/)
2. Search single/multiple Ineger numbers from given a list of Integer numbers.
   ```md
   After loing the user will be redearect to the home page. There a user can give a/some integer numbers as input and a/some integer numbers as search value.
   There will be a button named **Khoj**. After giving valid input user can search the search value/s into the input value/s whether search value have or not
   into the input values. If have **Result** will show `true` otherwise `false`.
   ```
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/webapp/images/)
3. Rest Api.

## Screenshots
![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/webapp/images/khoj_2.jpg)
![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/webapp/images/khoj_3.jpg)

## Prerequisites
What things I have installed in my Device:
```
Tomcat server 8.
Locally installed MySQL.
Compatible IDE, Intellij IDEA recommended for this project.
```
## Arrived Quesions
- **Connection with database failed:** When we try to connect our database with The DataSource object
  it was not working properly. It was showing this error:

  ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/webapp/images/DatabaseError_1.jpg)

  When we used `Connection Pool` from the Library `HikariCP` it is now working as much as good.
