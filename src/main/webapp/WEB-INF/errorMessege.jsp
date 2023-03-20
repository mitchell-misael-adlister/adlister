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
<% if (errorMessage.equals("Invalid input. Please provide valid data and try again.")) { %>
<p>Please check your input and try again.</p>
<% } else if (errorMessage.equals("Access denied. You are not authorized to view this page.")) { %>
<p>Please log in to view this page.</p>
<% } else if (errorMessage.equals("Invalid credentials. Please provide valid login information and try again.")) { %>
<p>Please check your login information and try again.</p>
<% } else if (errorMessage.equals("Authentication failed. You do not have the necessary permissions to access this resource.")) { %>
<p>Please contact your administrator for assistance.</p>
<% } %>
</body>
</html>
