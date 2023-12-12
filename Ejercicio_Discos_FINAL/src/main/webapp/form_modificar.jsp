<%@page import="com.ipartek.modelo.dto.V_Disco"%>
<%@page import="com.ipartek.modelo.DAO_Constantes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Grupo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
List<Grupo> listaGrupos = new ArrayList<Grupo>();
if(request.getAttribute(DAO_Constantes.ATR_LISTA_GRUPOS)!=null){
 listaGrupos = (List<Grupo>)request.getAttribute(DAO_Constantes.ATR_LISTA_GRUPOS);
}



V_Disco disco = new V_Disco();
if(request.getAttribute(DAO_Constantes.ATR_DISCO)!=null){
	disco=(V_Disco)request.getAttribute(DAO_Constantes.ATR_DISCO);
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
		
		<section>
			<form method="GET" action="Modificar">
				<h3>Modificar disco</h3>
				
				<input type="text" name="id"  required value="<%=disco.getId() %>" readonly ><br>
				
				<input type="text" name="titulo" required value="<%=disco.getTitulo() %>"><br>
				
				<input type="number" name="num_canciones"  required value="<%=disco.getNumCanciones() %>"><br>
			
			
				<select name="grupo">
				<%for(Grupo elemento:listaGrupos){
				
					if(elemento.getId()==disco.getFk_grupo()){
						%>
						<option value="<%= elemento.getId()%>" selected><%= elemento.getGrupo()%></option>
					<% 
					}else{
					%>
						<option value="<%= elemento.getId()%>"><%= elemento.getGrupo()%></option>
					<%	
					}		
				} %>	
				</select><br>
				
				<input type="submit" value="Modificar">
			</form>
		</section>
		
	
			

	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>