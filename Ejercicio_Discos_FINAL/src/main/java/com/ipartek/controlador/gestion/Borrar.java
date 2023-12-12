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
import com.ipartek.modelo.dto.Grupo;
import com.ipartek.modelo.dto.V_Disco;

@WebServlet("/Borrar")
public class Borrar extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;
       

    public Borrar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//los 7 pasos, el dos aqui no merece la pena por ser solo un int
		//1
		int id=0;
		if (request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		
		//traza para ver que funciona
		System.out.println("EL ID ES EL: "+id );
		
		//2
		//NO HACEMOS EL PASO 2 POR SER SOLO UN ID
		
		//3
		DB_Helper db= new DB_Helper();
		Connection con= db.conectar();
		
		//4 borrar y obtener todo lo necesario para que 
		// al volver a gestion.jsp cargue el select y la tabla
		db.borrarDiscoPorId(con, id);
		
		List<Grupo> listaGrupos = db.obtenerTodosGrupos(con);
		List<V_Disco> listaDiscos= db.obtenerTodosDiscos(con);
		
		
		//5
		db.desconectar(con);
		
		
		//6 meter en la mochila la tabla de discos al 
		// completo y el select de grupos
		request.setAttribute(ATR_LISTA_GRUPOS, listaGrupos);
		request.setAttribute(ATR_LISTA_DISCOS, listaDiscos);
		
		
		//7
		request.getRequestDispatcher(JSP_GESTION).forward(request, response);
		
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
