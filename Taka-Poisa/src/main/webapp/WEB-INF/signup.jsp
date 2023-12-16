<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container">
    <br/>

    <h2 class="h2" style="color: #f1ff20">Sign Up</h2>
    <hr class="mb-4">

    <form class="form-horizontal"
          role="form"
          action="<c:url value="/registration"/>"
          method="post">
        <div class="form-group">
            <label for="firstName" style="color: floralwhite">First Name</label>
            <input type="text" class="form-control"
                   id="firstName"
                   value="${dto.firstName}"
                   name="firstName" style="background: bisque"/>
            <c:if test="${errors.firstName != null}">
                <small class="text-danger"> ${errors.firstName} </small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="lastName" style="color: floralwhite">Last Name</label>
            <input type="text" class="form-control"
                   id="lastName"
                   value="${dto.lastName}"
                   name="lastName"
                   style="background: bisque"/>
            <c:if test="${errors.lastName != null}">
                <small class="text-danger"> ${errors.lastName} </small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="password" style="color: floralwhite">Password</label>
            <input type="password" class="form-control"
                   id="password"
                   name="password"
                   value="${dto.password}"
                   style="background: bisque"/>
            <c:if test="${errors.password != null}">
                <small class="text-danger"> ${errors.password} </small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="confirmPassword" style="color: floralwhite">Confirm Password</label>
            <input type="password" class="form-control"
                   id="confirmPassword"
                   name="confirmPassword"
                   value="${dto.confirmPassword}"
                   style="background: bisque"/>
            <c:if test="${errors.confirmPassword != null}">
                <small class="text-danger"> ${errors.confirmPassword} </small>
            </c:if>
        </div>
        <hr class="mb-4">
        <div class="form-group">
            <button class="btn btn-primary btn-lg"
                    type="submit">
                Next
            </button>
        </div>
    </form>
</div>
<%@include file="includes/footer.jsp"%>