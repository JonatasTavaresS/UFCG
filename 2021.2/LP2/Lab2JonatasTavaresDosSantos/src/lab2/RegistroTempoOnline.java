package lab2;

/**
 * Representação do Registro de Tempo Online com informações sobre a quantidade
 * de horas de internet que o aluno tem dedicado para uma disciplina remota.
 * Controla o estado do aluno em uma disciplina.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class RegistroTempoOnline {

	/**
	 * Nome da Disciplina é um atributo do tipo String que define o nome da
	 * disciplina em que está sendo avaliado o tempo que o aluno dedicou online.
	 */
	private String nomeDisciplina;
	/**
	 * Tempo Online Esperado é um atributo do tipo int que define o tempo online
	 * representado em horas que se espera que o aluno se dedique à disciplina.
	 */
	private int tempoOnlineEsperado;
	/**
	 * Tempo Online Gasto é um atributo do tipo int que define o tempo online
	 * representado em horas que o aluno realmente se dedicou à disciplina em
	 * questão. Idealmente, esse valor deve ser maior ou igual ao Tempo Online
	 * Esperado. É, por padrão, iniciadp com o valor 0.
	 */
	private int tempoOnlineGasto;

	/**
	 * Contrói um resgitro do tempo online dedicado à uma disciplina remota passando
	 * uma String com o nome da disciplina como parâmetro para tal. Quando o tempo
	 * online esperado para a disciplina não é informado, ele chama um outro
	 * {@link #RegistroTempoOnline(String, int) construtor que recebe o parâmetro do
	 * int de tempo online esperado} definindo, por padrão, como sendo de 120 horas.
	 * 
	 * @param nomeDisciplina String com o nome da disciplina remota.
	 */
	public RegistroTempoOnline(String nomeDisciplina) {
		this(nomeDisciplina, 120);
	}

	/**
	 * Contrói um resgitro do tempo online dedicado à uma disciplina remota passando
	 * uma String com o nome da disciplina e um int com o número de horas que se
	 * espera que o aluno dedique à diciplina como parâmetros para tal.
	 * 
	 * @param nomeDisciplina      String com o nome da disciplina remota.
	 * @param tempoOnlineEsperado int com o tempo online representado em horas
	 *                            estimado como meta a ser dedicado para a
	 *                            disciplina.
	 */
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
	}

	/**
	 * Adiciona Tempo Online ao tempo que o aluno dedicou à disciplina remota.
	 * Possui um único parâmetro do tipo int com tempo em horas que é somado ao
	 * tempo online gasto já definido. Caso nunca tenha sido adicionado tempo
	 * online, inicialmente ele é de 0 horas.
	 * 
	 * @param tempo int com a representação em horas do tempo gasto pelo aluno a ser
	 *              somado na disciplina.
	 */
	public void adicionaTempoOnline(int tempo) {
		this.tempoOnlineGasto += tempo;
	}

	/**
	 * Retorna um boolean que indica se o aluno conseguiu atingir ou não a Meta de
	 * Tempo Online definida para a disciplina remota. Caso o tempo online gasto
	 * seja maior ou igual ao tempo onlie esperado é retornado true, caso contrário,
	 * é retornado false.
	 * 
	 * @return Um valor boolean que indica se a meta foi atingida ou não.
	 */
	public boolean atingiuMetaTempoOnline() {
		if (this.tempoOnlineGasto >= this.tempoOnlineEsperado) {
			return true;
		}
		return false;
	}

	/**
	 * Gera e retorna uma String que representa a classe. Contém o nome da
	 * disciplina, o tempo online já usado e o tempo online esperado. A
	 * representação é feita seguindo um formato com o nome da disciplina e o tempo
	 * online gasto separados por um espaço em branco, já o tempo online gasto e o
	 * tempo online esperado são separados por uma barra.
	 * 
	 * @return Representação em string dos atributos da classe.
	 */
	@Override
	public String toString() {
		return this.nomeDisciplina + " " + this.tempoOnlineGasto + "/" + this.tempoOnlineEsperado;
	}
}
