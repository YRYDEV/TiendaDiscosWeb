package com.ipartek.modelo.dto;

public class V_Disco {
	
	private int id;
	private String titulo;
	private int numCanciones;
	private int fk_grupo;
	private String grupo;
	
	public V_Disco(int id, String titulo, int numCanciones, int fk_grupo, String grupo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.numCanciones = numCanciones;
		this.fk_grupo = fk_grupo;
		this.grupo = grupo;
	}
	
	public V_Disco() {
		super();
		this.id = 0;
		this.titulo = "";
		this.numCanciones = 0;
		this.fk_grupo = 0;
		this.grupo = "";
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

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "v_disco [id=" + id + ", titulo=" + titulo + ", numCanciones=" + numCanciones + ", fk_grupo=" + fk_grupo
				+ ", grupo=" + grupo + "]";
	}
	
	
	
	

}
