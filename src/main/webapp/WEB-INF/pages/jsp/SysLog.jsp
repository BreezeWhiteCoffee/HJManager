<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>System Log List Page</h1>
   <div>
   <table border="1" width="100%" cellpadding="2" cellspacing="0">
       <thead>
          <tr>
           <th>id</th>
           <th>username</th>
           <th>method</th>
          </tr>
       </thead>
       <tbody>
          <c:forEach items="${pageObject.records}" var="item">
            <tr>
            <td>${item.id}</td>
            <td>${item.username}</td>
            <td>${item.method}</td>
            </tr>
          </c:forEach>
       </tbody>
   </table>
   </div>
</body>
</html>





