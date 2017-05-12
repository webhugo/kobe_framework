<html>
<body>
<h2>Hello World!</h2>
<%
    Object str = request.getAttribute("test");
%>
<h2><%=str%> <hr /></h2>
</body>
</html>
