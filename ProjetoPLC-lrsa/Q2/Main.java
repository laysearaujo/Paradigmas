class Main {
	
	public static void main(String[] args) {
		Texto t1 = new Texto("ola, estou aprendendo java e estou achando java legal.");
		
		t1.imprimir();
		
		System.out.print();
		
		int total = t1.informarONumeroTotal();
		System.out.print("Numero total de palavras: "+total+"\n");
		
		int freq = t1.informaAFrencia("java");
		System.out.print("Frequência da palavra 'java' na frase: "+freq+"\n");
		
		String newText = t1.substituirTodasAsOcorrencias("java", "alemao");
		System.out.print("Substituir todas as ocorrências da palavra 'java' no texto pela palavra 'alemao': \n"+newText+"\n");
	}
	
}


class Texto {
	
	private String text;
	
	public Texto() {}
	
	public Texto(String text) {
		this.text = text;
	}
	
	public setTexto(String newTexto) {
		this.text = newTexto;
	}
	
	public String getTexto() {
		return this.text;
	}
	
	public void imprimir() {
		System.out.print(this.text+"\n");
	}
	
	public int informarONumeroTotal() {
		// De palavras dentro do texto
		int count = 0;
	    int cur = 0;

	    for(char c: this.text.toCharArray()){
	      if(('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')){
	        cur += 1;
	      }
	      else {
	        if(cur > 0) count++;
	        cur = 0;
	      }
	    }

	    if(cur > 0) count++;
	    return count;
	}
	
	public int informaAFrencia(String sub) {
		// de uma determinada substring dentro do texto
		int count = 0;
		int n = -1;
		for(;;++count) {
			n = this.text.indexOf(sub, n+1);
			if(n == -1)
				break;
		}
		return count;
	}
	
	public String substituirTodasAsOcorrencias(String oldWord, String newWord) {
		// de uma palavra no texto por uma outra palavra qualquer
		String newText = this.text.replace(oldWord, newWord);
		return newText;
	}
	
	
}