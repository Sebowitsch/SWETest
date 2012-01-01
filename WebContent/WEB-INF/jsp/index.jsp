<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>LaptopShop</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/stylesheet.css" type="text/css" />
</head>
<body>
	<div id="bg">
		<div id="container">
			<div id="header">
				<div id="title">
					Laptopshop
				</div>
				<form method="post" style="display:inline;" action="<%=request.getContextPath()%>/search">
					Artikelsuche: 
					<input name="query" type="text" size="15" />
					<input type="submit" value="Go" name="search" class="button" />
				</form>
				<div id="login">
					<div id="login">
						<c:choose>
							<c:when test="${not empty username}">	
								<a href="<%=request.getContextPath()%>/user/logout">Logout</a> &#124; <a href="<%=request.getContextPath()%>/user/daten">Meine Daten</a>
							</c:when>
							<c:otherwise>	
								<a href="<%=request.getContextPath()%>/user/login">Login</a> &#124; <a href="<%=request.getContextPath()%>/user/register">Registrieren</a>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
			<div id="menu">
				<ul>
					<li><a href="<%=request.getContextPath()%>/home">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/home/recent">Neueste Artikel</a></li>
					<li><a href="<%=request.getContextPath()%>/home/recent/laptops">Laptops</a></li>
					<li><a href="<%=request.getContextPath()%>/home/recent/bags">Laptoptaschen</a></li>
					<li><a href="<%=request.getContextPath()%>/home/recent/software">Software</a></li>
				</ul>
				
				Zum Testen
				<ul>
					<li><a href="<%=request.getContextPath()%>/user/userlist">Userlist</a></li>
					<li><a href="<%=request.getContextPath()%>/user/addUser">Add User</a></li>
					<li><a href="<%=request.getContextPath()%>/user/addArtikel">Add Artikel</a></li>
				</ul>
			</div>
			<div id="main">