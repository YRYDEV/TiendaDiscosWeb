package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Disco;
import com.ipartek.modelo.dto.Grupo;
import com.ipartek.modelo.dto.V_Disco;

public interface DAO_Metodos {

	Connection conectar();
	void desconectar(Connection con);
	
	List<Grupo> obtenerTodosGrupos(Connection con);
	
	void agregarDisco(Connection con, Disco disco);	
	List<V_Disco> obtenerTodosDiscos(Connection con);
	void borrarDiscoPorId(Connection con, int id);
	V_Disco obtenerDiscoPorId(Connection con, int id);
	void modificarDisco(Connection con, Disco disco);
	List<Disco> obtenerTodosDiscosTabla(Connection con);
	
	void borrarBaseDatos(Connection con);
	
	void restaurarFilaGrupos(Connection con, Grupo grupo);
	void restaurarFilaDiscos(Connection con, Disco disco);

}
