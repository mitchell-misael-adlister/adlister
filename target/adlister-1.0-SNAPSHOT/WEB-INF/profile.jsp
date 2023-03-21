<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">

    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <h1>Here Are all your ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <c:if test="${sessionScope.user.id eq ad.userId}">
            <div class="col-md-6">
                <h2>${ad.title}</h2>
                <p>${ad.description}</p>

                <form action="${pageContext.request.contextPath}/ads/edit/${ad.id}" method="get">
                    <button>Edit Ad</button>
                </form>


                <form action="/ads/delete" method="get">
                    <button>Delete Ad</button>
                    <input type="hidden" name="singleAd" value="${ad.id}">
                </form>

                <form action="/ads/single" method="get">
                    <button>Click for more details!</button>
                    <input type="hidden" name="singleAd" value="${ad.id}">
                </form>


            </div>
        </c:if>
    </c:forEach>

</div>

</body>
</html>
