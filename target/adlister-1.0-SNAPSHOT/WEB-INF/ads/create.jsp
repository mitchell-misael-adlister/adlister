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
        <%--     Categories goes here:       --%>
        <label>Categories: </label>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="checkbox" id="1" name="check" value="1">
            <label class="form-check-label" for="1">Anime</label>

            <input class="form-check-input" type="checkbox" id="2" name="check" value="2">
            <label class="form-check-label" for="2">Tech</label>

            <input class="form-check-input" type="checkbox" id="3" name="check" value="3">
            <label class="form-check-label" for="3">Gaming Consoles</label>

            <input class="form-check-input" type="checkbox" id="4" name="check" value="4">
            <label class="form-check-label" for="4">Video Games</label>

            <input class="form-check-input" type="checkbox" id="5" name="check" value="5">
            <label class="form-check-label" for="5">Office Supplies</label>

            <input class="form-check-input" type="checkbox" id="6" name="check" value="6">
            <label class="form-check-label" for="5">DVDs</label>

            <input class="form-check-input" type="checkbox" id="7" name="check" value="7">
            <label class="form-check-label" for="5">Vehicles</label>

            <input class="form-check-input" type="checkbox" id="8" name="check" value="8">
            <label class="form-check-label" for="5">Books</label>

            <input class="form-check-input" type="checkbox" id="9" name="check" value="9">
            <label class="form-check-label" for="5">Pets</label>

            <input class="form-check-input" type="checkbox" id="10" name="check" value="10">
            <label class="form-check-label" for="10">Miscellaneous</label>
        </div>
</div>

</body>
</html>
