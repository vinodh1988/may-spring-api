<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Welcome to the JSP page! Spring boot </h1>
   <u> Developers list </u>
   <ul>
       <%
          String[] names=(String[])request.getAttribute("names");
         
       for(String name:names){
       %>
       <li><%=name%></li>
       <% } %>
    </ul>
</body>
</html>