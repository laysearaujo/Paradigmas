class Main {
	
	public static void main(String[] args) {
		LivroBiblioteca livro1 = new LivroBiblioteca();
		LivroLivraria livro2 = new LivroLivraria("A Probabilidade Estatistica do Amor a Primeira Vista", "111-222-333", "Jennifer E. Smith", 2011, "Grupo Editorial Record.");
		
		livro1.setTitulo("A Moreninha");
		livro1.setAno(1844);
		livro1.setAutor("Joaquim Manuel de Macedo");
		livro1.setEditora("Nova");
		livro1.setISBN("000-111-222");
		
		System.out.print("Livro1: "+livro1.getTitulo()+"\n");
		System.out.print("Livro2: "+livro2.getTitulo()+"\n\n");
		
		System.out.print("Livro1: emprestado? "+livro1.emprestado()+"\n");
		System.out.print("Livro2: vendido? "+livro2.vendido()+"\n\n");
		
		livro1.emprestarLivro();
		livro2.venderLivro();
		
		System.out.print("Livro1: emprestado? "+livro1.emprestado()+"\n");
		System.out.print("Livro2: vendido? "+livro2.vendido()+"\n\n");
	}
	
}

abstract class Livro {
	
	private String titulo;
	private String ISBN;
	private String autor;
	private int ano;
	private String editora;
	
	public Livro() {}
	
	public Livro(String newTitulo, String newISBN, String newAutor, int newAno, String newEditora) {
		this.titulo = newTitulo;
		this.ISBN = newISBN;
		this.autor = newAutor;
		this.ano = newAno;
		this.editora = newEditora;
	}
	
	public void setTitulo(String newTitulo) {
		this.titulo = newTitulo;
	}
	
	public void setISBN(String newISBN) {
		this.ISBN = newISBN;
	}
	
	public void setAutor(String newAutor) {
		this.autor = newAutor;
	}
	
	public void setAno(int newAno) {
		this.ano = newAno;
	}
	
	public void setEditora(String newEditora) {
		this.editora = newEditora;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getISBN() {
		return this.ISBN;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public int getAno() {
		return this.ano;
	}
	
	public String getEditora() {
		return this.editora;
	}
	
};

class LivroLivraria extends Livro {
	
	private boolean vendido = false;
	
	public LivroLivraria() {}
	
	public LivroLivraria(String newTitulo, String newISBN, String newAutor, int newAno, String newEditora) {
		super(newTitulo, newISBN, newAutor, newAno, newEditora);
	}
	
	public void venderLivro() {
		// Livro foi vendido
		this.vendido = true;
	}
	
	public boolean vendido()
	{
		return this.vendido;
	}
	
};

class LivroBiblioteca extends Livro {
	
	private boolean emprestado = false;
	
	public LivroBiblioteca() {}
	
	public LivroBiblioteca(String newTitulo, String newISBN, String newAutor, int newAno, String newEditora) {
		super(newTitulo, newISBN, newAutor, newAno, newEditora);
	}
	
	public void emprestarLivro() {
		// Livro foi emprestado
		this.emprestado = true;
	}
	
	public boolean emprestado() {
		return this.emprestado;
	}
	
};