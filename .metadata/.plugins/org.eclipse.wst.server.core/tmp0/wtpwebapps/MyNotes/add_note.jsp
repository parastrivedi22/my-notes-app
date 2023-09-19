<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyNote: Add Note</title>
</head>
<%@include file="all_js_css.jsp" %>
    
<body>
<div class=container-fluid>
  	<%@include file="navbar.jsp" %>
  </div>
  
  
  
  	<div class="container">
  	<h2 class="mt-1 mb-3">Take a note</h2>
  	
  	<form action="SaveNoteServlet" method="post">
  	
  <div class="mb-3">
    <label for="title" class="form-label">Title</label>
    <input type="text" name="title" class="form-control border border-1 border-white" id="title" aria-describedby="emailHelp" required >
   
  </div>
  
  <div class="mb-3">
    <label for="content" class="form-label">Write here</label>
    <textarea name="content" class="form-control border border-1 border-white " id="content"  style="height:200px;" required></textarea>
    
  </div>

  <button type="submit" class="btn btn-primary">Add Note</button>
</form>
  	</div>
  

</body>
</html>