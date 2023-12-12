package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Disco;
import com.ipartek.modelo.dto.Grupo;
import com.ipartek.modelo.dto.V_Disco;

public class DB_Helper implements DAO_Constantes, DAO_Metodos{

	@Override
	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);
			System.out.println("BASE DE DATOS CONECTADA");
		} catch (ClassNotFoundException e) {
			System.out.println("NO SE ENCONTRO EL DRIVER");
		} catch (SQLException e) {
			System.out.println("ERROR AL CONECTAR A LA BD");
		}

		return con;
	}

	@Override
	public void desconectar(Connection con) {
		try {
			con.close();
			System.out.println("BASE DE DATOS DESCONECTADA");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO DESCONECTAR");
		}
	}

	@Override
	public void agregarDisco(Connection con, Disco disco) {

		try {
			// "call sp_insertar_disco('titulo', canciones, fk_grupo);"
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_DISCO);
				cStmt.setString(1, disco.getTitulo());
				cStmt.setInt(2, disco.getNumCanciones());
				cStmt.setInt(3, disco.getFk_grupo());

			cStmt.execute();

			System.out.println("SE INSERTO EL DISCO CORRECTAMENTE");

		} catch (SQLException e) {
			System.out.println("NO SE PUDO INSERTAR EL DISCO");
			e.printStackTrace();
		}

	}

	@Override
	public List<Grupo> obtenerTodosGrupos(Connection con) {

		List<Grupo> lista = new ArrayList<Grupo>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_GRUPOS);

			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				Grupo gru = new Grupo();

				gru.setId(rs.getInt(GRUPOS_ID));
				gru.setGrupo(rs.getString(GRUPOS_GRUPO));

				lista.add(gru);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return (List<Grupo>) new ArrayList<Grupo>();
		}
		return lista;

	}

	@Override
	public List<V_Disco> obtenerTodosDiscos(Connection con) {
		List<V_Disco> lista = new ArrayList<V_Disco>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TODOS_DISCOS);

			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				V_Disco disco = new V_Disco();

				disco.setId(rs.getInt(V_DISCOS_ID));
				disco.setTitulo(rs.getString(V_DISCOS_TITULO));
				disco.setNumCanciones(rs.getInt(V_DISCOS_NUM_CANCIONES));
				disco.setFk_grupo(rs.getInt(V_DISCOS_FK_GRUPO));
				disco.setGrupo(rs.getString(V_DISCOS_GRUPO));

				lista.add(disco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return (List<V_Disco>) new ArrayList<V_Disco>();
		}
		return lista;

	}

	@Override
	public void borrarDiscoPorId(Connection con, int id) {

		try {
			// call bd_discos.sp_borrar_disco(24);
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_DISCO_POR_ID);
				cStmt.setInt(1, id);

			cStmt.execute();

			System.out.println("SE BORRO EL DISCO CORRECTAMENTE");

		} catch (SQLException e) {
			System.out.println("NO SE PUDO BORRAR EL DISCO");
			e.printStackTrace();
		}
	}

	@Override
	public V_Disco obtenerDiscoPorId(Connection con, int id) {

		V_Disco disco = new V_Disco();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_DISCO_POR_ID);
				cStmt.setInt(1, id);

			cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				disco.setId(rs.getInt(V_DISCOS_ID));
				disco.setTitulo(rs.getString(V_DISCOS_TITULO));
				disco.setNumCanciones(rs.getInt(V_DISCOS_NUM_CANCIONES));
				disco.setFk_grupo(rs.getInt(V_DISCOS_FK_GRUPO));
				disco.setGrupo(rs.getString(V_DISCOS_GRUPO));
			}

		} catch (SQLException e) {
			disco = new V_Disco();
			e.printStackTrace();
		}

		return disco;

	}

	@Override
	public void modificarDisco(Connection con, Disco disco) {

		try {
			// call sp_modificar_disco(10, 'TITU', 1111, 2);
			CallableStatement cStmt = con.prepareCall(SP_MODIFICAR_DISCO);
				cStmt.setInt(1, disco.getId());
				cStmt.setString(2, disco.getTitulo());
				cStmt.setInt(3, disco.getNumCanciones());
				cStmt.setInt(4, disco.getFk_grupo());

			cStmt.execute();

			System.out.println("SE MODIFICO EL DISCO CORRECTAMENTE");

		} catch (SQLException e) {
			System.out.println("NO SE PUDO MODIFICAR EL DISCO");
			e.printStackTrace();
		}

	}

	@Override
	public List<Disco> obtenerTodosDiscosTabla(Connection con) {

		List<Disco> lista = new ArrayList<Disco>();

		try {
			CallableStatement cStmt = con.prepareCall(SP_OBTENER_TABLA_DISCOS);
				cStmt.execute();

			ResultSet rs = cStmt.getResultSet();

			while (rs.next()) {
				Disco disco = new Disco();

				disco.setId(rs.getInt(DISCOS_ID));
				disco.setTitulo(rs.getString(DISCOS_TITULO));
				disco.setNumCanciones(rs.getInt(DISCOS_NUM_CANCIONES));
				disco.setFk_grupo(rs.getInt(DISCOS_FK_GRUPO));

				lista.add(disco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return (List<Disco>) new ArrayList<Disco>();
		}
		return lista;

	}
	
	@Override
	public void restaurarFilaGrupos(Connection con, Grupo grupo) {

		try {
			// call sp_restaurar_una_fila_grupos(?, ?);
			CallableStatement cStmt = con.prepareCall(SP_RESTAURAR_GRUPO);
				cStmt.setInt(1, grupo.getId());
				cStmt.setString(2, grupo.getGrupo());

			cStmt.execute();

			System.out.println("SE INSERTO EL GRUPO CORRECTAMENTE");

		} catch (SQLException e) {
			System.out.println("NO SE PUDO INSERTAR EL GRUPO");
			e.printStackTrace();
		}
	}
	
	@Override
	public void borrarBaseDatos(Connection con) {

		try {
			CallableStatement cStmt = con.prepareCall(SP_BORRAR_BD);
				cStmt.execute();

			System.out.println("SE BORRO LAS TABLAS");

		} catch (SQLException e) {
			System.out.println("NO SE PUDO BORRAR LAS TABLAS");
			e.printStackTrace();
		}

	}
	
	@Override
	public void restaurarFilaDiscos(Connection con, Disco disco) {
		try {
			// call sp_restaurar_una_fila_discos(1, 'Sin after sin', 8, 5);

			CallableStatement cStmt = con.prepareCall(SP_RESTAURAR_DISCO);
				cStmt.setInt(1, disco.getId());
				cStmt.setString(2, disco.getTitulo());
				cStmt.setInt(3, disco.getNumCanciones());
				cStmt.setInt(4, disco.getFk_grupo());
				cStmt.execute();

			System.out.println("SE INSERTO EL DISCO CORRECTAMENTE");

		} catch (SQLException e) {
			System.out.println("NO SE PUDO INSERTAR EL GRUPO");
			e.printStackTrace();
		}
	}

}
