# Khoj The Search

## About
This project is simply a demo demonstrating basic features which is only the tip of an iceberg.
This project might (and certainly does) have bugs, vulnerabilities or some other types of issues. So, contributions are always welcome

## Features include
1. Login And Registration.
   ```md
   Users can create an account by providing a unique username and password. Subsequently,
   they can log in using the established credentials.
   ```
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/webapp/images/)
2. Searching single/multiple Integer numbers from the list of Integer numbers.
   ```md
   After logging in, users are redirected to the home page where they can input one or more integer values and specify one or more integer values as search criteria.
   A button labeled `Khoj` is provided. Upon entering valid input, users can initiate a search to determine whether the search values exist within the provided input values.
   The result, either `true` or `false`, will be displayed.
   ```
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/src/main/webapp/images/)
3. Rest Api.
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_rest_api?raw=true)
   ![Alter text](https://github.com/ImranHossain00/Simple-Projects-with-JAVA/blob/main/Khoj_The_Search/Khoj-The-Search/screenshots/khoj_signup.jpg?raw=true)


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
