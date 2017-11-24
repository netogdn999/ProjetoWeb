import java.sql.Date;
import java.text.MessageFormat;

public class Lance {
	private int id;
	private Fornecedor fornecedor;
	private float total;
	private int qtdParcelas, prazoEntrega;
	private float[] lances;
	private Date dataLance;
	//private String horario;
	private boolean isForaDoPadrao;
	
	public Lance(Fornecedor fornecedor, int qtdParcelas, 
			int prazoEntrega, float[] lances, Date dataLance) throws Exception {
		setFornecedor(fornecedor);
		setQtdParcelas(qtdParcelas);
		setPrazoEntrega(prazoEntrega);
		setLances(lances);
		setDataLance(dataLance);
		setForaDoPadrao(false);
	}
	public Lance(int id, Fornecedor fornecedor, int qtdParcelas, 
			int prazoEntrega, float[] lances, Date dataLance) throws Exception {
		this(fornecedor, qtdParcelas, prazoEntrega, lances, dataLance);
		setId(id);
	}
	public Lance(int id, Fornecedor fornecedor, int qtdParcelas, 
			int prazoEntrega) throws Exception {
		java.util.Date data = new java.util.Date();
		java.sql.Date dataSQL = new java.sql.Date(data.getTime());
		setFornecedor(fornecedor);
		setQtdParcelas(qtdParcelas);
		setPrazoEntrega(prazoEntrega);
		setDataLance(dataSQL);
		setForaDoPadrao(false);
		setId(id);
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) throws Exception {
		if(fornecedor != null) {
			this.fornecedor = fornecedor;
		} else {
			throw new Exception("Fornecedor invalido");
		}
	}
	public float getTotal() {
		total=0;
		for(float a : lances) {
			total += a;
		}
		return total;
	}
	/*public void setTotal(float total) {
		this.total = total;
	}*/
	public int getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(int qtdParcelas) throws Exception {
		if(qtdParcelas > 0 ) {
			this.qtdParcelas = qtdParcelas;
		} else {
			throw new Exception("Quantidade de parcelas invalida");
		}
	}
	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) throws Exception {
		if(prazoEntrega > 0 ) {
			this.prazoEntrega = prazoEntrega;
		} else {
			throw new Exception("Prazo de entrega invalido");
		}
	}
	public float[] getLances() {
		return lances;
	}
	public void setLances(float[] lances) throws Exception {
		if(lances != null) {
			this.lances = lances;
		} else {
			throw new Exception("Lance invalido");
		}
	}
	@SuppressWarnings("deprecation")
	public String getData() {
		return MessageFormat.format("{0}/{1}/{2}", dataLance.getDay(), dataLance.getMonth(), dataLance.getYear());
	}
	public void setDataLance(Date dataLance) throws Exception {
		if(dataLance != null) {
			this.dataLance = dataLance;
		} else {
			throw new Exception("Data invalida");
		}
	}
	@SuppressWarnings("deprecation")
	public String getHorario() {
		return MessageFormat.format("{0}:{1}:{2}", dataLance.getHours(), dataLance.getMinutes(), dataLance.getSeconds());
	}
	/*public void setHorario(String horario) throws Exception {
		if((horario != null) && (horario.trim().length() > 0)) {
			this.horario = horario;
		} else {
			throw new Exception("Horario invalido");
		}
	}*/
	public boolean isForaDoPadrao() {
		return isForaDoPadrao;
	}
	public void setForaDoPadrao(boolean isForaDoPadrao) {
		this.isForaDoPadrao = isForaDoPadrao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
