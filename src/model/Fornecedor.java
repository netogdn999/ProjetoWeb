package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.CnpjInvalidoException;
import model.CpfInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import control.FornecedorBean;
import dao.FornecedorDAO;
import model.ParametroInvalidoException;

public class Fornecedor {
	private int id;
	private String nomeFantasia, razaoSocial, cnpj, email, endereco, cep, 
					telefone1, telefone2, responsavel, login, senha, cpf;
	private Categoria[] categorias;
	private boolean isEmpresa;
	
	
	public Fornecedor() {
		
	}
	private Fornecedor(String nomeFantasia, String razaoSocial, String email, String endereco, String cep, String telefone1, String responsavel, String login, String senha) throws ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		setNomeFantasia(nomeFantasia);
		setRazaoSocial(razaoSocial);
		setEndereco(endereco);
		setCep(cep);
		setEmail(email);
		setTelefone1(telefone1);
		setResponsavel(responsavel);
		setLogin(login);
		setSenha(senha);
	}
	public Fornecedor(String nomeFantasia, String razaoSocial, String cnpjORcpf, String email, String endereco, String cep, String telefone1, String responsavel, String login, String senha, boolean isEmpresa) throws ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		this(nomeFantasia, razaoSocial, email, endereco, cep, telefone1, responsavel, login, senha);
		setEmpresa(isEmpresa);
		if(isEmpresa) {
			setCnpj(cnpj);
		} else {
			setCpf(cpf);
		}
	}
	public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String email, String endereco, String cep, String telefone1, String responsavel, String login, String senha, Categoria[] categorias, boolean isEmpresa) throws ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		this(nomeFantasia, razaoSocial, cnpj, email, endereco, cep, telefone1, responsavel, login, senha, isEmpresa);
		setCategorias(categorias);
	}
	public Fornecedor(int id, String nomeFantasia, String razaoSocial, String cnpj, String email, String endereco, String cep, String telefone1, String responsavel, String login, String senha, boolean isEmpresa) throws ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		this(nomeFantasia, razaoSocial, cnpj, email, endereco, cep, telefone1, responsavel, login, senha, isEmpresa);
		setId(id);
	}
	public Fornecedor(int id, String nomeFantasia, String razaoSocial, String cnpj, String cpf, String email, String endereco, String cep, String telefone1, String telefone2, String responsavel, String login, String senha, boolean isEmpresa) throws ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		this(id, nomeFantasia, razaoSocial, cnpj, email, endereco, cep, telefone1, responsavel, login, senha, isEmpresa);
		setTelefone2(telefone2);
		setCpf(cpf);
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) throws ParametroInvalidoException {
		if((nomeFantasia != null) && (nomeFantasia.trim().length() > 0)) {
			this.nomeFantasia = nomeFantasia;
		} else {
			throw new ParametroInvalidoException("Nome fantasia invalido");
		}
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) throws ParametroInvalidoException {
		if((razaoSocial != null) && (razaoSocial.trim().length() > 0)) {
			this.razaoSocial = razaoSocial;
		} else {
			throw new ParametroInvalidoException("Razao social invalido");
		}
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) throws CnpjInvalidoException {
		if(validarCNPJ(cnpj)) {
			this.cnpj = cnpj;
		} else {
			throw new CnpjInvalidoException("CNPJ invalido");
		}
	}
	public String getCpf() {
		return cnpj;
	}
	public void setCpf(String cpf) throws CpfInvalidoException {
		if(validarCPF(cpf)) {
			this.cpf = cpf;
		} else {
			throw new CpfInvalidoException("CPF invalido");
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws EmailInvalidoException{
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);
		if(m.matches()) {
			this.email = email;
		} else {
			throw new EmailInvalidoException("Email invalido");
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) throws ParametroInvalidoException {
		if((endereco != null) && (endereco.trim().length() > 0)) {
			this.endereco = endereco;
		} else {
			throw new ParametroInvalidoException("Endereco invalido");
		}
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) throws ParametroInvalidoException {
		if((cep != null) && (cep.trim().length() > 0)) {
			this.cep = cep;
		} else {
			throw new ParametroInvalidoException("Endereco invalido");
		}
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) throws ParametroInvalidoException {
		if((telefone1 != null) && (telefone1.trim().length() > 0)) {
			this.telefone1 = telefone1;
		} else {
			throw new ParametroInvalidoException("Telefone 1 invalido");
		}
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) throws ParametroInvalidoException {
		if((telefone2 != null) && (telefone2.trim().length() > 0)) {
			this.telefone2 = telefone2;
		} else {
			throw new ParametroInvalidoException("Telefone 2 invalido");
		}
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) throws ParametroInvalidoException {
		if((responsavel != null) && (responsavel.trim().length() > 0)) {
			this.responsavel = responsavel;
		} else {
			throw new ParametroInvalidoException("Nome do responsavel invalido");
		}
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) throws ParametroInvalidoException {
		if((login != null) && (login.trim().length() > 0)) {
			this.login = login;
		} else {
			throw new ParametroInvalidoException("Login invalido");
		}
	}
	//public String getSenha() {
	//	return senha;
	//}
	public void setSenha(String senha) throws ParametroInvalidoException {
		if((senha != null) && (senha.trim().length() > 0)) {
			this.senha = senha;
		} else {
			throw new ParametroInvalidoException("Senha invalido");
		}
	}
	public boolean verificaSenha(String senha) {
		if(this.senha.equals(senha)) {
			return true;
		}
		return false;
	}
	//modificar senha e login
	public Categoria[] getCategorias() {
		return categorias;
	}
	public void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}
	public boolean isEmpresa(){
		return this.isEmpresa;
	}
	public void setEmpresa(boolean isEmpresa){
		this.isEmpresa = isEmpresa;
	}
	
	//^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$ essa aqui é para o e-mail
	public boolean validarCPF(String CPF){
		int i=0;
		int j=0;
		int b=10;
		int cont=0;
		int CPFNum=0;
		int aux=0;
		if(CPF.length()<11){
			return false;
		}
		for(i=0;i<CPF.length()-1;i++){
			j++;
			if(CPF.charAt(i)=='.' || CPF.charAt(i)=='/' || CPF.charAt(i)=='-'){
				continue;
			}
			if((((int)CPF.charAt(i))-48)==(((int)CPF.charAt(j))-48)){
				cont++;
			}else{
				break;
			}
			if(cont>=11){
				return false;
			}
		}
		for(i=0; i<CPF.length()-2; i++){
			if(CPF.charAt(i)=='.' || CPF.charAt(i)=='-'){
				continue;
			}else{
				CPFNum=(((int)CPF.charAt(i))-48);
				if(CPFNum>9 || CPFNum<0){
					return false;
				}else{
					aux+=(CPFNum)*(b--);
				}
			}
		}
		aux=((aux*10)%11==10 || (aux*10)%11==11)?0:((aux*10)%11);
		if(aux==(((int)CPF.charAt(CPF.length()-2))-48)){
			aux=0;
			b=11;
			for(i=0; i<CPF.length()-1; i++){
				if(CPF.charAt(i)=='.' || CPF.charAt(i)=='-'){
					continue;
				}else{
					CPFNum=(((int)CPF.charAt(i))-48);
					if(CPFNum>9 || CPFNum<0){
						return false;
					}else{
						aux+=(CPFNum)*(b--);
					}
				}
			}
			aux=((aux*10)%11==10 || (aux*10)%11==11)?0:((aux*10)%11);
			if((aux==(((int)CPF.charAt(CPF.length()-1))-48)))
				return true;
		}
		return false;
	}
	public boolean validarCNPJ(String CNPJ){
		int i=0;
		int j=0;
		int b=2;
		int cont=0;
		int CNPJNum=0;
		int aux=0;
		if(CNPJ.length()<14){
			return false;
		}
		for(i=0;i<CNPJ.length()-1;i++){
			j++;
			if(CNPJ.charAt(i)=='.' || CNPJ.charAt(i)=='/' || CNPJ.charAt(i)=='-'){
				continue;
			}
			if((((int)CNPJ.charAt(i))-48)==(((int)CNPJ.charAt(j))-48)){
				cont++;
			}else{
				break;
			}
			if(cont>=14){
				return false;
			}
		}for(i=CNPJ.length()-3;i>=0;i--){
			if(CNPJ.charAt(i)=='.' || CNPJ.charAt(i)=='/' || CNPJ.charAt(i)=='-'){
				continue;
			}else{
				CNPJNum=(((int)CNPJ.charAt(i))-48);
				if(CNPJNum>9 || CNPJNum<0){
					return false;
				}else{
					if(b==10)
						b=2;
					aux+=(CNPJNum)*(b++);
				}
			}
		}if((aux)%11==0 || (aux)%11==1){
			aux=0;
		}else{
			aux=11-(aux%11);
		}if((aux==(((int)CNPJ.charAt(CNPJ.length()-2))-48))){
			aux=0;
			b=2;
			for(i=CNPJ.length()-2;i>=0;i--){
				if(CNPJ.charAt(i)=='.' || CNPJ.charAt(i)=='/' || CNPJ.charAt(i)=='-'){
					continue;
				}else{
					CNPJNum=(((int)CNPJ.charAt(i))-48);
					if(CNPJNum>9 || CNPJNum<0){
						return false;
					}else{
						if(b==10)
							b=2;
						aux+=(CNPJNum)*(b++);
					}
				}
			}
		}if((aux)%11==0 || (aux)%11==1){
			aux=0;
		}else{
			aux=11-(aux%11);
		}if((aux==(((int)CNPJ.charAt(CNPJ.length()-1))-48))){
			return true;
		}
		return false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void inserir(FornecedorBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Fornecedor forn = new Fornecedor(bean.getId(),bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),
				bean.getCpf(), bean.getEmail(), bean.getEndereco(), bean.getCep(),
				bean.getTelefone1(), bean.getTelefone2(), bean.getResponsavel(),
				bean.getLogin(), bean.getSenha(), bean.isEmpresa());
		
		FornecedorDAO dao = new FornecedorDAO();
		dao.inserir(bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),
				bean.getCpf(), bean.getEmail(), bean.getEndereco(), bean.getCep(),
				bean.getTelefone1(), bean.getTelefone2(), bean.getResponsavel(),
				bean.getLogin(), bean.getSenha());
		
		Categoria cat = new Categoria();
		cat.inserirFornecedorCategoria(bean);
	}
	public void atualizar(FornecedorBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Fornecedor forn = new Fornecedor(bean.getId(),bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),
				bean.getCpf(), bean.getEmail(), bean.getEndereco(), bean.getCep(),
				bean.getTelefone1(), bean.getTelefone2(), bean.getResponsavel(),
				bean.getLogin(), bean.getSenha(), bean.isEmpresa());
		
		FornecedorDAO dao = new FornecedorDAO();
		dao.update(bean.getId(), bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),
				bean.getCpf(), bean.getEmail(), bean.getEndereco(), bean.getCep(),
				bean.getTelefone1(), bean.getTelefone2(), bean.getResponsavel(),
				bean.getLogin(), bean.getSenha());
		
		Categoria cat = new Categoria();
		cat.inserirFornecedorCategoria(bean);
	}
	public void deletar(FornecedorBean bean) throws DAOException, ParametroInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		dao.delete(bean.getId());	
	}
	public Fornecedor encontrar(FornecedorBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		FornecedorBean fornBean = dao.encontrar(bean.getId());
		if(fornBean.getCpf()==null) {
			fornBean.setEmpresa(true);
		}else {
			fornBean.setEmpresa(false);
		}
		Fornecedor forn = new Fornecedor(fornBean.getId(),fornBean.getNomeFantasia(),
				fornBean.getRazaoSocial(), fornBean.getCnpj(), fornBean.getCpf(),
				fornBean.getEmail(), fornBean.getEndereco(), fornBean.getCep(),
				fornBean.getTelefone1(), fornBean.getTelefone2(), fornBean.getResponsavel(),
				fornBean.getLogin(), fornBean.getSenha(), fornBean.isEmpresa());
		
		Categoria cat = new Categoria();
		forn.setCategorias(cat.mostrarCategoriasFornecedor(fornBean));
		return forn;
	}
	public Fornecedor encontrar(int idFornecedor) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		FornecedorBean fornBean = dao.encontrar(idFornecedor);
		if(fornBean.getCpf()==null) {
			fornBean.setEmpresa(true);
		}else {
			fornBean.setEmpresa(false);
		}
		Fornecedor forn = new Fornecedor(fornBean.getId(),fornBean.getNomeFantasia(),
				fornBean.getRazaoSocial(), fornBean.getCnpj(), fornBean.getCpf(),
				fornBean.getEmail(), fornBean.getEndereco(), fornBean.getCep(),
				fornBean.getTelefone1(), fornBean.getTelefone2(), fornBean.getResponsavel(),
				fornBean.getLogin(), fornBean.getSenha(), fornBean.isEmpresa());
		
		Categoria cat = new Categoria();
		forn.setCategorias(cat.mostrarCategoriasFornecedor(fornBean));
		return forn;
	}
	public ArrayList<Fornecedor> mostrarTodas() throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		ArrayList<FornecedorBean> fornBean = dao.mostrarTodos();
		ArrayList<Fornecedor> fornecedores = null;
		for(FornecedorBean fornB:fornBean) {
			fornecedores.add(encontrar(fornB));
		}
		return fornecedores;
	}

}
