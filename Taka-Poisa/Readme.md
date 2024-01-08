### About
This project, with its basic and simple functionality, may contain some bugs or issues.
So Contributions from anyone are more than welcome.

### Errors
**During logged in URL links are not working**: It seems like there might be an issue with 
the URL links when users are logged in. When attempting to send a request
with a URL such as http://localhost:8080/home, the page appears blank.<br>
![image](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/tree/main/Taka-Poisa/screenshots/blank_signup_page.png?raw=true)
<br>I identified an issue where `username` was mistakenly typed instead of `firstName` on line number 50 in the `navigation.jsp` page.<br>
![image](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/tree/main/Taka-Poisa/screenshots/blank_page_sol_1_in_nav_page.png?raw=true)
<br>But another problem has arisen. <br>
![image](https://github.com/ImranHossainFakir/Simple-Projects-with-JAVA/tree/main/Taka-Poisa/screenshots/logout_username_error.png?raw=true)
<br>It seems that the issue is related to the initialization of the `user` object.
When attempting to find a `user` with a given `email` using the `findByEmail()` 
method in the repository class, the `user` object is initialized only with 
`email` and `login_password`. To address this, a new constructor has been 
created to initialize a `user` with `User(firstName, lastName, email, login_password)`.

