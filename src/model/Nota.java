
public class Nota {
	private int id;
	private int nota;
	private String descricao;
	
	public Nota(int nota, String descricao) throws Exception {
		setNota(nota);
		setDescricao(descricao);
	}
	public Nota(int id, int nota, String descricao) throws Exception {
		this(nota, descricao);
		setId(id);
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) throws Exception {
		if(nota>=0 && nota<6) {
			this.nota = nota;
		} else {
			throw new Exception("Nota invalida");
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
	
	
}
