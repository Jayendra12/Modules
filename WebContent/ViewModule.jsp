<%@page import="java.util.Iterator"%>
<%@page import="org.seed.bean.Module"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<script>
	$(document).ready(function() {
	    var t = $('#example').DataTable( {
	        "columnDefs": [ {
	            "searchable": false,
	            "orderable": false,
	            "targets": 0
	        } ],
	        "order": [[ 1, 'asc' ]]
	    } );
	 
	    t.on( 'order.dt search.dt', function () {
	        t.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
	            cell.innerHTML = i+1;
	        } );
	    } ).draw();
	} );
</script>
</body>
<a href="CreateModule.jsp" class="btn btn-info" role="button">Create
	Module</a>|
<a href="ViewModule.jsp" class="btn btn-info" role="button">View
	Module</a>
<br>

<div class="container">
	<h2>Table</h2>

	<div class="table-responsive">
		<table id="example" class="table">
			<thead>
				<tr>
					<th>SrNo</th>
					<th>ModuleCode</th>
					<th>ModuleName</th>
					<th>NoOfHours</th>
				</tr>
			</thead>
			<tbody>
				<% 
					  List<Module> list=(List)request.getAttribute("Modules");
				     if(list!=null){
					  Iterator it=  list.iterator();
					  while(it.hasNext()){
						  Module module=(Module)it.next();
					  
                %>
				<tr>
					
					<td><%= module.getModuleCode() %></td>
					<td><%= module.getModuleName() %></td>
					<td><%= module.getNoOfHours() %></td>
				</tr>
				<% 
					  }
				     }
				%>
</html>