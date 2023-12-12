package com.ipartek.modelo;

public interface DAO_Constantes {

	// cadenas de conexion
	String BASE_DATOS = "bd_discos";
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + BASE_DATOS;
	String USUARIO = "root";
	String PASS = "####";

	// archivos JSP
	String JSP_INDEX = "inicio.jsp";
	String JSP_GESTION = "gestion.jsp";
	String JSP_FRM_MODIFICAR ="form_modificar.jsp";
	String JSP_SEGURIDAD ="seguridad.jsp";

	// constantes de tablas y vistas
	String TABLA_GRUPOS="grupos";
	String GRUPOS_ID="id";
	String GRUPOS_GRUPO="grupo";
	
	String TABLA_DISCOS="discos";
	String DISCOS_ID="id";
	String DISCOS_TITULO="titulo";
	String DISCOS_NUM_CANCIONES="numCanciones";
	String DISCOS_FK_GRUPO="fk_grupo";
	
	String VISTA_DISCOS="v_discos";
	String V_DISCOS_ID="id";
	String V_DISCOS_TITULO="titulo";
	String V_DISCOS_NUM_CANCIONES="numCanciones";
	String V_DISCOS_FK_GRUPO="fk_grupo";
	String V_DISCOS_GRUPO="grupo";

	// constantes de llamadas a Stored procedures
	String SP_INSERTAR_DISCO="call sp_insertar_disco(?, ?, ?);";
	String SP_OBTENER_TODOS_GRUPOS="call sp_obtener_todos_grupos();";
	String SP_OBTENER_TODOS_DISCOS="call sp_obtener_todos_discos();";
	String SP_BORRAR_DISCO_POR_ID="call sp_borrar_disco(?);";
	String SP_OBTENER_DISCO_POR_ID="call sp_obtener_todos_discos_id(?);";
	String SP_MODIFICAR_DISCO="call sp_modificar_disco(?, ?, ?, ?);";
	String SP_OBTENER_TABLA_DISCOS="call sp_obtener_tabla_discos();";
	String SP_RESTAURAR_GRUPO="call sp_restaurar_una_fila_grupos(?, ?)";
	String SP_BORRAR_BD="call sp_borrar_todos();";
	String SP_RESTAURAR_DISCO="call sp_restaurar_una_fila_discos(?, ?, ?, ?);";

	// constantes de Atributos de los formularios
	String ATR_LISTA_GRUPOS="atr_lista_grupos";
	String ATR_LISTA_DISCOS="atr_lista_discos";
	String ATR_DISCO="atr_disco";
	
	// constantes de rutas 
	String DIRECCION_CS_GRUPOS="C:\\Alain\\grupos.csv";
	String DIRECCION_CS_DISCOS="C:\\Alain\\discos.csv";

}
