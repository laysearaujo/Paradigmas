import java.util.Scanner;

class Main {
	
	public static void main(String[] args) {
		System.out.println("Digite a expressão que deseja avaliar:");
		Scanner in = new Scanner(System.in);
		String expr = in.nextLine();
		
		int type = typeExpr(expr);
		
        if(type == 2) {
            ExprAritmetica expression = new ExprAritmetica(expr);
			System.out.println("Ao chamar avaliar: "+expression.avaliar(expression.getExpr()));
			System.out.println("Ao chamar imprimirArvore: "+expression.imprimirArvore(expression.getExpr()));
		} else { // Lógico
			ExprLogica expression = new ExprLogica(expr);
			System.out.println("Ao chamar avaliar: "+expression.avaliar(expression.getExpr()));
			System.out.println("Ao chamar imprimirArvore: "+expression.imprimirArvore(expression.getExpr()));
		}
	}
	
	public static int typeExpr(String expr) {
		for(int i = 0; i < expr.length(); i++) {
			if(expr.charAt(i) == '=' || expr.charAt(i) == '>' || expr.charAt(i) == '<' || expr.charAt(i) == '!') {
				return 1; // Lógico
			}	
		}
		return 2; // Aritmetica
	}
	
}

interface Expression{
	
	String avaliar(String expr);
	String imprimirArvore(String expr);
	
}

class ExprAritmetica implements Expression {
	
	String expr;
	
	ExprAritmetica(String expr) {
		this.expr = expr;
	}
	
	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}

	private int resultadoExpr(String expr) {
		int posOp = operadorIndex(expr,'+');
		if(posOp == -1) {
			posOp = operadorIndex(expr,'-');
			if(posOp == -1) {
				posOp = operadorIndex(expr, '*');
				if(posOp == -1) {
					posOp = operadorIndex(expr,'/');
				}
			}
		}
		return posOp;
	}

    private int operadorIndex(String expr, char op) {
		for(int i = expr.length() -1; i>= 0; i--){
			if(expr.charAt(i) == op) {
				return i;
			}
		}
		return -1;
	}

	private String avaliarExp(String expr1, char op, String expr2) {
		int opPos1 = resultadoExpr(expr1), opPos2 = resultadoExpr(expr2);
		if(opPos1 == -1 && opPos2 == -1) {
			double n1 = Double.parseDouble(expr1), n2 = Double.parseDouble(expr2);
			if(op == '+') {
				return Double.toString(n1 + n2);
			}
			else if(op == '-') {
				return Double.toString(n1 - n2);
			}
			else if(op == '*'){
				return Double.toString(n1 * n2);
			}
			else if(op == '/'){
				return Double.toString(n1/n2);
			}
		}
		String newExpr1 = expr1,newExpr2 = expr2;
		if(opPos1 != -1){ 
			newExpr1 = avaliarExp(expr1.substring(0,opPos1),expr1.charAt(opPos1),expr1.substring(opPos1+1,expr1.length()));
        }
		if(opPos2 != -1) {
            newExpr2 = avaliarExp(expr2.substring(0,opPos2),expr2.charAt(opPos2),expr2.substring(opPos2+1,expr2.length()));

		}
		return avaliarExp(newExpr1,op,newExpr2);
	}
	
	private String printTree(String expr1,char op, String expr2) {
    	int opPos1 = resultadoExpr(expr1), opPos2 = resultadoExpr(expr2);
		if(opPos1 == -1 && opPos2 == -1) {
			if(op == '+')
				return "(" + expr1 + ")" + "P" + "(" + expr2 +")";//PLUS
			else if(op == '-') 
					return "(" + expr1 + ")" + "M" + "(" + expr2 +")" ;	//MINUS
			else if(op == '/') 
				return "(" + expr1 + ")" + "D" + "(" + expr2 +")" ;	//DIVIDE
			else if(op == '*') 
				return "(" + expr1 + ")" + "T" + "(" + expr2 +")"; //TIMES
			
		}
		String newExpr1 = expr1,newExpr2 = expr2;
		if(opPos1 != -1){ 
			newExpr1 = printTree(expr1.substring(0,opPos1),expr1.charAt(opPos1),expr1.substring(opPos1+1,expr1.length()));
        }
		if(opPos2 != -1) {
            newExpr2 = printTree(expr2.substring(0,opPos2),expr2.charAt(opPos2),expr2.substring(opPos2+1,expr2.length()));
		}
		return printTree(newExpr1,op,newExpr2);
	}

    @Override
	public String avaliar(String expr) {
    	int posOp = resultadoExpr(expr);
		if(posOp == -1) {
			return expr;
		}
		char op = expr.charAt(posOp);
		String expr1 = expr.substring(0,posOp);
		String expr2 = expr.substring(posOp+1,expr.length());
		String tree = avaliarExp(expr1,op,expr2);
		return tree;
    }
	
    @Override
	public String imprimirArvore(String expr) {
    	int posOp = resultadoExpr(expr);
		char op = 'F';
		if(posOp!=-1)
			op = expr.charAt(posOp);
		else if(posOp == -1) {
			return "(" + expr + ")";
		}
		String expr1 = expr.substring(0,posOp);
		String expr2 = expr.substring(posOp+1,expr.length());
		
		String tree = printTree(expr1,op,expr2);
		tree = tree.replaceAll("P", "+");
		tree = tree.replaceAll("M", "-");
		tree = tree.replaceAll("D", "/");
		tree = tree.replaceAll("T", "*");
		if(resultadoExpr(expr1) == -1 && resultadoExpr(expr2) == -1)
			return "(" + tree + ")";
		return "(" + tree +")";			
	}

	public String toString() {
		return this.expr;
	}

}

