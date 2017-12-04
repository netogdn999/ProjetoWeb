package control;

import java.sql.Date;

public class LanceBean {
	private int idPedidoCompra;
	private int idFornecedor;
	private float total;
	private int qtdParcelas, prazoEntrega;
	private float[] lances;
	private Date dataLance;
	//private String horario;
	private boolean isForaDoPadrao;
	
	public LanceBean(int idPedidoCompra, int idFornecedor, float total, int qtdParcelas, int prazoEntrega,
			Date dataLance, boolean isForaDoPadrao) {
		super();
		this.idPedidoCompra = idPedidoCompra;
		this.idFornecedor = idFornecedor;
		this.total = total;
		this.qtdParcelas = qtdParcelas;
		this.prazoEntrega = prazoEntrega;
		this.dataLance = dataLance;
		this.isForaDoPadrao = isForaDoPadrao;
	}
	public LanceBean(int idPedidoCompra, int idFornecedor, float total, int qtdParcelas, int prazoEntrega, float[] lances,
			Date dataLance, boolean isForaDoPadrao) {
		this(idPedidoCompra, idFornecedor, total, qtdParcelas, prazoEntrega, dataLance, isForaDoPadrao);
		this.lances = lances;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}
	public float[] getLances() {
		return lances;
	}
	public void setLances(float[] lances) {
		this.lances = lances;
	}
	public Date getDataLance() {
		return dataLance;
	}
	public void setDataLance(Date dataLance) {
		this.dataLance = dataLance;
	}
	public boolean isForaDoPadrao() {
		return isForaDoPadrao;
	}
	public void setForaDoPadrao(boolean isForaDoPadrao) {
		this.isForaDoPadrao = isForaDoPadrao;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public int getIdPedidoCompra() {
		return idPedidoCompra;
	}
	public void setIdPedidoCompra(int idPedidoCompra) {
		this.idPedidoCompra = idPedidoCompra;
	}
	
}
