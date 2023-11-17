<%@include file="includes/header.jsp"%>
<%@include file="includes/navigation.jsp"%>
<div class="container">

    <h1>Khoj The Search</h1>
    <form class="form-horizontal" role="form"
          method="post"
          action="<c:url value="/home"/>">
        <div class="form-group">
            <label for="inputvalues">
                Input values
            </label>
            <input type="number"
                   class="form-control"
                   id="inputvalues"
                   name="inputvalues"/>
        </div>
        <div class="form-group">
            <label for="search">
                Search
            </label>
            <input type="number"
                   class="form-control"
                   id="search"
                   name="search"/>
        </div>
        <input type="submit" value="Khoj">
    </form>
</div>
<%@include file="includes/footer.jsp"%>
