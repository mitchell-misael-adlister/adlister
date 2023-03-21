<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p> Description: ${ad.description}</p>
            <form action="/ads/single" method="get">
                    <%--      put a hidden input type ="hidden" send over value with
                              whole ad Object--%>
                <button>Click for more details!</button>
                <input type="hidden" name="singleAd" value="${ad.id}">
            </form>
        </div>
    </c:forEach>
</div>


</body>
</html>
