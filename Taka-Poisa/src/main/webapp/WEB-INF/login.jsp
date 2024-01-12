<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container col-lg-6">
    <h2 class="text-info">Login In</h2>
    <hr class="mb-4">

    <form class="form-horizontal"
          role="form"
          action="<c:url value="/login"/>"
          method="post">
        <div class="form-group">
            <label for="email" >Email</label>
            <input type="email" class="form-control"
                   id="email"
                   name="email"
                   value="${dto.email}"
            />
            <c:if test="${errors.email != null}">
                <small class="text-danger"> ${errors.email} </small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="password" >Password</label>
            <input type="password" class="form-control"
                   id="password"
                   name="password"
                   value="${dto.password}"
            />
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
    <div class="row">
        <c:if test="${message != null}">
            <div class="alert alert-success">
                    ${message}
            </div>
        </c:if>
    </div>
</div>
<%@include file="includes/footer.jsp"%>