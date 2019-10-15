<%@include file="Meta.jsp"%>
<html>
<head>
  <style>
    .seats .btn{
      margin:10px;
      
    }
  </style>
</head>

<body>
<%
  String[] arr = {"A", "B", "C", "D", "E"};
  pageContext.setAttribute("rownos", arr);
%>
<c:forEach begin="0" end="4" var="i">
<div class="seats">
   <c:forEach begin="1" end="5" var="j">
      <input type="button" class="btn" value="${pageScope.rownos[i]}${j}" disabled/>
   </c:forEach>
   </div>
</c:forEach>
</body>
</html>