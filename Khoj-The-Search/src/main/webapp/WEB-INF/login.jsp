<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container">
    <br/>

    <h2 class="h2">Login</h2>
    <hr class="mb-4">

    <form class="form-horizontal" role="form"
          action="<c:url value="/login"/>"
          method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control"
                   id="username"
                   name="username"/>

            <c:if test="${errors.username != null}">
                <small class="text-danger"> ${errors.username} </small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control"
                   id="password"
                   name="password"/>
            <c:if test="${errors.password != null}">
                <small class="text-danger"> ${errors.password} </small>
            </c:if>
        </div>
        <hr class="mb-4">
        <div class="form-group">
            <button class="btn btn-primary btn-lg"
                    type="submit">
                Login
            </button>
        </div>
    </form>
    <span>
        Don't have a account?
        <a class="btn-link" href="<c:url value="/signup"/>">
            Sing Up
        </a>
    </span>
    <div class="row">
        <c:if test="${message != null}">
            <div class="alert alert-success">
                    ${message}
            </div>
        </c:if>
    </div>
</div>
<%@include file="includes/footer.jsp"%>