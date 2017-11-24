package model;

public class Produto {
	private int id;
	private String nome, marca;
	private Categoria categoria;
	
	public Produto(String nome, String marca, Categoria categoria) throws Exception {
		setNome(nome);
		setMarca(marca);
		setCategoria(categoria);
	}
	public Produto(int id, String nome, String marca, Categoria categoria) throws Exception {
		this(nome, marca, categoria);
		setId(id);
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) throws Exception {
		if((marca != null) && (marca.trim().length() > 0)) {
			this.marca = marca;
		} else {
			throw new Exception("Marca invalida");
		}
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) throws Exception {
		if(categoria != null) {
			this.categoria = categoria;
		} else {
			throw new Exception("Categoria invalida");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
