package model;

import java.sql.Date;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import model.CnpjInvalidoException;
import dao.DAOException;
import model.EmailInvalidoException;
import control.ItemBean;
import control.LanceBean;
import control.PedidoCompraBean;
import dao.LanceDAO;
import model.ParametroInvalidoException;

public class Lance {
	private Fornecedor fornecedor;
	private float total;
	private int qtdParcelas, prazoEntrega;
	private float[] lances;
	private Date dataLance;
	//private String horario;
	private boolean isForaDoPadrao;
	
	//public Lance(LanceBean bean) {
		//this(bean.getIdPedidoCompra(), bean.);
		//int idPedidoCompra, Fornecedor fornecedor, int qtdParcelas, 
		//int prazoEntrega
	//}
	public Lance() throws ParametroInvalidoException {
		java.util.Date data = new java.util.Date();
		java.sql.Date dataSQL = new java.sql.Date(data.getTime());
		setDataLance(dataSQL);
		setForaDoPadrao(false);
	}
	public Lance(Fornecedor fornecedor, int qtdParcelas, 
			int prazoEntrega, float[] lances, Date dataLance) throws ParametroInvalidoException {
		setFornecedor(fornecedor);
		setQtdParcelas(qtdParcelas);
		setPrazoEntrega(prazoEntrega);
		setLances(lances);
		setDataLance(dataLance);
		setForaDoPadrao(false);
	}
	public Lance(Fornecedor fornecedor, int qtdParcelas, 
			int prazoEntrega, float[] lances) throws ParametroInvalidoException {
		this();
		setFornecedor(fornecedor);
		setQtdParcelas(qtdParcelas);
		setPrazoEntrega(prazoEntrega);
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) throws ParametroInvalidoException {
		if(fornecedor != null) {
			this.fornecedor = fornecedor;
		} else {
			throw new ParametroInvalidoException("Fornecedor invalido");
		}
	}
	public float getTotal() {
		total=0;
		for(float a : lances) {
			total += a;
		}
		return total;
	}
	/*public void setTotal(float total) {
		this.total = total;
	}*/
	public int getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(int qtdParcelas) throws ParametroInvalidoException {
		if(qtdParcelas > 0 ) {
			this.qtdParcelas = qtdParcelas;
		} else {
			throw new ParametroInvalidoException("Quantidade de parcelas invalida");
		}
	}
	public int getPrazoEntrega() {
		return prazoEntrega;
	}
	public void setPrazoEntrega(int prazoEntrega) throws ParametroInvalidoException {
		if(prazoEntrega > 0 ) {
			this.prazoEntrega = prazoEntrega;
		} else {
			throw new ParametroInvalidoException("Prazo de entrega invalido");
		}
	}
	public float[] getLances() {
		return lances;
	}
	public void setLances(float[] lances) throws ParametroInvalidoException {
		if(lances != null) {
			this.lances = lances;
		} else {
			throw new ParametroInvalidoException("Lance invalido");
		}
	}
	@SuppressWarnings("deprecation")
	public String getData() {
		return MessageFormat.format("{0}/{1}/{2}", dataLance.getDay(), dataLance.getMonth(), dataLance.getYear());
	}
	public void setDataLance(Date dataLance) throws ParametroInvalidoException {
		if(dataLance != null) {
			this.dataLance = dataLance;
		} else {
			throw new ParametroInvalidoException("Data invalida");
		}
	}
	@SuppressWarnings("deprecation")
	public String getHorario() {
		return MessageFormat.format("{0}:{1}:{2}", dataLance.getHours(), dataLance.getMinutes(), dataLance.getSeconds());
	}
	/*public void setHorario(String horario) throws Exception {
		if((horario != null) && (horario.trim().length() > 0)) {
			this.horario = horario;
		} else {
			throw new Exception("Horario invalido");
		}
	}*/
	public boolean isForaDoPadrao() {
		return isForaDoPadrao;
	}
	public void setForaDoPadrao(boolean isForaDoPadrao) {
		this.isForaDoPadrao = isForaDoPadrao;
	}
	public void inserir(LanceBean bean) throws DAOException, ParametroInvalidoException, CnpjInvalidoException, EmailInvalidoException, ParseException {
		Lance lance = new Lance();
		setQtdParcelas(bean.getQtdParcelas()); 
		setPrazoEntrega(bean.getPrazoEntrega());
		
		LanceDAO dao = new LanceDAO();
		
		dao.inserirProposta(bean.getIdPedidoCompra(), bean.getIdFornecedor(),
				bean.getTotal(), bean.getQtdParcelas(), bean.getPrazoEntrega(),
				new Date(new SimpleDateFormat("dd-MM-yyyy").parse(lance.getData()).getTime()), lance.isForaDoPadrao());
		//Acho que é a data que esta dando problema
		
		Item item = new Item();
		
		PedidoCompraBean pcb = new PedidoCompraBean();
		pcb.setId(bean.getIdPedidoCompra());
		
		int i=0;
		for(ItemBean it: item.mostrarItensPedido(pcb)) {
			dao.inserirLance(it.getId(), bean.getIdPedidoCompra(),
					bean.getIdFornecedor(), bean.getLances()[i]);
			i++;
		}
		
	}
	public void atualizar(LanceBean bean) throws DAOException, ParametroInvalidoException,  CnpjInvalidoException, EmailInvalidoException, ParseException {
		Lance lance = new Lance();
		setQtdParcelas(bean.getQtdParcelas()); 
		setPrazoEntrega(bean.getPrazoEntrega());
		
		LanceDAO dao = new LanceDAO();
		
		dao.updateProposta(bean.getIdPedidoCompra(), bean.getIdFornecedor(),
				bean.getTotal(), bean.getQtdParcelas(), bean.getPrazoEntrega(),
				new Date(new SimpleDateFormat("dd-MM-yyyy").parse(lance.getData()).getTime()), lance.isForaDoPadrao());
		//Acho que é a data que esta dando problema
		
		Item item = new Item();
		
		PedidoCompraBean pcb = new PedidoCompraBean();
		pcb.setId(bean.getIdPedidoCompra());
		
		int i=0;
		for(ItemBean it: item.mostrarItensPedido(pcb)) {
			dao.updateLance(it.getId(), bean.getIdPedidoCompra(),
					bean.getIdFornecedor(), bean.getLances()[i]);
			i++;
		}
	}
	public void deletar(LanceBean bean) throws DAOException, ParametroInvalidoException {
		LanceDAO dao = new LanceDAO();
		dao.deleteProposta(bean.getIdPedidoCompra(), bean.getIdFornecedor());
	}
	private float[] encontrarValoresLances(LanceBean bean) throws DAOException, ParametroInvalidoException,  CnpjInvalidoException, EmailInvalidoException {
		LanceDAO dao = new LanceDAO();
		LanceBean lanceBean = dao.encontrarProposta(bean.getIdPedidoCompra(), bean.getIdFornecedor());
	
		ArrayList<Float> lancesF = dao.mostrarTodosLances(lanceBean.getIdPedidoCompra(),
					lanceBean.getIdFornecedor());
		int i=0;
		float[] lances = new float[lancesF.size()];
		for(Float lance: lancesF) {
			lances[i]= lance;
			i++;
		}
		
		//Fornecedor forn = new Fornecedor();
		//lanceBean.setLances(lances);
		//Lance lance = new Lance(forn.encontrar(lanceBean.getIdFornecedor()), lanceBean.getQtdParcelas(), 
				//lanceBean.getPrazoEntrega(), lances);
		
		return lances;
	}
	public LanceBean encontrar(LanceBean bean) throws DAOException, ParametroInvalidoException,  CnpjInvalidoException, EmailInvalidoException {
		LanceDAO dao = new LanceDAO();
		LanceBean lanceBean = dao.encontrarProposta(bean.getIdPedidoCompra(), bean.getIdFornecedor());
	
		ArrayList<Float> lancesF = dao.mostrarTodosLances(lanceBean.getIdPedidoCompra(),
					lanceBean.getIdFornecedor());
		int i=0;
		float[] lances = new float[lancesF.size()];
		for(Float lance: lancesF) {
			lances[i]= lance;
			i++;
		}
		
		//Fornecedor forn = new Fornecedor();
		lanceBean.setLances(lances);
		//Lance lance = new Lance(forn.encontrar(lanceBean.getIdFornecedor()), lanceBean.getQtdParcelas(), 
				//lanceBean.getPrazoEntrega(), lances);
		
		return lanceBean;
	}
	public ArrayList<LanceBean> mostrarTodos() throws DAOException, ParametroInvalidoException,  CnpjInvalidoException, EmailInvalidoException {
		LanceDAO dao = new LanceDAO();
		ArrayList<LanceBean> lancesBean = dao.mostrarTodasPropostas();
		for(LanceBean lanB:lancesBean) {
			lanB.setLances(encontrarValoresLances(lanB));
		}
		return lancesBean;
	}
	public float calcularTotal(float[] lances){
		float total=0;
		for(float lance: lances) total+=lance;
		return total;
	}
	public ArrayList<LanceBean> mostrarLancesPedido(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException,  CnpjInvalidoException, EmailInvalidoException {
		LanceDAO dao = new LanceDAO();
		ArrayList<LanceBean> lancesBean = dao.mostrarTodosLances(bean.getId());
		float total =0;
		for(LanceBean lanB:lancesBean) {
			total += lanB.getTotal();
		}
		total = total/lancesBean.size();
		for(LanceBean lanB:lancesBean) {
			if(lanB.getTotal()>(total(total*0.5)) || lanB.getTotal()<(total(total*0.5))) lanB.setForaDoPadrao(true);
			lanB.setLances(encontrarValoresLances(lanB));
		}
		return lancesBean;
	}
}
