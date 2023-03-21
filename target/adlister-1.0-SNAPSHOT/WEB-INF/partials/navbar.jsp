<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<%--<nav class="navbar navbar-default">--%>
<%--    <div class="container-fluid">--%>
<%--        <div class="navbar-header">--%>
<%--            <a class="navbar-brand" href="/ads">AdLister<i class="fas fa-network-wired"></i></a>--%>
<%--        </div>--%>
<%--        <div>--%>
<%--            <ul class="nav navbar-nav navbar-right">--%>
<%--                <li>--%>
<%--                    <form action="/ads/search" class="form-inline" method="GET">--%>
<%--                        <input id="s" name="s" class="form-control" type="search" placeholder="Search Ads..." aria-label="Search">--%>
<%--                        <button class="btn btn-outline-success" type="submit"><i class="fas fa-search"></i></button>--%>
<%--                    </form>--%>
<%--                </li>--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${sessionScope['user'] != null}">--%>
<%--                        <li><a href="${pageContext.request.contextPath}/profile">View Profile</a></li>--%>
<%--                        <li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>--%>
<%--                        <li><a href="${pageContext.request.contextPath}/ads/create">Create Ads</a></li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <li><a href="${pageContext.request.contextPath}/login">Login</a></li>--%>
<%--                        <li><a href="${pageContext.request.contextPath}/register">Register</a></li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--            </ul>--%>
<%--        </div>--%>
<%--    </div><!-- /.navbar-collapse -->--%>
<%--    </div><!-- /.container-fluid -->--%>

<%--</nav>--%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/ads">Adlister</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/">Home</a>
                </li>
            <c:choose>
                <c:when test="${sessionScope['user'] != null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/profile">Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/ads/create">Create Ad</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                </li>
                </c:when>
                <c:otherwise>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/register">Register</a>
                </li>
                </c:otherwise>
            </c:choose>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
