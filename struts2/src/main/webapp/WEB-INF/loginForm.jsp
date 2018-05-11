<%@ page 
 contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" 
			 uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
</head>
<body style="font-size:30px;">

	<c:url var="url" value="/login/login2.action"/>
	<h1>${message}</h1>
	<form action="${url}" method="post">
	
		<div><label>用户:</label>
			  <input type="text" name="user.name"/>
	   </div>
	   <div><label>密码:</label>
	   	  <input type="password" name="user.pwd" />
	   </div>
	   <div><input type="submit" value="登录" /></div>
	</form>
</body>
</html>




