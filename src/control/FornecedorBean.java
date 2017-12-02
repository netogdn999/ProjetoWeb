
public class FornecedorBean {
	private int id;
	private String nomeFantasia, razaoSocial, cnpj, email, endereco, cep, 
					telefone1, telefone2, responsavel, login, senha, cpf;
	private int[] categorias;
	private boolean isEmpresa;
	
	public FornecedorBean(int id, String nomeFantasia, String razaoSocial, String cnpj,
			String cpf, String email, String endereco, String cep, String telefone1,
			String telefone2, String responsavel, String login, String senha) {
		super();
		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.email = email;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.responsavel = responsavel;
		this.login = login;
		this.senha = senha;
		this.cpf = cpf;
	}
	public FornecedorBean(int id, String nomeFantasia, String razaoSocial, String cnpj, String cpf, String email, String endereco,
			String cep, String telefone1, String telefone2, String responsavel, String login, String senha,
			int[] categorias, boolean isEmpresa) {
		this(id, nomeFantasia, razaoSocial, cnpj, cpf, email, endereco,
				cep, telefone1, telefone2, responsavel, login, senha);
		this.categorias = categorias;
		this.isEmpresa = isEmpresa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int[] getCategorias() {
		return categorias;
	}
	public void setCategorias(int[] categorias) {
		this.categorias = categorias;
	}
	public boolean isEmpresa() {
		return isEmpresa;
	}
	public void setEmpresa(boolean isEmpresa) {
		this.isEmpresa = isEmpresa;
	}
}
