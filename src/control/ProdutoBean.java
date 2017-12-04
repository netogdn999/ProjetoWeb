package control;

public class ProdutoBean {
	private int id;
	private String nome, marca;
	private int idCategoria;
	
	public ProdutoBean(int id, String nome, String marca, int idCategoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.idCategoria = idCategoria;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
