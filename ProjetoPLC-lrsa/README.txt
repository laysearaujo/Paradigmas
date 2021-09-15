[Q1] Crie uma classe abstrata Livro e a modele com os atributos básicos de um livro, sendo eles título, ISBN, autor, ano e editora bem como seus getters e setters. Em seguida, modele e crie as classes LivroLivraria e LivroBiblioteca, a primeira classe deve conter um método venderLivro, e a segunda deve conter um método emprestarLivro. Ambas as classes, respectivamente, devem conter um atributo indicador de que o livro já foi vendido ou emprestado.

[Q2] Implemente a classe Texto que é a representação de um texto qualquer com algumas operações básicas. A forma de implementar essa classe ficará a sua escolha (desde que você respeite os princípios da programação orientada a objetos, principalmente os de encapsulamento), entretanto a classe deverá possuir métodos para imprimir o texto completo na tela do console, informar o número total de palavras do texto, informar a frequência de uma determinada substring dentro do texto e substituir todas as ocorrências de uma palavra no texto por uma outra palavra qualquer. Considere que uma palavra é uma sequência de caracteres alfanuméricos, separadas por espaços, tabs ou pontuação. Crie também uma aplicação simples (Main) que utilize ao menos uma vez cada um dos métodos propostos para essa classe.

[Q3] Faça uma classe que modele uma pessoa. Uma pessoa no escopo para essa questão tem nome, idade, grau de escolaridade, identidade de gênero, orientação sexual e sexo biológico. Todos os atributos devem ser  protegidos (protected). Crie o construtor default dessa classe e um outro construtor com todos os atributos passados por passagem de argumentos (parâmetros). Faça o encapsulamento da seguinte forma: crie os métodos getter para todos os atributos, e os setter somente para idade, nome, grau de escolaridade. Defina uma classe do tipo enumerável (Pesquise!) para criar as constantes string da identidade de gênero, sendo elas: cisgênero, transgênero, gênero fluido e não-binário. Crie também os métodos (comportamentos) de uma pessoa (também conhecida por ser humano), sendo eles, dormir, cagar, comer, estudar, viver, sobreviver e trabalhar. Nesses últimos casos, basta colocar um system.out.println mantendo assim a coesão da classe. Após isso, crie a classe principal (Main), crie 2 objetos do tipo pessoa,o primeiro instanciado por meio do construtor default e o segundo com o outro construtor. Fique à vontade para usar os métodos criados com as instâncias criadas, mas não precisa utilizar todos.

[Q4] Crie uma classe Conta e uma classe Senha. Nesse caso, uma Conta tem um número de identificação, uma agência e uma senha que deve ser um atributo na classe Conta, fazendo assim a composição da classe Senha na classe Conta. Na classe Senha temos duas senhas: uma composta de letras com números, exemplo A1B2C3, e outra somente de números, exemplo, 123456. Em ambas classes, crie o construtor com todos os atributos passados por passagem de argumentos (parâmetros); e faça o encapsulamento com a criação de getters e setters. Crie todas as variáveis e métodos com o modificador de acesso protegido em ambas as classes. Em seguida, crie uma classe principal (Main) e instancie uma conta. Após isso, mostre a senha de letras dessa conta e seu número de identificação. Ademais, modifique a senha de letras com o uso de um método setter respectivo e mostre a senha de letras dessa conta agora modificada.


[Q5] Implemente a modelagem Q5 abaixo. Em outras palavras: 

Implemente a interface Colecao e a classe abstrata Pessoa definindo os modificadores de acessos dos atributos como protegidos (protected), seu construtor, seus métodos (getters e setters), os quais, todos os setters serão métodos abstratos. 
Após isso, implemente as classes (concretas) Professor e Aluno. Note que Professor e Aluno são subclasses de Pessoa. 
Em outra classe, de nome ColecaoVetor, instancie um vetor de Pessoas de nome dados e que possui tamanho 5.
Crie então uma classe chamada Principal ou Main que conterá o método vazio e estático padrão para execução de um programa java (public static void main(String[] args)). 
Dentro desse último método mencionado, crie uma instância da classe ColecaoVetor. 
Ainda na “main” insira a partir da função inserir, três objetos Pessoa na instância criada, podendo ser Professor ou Aluno e cada vez que um desses dois tipos de Pessoa for inserido, faça uso da função tamanhoColecaoNaoNull para informar quantas vagas existem de inserção. Faça outro método que retorne o nome de cada Pessoa inserida na classe ColecaoVetor.

A semântica básica do diagrama: 
Primeiro retângulo possui o nome da Classe e o seu tipo, podendo ser abstract (Classe Abstrata), Java Bean (Classe concreta) e interface.
Segundo retângulo possui os atributos. Ex.: atributoNome: tipoAtributo.
Terceiro retângulo possui os métodos. Ex.: nomeMetodo (Parâmetros e tipos): tipoDeRetorno.
A seta pontilhada representa qual interface deve se implementar (nesse caso).
A seta contínua representa qual é a classe mãe (super), cujas classes filhos devem herdar atributos e métodos.
A linha reta representa que Colecao terá elementos Pessoas.
Onde se lê o símbolo menos (-, que seria para modificador de acesso private) nos atributos, leia-se o símbolo jogo da velha (#, que representa o modificador de acesso protected).
Modelagem Q5


[Q6] Implemente um avaliador de expressões. Nesse caso, utilize a interface Expression. Ela contém dois métodos implementáveis, avaliar() e imprimirArvore(). A função avaliar() avalia recursivamente a expressão que lhe é passada como argumento considerando a precedência das operações na seguinte ordem de prioridade quanto às operações aritméticas: divisão (/), multiplicação (*), subtração (-) e soma (+). Além disso, deve ser considerada também a leitura da String de entrada, que é avaliada sempre da direita para a esquerda, e conterá somente números naturais maiores que zero ( ℕ+ , i.e, { 1, 2, 3, … , n}. Quanto às operações lógicas, elas seguirão um padrão onde uma expressão contém uma exprAritmetica operadorLogico exprAritimetica, tendo como operadores o maior que (>), menor que (<), maior ou igual (>=), menor ou igual (<=), diferente (!=) e igual (==).
Com a interface criada, você deve implementar as classes ExprAritmetica e ExprLogica. Deve existir também uma classe Main, que deve receber a entrada em formato de string, descobrir o tipo da expressão, instanciar um objeto do tipo da expressão, avaliar e printar a árvore respectiva a expressão dada na entrada.

Exemplos de Entradas e saídas:

1º Caso Teste:

Input: 
2*3+4/6
Output: 
ao chamar avaliar: 6.66666666667
ao chamar imprimirArvore: (((2)*(3))+((4)/(6)))


2º Caso Teste:

Input: 
2+5/10<12+16
Output: 
ao chamar avaliar: True
ao chamar imprimirArvore: (((2)+((5)/(10)))<((12)+(16)))

3º Caso Teste:

Input: 
2*3+4/6/6*4
Output: 
ao chamar avaliar: 6.44444444444
ao chamar imprimirArvore: (((2)*(3))+((((4)/(6))/(6))*(4)))

4º Caso Teste:

Input: 
24-12-4/12/12/12
Output: 
ao chamar avaliar:11.997685185185185
ao chamar imprimirArvore: (((24)-(12))-((((4)/(12))/(12))/(12)))
