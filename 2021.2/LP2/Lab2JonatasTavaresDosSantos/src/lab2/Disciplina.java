package lab2;

import java.util.Arrays;

/**
 * Representação de uma Disciplina com informações sobre as horas de estudo e
 * notas de um aluno em determinada disciplina. Gerencia notas e avalia o
 * desempenho de um aluno na diciplina.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Disciplina {

	/**
	 * Nome da Disciplina é um atributo do tipo String que define o nome da
	 * disciplina que está sendo registrada.
	 */
	private String nomeDisciplina;
	/**
	 * Horas de Estudo é um atributo do tipo int que define a representação em horas
	 * do tempo que o aluno estudou para essa disciplina. Iniciado, por padrão, com
	 * o valor 0.
	 */
	private int horasEstudo;
	/**
	 * Notas é um array de valores do tipo double que armazena cada nota do aluno. O
	 * número de notas é definido no momento da construção da classe, mas, caso não
	 * informado, por padrão ele é de 4 notas.
	 */
	private double[] notas;
	/**
	 * Pesos das Notas é um array de valores do tipo int contendo os pesos de cada
	 * nota. Se há N notas, há N pesos, o peso corresponde a nota no array de notas
	 * que está no mesmo índice. Caso não informado, o peso de todas notas é 1.
	 */
	private int[] pesosNotas;

	/**
	 * Constrói uma Disciplina passando como parâmetro apenas uma String com o nome
	 * da disciplia. Como não é passada a informação do número de notas nem dos
	 * pesos de cada nota, ele chama um outro {@link #Disciplina(String, int)
	 * construtor que recebe o número de notas} passando o valor definido, por
	 * padrão, como de 4 notas. Ademais, o outro construtor define que o peso dessas
	 * notas, como não é passado os pesos, como sendo todas de peso 1.
	 * 
	 * @param nomeDisciplina String contendo o Nome da Disciplina a ser definida no
	 *                       atributo nomeDisciplina.
	 */
	public Disciplina(String nomeDisciplina) {
		this(nomeDisciplina, 4);
	}

	/**
	 * Constrói uma Disciplina a partir de um valor do tipo String com o nome da
	 * disciplina e um valor do tipo int com o número de notas a serem cadastradas.
	 * A partir do número de notas é possível definir o tamanho do array de notas e
	 * pesos. Como não é passado array com os pesos, por padrão, todos os pesos são
	 * definidos como 1, o que se equipara a uma nota aritmética sem arredondamento.
	 * 
	 * @param nomeDisciplina String contendo o Nome da Disciplina a ser definida no
	 *                       atributo nomeDisciplina.
	 * @param numeroNotas    int contendo o número de notas a serem cadastradas nos
	 *                       arrays de notas e de pesos dessas notas.
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = new double[numeroNotas];
		this.pesosNotas = new int[numeroNotas];
		Arrays.fill(this.pesosNotas, 1);
	}

	/**
	 * Constrói uma Disciplina a partir de um valor do tipo String com o nome da
	 * disciplina, um valor do tipo int com o número de notas a serem cadastradas e
	 * um array de valores do tipo int com os pesos de cada nota cadastrada. A
	 * partir do número de notas é possível definir o tamanho do array de notas.
	 * Define os paraêmtros necessários valendo-se do
	 * {@link #Disciplina(String, int) construtor que recebe o nome da disciplina e
	 * o número de notas}, apenas. Como é passado array com os pesos, esses pesos
	 * serão usados no atributo de pesos e serão usados para o cálculo de uma média
	 * ponderada sem arredondamento.
	 * 
	 * @param nomeDisciplina String contendo o Nome da Disciplina a ser definida no
	 *                       atributo nomeDisciplina.
	 * @param numeroNotas    int contendo o número de notas a serem cadastradas nos
	 *                       arrays de notas e de pesos dessas notas.
	 * @param pesosNotas     Array de valores do tipo int com os pesos de cada nota
	 *                       a serem definidos no atributo.
	 */
	public Disciplina(String nomeDisciplina, int numeroNotas, int[] pesosNotas) {
		this(nomeDisciplina, numeroNotas);
		this.pesosNotas = pesosNotas;
	}

	/**
	 * Cadastra Horas soma as horas de estudo já cadastradas com um valor do tipo
	 * int de horas passado como parâmetro, ou seja, as horas de estudo são
	 * cumulativas. Caso nunca tenham sido cadastradas horas de estudo, ela é
	 * iniciada com o valor 0.
	 * 
	 * @param horas Valor do tipo int com o número de horas de estudo a ser
	 *              acrescida às horas de estudo já cadastardas.
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}

	/**
	 * Cadastra a nota de um aluno recendo um int que define qual nota será
	 * cadastrada e o valor dessa nota. Caso alguma das notas não seja cadastrada,
	 * ela é considerada como zero. Se alguma das notas for cadastrada mais de uma
	 * vez, é considerada a última nota cadastrada.
	 * 
	 * @param nota      Valor do tipo int que indica qual nota será cadastrada ou
	 *                  alterada. Só pode assumir valores entre 1 e o número total
	 *                  de notas.
	 * @param valorNota Valor do tipo double contendo o valor real da nota a ser
	 *                  cadastrada.
	 */
	public void cadastraNota(int nota, double valorNota) {
		if (nota >= 1 && nota <= this.notas.length) {
			this.notas[nota - 1] = valorNota;
		}
	}

	/**
	 * Retorna um boolean que indica se o aluno foi aprovado ou não. Caso a média
	 * atingida pelo aluno seja maior ou igual a 7.0, ele é considerado aprovado e é
	 * retornado o valor true. Caso a média atingida seja menor que 7.0, ele não é
	 * considerado aprovado e é retornado o valor false.
	 * 
	 * @return Um valor do tipo boolean que representa se o aluno foi aprovado ou
	 *         não. Valor true caso seja aprovado, valor false caso não seja
	 *         aprovado.
	 * @see #calculaMedia() Método que calcula a média de um aluno.
	 */
	public boolean aprovado() {
		if (this.calculaMedia() >= 7.0) {
			return true;
		}
		return false;
	}

	/**
	 * Gera e retorna uma String que representa a classe. Contém o nome da
	 * disciplina, as horas de estudo cadastradas, a média do aluno e o array de
	 * notas cadastradas. A representação é feita em um formato seguindo uma ordem
	 * com: o nome da disciplina; as horas de estudo cadastradas; a média do aluno;
	 * e um array com as notas cadastradas no formato [nota 1, nota 2, ... , nota
	 * n]. Cada informação é separada por um espaço em branco.
	 * 
	 * @return Representação em string da classe.
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.horasEstudo + " " + this.calculaMedia() + " "
				+ Arrays.toString(this.notas);
	}

	/**
	 * Calcula média ponderada sem arredondamento a partir dos atributos de notas e
	 * de pesos dessas notas. Caso todos os pesos sejam 1, o resultado é o mesmo que
	 * uma média aritmética sem arredondamento. Soma-se o produto de cada nota pelo
	 * seu respectivo peso e, depois, essa soma é dividida pela soma de todos os
	 * pesos. Segue exemplo:
	 * 
	 * ((peso_1 * nota_1) + (peso_2 * nota_2) + ... + (peso_n * nota_n)) /
	 * soma_pesos
	 * 
	 * @return Valor do tipo double contendo a média do aluno calculada a partir das
	 *         notas e pesos.
	 */
	private double calculaMedia() {
		double media = 0;
		int somaPesos = 0;
		for (int i = 0; i < this.notas.length; i++) {
			media += this.notas[i] * this.pesosNotas[i];
			somaPesos += pesosNotas[i];
		}
		media /= somaPesos;
		return media;
	}
}
