package model;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.CnpjInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import model.ParametroInvalidoException;
import control.CategoriaBean;
import control.PedidoCompraBean;
import control.UsuarioBean;
import dao.PedidoCompraDAO;

public class PedidoCompra {
	private int id;
	private Item[] itens;
	private Lance[] lances;
	private Date dataInicio, dataFim;
	private Usuario usuario;
	private boolean isInterno;
	
	public PedidoCompra() {
		
	}
	public PedidoCompra(Item[] itens, Lance[] lances, Date dataInicio, 
			Date dataFim, Usuario usuario, boolean isInterno) throws ParametroInvalidoException {
		setItens(itens);
		setLances(lances);
		setDataFim(dataFim);
		setDataInicio(dataInicio);
		setInterno(isInterno);
		setUsuario(usuario);
	}
	public PedidoCompra(int id, Item[] itens, Lance[] lances, Date dataInicio, 
			Date dataFim, Usuario usuario,  boolean isInterno) throws ParametroInvalidoException {
		this(itens, lances, dataInicio, dataFim, usuario, isInterno);
		setId(id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item[] getItens() {
		return itens;
	}
	public void setItens(Item[] itens) throws ParametroInvalidoException {
		if(itens != null) {
			this.itens = itens;
		} else {
			throw new ParametroInvalidoException("Itens invalidos");
		}
	}
	public Lance[] getLances() {
		return lances;
	}
	public void setLances(Lance[] lances) throws ParametroInvalidoException {
		if(lances != null) {
			this.lances = lances;
		} else {
			throw new ParametroInvalidoException("Lances invalidos");
		}
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) throws ParametroInvalidoException {
		if(dataInicio != null) {
			this.dataInicio = dataInicio;
		} else {
			throw new ParametroInvalidoException("Data de inicio invalida");
		}
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) throws ParametroInvalidoException {
		if(dataFim != null) {
			this.dataFim = dataFim;
		} else {
			throw new ParametroInvalidoException("Data de finalizacao invalida");
		}
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) throws ParametroInvalidoException {
		if(usuario != null) {
			this.usuario = usuario;
		} else {
			throw new ParametroInvalidoException("Usuario invalido");
		}
	}
	public boolean isInterno() {
		return isInterno;
	}
	public void setInterno(boolean isInterno) {
		this.isInterno = isInterno;
	}
	public void inserir(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompra pedido = new PedidoCompra();
		pedido.setDataInicio(bean.getDataInicio());
		pedido.setDataFim(bean.getDataFim());
		
		PedidoCompraDAO dao = new PedidoCompraDAO();
		
		dao.inserir(bean.getDataInicio(), bean.getDataFim(),
				bean.getLoginUsuario(), bean.isInterno());
	}
	public void atualizar(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompra pedido = new PedidoCompra();
		pedido.setDataInicio(bean.getDataInicio());
		pedido.setDataFim(bean.getDataFim());
		
		PedidoCompraDAO dao = new PedidoCompraDAO();
		
		dao.update(bean.getId(), bean.getDataInicio(), bean.getDataFim(),
				bean.getLoginUsuario(), bean.isInterno());
	}
	public void deletar(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		dao.delete(bean.getId());	
	}
	public PedidoCompraBean encontrar(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		PedidoCompraBean fornBean = dao.encontrar(bean.getId());
		return fornBean;
	}
	public ArrayList<PedidoCompraBean> mostrarTodos() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		ArrayList<PedidoCompraBean> pedsBean = dao.mostrarTodos();
		return pedsBean;
	}
public void deletarPedidosSemItens() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		ArrayList<PedidoCompraBean> pedsBean = dao.mostrarPedidosSemItens();
		for(PedidoCompraBean ped : pedsBean){
			deletar(ped)
}
	}

	public ArrayList<PedidoCompraBean> mostrarPedidosCategoria(CategoriaBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		ArrayList<PedidoCompraBean> pedsBean = dao.mostrarPedidosCategoria(bean.getId());
		return pedsBean;
	}
	
	public PedidoCompraBean ultimoPedidoCadastrado() throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException{
		PedidoCompraDAO dao = new PedidoCompraDAO();
		int id = dao.idUltimoCadastrado();
		if(id==-1) {
			throw new ParametroInvalidoException("Nenhum pedido cadastrado");
		}
		PedidoCompraBean pedBean = new PedidoCompraBean();
		pedBean.setId(id);
		return encontrar(pedBean);
	}
	
	public ArrayList<PedidoCompraBean> mostrarPedidosUsuario(UsuarioBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		ArrayList<PedidoCompraBean> pedsBean = dao.mostrarPedidosUsuario(bean.getLogin());
		return pedsBean;
	}
}
