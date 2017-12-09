package control;

public class NotaBean {
	private int id, nota, idFornecedor;
	private String descricao, loginUsuario;
	
	public NotaBean() { }
	public NotaBean(int id, int nota, String descricao, String loginUsuario, int idFornecedor) {
		this(id, nota, descricao);
		this.loginUsuario = loginUsuario;
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
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	
}
