<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Welcome!" />
    </jsp:include>
</head>
<body>
    <%@include file="partials/navbar.jsp" %>
    <div class="container">
        <div class="profile-header">
            <h1>Welcome,
                ${sessionScope.user.username}!</h1>
            <div class="button-container">
                <a href="/profile/edit" class="btn btn-default">
                    <span class="oi oi-pencil"></span>
                      Edit Profile
                </a>
                <a href="/ads/create" class="btn btn-default">
                    <span class="oi oi-clipboard"></span>
                      New Ad
                </a>
                <a href="/ads/deleted" class="btn btn-default">
                    <span class="oi oi-trash"></span>
                      Deleted Ads
                </a>
            <span> ${sessionScope.id}</span>
            </div>
        </div>
    </div>

    <div class="container">
        <c:forEach var="ad" items="${ads}">
            <div class="col-sm-6">
                <div class="card">
                    <div class="card-body">
                        <h4 class="card-title">${ad.title}</h4>
                        <p class="card-text">${ad.shortDescription}</p>
                        <a href="/ad?id=${ad.id}" class="btn btn-primary">More Details</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
