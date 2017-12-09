package model;

import java.util.ArrayList;

import model.CnpjInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import control.FornecedorBean;
import control.NotaBean;
import dao.NotaDAO;
import model.ParametroInvalidoException;

public class Nota {
	private int id;
	private int nota;
	private String descricao, nome;
	
	public Nota(){
	}
	public Nota(int nota, String descricao) throws ParametroInvalidoException {
		setNota(nota);
		setDescricao(descricao);
	}
	public Nota(int id, int nota, String descricao) throws ParametroInvalidoException {
		this(nota, descricao);
		setId(id);
	}
	public Nota(int id, int nota, String descricao, String nome) throws ParametroInvalidoException {
		this(id, nota, descricao);
		setNome(nome);
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) throws ParametroInvalidoException {
		if(nota>=0 && nota<6) {
			this.nota = nota;
		} else {
			throw new ParametroInvalidoException("Nota invalida");
		}
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void inserir(NotaBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Nota nota = new Nota(bean.getId(), bean.getNota(),bean.getDescricao());
		NotaDAO dao = new NotaDAO();
		dao.inserir(bean.getNota(), bean.getDescricao(),bean.getLoginUsuario(), bean.getIdFornecedor());
	}
	
	public void atualizar(NotaBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Nota nota = new Nota(bean.getId(), bean.getNota(),bean.getDescricao());
		NotaDAO dao = new NotaDAO();
		dao.update(bean.getId(), bean.getNota(), bean.getDescricao(),bean.getLoginUsuario());
	}
	
	public void deletar(NotaBean bean) throws DAOException, ParametroInvalidoException {
		NotaDAO dao = new NotaDAO();
		dao.delete(bean.getId(), bean.getLoginUsuario());
	}
	
	public NotaBean encontrar(NotaBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		NotaDAO dao = new NotaDAO();
		NotaBean prodBean = dao.encontrar(bean.getId(), bean.getLoginUsuario());
		return prodBean;
	}
	
	public ArrayList<NotaBean> mostrarTodas() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		NotaDAO dao = new NotaDAO();
		ArrayList<NotaBean> notasBean = dao.mostrarTodas();
	
		return notasBean;
	}
	
	public ArrayList<NotaBean> mostrarNotasFornecedor(FornecedorBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		NotaDAO dao = new NotaDAO();
		ArrayList<NotaBean> notasBean = dao.mostrarNotasFornecedor(bean.getId());
		return notasBean;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
