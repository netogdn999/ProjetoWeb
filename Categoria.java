import java.util.ArrayList;

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
	public Categoria encontrar(CategoriaBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		CategoriaBean catBean = dao.encontrar(bean.getId());
		Categoria cat = new Categoria(catBean.getId(), catBean.getNome());
		return cat;
	}
	public ArrayList<Categoria> mostrarTodas() throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		ArrayList<CategoriaBean> catsBean = dao.mostrarTodas();
		ArrayList<Categoria> categorias = null;
		for(CategoriaBean catB:catsBean) {
			categorias.add(new Categoria(catB.getId(), catB.getNome()));
		}
		return categorias;
	}
	public Categoria[] mostrarCategoriasFornecedor(FornecedorBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		ArrayList<CategoriaBean> catsBean = dao.mostrarCategoriasFornecedor(bean.getId());
		Categoria[] categorias = new Categoria[catsBean.size()];
		int i=0;
		for(CategoriaBean catB:catsBean) {
			categorias[i] = (new Categoria(catB.getId(), catB.getNome()));
			i++;
		}
		return categorias;
	}
	public Categoria mostrarCategoriaProduto(ProdutoBean bean) throws DAOException, ParametroInvalidoException {
		CategoriaDAO dao = new CategoriaDAO();
		CategoriaBean cat = dao.mostrarCategoriaProduto(bean.getId());
		Categoria categoria = new Categoria(cat.getId(), cat.getNome());
		return categoria;
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
}
