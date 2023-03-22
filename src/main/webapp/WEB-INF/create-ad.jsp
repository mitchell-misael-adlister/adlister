<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Create an Ad" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <h1>Create an Ad</h1>
    <br>
    <a href="/profile" class="btn btn-default btn-return">Return to Profile</a>
    <div class="container">
        <div class="input-container">
            <form action="/ads/create" method="post">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input id="title" name="title" class="form-control" type="text" value="${title}">
                    <c:if test="${adErrors.containsKey('title')}">
                        <span class="errors">${adErrors.get('title')}</span>
                    </c:if>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input id="description" name="description" class="form-control" type="text" value="${description}">
                    <c:if test="${adErrors.containsKey('description')}">
                        <span class="errors">${adErrors.get('description')}</span>
                    </c:if>
                </div>
                <input type="submit" class="btn btn-primary btn-block" id="createAd-button">
            </form>
        </div>
    </div>
<script>
    function checkErrorMessages() {

        console.log(document.getElementsByClassName("errors"));

        if (document.getElementsByClassName("errors").length > 0) {
            document.getElementsByClassName("form-container")[0].style.height = "47%";
        }

    }

    window.onload = checkErrorMessages();
</script>
</body>
</html>
