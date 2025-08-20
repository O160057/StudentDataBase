<html>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
<h2 align="center">All Students</h2>
<table border="1" align="center">
  <tr><th>ID</th><th>Name</th><th>Email</th><th>Course</th><th>Update Action</th><th>Delete Action</th>
	<th style="color:red"><input type="button" value="Add Student" onclick="location.href='/form'"></th></tr>
  <c:forEach var="s" items="${students}">
    <tr>
		<form action="/update" modelAttribute="students" method="post">
      		<td><input type="number" value="${s.id}" name="id"/></td>
      		<td><input type="text" value="${s.name}" name="name"/></td>
      		<td><input type="text" value="${s.email}" name="email"/></td>
      		<td><input type="text" value="${s.course}" name="course"/></td>
      		<td align="center" valign="middle"><input type="submit" value="Update"/></td>
			<td align="center" valign="middle"><input type="button" value="Delete" onclick="location.href='/delete/${s.id}'"></td>
	 	</form>
	</tr>
  </c:forEach>
</table>
</body>
</html>