import java.util.ArrayList;

public class Produto {
	private int id;
	private String nome, marca;
	private Categoria categoria;
	
	public Produto() {}
	public Produto(int id, String nome, String marca) throws ParametroInvalidoException {
		setId(id);
		setNome(nome);
		setMarca(marca);
	}
	public Produto(String nome, String marca, Categoria categoria) throws ParametroInvalidoException {
		setNome(nome);
		setMarca(marca);
		setCategoria(categoria);
	}
	public Produto(int id, String nome, String marca, Categoria categoria) throws ParametroInvalidoException {
		this(nome, marca, categoria);
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) throws ParametroInvalidoException {
		if((marca != null) && (marca.trim().length() > 0)) {
			this.marca = marca;
		} else {
			throw new ParametroInvalidoException("Marca invalida");
		}
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) throws ParametroInvalidoException {
		if(categoria != null) {
			this.categoria = categoria;
		} else {
			throw new ParametroInvalidoException("Categoria invalida");
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void inserir(ProdutoBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Produto usu = new Produto(bean.getId(), bean.getNome(),
				bean.getMarca());
		
		ProdutoDAO dao = new ProdutoDAO();
		
		dao.inserir(bean.getNome(),
				bean.getMarca(), bean.getIdCategoria());
	}
	public void atualizar(ProdutoBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		Produto usu = new Produto(bean.getId(), bean.getNome(),
				bean.getMarca());
		
		ProdutoDAO dao = new ProdutoDAO();
		
		dao.update(bean.getId(), bean.getNome(),
				bean.getMarca(), bean.getIdCategoria());
	}
	public void deletar(ProdutoBean bean) throws DAOException, ParametroInvalidoException {
		ProdutoDAO dao = new ProdutoDAO();
		dao.delete(bean.getId());
	}
	public Produto encontrar(ProdutoBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoBean prodBean = dao.encontrar(bean.getId());
		Categoria cat = new Categoria();
		Produto produto = new Produto(bean.getId(), bean.getNome(),
				bean.getMarca(), cat.mostrarCategoriaProduto(prodBean));
		return produto;
	}
	public Produto encontrar(int idProduto) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoBean prodBean = dao.encontrar(idProduto);
		Categoria cat = new Categoria();
		Produto produto = new Produto(prodBean.getId(), prodBean.getNome(),
				prodBean.getMarca(), cat.mostrarCategoriaProduto(prodBean));
		return produto;
	}
	public ArrayList<Produto> mostrarTodas() throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<ProdutoBean> prodsBean = dao.mostrarTodos();
		ArrayList<Produto> produtos = null;
		for(ProdutoBean prodB:prodsBean) {
			produtos.add(encontrar(prodB));
		}
		return produtos;
	}
	public ArrayList<Produto> mostrarProdutosCategoria(CategoriaBean bean) throws DAOException, ParametroInvalidoException, CpfInvalidoException, CnpjInvalidoException, EmailInvalidoException {
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<ProdutoBean> prodsBean = dao.mostrarProdutosCategoria(bean.getId());
		ArrayList<Produto> produtos = null;
		for(ProdutoBean prodB:prodsBean) {
			produtos.add(encontrar(prodB));
		}
		return produtos;
	}
}
