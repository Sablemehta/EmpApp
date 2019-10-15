<%@include file="Meta.jsp"%>
<html>
<%@include file="HeadSection.jsp"%>
<body>
<%@include file="Header.jsp"%>
<article>
<h2>Home</h2>

<nav>
   <a href="viewall.htm"><div>View All Employee</div></a>
   <a href="DeptList.jsp"> <div>View By Dept</div></a>
   <a href="EmpId.jsp"> <div>View By ID</div></a>
   <a href="AddEmployee.jsp"><div>Add Employee</div></a>
</nav>
<div style="text-align:center">
    ${msg}
</div>

</article>
</body>
</html>