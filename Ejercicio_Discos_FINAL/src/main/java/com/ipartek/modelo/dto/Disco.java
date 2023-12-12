package com.ipartek.modelo.dto;

public class Disco {
	
	private int id;
	private String titulo;
	private int numCanciones;
	private int fk_grupo;
	
	public Disco(int id, String titulo, int numCanciones, int fk_grupo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numCanciones = numCanciones;
		this.fk_grupo = fk_grupo;
	}
	
	public Disco() {
		super();
		this.id = 0;
		this.titulo = "";
		this.numCanciones = 0;
		this.fk_grupo = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumCanciones() {
		return numCanciones;
	}

	public void setNumCanciones(int numCanciones) {
		this.numCanciones = numCanciones;
	}

	public int getFk_grupo() {
		return fk_grupo;
	}

	public void setFk_grupo(int fk_grupo) {
		this.fk_grupo = fk_grupo;
	}

	@Override
	public String toString() {
		return id+";"+titulo+";"+numCanciones+";"+fk_grupo;
	}
	
	
	
	

}
