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
            <label for="inputValues">
                Input values
            </label>
            <input type="text"
                   class="form-control"
                   id="inputValues"
                   value="${numberListDTO.inputValues}"
                   name="inputValues"
                   placeholder="don't use 2 consecutive spaces. For example: 1, 2, 3"/>

            <c:if test="${errors.inputValues != null}">
                <small class="text-danger">${errors.inputValues}</small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="searchValue">
                Value for Search
            </label>
            <input type="text"
                   class="form-control"
                   id="searchValue"
                   value="${numberListDTO.searchValue}"
                   name="searchValue"/>
            <c:if test="${errors.searchValue != null}">
                <small class="text-danger">${errors.searchValue}</small>
            </c:if>
        </div>
        <input type="submit" value="Khoj">
    </form>
</div>

<%@include file="includes/footer.jsp"%>
