package lab2;

/**
 * Representação de um Estágio registrado como atividade complementar de um
 * aluno. Carrega informações da duração desse estágio em horas e os meses de
 * execução desse estágio.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Estagio {

	/**
	 * Atibuto do tipo int que armazena as horas de estágio registradas para o
	 * devido cálculo de créditos por atividade complementar.
	 */
	private int horas;
	/**
	 * Atibuto do tipo int que armazena o tempo de execução do estágio em meses para
	 * o devido cálculo de créditos por atividade complementar.
	 */
	private int meses;

	/**
	 * Constrói um Estágio a partir das horas de duração e dos meses de execução
	 * desse estágio. Os valores passados como atributos são definidos como valores
	 * dos atributos da classe.
	 * 
	 * @param horas Valor do tipo int com as horas de duração do estágio a ser
	 *              criado.
	 * @param meses Valor to tipo int com o tempo de execução do estágio em meses
	 *              para criação do estágio.
	 */
	public Estagio(int horas, int meses) {
		this.horas = horas;
		this.meses = meses;
	}

	/**
	 * Retorna o valor do atributo horas para o uso no devido cálculo das atividades
	 * complementares.
	 * 
	 * @return Valor int do atributo horas.
	 */
	public int getHoras() {
		return this.horas;
	}

	/**
	 * Retorna o valor do atributo meses para o uso no devido cálculo das atividades
	 * complementares.
	 * 
	 * @return Valor int do atributo meses.
	 */
	public int getMeses() {
		return this.meses;
	}
}
