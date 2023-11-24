<%@taglib prefix="sec" uri="http://imran.com/functions" %>
<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container">
    <div class="jumbotron">
        <c:if test="${sec:isAuthenticated(pageContext.request)}">
            <h1> Hello <c:out value="${sec:getCurrentUser(pageContext.request).username}"/>, Welcome to our Astana </h1>
        </c:if>
    </div>

    <form class="form-horizontal" role="form"
          method="post"
          action="<c:url value="/home"/>">
        <div class="form-group">
            <label for="inputvalues">
                Input values
            </label>
            <input type="number"
                   class="form-control"
                   id="inputvalues"
                   name="inputvalues"/>
        </div>
        <div class="form-group">
            <label for="search">
                Search
            </label>
            <input type="number"
                   class="form-control"
                   id="search"
                   name="search"/>
        </div>
        <input type="submit" value="Khoj">
    </form>
</div>

<%@include file="includes/footer.jsp"%>
