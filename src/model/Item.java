
public class Item {
	private int id;
	private Produto produto;
	private int qtd;
	
	public Item(Produto produto, int qtd) throws Exception {
		setProduto(produto);
		setQtd(qtd);
	}
	public Item(int id, Produto produto, int qtd) throws Exception {
		this(produto,qtd);
		setId(id);
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) throws Exception {
		if(produto!=null) {
			this.produto = produto;
		} else {
			throw new Exception("Produto invalido");
		}
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) throws Exception {
		if(qtd>0) {
			this.qtd = qtd;
		} else {
			throw new Exception("Quantidade invalida");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
