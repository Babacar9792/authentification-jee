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

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
  Ajout
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
		 <form action="admin" method="post">
		  <div class="mb-3">
		    <label for=firstName class="form-label">First name</label>
		    <input type="text" class="form-control" id="firstName"  name = "firstName">
		  </div>
		  <div class="mb-3">
		    <label for="lastName" class="form-label">Last name</label>
		    <input type="text" class="form-control" id="lastName"  name = "lastName">
		  </div>
		  <div class="mb-3">
		    <label for="email" class="form-label">Email address</label>
		    <input type="email" class="form-control" id="email" aria-describedby="emailHelp" name = "email">
		  </div>
		  <div class="mb-3">
		    <label for="password" class="form-label">Password</label>
		    <input type="password" class="form-control" id="password" name="password">
		  </div>
			  <button type="reset" class="btn btn-secondary" data-bs-dismiss="modal">Annuler</button>
	        <button type="submit" class="btn btn-primary">Ajouter</button>
		</form>
      </div>
      <div class="modal-footer">
        
      </div>
    </div>
  </div>
</div>


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