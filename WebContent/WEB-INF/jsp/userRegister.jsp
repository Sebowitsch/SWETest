<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<h1>${title}</h1>

<form method="post" action="<%=request.getContextPath()%>/user/newUser">
	Vorname: <input type="text" name="firstname" /><br />
	Nachname: <input type="text" name="lastname" /><br />
	Username: <input type="text" name="username" /><br />
	Passwort: <input type="password" name="password" /><br />
	<input type="submit" value="Registrieren" />
</form>