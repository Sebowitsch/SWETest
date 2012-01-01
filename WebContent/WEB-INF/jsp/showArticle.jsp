<h1>Artikel: ${article.bezeichnung}</h1>

<h2>Produktübersicht</h2>
<table class="articleview">
	<tr>
		<td rowspan="4"><img src="<%=request.getContextPath()%>/images/laptop.jpg" alt="Abbildung"/></td>
		<td> Kaufen </td>
	</tr>
	<tr>
		<td>Preis: ${article.preis}</td>
	</tr>
	<tr>
		<td>${article.preis} aktueller Preis/st&uuml;ckzahl</td>
	</tr>	
	<tr>
		<td>Verk&auml;ufer</td>
	</tr>

</table>

<h2>Produktbeschreibung</h2>
Beschreibung