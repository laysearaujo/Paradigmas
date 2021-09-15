public class Main {

	public static void main(String[] args){
		Senha senha = new Senha ("senha123", 123456);
		Conta conta = new Conta(1057, 3459, senha);
		
		System.out.print("Conta e senha: "+conta.getNumeroDeIdentificacao()+" -> ");
		System.out.println(conta.getSenha().getSenhaMista());
		
		senha.setSenhaMista("a1b2c3");
		conta.setSenha(senha);
		
		System.out.print("Conta e senha: "+conta.getNumeroDeIdentificacao()+" -> ");
		System.out.println(conta.getSenha().getSenhaMista());
	}
	
}

class Conta {

	protected int numeroDeIdentificacao;
	protected int agencia;
	protected Senha senha;
	
	protected Conta() {}
	
	protected Conta(int numeroDeIdentificacao, int agencia, Senha senha) {
		this.numeroDeIdentificacao = numeroDeIdentificacao;
		this.agencia = agencia;
		this.senha = senha;
	}
	
	// Setters
	protected void setNumeroDeIdentificacao(int newNumeroDeIdentificacao) {
		this.numeroDeIdentificacao = newNumeroDeIdentificacao;
	}
	
	protected void setAgencia(int newAgencia) {
		this.agencia = newAgencia;
	}
	
	protected void setSenha(Senha newSenha) {
		this.senha = newSenha;
	}
	
	// Getters
	protected int getNumeroDeIdentificacao() {
		return this.numeroDeIdentificacao;
	}
	
	protected int getAgencia() {
		return this.agencia;
	}
	
	protected Senha getSenha() {
		return this.senha;
	}
}

class Senha {
	
	protected String senhaMista;
	protected int SenhaNum;
	
	protected Senha() {}
	
	protected Senha(String senhaMista, int senhaNum) {
		this.senhaMista = senhaMista;
		this.SenhaNum = senhaNum;
	}
	
	// Setters
	protected void setSenhaMista(String newSenha) {
		this.senhaMista = newSenha;
	}
	
	protected void setSenhaNum(int newSenha) {
		this.SenhaNum = newSenha;
	}
	
	// Getters
	protected String getSenhaMista() {
		return this.senhaMista;
	}
	
	protected int getSenhaNum() {
		return this.SenhaNum;
	}
}