<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Edit your Ad"/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
    <form action="/ads/edit" method="post">
        <input type="hidden" name="adToUpdate" value="${adObject}">
        <div class="col-md-6 justify-content-center form-group">
            <h1>TODO edit Ads.</h1>

            <label for="title"> Title:</label>
            <input id="title" type="text" name="title" value="${existingTitle}">
        </div>
        <div class="form-group">
            <label for="description"> Description: </label>
            <textarea id="description" type="text" name="description">${existingDescription}</textarea>
            <h3>Categories would go here: </h3>
            <button>Save Changes</button>
        </div>

    </form>

</div>

</body>
</html>
