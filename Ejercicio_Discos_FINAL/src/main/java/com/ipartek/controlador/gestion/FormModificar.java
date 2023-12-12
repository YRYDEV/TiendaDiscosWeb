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

@WebServlet("/FormModificar")
public class FormModificar extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;

    public FormModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1
		int id=0;
		if (request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		
		
		
		//2 NO LO HACEMOS POR SER SOLO UN ID
		
		//3
		DB_Helper db=new DB_Helper();
		Connection con=db.conectar(); 
		
		//4 HACER LUEGO
		//4.1 obtener todos los datos del disco que tiene ese id
		V_Disco disco= db.obtenerDiscoPorId(con, id);
		
		//4.2 obtener todos los grupos
		List<Grupo> listaGrupos = db.obtenerTodosGrupos(con);
		
		//5
		db.desconectar(con);

		//6 HACER LUEGO
		//6.1 el disco leido, a la mochila
		
		//6.2 meter en la mochila la lista de todos los grupos
		request.setAttribute(ATR_LISTA_GRUPOS, listaGrupos);
		request.setAttribute(ATR_DISCO, disco);
		
		//7
		request.getRequestDispatcher(JSP_FRM_MODIFICAR).forward(request, response);
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
