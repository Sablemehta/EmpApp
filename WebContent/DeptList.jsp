<%@include file="Meta.jsp" %>
<html>
<%@include file="HeadSection.jsp" %>
<body>
<%@include file="Header.jsp" %>
<article>
   <h2>View Departments</h2>
   <nav>
     <c:forEach items="${applicationScope.dlist}" var="dept">
          <a href="viewdept.htm?dept=${dept.dname}"><div>${dept.dname}</div></a>
     </c:forEach>
   </nav>
   
</article>


</body>
</html>