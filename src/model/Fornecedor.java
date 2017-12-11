package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.CnpjInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import control.FornecedorBean;
import dao.FornecedorDAO;
import model.ParametroInvalidoException;

public class Fornecedor {
	private int id;
	private String nomeFantasia, razaoSocial, cnpj, email, endereco, cep, 
					telefone1, telefone2;
	private Categoria[] categorias;
	private boolean isAutenticado;
	
	
	public Fornecedor() {
		
	}
	public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String email, String endereco, String cep, String telefone1, boolean isAutenticado) throws ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		setNomeFantasia(nomeFantasia);
		setRazaoSocial(razaoSocial);
		setEndereco(endereco);
		setCep(cep);
		setEmail(email);
		setTelefone1(telefone1);
		setAutenticado(isAutenticado);
		setCnpj(cnpj);
	}
	public Fornecedor(int id, String nomeFantasia, String razaoSocial, String cnpj, String email, String endereco, String cep, String telefone1, String telefone2, boolean isAutenticado) throws ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		this(nomeFantasia, razaoSocial, cnpj, email, endereco, cep, telefone1, isAutenticado);
		setId(id);
		setTelefone2(telefone2);
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
	//public String getSenha() {
	//	return senha;
	//}
	//modificar senha e login
	public Categoria[] getCategorias() {
		return categorias;
	}
	public void setCategorias(Categoria[] categorias) {
		this.categorias = categorias;
	}
	
	//^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$ essa aqui é para o e-mail
	
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
	
	public void inserir(FornecedorBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Fornecedor forn = new Fornecedor(bean.getId(),bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),bean.getEmail(), bean.getEndereco(), bean.getCep(),bean.getTelefone1(), bean.getTelefone2(), bean.isAutenticado());
		FornecedorDAO dao = new FornecedorDAO();
		dao.inserir(bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),bean.getEmail(), bean.getEndereco(), bean.getCep(),bean.getTelefone1(), bean.getTelefone2(), bean.isAutenticado());
	}
	
	public void atualizar(FornecedorBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Fornecedor forn = new Fornecedor(bean.getId(),bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),
				bean.getEmail(), bean.getEndereco(), bean.getCep(),
				bean.getTelefone1(), bean.getTelefone2(), bean.isAutenticado());
		
		FornecedorDAO dao = new FornecedorDAO();
		dao.update(bean.getId(), bean.getNomeFantasia(),bean.getRazaoSocial(), bean.getCnpj(),
				bean.getEmail(), bean.getEndereco(), bean.getCep(),
				bean.getTelefone1(), bean.getTelefone2(), bean.isAutenticado());
	}
	public void deletar(FornecedorBean bean) throws DAOException, ParametroInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		dao.delete(bean.getId());	
	}
	public FornecedorBean encontrar(FornecedorBean bean) throws DAOException, CnpjInvalidoException, EmailInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		FornecedorBean fornBean = dao.encontrar(bean.getId());
		
		return fornBean;
	}
	/*public Fornecedor encontrar(int idFornecedor) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		FornecedorBean fornBean = dao.encontrar(idFornecedor);
		
		Fornecedor forn = new Fornecedor(fornBean.getId(),fornBean.getNomeFantasia(),
				fornBean.getRazaoSocial(), fornBean.getCnpj(),
				fornBean.getEmail(), fornBean.getEndereco(), fornBean.getCep(),
				fornBean.getTelefone1(), fornBean.getTelefone2(), fornBean.getResponsavel(),
				fornBean.getLogin(), fornBean.getSenha(), fornBean.isEmpresa());
		
		Categoria cat = new Categoria();
		forn.setCategorias(cat.mostrarCategoriasFornecedor(fornBean));
		return forn;
	}*/
	public ArrayList<FornecedorBean> mostrarTodas() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		FornecedorDAO dao = new FornecedorDAO();
		ArrayList<FornecedorBean> fornBean = dao.mostrarTodos();
		
		return fornBean;
	}
	
	public FornecedorBean ultimoFornecedorCadastrado() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		FornecedorDAO dao = new FornecedorDAO();
		int id = dao.idUltimoCadastrado();
		if(id==-1) {
			throw new ParametroInvalidoException("Nenhum fornecedor cadastrado");
		}
		FornecedorBean fornBean = new FornecedorBean();
		fornBean.setId(id);
		return encontrar(fornBean);
	}
	
	public boolean isAutenticado() {
		return isAutenticado;
	}
	public void setAutenticado(boolean isAutenticado) {
		this.isAutenticado = isAutenticado;
	}

}