class ExprLogica implements Expression{
	
	String expr;

	ExprLogica(String expr){
		this.expr = expr;
	}
	
    public String getExpr() {
		return this.expr;
	}
	
    public void setExpr(String expr){
		this.expr = expr;
	}
	
    public String toString() {
		return this.expr;
	}

    private int operadorIndex(String expr) {
		int pos = -1;
		for(int i = 0; i<expr.length(); i++) {
			if(expr.charAt(i) == '=' || expr.charAt(i) == '>' || expr.charAt(i) == '<' || expr.charAt(i) == '!' ) {
				return i;
			}				
		}
		return pos;
	}
	
	private String opRetorno(String expr) {
		int pos = operadorIndex(expr);
		char op = expr.charAt(pos);
		char op1 = expr.charAt(pos+1);
		if(op == '=' && op1 == '=') {
			return "==";
		}
		else if(op == '!'&& op1 == '=') {
			return "!=";
		}
		else if(op == '>') {
			if(op1 == '=') {
				return ">=";
			}
			return ">";
		}
		else if(op == '<') {
			if(op1 == '=') {
				return ">=";
			}
			return "<";
		}
		return "";
	}
	
    @Override
	public String avaliar(String expr) {
		int posOp = operadorIndex(expr);
		String op = opRetorno(expr);
		int opLen = op.length();
		ExprAritmetica expr1 = new ExprAritmetica(expr.substring(0,posOp));
		ExprAritmetica expr2 = new ExprAritmetica(expr.substring(posOp + opLen, expr.length()));
		Double resultado1 = Double.parseDouble(expr1.avaliar(expr1.getExpr()).toString().toString());
		Double resultado2 = Double.parseDouble(expr2.avaliar(expr2.getExpr()).toString());
		boolean finalResult = true;
		if(op == "==") {
			finalResult = Double.compare(resultado1, resultado2) == 0? true : false;
		}
		else if(op == "!=")
			finalResult = Double.compare(resultado1, resultado2) == 0 ? false : true;
		else if(op == ">=")
			finalResult = resultado1 >= resultado2;
		else if(op == "<=")
			finalResult = resultado1 <= resultado2;
		else if(op == "<")
			finalResult = resultado1 < resultado2;
		else if(op == ">")
			finalResult = resultado1 > resultado2;
		return finalResult? "True":"False";
	}

	@Override
	public String imprimirArvore(String expr) {
		int posOp = operadorIndex(expr);
		String op = opRetorno(expr);
		int opLen = op.length();
		ExprAritmetica expr1 = new ExprAritmetica(expr.substring(0,posOp));
		ExprAritmetica expr2 = new ExprAritmetica(expr.substring(posOp + opLen, expr.length()));
		String resultado1 = expr1.imprimirArvore(expr1.getExpr());
		String resultado2 = expr2.imprimirArvore(expr2.getExpr());
		return "("+resultado1+op+resultado2+")";
	}	

}
