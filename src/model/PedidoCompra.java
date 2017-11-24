import java.sql.Date;

public class PedidoCompra {
	private int id;
	private Item[] itens;
	private Lance[] lances;
	private Date dataInicio, dataFim;
	private boolean isInterno;
	
	public PedidoCompra(Item[] itens, Lance[] lances, Date dataInicio, 
			Date dataFim,  boolean isInterno) throws Exception {
		setItens(itens);
		setLances(lances);
		setDataFim(dataFim);
		setDataInicio(dataInicio);
		setInterno(isInterno);
	}
	public PedidoCompra(int id, Item[] itens, Lance[] lances, Date dataInicio, 
			Date dataFim,  boolean isInterno) throws Exception {
		this(itens, lances, dataInicio, dataFim, isInterno);
		setId(id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item[] getItens() {
		return itens;
	}
	public void setItens(Item[] itens) throws Exception {
		if(itens != null) {
			this.itens = itens;
		} else {
			throw new Exception("Itens invalidos");
		}
	}
	public Lance[] getLances() {
		return lances;
	}
	public void setLances(Lance[] lances) throws Exception {
		if(lances != null) {
			this.lances = lances;
		} else {
			throw new Exception("Lances invalidos");
		}
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) throws Exception {
		if(dataInicio != null) {
			this.dataInicio = dataInicio;
		} else {
			throw new Exception("Data de inicio invalida");
		}
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) throws Exception {
		if(dataFim != null) {
			this.dataFim = dataFim;
		} else {
			throw new Exception("Data de finalizacao invalida");
		}
	}
	public boolean isInterno() {
		return isInterno;
	}
	public void setInterno(boolean isInterno) {
		this.isInterno = isInterno;
	}
}
