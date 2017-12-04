package model;

import java.util.ArrayList;
import model.CnpjInvalidoException;
import model.CpfInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import model.ParametroInvalidoException;
import control.UsuarioBean;
import dao.UsuarioDAO;

public class Usuario {
	private int id;
	private String nome, login, senha, cpf, setor;

	public Usuario() {}
	public Usuario(String nome, String login, String senha, String cpf, String setor) throws ParametroInvalidoException, CpfInvalidoException {
		setNome(nome);
		setLogin(login);
		setSenha(senha);
		setCpf(cpf);
		setSetor(setor);
	}
	public Usuario(int id, String nome, String login, String senha, String cpf, String setor) throws ParametroInvalidoException, CpfInvalidoException {
		this(nome, login, senha, cpf, setor);
		setId(id);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws ParametroInvalidoException {
		if((nome != null) && (nome.trim().length() > 0)) {
			this.nome = nome;
		} else {
			throw new ParametroInvalidoException("Nome invalido");
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) throws ParametroInvalidoException {
		if((senha != null) && (senha.trim().length() > 0)) {
			this.senha = senha;
		} else {
			throw new ParametroInvalidoException("Senha invalida");
		}
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws CpfInvalidoException {
		if(validarCPF(cpf)) {
			this.cpf = cpf;
		} else {
			throw new CpfInvalidoException("CPF invalido");
		}
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) throws ParametroInvalidoException {
		if((nome != null) && (nome.trim().length() > 0)) {
			this.setor = setor;
		} else {
			throw new ParametroInvalidoException("Setor invalido");
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
	public void inserir(UsuarioBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Usuario usu = new Usuario(bean.getId(), bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getCpf(), bean.getSetor());
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.inserir(bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getCpf(), bean.getSetor());
	}
	public void atualizar(UsuarioBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Usuario usu = new Usuario(bean.getId(), bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getCpf(), bean.getSetor());
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.update(bean.getId(), bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getCpf(), bean.getSetor());
	}
	public void deletar(UsuarioBean bean) throws DAOException, ParametroInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		dao.delete(bean.getId());
	}
	public Usuario encontrar(UsuarioBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioBean usuBean = dao.encontrar(bean.getId());
		Usuario usu = new Usuario(usuBean.getId(), usuBean.getNome(),
				usuBean.getLogin(), usuBean.getSenha(),
				usuBean.getCpf(), usuBean.getSetor());
		return usu;
	}
	public Usuario encontrar(int idUsuario) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioBean usuBean = dao.encontrar(idUsuario);
		Usuario usu = new Usuario(usuBean.getId(), usuBean.getNome(),
				usuBean.getLogin(), usuBean.getSenha(),
				usuBean.getCpf(), usuBean.getSetor());
		return usu;
	}
	public ArrayList<Usuario> mostrarTodas() throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		ArrayList<UsuarioBean> usersBean = dao.mostrarTodos();
		ArrayList<Usuario> usuarios = null;
		for(UsuarioBean userB:usersBean) {
			usuarios.add(encontrar(userB));
		}
		return usuarios;
	}
}
