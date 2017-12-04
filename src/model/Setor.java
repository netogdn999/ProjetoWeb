package model;


public class Setor {
	private int id;
	private String nome;
	
	public Setor(int id, String nome) throws Exception {
		setId(id);
		setNome(nome);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if((nome != null) && (nome.trim().length() > 0)) {
			this.nome = nome;
		} else {
			throw new Exception("Nome invalido");
		}
	}
}
