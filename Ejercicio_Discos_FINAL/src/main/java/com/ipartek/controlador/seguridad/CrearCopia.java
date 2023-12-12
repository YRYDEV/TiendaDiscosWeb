package com.ipartek.controlador.seguridad;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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


@WebServlet("/CrearCopia")
public class CrearCopia extends HttpServlet implements DAO_Constantes {
	private static final long serialVersionUID = 1L;
       
 
    public CrearCopia() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
			DB_Helper db= new DB_Helper();
			Connection con= db.conectar();

			List<Grupo> listaGrupos= db.obtenerTodosGrupos(con);
			List<Disco> listaDiscos= db.obtenerTodosDiscosTabla(con);

			db.desconectar(con);

		//guardar el fichero GRUPOS y discos
			try {
				FileWriter archivo = new FileWriter(DIRECCION_CS_GRUPOS);
				PrintWriter pw = new PrintWriter(archivo);
				for (Grupo elemento : listaGrupos) {
					pw.println(elemento);
				}
				archivo.close();//si no lo pongo, no escribe
				System.out.println("GUARDADO EL ARCHIVO GRUPOS");
				
				
				archivo = new FileWriter(DIRECCION_CS_DISCOS);
				pw = new PrintWriter(archivo);
				for (Disco elemento : listaDiscos) {
					pw.println(elemento);
				}
				archivo.close();//si no lo pongo, no escribe
				System.out.println("GUARDADO EL ARCHIVO DISCOS");
			
			} catch (IOException e) {
				System.out.println("NO SE PUDO GUARDAR EL ARCHIVO");
				e.printStackTrace();
				
			}
				
			request.getRequestDispatcher(JSP_SEGURIDAD).forward(request, response);
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
