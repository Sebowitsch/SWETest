<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<h1>${title}</h1>
<table class="articletable">
	<tr>
		<th>Bezeichnung</th>
		<th>Preis</th>
		<th>Sofortkauf</th>
		<th>Datum</th>
	</tr>
	<c:forEach items="${articles}" var="article">
		<tr>
			<td>${article.bezeichnung}</td>
			<td>${article.preis}</td>
			<td>${article.sofortkauf}</td>
			<td>${article.datum}</td>
			<td><a href="<%=request.getContextPath()%>/home/show?articleID=${article.ID}">Details</a></td>
		</tr>
	</c:forEach>
</table>