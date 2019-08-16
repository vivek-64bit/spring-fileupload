<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process Transactions records</title>
</head>
<body>
<form:form method="POST" action="processFile" enctype="multipart/form-data" modelAttribute="fileUploadModel">
        File to Upload: <input type="file" name="file"></br></br> 
        <input type="submit" value="Upload"></br>
        <form:errors path="file" style="color:red;"/>
</form:form>
</body>
</html>