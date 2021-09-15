public class Main {

	public static void main(String[] args) {
		Pessoa layane = new Pessoa();
		Pessoa layse = new Pessoa("Layse", 21, "Superior Incompleto", Genero.NONBIN, "Hetero", 'F');
		
		layane.setNome("Layane");
		layane.setIdade(16);
		layane.setGrauDeEscolaridade("Curasando Ensino Medio");
		
		System.out.println(layane.getNome());
		System.out.println(layane.getIdade());
		System.out.println(layane.getGrauDeEscolaridade()+"\n");
		
		System.out.println(layse.getNome());
		System.out.println(layse.getOrientacaoSexual());
		System.out.println(layse.getSexo());
		System.out.println(layse.getIdentidadeDeGenero());
		layse.viver();
		layse.sobreviver();
		layse.comer();
		layse.dormir();
		
	}
	
}

class Pessoa{

	protected String nome;
	protected int idade;
	protected String grauDeEscolaridade;
	protected Genero identidadeDeGenero;
	protected String orientacaoSexual;
	protected char sexoBiologico;
	
	Pessoa() {}
	
	Pessoa(String nome, int idade, String grauDeEscolaridade, Genero identidadeDeGenero, String orientacaoSexual, char sexoBiologico) {
		this.nome = nome;
		this.idade = idade;
		this.grauDeEscolaridade = grauDeEscolaridade;
		this.identidadeDeGenero = identidadeDeGenero;
		this.orientacaoSexual = orientacaoSexual;
		this.sexoBiologico = sexoBiologico;
	}
	
	// Getter para todos os atributos
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public String getGrauDeEscolaridade() {
		return grauDeEscolaridade;
	}
	
	public Genero getIdentidadeDeGenero() {
		return identidadeDeGenero;
	}
	
	public String getOrientacaoSexual() {
		return orientacaoSexual;
	}
	
	public char getSexo() {
		return sexoBiologico;
	}
	
	// Setter somente para idade, nome, grau de escolaridade
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setGrauDeEscolaridade(String grauDeEscolaridade) {
		this.grauDeEscolaridade = grauDeEscolaridade;
	}
	
	// Métodos de uma pessoa
	public void dormir() {
		System.out.println("Dormindo");
	}
	
	public void cagar() {
		System.out.println("Cagando");
	}
	
	public void comer() {
		System.out.println("Comendo");
	}
	
	public void estudar() {
		System.out.println("Estudando");
	}
	
	public void viver() {
		System.out.println("Vivendo");
	}
	
	public void sobreviver() {
		System.out.println("Sobrevivendo");
	}
	
	public void trabalhar() {
		System.out.println("Trabalhando");
	}
	
}

enum Genero {
	
	CIS {
		@Override
		public String toString() {
			return "cisgênero";
		}
	},
	TRANS {
		@Override
		public String toString() {
			return "transgênero";
		}
	},
	FLUID {
		@Override
		public String toString() {
    		return "gênero fluido";
    	}
	},
	NONBIN {
		@Override
		public String toString() {
			return "não-binário";
		}	
	}

}