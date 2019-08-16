<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Records with Error</h2>
	FileName :
	<strong> ${fileName} </strong> has below problems:
	<table border="1">
	<th>Transaction Reference</th><th>Description</th><th>End Balance</th>
		<c:forEach var="record" items="${recordList}">
			<tr>
				<td>${record.reference}</td>
				<td>${record.description}</td>
				<td>${record.endBalance}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/">Try Again!</a>
</body>
</html>