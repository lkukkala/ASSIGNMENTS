<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Customer details are:

<%

String s = request.getParameter("uname");

String p = request.getParameter("pass");

int count= 0;

for (int i = 0; i < s.length(); i++) {

	if (Character.isAlphabetic(s.charAt(i))) {

		count++;
	}

}

if (count == s.length())

	out.print("valid username : "+s);

else

	out.print("Not valid username : "+s);

%>
%>

</html>