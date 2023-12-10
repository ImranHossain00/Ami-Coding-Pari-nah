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

<div class="form-container">
    <div class="form-control">
        <div class="form-group">
            <form method="post"
                  action="file-upload"
                  enctype="multipart/form-data">
                <input type="file" name="file" style="width: 100%; margin-bottom: 10px;">
                <input type="submit" value="Upload" style="width: 100%;">
            </form>
        </div>
    </div>
</div>

<%@include file="includes/footer.jsp"%>