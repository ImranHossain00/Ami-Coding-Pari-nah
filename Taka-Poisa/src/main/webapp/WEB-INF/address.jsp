<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<div class="container col-lg-6">
    <h1 style="color: #f1ff20">Address</h1>
    <hr class="mb-4">
    <form class="form-horizontal"
          role="form"
          method="post"
          class="form-group"
          action="<c:url value="/address-info"/>">

        <!-- Address Information -->
        <div class="form-group">
            <label for="road" style="color: floralwhite">Road</label>
            <input type="text"
                   name="road"
                   id="road"
                   value="${dto.road}"
                   class="form-control"/>
            <c:if test="${errors.road != null}">
                <small class="text-danger">${errors.road}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="thana" style="color: floralwhite">Thana</label>
            <input type="text"
                   name="thana"
                   id="thana"
                   value="${dto.thana}"
                   class="form-control"/>
            <c:if test="${errors.thana != null}">
                <small class="text-danger">${errors.thana}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="district" style="color: floralwhite">District</label>
            <input type="text"
                   name="district"
                   id="district"
                   value="${dto.district}"
                   class="form-control"/>
            <c:if test="${errors.district != null}">
                <small class="text-danger">${errors.district}</small>
            </c:if>
        </div>

        <div class="form-group">
            <label for="division" style="color: floralwhite">Division</label>
            <input type="text"
                   name="division"
                   id="division"
                   value="${dto.division}"
                   class="form-control"/>
            <c:if test="${errors.division != null}">
                <small class="text-danger">${errors.division}</small>
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
      action="<c:url value="/nid-info"/>">
</form>
<%@include file="includes/footer.jsp"%>