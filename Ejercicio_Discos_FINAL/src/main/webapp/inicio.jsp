<%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.V_Disco"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
List<V_Disco> listaDiscos = new ArrayList<V_Disco>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_DISCOS)!=null){
	listaDiscos=(List<V_Disco>)request.getAttribute(DAO_Constantes.ATR_LISTA_DISCOS);
}
%> 


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plantilla</title>
<link rel="stylesheet" href="styles/styles.css">
<link rel="stylesheet" href="styles/styles_index.css">
</head>

<body>

	<%@ include file="includes/cabecera.jsp"%>

	<main>
		<h2>Ver todos los discos</h2>
		
		<%for(V_Disco elemento:listaDiscos) {%>
		<section>
			<h3><%=elemento.getGrupo() %></h3>
			<p><%=elemento.getTitulo() %></p>
			<p><%=elemento.getNumCanciones() %> canciones</p>
		</section>
		<%}%>
		

	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>