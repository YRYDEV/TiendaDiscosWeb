package com.ipartek.controlador.menu;

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
import com.ipartek.modelo.dto.V_Disco;


@WebServlet("/MenuVerTodosDiscos")
public class MenuVerTodosDiscos extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;

    public MenuVerTodosDiscos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DB_Helper db= new DB_Helper();
		Connection con= db.conectar();
		
		List<V_Disco> listaDiscos= db.obtenerTodosDiscos(con);
		
		db.desconectar(con);
		
		request.setAttribute(ATR_LISTA_DISCOS, listaDiscos);
		
		
		
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
