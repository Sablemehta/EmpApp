<%@include file="Meta.jsp"%>
<html>
<%@include file="HeadSection.jsp"%>
<body>
	<%@include file="Header.jsp"%>
	<article>
		<h2>View Employee By ID</h2>
		<div style="text-align:center;margin:20px;">
		<form action="viewbyid.htm">
			Emp ID <input type="number" name="txteid" required /> 
			       <input type="submit"	value="Search"/>
		</form>
		</div>
		
		<div id="err" style="color:red;text-align:center"></div>
		<c:if test="${employee ne null}">
		<table id="tbl1" style="width:200px;">
		   <tbody>
			<tr>
				<td >EID</td>
				<td>${employee.empId}</td>
			</tr>
			<tr>
				<td>ENAME</td>
				<td>${employee.empName}</td>
			</tr>
			<tr>
				<td>SALARY</td>
				<td>${employee.empSal}</td>
			</tr>
			<tr>
				<td>DOJ</td>
				<td>${employee.doj}</td>
			</tr>
			<tr>
				<td>Dept</td>
				<td>${employee.dept}</td>
			</tr>
			</tbody>
		</table>
		</c:if>


	</article>


</body>
</html>