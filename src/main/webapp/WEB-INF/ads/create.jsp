<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <h1>Create a new Ad</h1>
    <%
        if (request.getAttribute("errors") != null) {
    %>
    <fieldset>
        <legend>Error</legend>
        <ul>
            <%if (request.getAttribute("errors") != null) {%>
            <li class="error">Please Fill out all Information</li>
            <% } %>
        </ul>
    </fieldset>
    <%
        }
    %>
    <form action="/ads/create" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text">${description}</textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
</div>

</body>
</html>
