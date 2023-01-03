<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="./base.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<body>
<div class="container mt-3">
    
      <div class="row">
        <div class="col-md-12"></div>
        
        <h1 class="text-center mb-3">Welcome to Product App</h1>
      
      <table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Product Name</th>
      <th scope="col">Description</th>
      <th scope="col">Price</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  
  
  
  <c:forEach items="${product }" var="p">
    <tr>
      <th scope="row">${p.id}</th>
      <td>${p.name }</td>
      <td>${p.description }</td>
      <td>${p.price }</td>
      <td>
        <%-- <a href="delete/${p.id }">delete</a> --%>
        <a href="delete/${p.id}"><i class="fa-solid fa-trash-can"></i></a>
        <a href="update/${p.id}"><i class="fa-solid fa-pen"></i></a>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>

<div class="container text-center">
     <a href="add_p" class="btn btn-outline-success">Add Product</a>
</div>
      </div>
    
    
    </div>
</body>
</html>