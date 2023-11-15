<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result page</title>
</head>
<body>

Customer details are:

<br><%= "UserId"+request.getParameter("id") %><br>
<%= "UserName "+request.getParameter("uname") %><br>
 <%= "PhoneNumber"+request.getParameter("phnNo") %><br>
 <%= "Address"+request.getParameter("add") %><br>
 <input type="submit">
</body>
</html>