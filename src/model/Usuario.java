package model;

import java.util.ArrayList;
import model.CnpjInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import model.ParametroInvalidoException;
import control.UsuarioBean;
import dao.UsuarioDAO;

public class Usuario {
	private int idFornecedor;
	private String nome, login, senha, setor;
	private int privilegio; // 1 - administrador, 2 - funcionario, 3 - fornecedor

	public Usuario() {}
	public Usuario(String nome, String login, String senha, int privilegio, String setor) throws ParametroInvalidoException {
		setNome(nome);
		setLogin(login);
		setSenha(senha);
		setPrivilegio(privilegio);
		setSetor(setor);
	}
	public Usuario(int idFornecedor, String nome, String login, String senha, int privilegio, String setor) throws ParametroInvalidoException {
		this(nome, login, senha, privilegio, setor);
		setIdFornecedor(idFornecedor);
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
	
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor){
		this.setor = setor;
	}
	public boolean verificaSenha(String senha) {
		if(this.senha.equals(senha)) {
			return true;
		}
		return false;
	}
	//modificar senha e login
	public void inserir(UsuarioBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Usuario usu = new Usuario(bean.getIdFornecedor(), bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getPrivilegio(), bean.getSetor());
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.inserir(bean.getIdFornecedor(), bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getPrivilegio(), bean.getSetor());
	}
	public void atualizar(UsuarioBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Usuario usu = new Usuario(bean.getIdFornecedor(), bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getPrivilegio(), bean.getSetor());
		
		UsuarioDAO dao = new UsuarioDAO();
		
		dao.update(bean.getIdFornecedor(), bean.getNome(),
        		bean.getLogin(), bean.getSenha(),
        		bean.getPrivilegio(), bean.getSetor());
	}
	public void deletar(UsuarioBean bean) throws DAOException, ParametroInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		dao.delete(bean.getLogin());
	}
	public Usuario encontrar(UsuarioBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioBean usuBean = dao.encontrar(bean.getLogin());
		Usuario usu = new Usuario(usuBean.getIdFornecedor(), usuBean.getNome(),
				usuBean.getLogin(), usuBean.getSenha(),
				usuBean.getPrivilegio(), usuBean.getSetor());
		return usu;
	}
	public void entrar(UsuarioBean bean) throws DAOException, LoginInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioBean usuBean = dao.encontrar(bean.getLogin());
		if(usuBean==null || !(bean.getSenha().equals(usuBean.getSenha()))) {
			throw new LoginInvalidoException("usuário inválido");
		}
	}
	/*public Usuario encontrar(int idUsuario) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		UsuarioBean usuBean = dao.encontrar(idUsuario);
		Usuario usu = new Usuario(usuBean.getIdFornecedor(), usuBean.getNome(),
				usuBean.getLogin(), usuBean.getSenha(),
				usuBean.getCpf(), usuBean.getSetor());
		return usu;
	}*/
	public ArrayList<UsuarioBean> mostrarTodas() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		UsuarioDAO dao = new UsuarioDAO();
		ArrayList<UsuarioBean> usersBean = dao.mostrarTodos();
		return usersBean;
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
	public void setPrivilegio(int privilegio) throws ParametroInvalidoException{
		if( privilegio >=1 && privilegio < 4) {
			this.privilegio = privilegio;
		}else {
			throw new ParametroInvalidoException("Privilegio invalido");
		}
	}
}
