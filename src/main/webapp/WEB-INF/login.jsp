<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Log In"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Please Log In</h1>
    <%
        if (request.getAttribute("errors") != null) {
    %>
        <ul>
            <%if (request.getAttribute("username_error") != null) {%>
            <li class="error">Username error</li>
            <% } %>

            <%if (request.getAttribute("password_error") != null) {%>
            <li class="error">Password error</li>
            <% } %>
        </ul>
    <%
        }
    %>
    <form action="/login" method="POST">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="bob">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password" value="pass">
        </div>
        <input type="submit" class="btn btn-primary btn-block" value="Log In">
    </form>
</div>
</body>
</html>
