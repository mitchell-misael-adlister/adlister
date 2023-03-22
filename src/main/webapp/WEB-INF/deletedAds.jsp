<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
<div class="profile-header">
    <h1>Deleted Ads</h1>
    <br>
    <a href="/profile" class="btn btn-default btn-return">Return to Profile</a>
    <span> ${sessionScope.id}</span>
</div>
<div class="container">
    <c:forEach var="Ad" items="${deletedAds}">
        <div class="col-sm-4">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">${Ad.title}</h4>
                    <p class="card-text">${Ad.shortDescription}</p>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
