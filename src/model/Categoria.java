package model;

import java.util.ArrayList;

import control.CategoriaBean;
import dao.CategoriaDAO;
import dao.DAOException;
import control.FornecedorBean;
import model.ParametroInvalidoException;
import control.ProdutoBean;

public class Categoria {
	private int id;
	private String nome;

	public Categoria(){
		
	}
	public Categoria(String nome) throws ParametroInvalidoException {
		setNome(nome);
	}
	public Categoria(int id, String nome) throws ParametroInvalidoException {
		setNome(nome);
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void inserir(CategoriaBean bean) throws DAOException, ParametroInvalidoException {
		Categoria cat = new Categoria();
		cat.setNome(bean.getNome());
		CategoriaDAO dao = new CategoriaDAO();
		dao.inserir(bean.getNome());
	}
	public void atualizar(CategoriaBean bean) throws DAOException, ParametroInvalidoException {
		Categoria cat = new Categoria();
		cat.setNome(bean.getNome());
		CategoriaDAO dao = new CategoriaDAO();
		dao.update(bean.getId(), bean.getNome());
	}
	public void deletar(CategoriaBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		dao.delete(bean.getId());
	}
	public CategoriaBean encontrar(CategoriaBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		CategoriaBean catBean = dao.encontrar(bean.getId());
		return catBean;
	}
	public ArrayList<CategoriaBean> mostrarTodas() throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		ArrayList<CategoriaBean> catsBean = dao.mostrarTodas();
		return catsBean;
	}
	public ArrayList<CategoriaBean> mostrarCategoriasFornecedor(FornecedorBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		ArrayList<CategoriaBean> catsBean = dao.mostrarCategoriasFornecedor(bean.getId());
	
		return catsBean;
	}
	public CategoriaBean mostrarCategoriaProduto(ProdutoBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		CategoriaBean cat = dao.mostrarCategoriaProduto(bean.getId());

		return cat;
	}
	public void inserirFornecedorCategoria(FornecedorBean bean) {
		CategoriaDAO dao = new CategoriaDAO();
 		for(int i:bean.getCategorias()) {
			dao.inserirFornecedorCategoria(i, bean.getId());
		}
	}
	public void deletarFornecedorCategoria(FornecedorBean bean) {
		CategoriaDAO dao = new CategoriaDAO();
 		for(int i:bean.getCategorias()) {
			dao.deleteFornecedorCategoria(i, bean.getId());
		}
	}
	public CategoriaBean mostrarCategoriaPedido(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		CategoriaBean cat = dao.mostrarCategoriaPedido(bean.getId());

		return cat;
	}

}
