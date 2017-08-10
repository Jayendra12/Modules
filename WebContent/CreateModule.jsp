<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="module.js"></script>
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

	<%
		String msg = request.getParameter("Message");
		if (msg != null) {
	%>
	Record inserted successfully
	<%
		}
	%>
	<h2>Module Form</h2>

	<form action="ModuleRegisterAndFetchServlet" name="emp" method="post"
		onsubmit="return validate_form();">



		<label><b>Module Code</b></label><br>

		<%
			Boolean bcode = (Boolean) request.getAttribute("code");
			if (bcode != null) {
				if (bcode.equals(true)) {
		%>
		module code already exists!
		<%
			}
			}
		%>

		<div class="form-group">

			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<input type="text" placeholder="Enter module Code" name="mcode"
						required> <label><b>Module Name</b></label> <br>
				</div>
			</div>
		</div>
		<%
			Boolean bcheck = (Boolean) request.getAttribute("moduleCheck");
			if (bcheck != null) {
				if (bcheck.equals(true)) {
		%>
		module name and hours already exists!
		<%
			}
			}
		%>
		<font color="red">
			<DIV id="vname"></DIV>
		</font>
		<div class="form-group">

			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<input type="text" placeholder="Enter module Name"
						onkeypress="return isStringKey(event)" name="mname" required>
					<label><b>No Of Hours</b></label>

				</div>
			</div>
		</div>
		<font color="red">
			<DIV id="vhours"></DIV>
		</font>
		<div class="form-group">
			<div class="col-md-4 inputGroupContainer">
				<div class="input-group">
					<input type="text" placeholder="Enter no of hours"
						onkeypress="return isNumberKey(event)" name="mhours" required>
				</div>
			</div>
		</div>
		<button type="submit">Create Module</button>
		<button type="reset">Reset</button>
		<input type="checkbox" name="mstatus" checked="checked"> Is
		Module Active
		</div>


	</form>

</body>
</html>

</body>
</html>