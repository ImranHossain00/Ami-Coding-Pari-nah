<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container col-lg-6">
    <h2 class="text-info">Sign Up</h2>
    <hr class="mb-4">

    <form class="form-horizontal"
          role="form"
          action="<c:url value="/signup"/>"
          method="post">
        <div class="form-group">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control"
                   id="firstName"
                   value="${dto.firstName}"
                   name="firstName" />
            <c:if test="${errors.firstName != null}">
                <small class="text-danger"> ${errors.firstName} </small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control"
                   id="lastName"
                   value="${dto.lastName}"
                   name="lastName"/>
            <c:if test="${errors.lastName != null}">
                <small class="text-danger"> ${errors.lastName} </small>
            </c:if>
        </div>
        <div class="form-group">
            <label for="email" >Email</label>
            <input type="email" class="form-control"
                   id="email"
                   name="email"
                   value="${dto.email}"/>
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
        <div class="form-group">
            <label for="confirmPassword">Confirm Password</label>
            <input type="password" class="form-control"
                   id="confirmPassword"
                   name="confirmPassword"
                   value="${dto.confirmPassword}"
                   />
            <c:if test="${errors.confirmPassword != null}">
                <small class="text-danger"> ${errors.confirmPassword} </small>
            </c:if>
        </div>
        <hr class="mb-4">
        <div class="form-group">
            <button class="btn btn-primary btn-lg"
                    type="submit">
                Sign up
            </button>
        </div>
    </form>
</div>
<%@include file="includes/footer.jsp"%>