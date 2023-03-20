<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="container">
    <h1>Please fill in your information.</h1>


    <%--    added this...--%>
    <!-- Display an error message if the username is not unique -->
    <% if (request.getAttribute("usernameNotUnique") != null && (boolean) request.getAttribute("usernameNotUnique")) { %>
    <div class="alert alert-danger" role="alert">
        The chosen username is already taken. Please choose another one.
    </div>
    <% } %>
    <%--    added this...--%>


    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
</body>
</html>

<%--I've updated the register.jsp file to display an error message when the
"usernameNotUnique" attribute is set to true.--%>