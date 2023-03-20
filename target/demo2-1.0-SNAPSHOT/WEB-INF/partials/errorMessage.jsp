<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
</head>
<body>
<% String errorMessage = request.getParameter("errorMessage");
    if (errorMessage == null) {
        errorMessage = "Oops, something went wrong. Please try again later.";
    }
%>
<h1>Error</h1>
<p><%= errorMessage %></p>
<% if (errorMessage.equals("invalid_input")) { %>
<p>Please check your input and try again.</p>
<% } else if (errorMessage.equals("unauthorized")) { %>
<p>Please log in to view this page.</p>
<% } else if (errorMessage.equals("invalid_credentials")) { %>
<p>Please check your login information and try again.</p>
<% } else if (errorMessage.equals("auth_fail")) { %>
<p>Please contact your administrator for assistance.</p>
<% } %>
</body>
</html>
