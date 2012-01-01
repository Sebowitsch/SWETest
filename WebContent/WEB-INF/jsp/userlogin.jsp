<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<h1>${title}</h1>

<c:if test="${not empty error}">
	${error}
</c:if>

<form method="post" action="<%=request.getContextPath()%>/user/access">
	Username: <input type="text" name="username" /><br />
	Passwort: <input type="password" name="password" /><br />
	<input type="submit" value="Einloggen" />
</form>