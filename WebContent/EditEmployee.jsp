<%@include file="Meta.jsp"%>
<html>
<%@include file="HeadSection.jsp"%>
<body>
	<%@include file="Header.jsp"%>
	
	<article>
		<h2>Add Employee</h2>
		<form action="update.htm" method="post">
			<table>
				<tbody>
					<tr>
						<td>Eid</td>
						<td><input type="number" readonly name="txteid" value="${employee.empId }"/></td>
					</tr>
					<tr>
						<td>Emp Name</td>
						<td>${employee.empName}</td>
					</tr>
					<tr>
						<td>Salary</td>
						<td><input type="number" required name="txtsal" value="${employee.empSal }"/></td>
					</tr>
					<tr>
						<td>Dept</td>
						<td><select name="cbodept" required>
						    <option value="">--select dept--</option>
						    <c:forEach items="${applicationScope.dlist}" var="dept">
						    <c:choose>
						       <c:when test="${dept.dname eq employee.dept}">
						           <option value="${dept.dname}" selected>${dept.dname}</option>
						       </c:when>
						       <c:otherwise>
						          <option value="${dept.dname}">${dept.dname}</option>
						       </c:otherwise>
						    </c:choose>
						        
						    </c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>DOJ</td>
						<td><input type="date" required name="txtdt" value="${employee.doj}"/></td>
					</tr>
					<tr>
						<td colspan="2" class="last"><input type="submit" value="Edit"/></td>
						
					</tr>
				</tbody>
			</table>
		</form>
	</article>


</body>
</html>