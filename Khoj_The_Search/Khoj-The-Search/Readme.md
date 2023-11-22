### Arrived Quesions
- **Connection with database failed:** When we try to connect our database with The DataSource object
  it was not working properly. It was showing this error:
  >HTTP Status 500 – Internal Server Error <br/>
  >Type Exception Report

Message Unable to insert data into database.

Description The server encountered an unexpected condition that prevented it from fulfilling the request.

Exception

java.lang.RuntimeException: Unable to insert data into database.
com.imran.repository.JDBCUserRepositoryImpl.findByUsername(JDBCUserRepositoryImpl.java:69)
com.imran.service.UserServiceImpl.isNotUniqueUsername(UserServiceImpl.java:37)
com.imran.web.Signup.doPost(Signup.java:52)
javax.servlet.http.HttpServlet.service(HttpServlet.java:555)
javax.servlet.http.HttpServlet.service(HttpServlet.java:623)
org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)

Note The full stack trace of the root cause is available in the server logs.
Apache Tomcat/9.0.78
  > 
  When we used `Connection Pool` from the Library `HikariCP` it is now working as much as good.