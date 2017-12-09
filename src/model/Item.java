package model;

import java.util.ArrayList;

import model.CnpjInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import control.ItemBean;
import control.PedidoCompraBean;
import control.ProdutoBean;
import dao.ItemDAO;
import model.ParametroInvalidoException;

public class Item {
	private int id;
	private Produto produto;
	private int qtd;
	
	public Item() {
		
	}
	public Item(int id, int qtd) throws ParametroInvalidoException {
		setId(id);
		setQtd(qtd);
	}
	public Item(Produto produto, int qtd) throws ParametroInvalidoException {
		setProduto(produto);
		setQtd(qtd);
	}
	public Item(int id, Produto produto, int qtd) throws ParametroInvalidoException {
		this(produto,qtd);
		setId(id);
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) throws ParametroInvalidoException {
		if(produto!=null) {
			this.produto = produto;
		} else {
			throw new ParametroInvalidoException("Produto invalido");
		}
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) throws ParametroInvalidoException {
		if(qtd>0) {
			this.qtd = qtd;
		} else {
			throw new ParametroInvalidoException("Quantidade invalida");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void inserir(ItemBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Item item = new Item(bean.getId(), bean.getQtd());
		
		ItemDAO dao = new ItemDAO();
		
		dao.inserir(bean.getIdPedidoCompra(), bean.getIdProduto(),
				bean.getQtd());
	}
	public void atualizar(ItemBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Item item = new Item(bean.getId(), bean.getQtd());
		
		ItemDAO dao = new ItemDAO();
		
		dao.update(bean.getId(), bean.getIdPedidoCompra(), bean.getIdProduto(),
				bean.getQtd());
	}
	public void deletar(ItemBean bean) throws DAOException, ParametroInvalidoException {
		ItemDAO dao = new ItemDAO();
		dao.delete(bean.getId(), bean.getIdPedidoCompra());
	}
	public ItemBean encontrar(ItemBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		ItemBean itemBean = dao.encontrar(bean.getId(), bean.getIdPedidoCompra());
		return itemBean;
	}
	public ArrayList<ItemBean> mostrarTodas() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemBean> itensBean = dao.mostrarTodos();
	
		return itensBean;
	}
	public ArrayList<ItemBean> mostrarItensPedido(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemBean> itensBean = dao.mostrarItensPedido(bean.getId());
		
		return itensBean;
	}
	public ArrayList<ItemBean> mostrarItensProduto(ProdutoBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemBean> notasBean = dao.mostrarItensProduto(bean.getId());
		
		return notasBean;
	}
}
