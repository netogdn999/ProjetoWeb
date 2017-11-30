import java.util.ArrayList;

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
	public void inserir(ItemBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Item item = new Item(bean.getId(), bean.getQtd());
		
		ItemDAO dao = new ItemDAO();
		
		dao.inserir(bean.getIdPedidoCompra(), bean.getIdProduto(),
				bean.getQtd());
	}
	public void atualizar(ItemBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Item item = new Item(bean.getId(), bean.getQtd());
		
		ItemDAO dao = new ItemDAO();
		
		dao.update(bean.getId(), bean.getIdPedidoCompra(), bean.getIdProduto(),
				bean.getQtd());
	}
	public void deletar(ItemBean bean) throws DAOException, ParametroInvalidoException {
		ItemDAO dao = new ItemDAO();
		dao.delete(bean.getId(), bean.getIdPedidoCompra());
	}
	public Item encontrar(ItemBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		
		ItemBean itemBean = dao.encontrar(bean.getId(), bean.getIdPedidoCompra());

		Produto produtoB = new Produto();
		Item item = new Item(itemBean.getId(), produtoB.encontrar(itemBean.getIdProduto()),
				itemBean.getQtd());
		
		return item;
	}
	public ArrayList<Item> mostrarTodas() throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemBean> itensBean = dao.mostrarTodos();
		ArrayList<Item> itens = null;
		for(ItemBean itemB:itensBean) {
			itens.add(encontrar(itemB));
		}
		return itens;
	}
	public Item[] mostrarItensPedido(int idPedidoCompra) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemBean> itensBean = dao.mostrarItensPedido(idPedidoCompra);
		Item[] itens = new Item[itensBean.size()];
		int i=0;
		for(ItemBean itemB:itensBean) {
			itens[i] = encontrar(itemB);
			i++;
		}
		return itens;
	}
	public ArrayList<Item> mostrarItensProduto(int idProduto) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ItemDAO dao = new ItemDAO();
		ArrayList<ItemBean> notasBean = dao.mostrarItensProduto(idProduto);
		ArrayList<Item> notas = null;
		for(ItemBean notaB:notasBean) {
			notas.add(encontrar(notaB));
		}
		return notas;
	}
}
