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

</head>

<body>

	<%@ include file="includes/cabecera.jsp"%>

	<main>
		<h2>Gestion los discos</h2>
		
		<section>
			<form method="GET" action="Agregar">
				<h3>Agredar disco</h3>
				<input type="text" name="titulo" placeholder="Titulo" required><br>
				
				<input type="number" name="num_canciones" placeholder="Numero de canciones" required><br>
			
			
				<select name="grupo">
					<%for(Grupo elemento: listaGrupos){%>	
						<option value="<%=elemento.getId()%>"><%=elemento.getGrupo()%></option>
					<%}%>
				</select><br>
				
				<input type="submit" value="Agregar">
			</form>
		</section>
		
		
		
		<section>
			<table>
		        <thead>
		            <tr>
		                <th>ID</th>
		                <th>Título</th>
		                <th>Número de Canciones</th>
		                <th>Grupo</th>
		                <th>Opciones</th>
		            </tr>
		        </thead>
		        <tbody>
		        
		        <%
		        for(V_Disco  elemento : listaDiscos){
		        
		        %>	
		        	<tr>
		                <td><%=elemento.getId() %></td>
		                <td><%=elemento.getTitulo() %></td>
		                <td><%=elemento.getNumCanciones() %></td>
		                <td><%=elemento.getGrupo() %></td>
		                <td>
		                    <a href="Borrar?id=<%=elemento.getId() %>">Borrar</a> |
		                    <a href="FormModificar?id=<%=elemento.getId() %>">Modificar</a>
		                </td>
	           		</tr>
		        	
		        	
		       	<%	
		        }
		        %>
		            
		            
		        </tbody>
    		</table>
		</section>
		

	</main>

	<%@ include file="includes/pie.jsp"%>

</body>
</html>