package control;

public class ItemBean {
	private int id;
	private int idPedidoCompra, idProduto;
	private int qtd;
	
	public ItemBean(int id, int idFornecedor, int idProduto, int qtd) {
		this.id = id;
		this.qtd = qtd;
		this.idPedidoCompra=idPedidoCompra;
		this.idProduto = idProduto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public int getIdPedidoCompra() {
		return idPedidoCompra;
	}
	public void setIdPedidoCompra(int idPedidoCompra) {
		this.idPedidoCompra = idPedidoCompra;
	}
}
