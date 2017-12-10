package control;

public class FornecedorBean {
	private int id;
	private String nomeFantasia, razaoSocial, cnpj, email, endereco, cep, telefone1, telefone2;
	private int[] categorias;
	private boolean isAutenticado;
	
	public FornecedorBean() {
		
	}
	public FornecedorBean(int id, String nomeFantasia, String razaoSocial, String cnpj,
			String email, String endereco, String cep, String telefone1,
			String telefone2, boolean isAutenticado) {
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
		this.isAutenticado = isAutenticado;
	}
	public FornecedorBean(int id, String nomeFantasia, String razaoSocial, String cnpj, String cpf, String email, String endereco,
			String cep, String telefone1, String telefone2, String responsavel, String login, String senha,
			int[] categorias, boolean isAutenticado) {
		this(id, nomeFantasia, razaoSocial, cnpj, email, endereco,
				cep, telefone1, telefone2, isAutenticado);
		this.categorias = categorias;
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
	public int[] getCategorias() {
		return categorias;
	}
	public void setCategorias(int[] categorias) {
		this.categorias = categorias;
	}
	public boolean isAutenticado() {
		return isAutenticado;
	}
	public void setAutenticado(boolean isAutenticado) {
		this.isAutenticado = isAutenticado;
	}
}
