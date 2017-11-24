package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.ParametroVazioException;

public class Fornecedor {
	private int id;
	private String nomeFantasia, razaoSocial, cnpj, email, endereco, cep, 
					telefone, responsavel, login, senha;
	private Categoria[] categorias;
	
	//public Fornecedor() {}
	public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String email, String endereco, String cep, String telefone, String responsavel, String login, String senha) throws Exception{
		setNomeFantasia(nomeFantasia);
		setRazaoSocial(razaoSocial);
		setEndereco(endereco);
		setCep(cep);
		setCnpj(cnpj);
		setEmail(email);
		setTelefone(telefone);
		setResponsavel(responsavel);
		setLogin(login);
		setSenha(senha);
	}
	public Fornecedor(String nomeFantasia, String razaoSocial, String cnpj, String email, String endereco, String cep, String telefone, String responsavel, String login, String senha, Categoria[] categorias) throws Exception{
		this(nomeFantasia, razaoSocial, cnpj, email, endereco, cep, telefone, responsavel, login, senha);
		setCategorias(categorias);
	}
	public Fornecedor(int id, String nomeFantasia, String razaoSocial, String cnpj, String email, String endereco, String cep, String telefone, String responsavel, String login, String senha) throws Exception{
		this(nomeFantasia, razaoSocial, cnpj, email, endereco, cep, telefone, responsavel, login, senha);
		setId(id);
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) throws ParametroVazioException {
		if((nomeFantasia != null) && (nomeFantasia.trim().length() > 0)) {
			this.nomeFantasia = nomeFantasia;
		} else {
			throw new ParametroVazioException("Nome fantasia invalido");
		}
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) throws ParametroVazioException {
		if((razaoSocial != null) && (razaoSocial.trim().length() > 0)) {
			this.razaoSocial = razaoSocial;
		} else {
			throw new ParametroVazioException("Razao social invalido");
		}
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) throws ParametroVazioException {
		if(validarCNPJ(cnpj)) {
			this.cnpj = cnpj;
		} else {
			throw new ParametroVazioException("CNPJ invalido");
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws ParametroVazioException{
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);
		if(m.matches()) {
			this.email = email;
		} else {
			throw new ParametroVazioException("Email invalido");
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) throws ParametroVazioException {
		if((endereco != null) && (endereco.trim().length() > 0)) {
			this.endereco = endereco;
		} else {
			throw new ParametroVazioException("Endereco invalido");
		}
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) throws ParametroVazioException {
		if((cep != null) && (cep.trim().length() > 0)) {
			this.cep = cep;
		} else {
			throw new ParametroVazioException("Endereco invalido");
		}
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) throws ParametroVazioException {
		if((telefone != null) && (telefone.trim().length() > 0)) {
			this.telefone = telefone;
		} else {
			throw new ParametroVazioException("Telefone invalido");
		}
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) throws ParametroVazioException {
		if((responsavel != null) && (responsavel.trim().length() > 0)) {
			this.responsavel = responsavel;
		} else {
			throw new ParametroVazioException("Nome do responsavel invalido");
		}
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) throws ParametroVazioException {
		if((this.login == null) && (login != null) && (login.trim().length() > 0)) {
			this.login = login;
		} else {
			throw new ParametroVazioException("Login invalido");
		}
	}
	//public String getSenha() {
	//	return senha;
	//}
	public void setSenha(String senha) throws ParametroVazioException {
		if((this.senha ==null) && (senha != null) && (senha.trim().length() > 0)) {
			this.senha = senha;
		} else {
			throw new ParametroVazioException("Senha invalido");
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
	

}
