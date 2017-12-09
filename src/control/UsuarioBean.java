package control;

public class UsuarioBean {
	private int idFornecedor;
	private String nome, login, senha, setor;
	private int privilegio; // 1 - administrador, 2 - funcionario, 3 - fornecedor
	
	public UsuarioBean() {
		
	}
	public UsuarioBean(int idFornecedor,String nome, String login, String senha, int privilegio, String setor) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.idFornecedor = idFornecedor;
		this.privilegio = privilegio;
		this.setor = setor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public int getPrivilegio() {
		return privilegio;
	}
	public void setPrivilegio(int privilegio) {
		this.privilegio = privilegio;
	}
	
}
