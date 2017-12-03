import java.sql.Date;
import java.util.ArrayList;

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
	public void inserir(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompra pedido = new PedidoCompra();
		pedido.setDataInicio(bean.getDataInicio());
		pedido.setDataFim(bean.getDataFim());
		
		PedidoCompraDAO dao = new PedidoCompraDAO();
		
		dao.inserir(bean.getDataInicio(), bean.getDataFim(),
				bean.getIdUsuario(), bean.isInterno());
	}
	public void atualizar(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompra pedido = new PedidoCompra();
		pedido.setDataInicio(bean.getDataInicio());
		pedido.setDataFim(bean.getDataFim());
		
		PedidoCompraDAO dao = new PedidoCompraDAO();
		
		dao.update(bean.getId(), bean.getDataInicio(), bean.getDataFim(),
				bean.getIdUsuario(), bean.isInterno());
	}
	public void deletar(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		dao.delete(bean.getId());	
	}
	public PedidoCompra encontrar(PedidoCompraBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		PedidoCompraBean fornBean = dao.encontrar(bean.getId());
		
		Item item = new Item();
		Lance lance = new Lance();
		Usuario user = new Usuario();
		
		PedidoCompra pedido = new PedidoCompra(bean.getId(), item.mostrarItensPedido(bean.getId()), lance.mostrarLancesPedido(bean.getId()),bean.getDataInicio(),
				bean.getDataFim(), user.encontrar(bean.getIdUsuario()), bean.isInterno());
		
		return pedido;
	}
	public ArrayList<PedidoCompra> mostrarTodos() throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		ArrayList<PedidoCompraBean> pedsBean = dao.mostrarTodos();
		ArrayList<PedidoCompra> pedidos = null;
		for(PedidoCompraBean pedB:pedsBean) {
			pedidos.add(encontrar(pedB));
		}
		return pedidos;
	}
	public ArrayList<PedidoCompra> mostrarPedidosCategoria(int idCategoria) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		PedidoCompraDAO dao = new PedidoCompraDAO();
		ArrayList<PedidoCompraBean> pedsBean = dao.mostrarPedidosCategoria(idCategoria);
		ArrayList<PedidoCompra> pedidos = null;
		for(PedidoCompraBean pedB:pedsBean) {
			pedidos.add(encontrar(pedB));
		}
		return pedidos;
	}
}
