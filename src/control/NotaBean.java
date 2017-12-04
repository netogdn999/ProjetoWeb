package control;

public class NotaBean {
	private int id, nota, idUsuario, idFornecedor;
	private String descricao;
	
	public NotaBean(int id, int nota, String descricao, int idUsuario, int idFornecedor) {
		this(id, nota, descricao);
		this.idUsuario = idUsuario;
		this.idFornecedor = idFornecedor;
	}
	public NotaBean(int id, int nota, String descricao) {
		super();
		this.id = id;
		this.nota = nota;
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
}
