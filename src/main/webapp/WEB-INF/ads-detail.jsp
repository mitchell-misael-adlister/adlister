
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Ad Details" />
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <h1>Ad Details</h1>
        <a href="/profile" class="btn btn-default btn-return">Return to Profile</a>
        <div class="card" style="">
            <div class="card-body">
                <h4 class="card-title">${viewAdInfo.title}</h4>
                <p class="card-text">${viewAdInfo.description}</p>

                <div class="button-container">
                    <form action="/ad/delete?id=${viewAdInfo.id}" method="post">
                          <button class="btn btn-primary delete" type="submit">Delete</button>
                    </form>
                    <form action="/ad/edit?id=${viewAdInfo.id}" method="post">
                        <a href="/ad/edit?id=${viewAdInfo.id}" class="btn btn-primary" type="submit">Edit</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
