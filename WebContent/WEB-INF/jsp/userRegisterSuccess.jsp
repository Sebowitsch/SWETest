<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<h1>${title}</h1>

<c:if test="${not empty print}">
	${print}
</c:if>