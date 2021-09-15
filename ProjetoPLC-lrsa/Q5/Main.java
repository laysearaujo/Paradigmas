public class Main {

	public static void main(String[] args) {
		ColecaoVetor array = new ColecaoVetor();
		
		Professor p1 = new Professor("Vitor", "112233", "Computacao", "TI");
		Aluno p2 = new Aluno("Layse", "112233", "112233", "Computacao");
		Aluno p3 = new Aluno("Layane", "112233", "112233", "Computacao");
		
		array.inserir(p1);
		System.out.println("Tamanho da colecao: "+array.tamanhoColecaoNaoNull());
		
		array.inserir(p2);
		System.out.println("Tamanho da colecao: "+array.tamanhoColecaoNaoNull());
		
		array.inserir(p3);
		System.out.println("Tamanho da colecao: "+array.tamanhoColecaoNaoNull());
		
		System.out.println("Pessoas inseridas na colecao: "+array.getNomeDados());
	}

}

interface Colecao {
	
	void inserir(Pessoa p);
	int tamanhoColecaoNaoNull();
	
}

abstract class Pessoa {
	
	protected String nome;
	protected String cpf;
	
	protected Pessoa() {}
	
	protected Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	protected abstract void setNome(String nome);
	
	protected abstract void setCpf(String cpf);
	
	protected String getNome() {
		return this.nome;
	}
	
	protected String getCpf() {
		return this.cpf;
	}

}
 
class Professor extends Pessoa {
	
	protected String formacao;
	protected String area;
	
	protected Professor() {}
	
	protected Professor(String nome, String cpf, String formacao, String area) {
		super(nome, cpf);
		this.formacao = formacao;
		this.area = area;
	}
	
	@Override
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getFormacao() {
		return this.formacao;
	}
	
	public String getArea() {
		return this.area;
	}
}

class Aluno extends Pessoa {
	
	protected String matricula;
	protected String curso;
	
	protected Aluno() {}
	
	protected Aluno(String nome, String cpf, String matricula, String curso) {
		super(nome, cpf);
		this.matricula = matricula;
		this.curso = curso;
	}
	
	@Override
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getCurso() {
		return this.curso;
	}
	
}

class ColecaoVetor implements Colecao {

	Pessoa[] dados = new Pessoa[5];
	
	public void inserir(Pessoa p) {
		int pos = 0;
        for(int i = 0; i < this.dados.length; i++) {
            if (this.dados[i] != null) {
                pos += 1;
            }
        }
        if (pos < this.dados.length) {
            this.dados[pos] = p;
        }else {
            System.out.println("A colecao encheu e nao pode ter mais itens inseridos!");
        }
    }

    public int tamanhoColecaoNaoNull() {
        int pos = 0;
        for(int i = 0; i < this.dados.length; i++) {
            if (this.dados[i] != null) {
                pos += 1;
            }
        }
        return pos;
    }
    
    public String getNomeDados() {
    	String result = "";
    	for(int i = 0; i < this.tamanhoColecaoNaoNull(); i++) {
    		result += this.dados[i].getNome()+" ";
        }
    	return result;
    }
    
}