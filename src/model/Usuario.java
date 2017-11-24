package model;

public class Usuario {
	private int id;
	private String nome, login, senha, cpf;
	private Setor setor;

	public Usuario(String nome, String login, String senha, String cpf, Setor setor) throws Exception {
		setNome(nome);
		setLogin(login);
		setSenha(senha);
		setCpf(cpf);
		setSetor(setor);
	}
	public Usuario(int id, String nome, String login, String senha, String cpf, Setor setor) throws Exception {
		this(nome, login, senha, cpf, setor);
		setId(id);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if((nome != null) && (nome.trim().length() > 0)) {
			this.nome = nome;
		} else {
			throw new Exception("Nome invalido");
		}
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) throws Exception {
		if((login != null) && (login.trim().length() > 0)) {
			this.login = login;
		} else {
			throw new Exception("Login invalido");
		}
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) throws Exception {
		if((senha != null) && (senha.trim().length() > 0)) {
			this.senha = senha;
		} else {
			throw new Exception("Senha invalida");
		}
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws Exception {
		if(validarCPF(cpf)) {
			this.cpf = cpf;
		} else {
			throw new Exception("CPF invalido");
		}
	}
	public Setor getSetor() {
		return setor;
	}
	public void setSetor(Setor setor) throws Exception {
		if(setor != null) {
			this.setor = setor;
		} else {
			throw new Exception("Setor invalido");
		}
	}
	public boolean verificaSenha(String senha) {
		if(this.senha.equals(senha)) {
			return true;
		}
		return false;
	}
	//modificar senha e login
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
