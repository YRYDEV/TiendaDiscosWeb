package com.ipartek.controlador.gestion;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DAO_Constantes;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Disco;
import com.ipartek.modelo.dto.Grupo;
import com.ipartek.modelo.dto.V_Disco;

@WebServlet("/Agregar")
public class Agregar extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;

    public Agregar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1
		String titulo="";
		if (request.getParameter("titulo")!=null ) {
			titulo=request.getParameter("titulo");
		}
		
		int num_canciones=0;
		if (request.getParameter("num_canciones")!=null) {
			num_canciones=Integer.parseInt(request.getParameter("num_canciones"));		
		}
		
		int grupo=0;
		if (request.getParameter("grupo")!=null) {
			grupo=Integer.parseInt(request.getParameter("grupo"));
		}
		
		//2
		Disco disco=new Disco(0, titulo, num_canciones, grupo);
		System.out.println(disco);

		//3
		DB_Helper db= new DB_Helper();
		Connection con= db.conectar();
		
		//4
		db.agregarDisco(con,disco);
		
		List<Grupo> listaGrupos= db.obtenerTodosGrupos(con);
		List<V_Disco> listaDiscos= db.obtenerTodosDiscos(con);
		
		//5
		db.desconectar(con);
		
		//6
		request.setAttribute(ATR_LISTA_GRUPOS, listaGrupos);
		request.setAttribute(ATR_LISTA_DISCOS, listaDiscos);
		
		//7
		request.getRequestDispatcher(JSP_GESTION).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
