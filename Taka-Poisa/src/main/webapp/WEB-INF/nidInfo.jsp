<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>

<style>
    .form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .form-control {
        width: 300px; /* Adjust the width as needed */
    }

    .form-group {
        margin-bottom: 15px;
    }

    /* Add more styles as needed */
</style>

<div class="container col-lg-6">
    <h1 class="text-info">NID Information</h1>
    <hr class="mb-4">

    <form class="form-horizontal"
          role="form"
          method="post"
          action="<c:url value="/nid-info"/>"
          enctype="multipart/form-data">
        <!-- Name -->
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text"
                   name="name"
                   id="name"
                   value="${dto.name}"
                   class="form-control"
                   placeholder="Name that is provided in your NID" />
            <c:if test="${errors.name != null}">
                <small class="text-danger"> ${errors.name} </small>
            </c:if>
        </div>
        <!-- Date of Birth -->
        <div class="form-group">
            <label for="dob">Date of Birth</label>
            <input type="date"
                   name="dob"
                   id="dob"
                   value="${dto.dob}"
                   class="form-control"
                   placeholder="yyyy-MM-dd"/>
            <c:if test="${errors.dob != null}">
                <small class="text-danger">${errors.dob}</small>
            </c:if>
        </div>
        <!-- NID Number -->
        <div class="form-group">
            <label for="nidNumber">NID Number</label>
            <input type="text"
                   name="nidNumber"
                   id="nidNumber"
                   value="${dto.nidNumber}"
                   class="form-control"
                   placeholder="Enter your NID number" />
            <c:if test="${errors.nidNumber != null}">
                <small class="text-danger">${errors.nidNumber}</small>
            </c:if>
        </div>
        <!-- Profile Photo -->
        <div class="form-group">
            <label for="photo"> Profile Photo </label>
            <input type="file"
                   name="photo"
                   id="photo"
                   value="${dto.photo}"
                   size="50" />
            <c:if test="${errors.photo != null}">
                <small class="text-danger"> ${errors.photo} </small>
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
      action="<c:url value="/signup"/>">
</form>
<%@include file="includes/footer.jsp"%>