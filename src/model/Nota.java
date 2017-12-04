package model;

import java.util.ArrayList;

import model.CnpjInvalidoException;
import model.CpfInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import control.FornecedorBean;
import control.NotaBean;
import dao.NotaDAO;
import model.ParametroInvalidoException;

public class Nota {
	private int id;
	private int nota;
	private String descricao;
	
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
	
	public void inserir(NotaBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Nota nota = new Nota(bean.getId(), bean.getNota(),bean.getDescricao());
		NotaDAO dao = new NotaDAO();
		dao.inserir(bean.getNota(), bean.getDescricao(),bean.getIdUsuario(), bean.getIdFornecedor());
	}
	
	public void atualizar(NotaBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Nota nota = new Nota(bean.getId(), bean.getNota(),bean.getDescricao());
		NotaDAO dao = new NotaDAO();
		dao.update(bean.getId(), bean.getNota(), bean.getDescricao(),bean.getIdUsuario());
	}
	
	public void deletar(NotaBean bean) throws DAOException, ParametroInvalidoException {
		NotaDAO dao = new NotaDAO();
		dao.delete(bean.getId(), bean.getIdUsuario());
	}
	
	public Nota encontrar(NotaBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		NotaDAO dao = new NotaDAO();
		NotaBean prodBean = dao.encontrar(bean.getId(), bean.getIdUsuario());
		Categoria cat = new Categoria();
		Nota nota = new Nota(prodBean.getId(), prodBean.getNota(),prodBean.getDescricao());
		return nota;
	}
	
	public ArrayList<Nota> mostrarTodas() throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		NotaDAO dao = new NotaDAO();
		ArrayList<NotaBean> notasBean = dao.mostrarTodas();
		ArrayList<Nota> notas = null;
		for(NotaBean notaB:notasBean) {
			notas.add(encontrar(notaB));
		}
		return notas;
	}
	
	public ArrayList<Nota> mostrarNotasFornecedor(FornecedorBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		NotaDAO dao = new NotaDAO();
		ArrayList<NotaBean> notasBean = dao.mostrarNotasFornecedor(bean.getId());
		ArrayList<Nota> notas = null;
		for(NotaBean notaB:notasBean) {
			notas.add(encontrar(notaB));
		}
		return notas;
	}	
}
