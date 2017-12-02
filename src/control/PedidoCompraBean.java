import java.sql.Date;

public class PedidoCompraBean {
	private int id;
	private Date dataInicio, dataFim;
	private int idUsuario;
	private boolean isInterno;
	
	public PedidoCompraBean(int id, Date dataInicio, Date dataFim, int idUsuario,
			boolean isInterno) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.idUsuario = idUsuario;
		this.isInterno = isInterno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public boolean isInterno() {
		return isInterno;
	}

	public void setInterno(boolean isInterno) {
		this.isInterno = isInterno;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
}
