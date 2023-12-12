package com.ipartek.modelo.dto;

public class Grupo {

	private int id;
	private String grupo;
	
	public Grupo(int id, String grupo) {
		this.id = id;
		this.grupo = grupo;
	}
	
	public Grupo() {
		this.id = 0;
		this.grupo = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return id+";"+grupo;
	}

}
