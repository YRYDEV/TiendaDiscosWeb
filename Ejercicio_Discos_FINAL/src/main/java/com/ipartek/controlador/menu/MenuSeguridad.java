package com.ipartek.controlador.menu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DAO_Constantes;


@WebServlet("/MenuSeguridad")
public class MenuSeguridad extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;
  
    public MenuSeguridad() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//hacer los 6 primeros pasos si es que toca
		
		//7
		request.getRequestDispatcher(JSP_SEGURIDAD).forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
