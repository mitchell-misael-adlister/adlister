<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<h1>Change Your Password</h1>
<br>
<a href="/profile" class="btn btn-default btn-return">Return to Profile</a>
<div class="form-container">
    <div class="input-container">
        <form action="/profile/password" method="POST">
        <%-- old password --%>
        <div class="form-group">
            <label for="old-password">Current Password</label>
            <input id="old-password" name="old-password" class="form-control" type="password">
            <c:if test="${error != null}">
                <span class="errors">${error}</span>
            </c:if>

            <c:if test="${errors.containsKey('password')}">
                <span class="errors">${errors.get('password')}</span>
            </c:if>
        </div>
        <%-- new- password field--%>
        <div class="form-group">
            <label for="new-password">New Password</label>
            <input id="new-password" name="new-password" class="form-control" type="password">
            <c:if test="${error != null}">
                <span class="errors">${error}</span>
            </c:if>
            <c:if test="${errors.containsKey('mustHave')}">
                <span class="errors">${errors.get('mustHave')}</span>
            </c:if>
            <c:if test="${errors.containsKey('current')}">
                <span class="errors">${errors.get('confirm')}</span>
            </c:if>
        </div>
        <%--Confirm new-password--%>
        <div class="form-group">
            <label for="confirm-new-password">Confirm Password</label>
            <input id="confirm-new-password" name="confirm-new-password" class="form-control" type="password">
        </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</div>

<script>
    function checkErrorMessages() {

        if (document.getElementsByClassName("errors").length > 0) {
            document.getElementsByClassName("form-container")[0].style.height = "56%";
        }

    }

    window.onload = checkErrorMessages();

</script>
</body>
</html>
