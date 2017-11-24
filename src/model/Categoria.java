package model;

import control.ParametroVazioException;

public class Categoria {
	private int id;
	private String nome;

	public Categoria(String nome) throws Exception {
		setNome(nome);
	}
	public Categoria(int id, String nome) throws Exception {
		setNome(nome);
		setId(id);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws ParametroVazioException {
		if((nome != null) && (nome.trim().length() > 0)) {
			this.nome = nome;
		} else {
			throw new ParametroVazioException("Nome invalido");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
