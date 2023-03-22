
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Profile Info</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
</head>
<body>
<%@include file="partials/navbar.jsp" %>
<div class="container">
    <h1>Edit Your Profile</h1>
    <br>
    <a href="/profile" class="btn btn-default btn-return">Return to Profile</a>
    <span> ${sessionScope.id}</span>
</div>
<div class="container">
    <div class="input-container">
        <form action="/profile/edit" method="POST">
            <div class="form-group">
                <label for="email">Change Email</label>
                <input id="email" name="email" class="form-control" type="text" placeholder="joe@gmail.com">
                <c:if test="${error != null}">
                    <span class="errors">${error}</span>
                </c:if>

                <c:if test="${errors.containsKey('improper')}">
                    <span class="errors">${errors.get('improper')}</span>
                </c:if>
                <c:if test="${errors.containsKey('nothing')}">
                    <span class="errors">${errors.get('nothing')}</span>
                </c:if>
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
</div>

<script>
    function checkErrorMessages() {

        if (document.getElementsByClassName("errors").length > 0) {
            document.getElementsByClassName("form-container")[0].style.height = "37%";
        }

    }

    window.onload = checkErrorMessages();

</script>
</body>
</html>
