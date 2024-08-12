<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>Document</title>
</head>
<body>
   
   
   <jsp:include page="../shared/Navbar.jsp"></jsp:include>
   <h4 class="text-danger text-center">Liste des utilisateurs</h4>

   
   <%
 String userList = (String) request.getAttribute ("userList").toString();
   out.print(userList);
%>
   
   <p> avec c:out</p>
   
   <c:out value="${1 + 1}" />
  
   <!-- <c:out value="${userList[0].firstName}"></c:out>
   <c:choose>
    <c:when test="${not empty userList}">
        <p>La liste des utilisateurs est récupérée. </p>
    </c:when>
    <c:otherwise>
        <p>Aucune donnée trouvée dans userList .</p>
    </c:otherwise>
</c:choose> -->
   <div class="container">
    <table class="table table-striped">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">FirstName</th>
            <th scope="col">LastName</th>
            <th scope="col">Email</th>
             <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${userList}" var="user">
                   <tr>
                       <th scope="row">${user.id}</th>
                       <td>${user.firstName}</td>
                       <td>${user.lastName}</td>
                       <td>${user.email}</td>
                       <td><a href="#">Edit</a></td>
                   </tr>
               </c:forEach>
        </tbody>
      </table>
   </div>
   

    
</body>
</html>