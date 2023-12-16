<%@taglib prefix="sec" uri="http://imran.com/functions" %>
<nav class="navbar navbar-expand-lg navbar-light
            bg-light fixed-top">
    <div class="container">
        <a class="navbar-brand"
           href="<c:url value="/"/>">
            Taka Poisa Lagbe
        </a>
        <button class="navbar-toggler"
                type="button"
                data-toggle="collapse"
                data-target="#navbarResponsive"
                aria-controls="navbarResponsive"
                aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse"
             id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item active">
                    <a class="nav-link"
                       href="<c:url value="/"/>">
                        Home
                    </a>
                </li>
                <c:choose>
                    <c:when test="${sec:isAuthenticated(pageContext.request)}">
                        <a class="nav-link" href="#" onclick="upload()">
                            File Upload
                        </a>
                        <script>
                            function upload() {
                                document.getElementById("fileUpload").submit();
                            }
                        </script>
                        <form style="visibility: hidden"
                              id="fileUpload"
                              method="post"
                              action="<c:url value="/file-upload"/>">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link"
                           href="<c:url value="/signup"/>">
                            Sign up
                        </a>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${sec:isAuthenticated(pageContext.request)}">
                        <a class="nav-link" href="#" onclick="logout()">
                            Log Out
                            [${sec:getCurrentUser(pageContext.request).username}]
                        </a>
                        <script>
                            function logout() {
                                document.getElementById("logoutForm").submit();
                            }
                        </script>
                        <form style="visibility: hidden"
                              id="logoutForm"
                              method="post"
                              action="<c:url value="/logout"/>">
                        </form>
                    </c:when>
                    <c:otherwise>
                        <a class="nav-link"
                           href="<c:url value="/login"/>">
                            Log In
                        </a>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
