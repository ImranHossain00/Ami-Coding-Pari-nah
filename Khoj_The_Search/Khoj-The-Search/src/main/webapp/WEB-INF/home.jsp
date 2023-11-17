<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>
<div class="container">

    <h1>Celsius to Fahrenheit conversion</h1>
    <form class="form-horizontal" role="form"
          method="post"
          action="<c:url value="/home"/>">
        <div class="form-group">
            <label for="celsius">Temperature in Celsius</label>
            <input type="number"
                   id="celsius"
                   name="temperature"/>
        </div>
        <input type="submit" value="Submit">
    </form>
</div>
<%@include file="includes/footer.jsp"%>
