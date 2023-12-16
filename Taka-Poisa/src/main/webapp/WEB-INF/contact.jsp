<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>
<div class="container col-lg-6">
    <h1 style="color: #f1ff20">Contact Information</h1>
    <hr class="mb-4">
    <form class="form-horizontal"
          role="form"
          method="post"
          class="form-group"
          action="<c:url value="/contact-info"/>">

        <!-- Address Information -->
        <div class="form-group">
            <label for="phoneNumber" style="color: floralwhite">Phone Number</label>
            <input type="text"
                   name="phoneNumber"
                   id="phoneNumber"
                   value="${dto.phoneNumber}"
                   class="form-control" placeholder="+8801xxxxxxxxx"/>
            <c:if test="${errors.phoneNumber != null}">
                <small class="text-danger">${errors.phoneNumber}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="email" style="color: floralwhite">Email</label>
            <input type="email"
                   name="email"
                   id="email"
                   value="${dto.email}"
                   class="form-control"/>
            <c:if test="${errors.email != null}">
                <small class="text-danger">${errors.email}</small>
            </c:if>
        </div>

        <div class="form-group">
            <a class="btn btn-primary btn-lg" href="#" onclick="back()">
                Back
            </a>
            <button class="btn btn-primary btn-lg"
                    type="submit">
                Next
            </button>
        </div>
    </form>
</div>
<script>
    function back() {
        document.getElementById("back").submit();
    }
</script>
<form style="visibility: hidden"
      id="back"
      method="get"
      action="<c:url value="/address-info"/>">
</form>
<%@include file="includes/footer.jsp"%>