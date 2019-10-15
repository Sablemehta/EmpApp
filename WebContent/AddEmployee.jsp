<%@include file="Meta.jsp"%>
<html>
<%@include file="HeadSection.jsp"%>
<body>
	<%@include file="Header.jsp"%>
	
	<article>
		<h2>Add Employee</h2>
		<form action="add.htm" method="post">
			<table>
				<tbody>
					<tr>
						<td>Eid</td>
						<td><input type="number" required name="txteid"/></td>
					</tr>
					<tr>
						<td>Emp Name</td>
						<td><input type="text" required pattern="[a-z]{3,15}" name="txtname"/></td>
					</tr>
					<tr>
						<td>Salary</td>
						<td><input type="number" required name="txtsal"/></td>
					</tr>
					<tr>
						<td>Dept</td>
						<td><select name="cbodept" required>
						    <option value="">--select dept--</option>
						    <c:forEach items="${applicationScope.dlist}" var="dept">
						        <option value="${dept.dname}">${dept.dname}</option>
						    </c:forEach>
						</select></td>
					</tr>
					<tr>
						<td>DOJ</td>
						<td><input type="date" required name="txtdt"/></td>
					</tr>
					<tr>
						<td colspan="2" class="last"><input type="submit" value="add"/></td>
						
					</tr>
				</tbody>
			</table>
		</form>
	</article>


</body>
</html>