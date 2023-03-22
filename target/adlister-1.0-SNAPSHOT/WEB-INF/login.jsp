
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <div class="input-container">
            <form action="/login" method="post">
                    <h1>Login to Your Account</h1>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" class="form-control" type="text" value="${username}">
                        <c:if test="${error != null}">
                            <span class="errors">${error}</span>
                        </c:if>

                        <c:if test="${errors.containsKey('exist')}">
                            <span class="errors">${errors.get('exist')}</span>
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" name="password" class="form-control" type="password">
                    </div>
                <input type="submit" class="btn btn-primary btn-block form-button" value="Login">
            </form>
        </div>
    </div>


    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>


</body>
</html>
