<%@page import="org.seed.bean.Module"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-image: url("paper.gif");
	background-color: #cccccc;
}

form {
	border: 3px solid #f1f1f1;
}

input[type=text], input[type=password] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="CreateModule.jsp" class="btn btn-info" role="button">Create
		Module</a>|
	<a href="ViewModule.jsp" class="btn btn-info" role="button">View
		Module</a>
	<br>
	<hr>
<body>

	<h2>Module Form</h2>
	<% 
 String message= request.getParameter("update");
if(message!=null){
	
%>
	<h3>Data Updated Successfully</h3>
	<% 
}
%>
	<form action="ModuleRegisterAndFetchServlet">


		<% 
 Module module= (Module)request.getAttribute("module");
		if(module!=null){
 System.out.print(module.getId());
%>
		<input type="hidden" name="updateForm" value="<%= module.getId() %>" />
		<div class="container">
			<label><b>Module Code</b></label> <input type="text"
				placeholder="Enter module Code"
				value="<%= module.getModuleCode() %>" name="mcode" required>

			<label><b>Module Name</b></label> <input type="text"
				placeholder="Enter module Name"
				value="<%= module.getModuleName() %>" name="mname" required>

			<label><b>No Of Hours</b></label> <input type="text"
				placeholder="Enter no of hours" value="<%= module.getNoOfHours() %>"
				name="mhours" required>

			

			<button type="submit">Update Module</button>
			<button type="reset">Reset</button>
			<input type="checkbox" name="mstatus"> Is Module Active
		</div>

<% 
		}
%>
	</form>

</body>
</html>

</body>
</html>