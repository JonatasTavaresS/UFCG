package lab2;

/**
 * Representação da rotina de descanso semanal de um aluno. Gerencia as horas de
 * descanso e o número de semanas para acompanhar o estado de cansaço de um
 * aluno.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Descanso {

	/**
	 * Horas de Descanso é um atributo do tipo int que armazena a representação em
	 * horas do tempo que o aluno descansou. Não inclui as horas de sono, mas sim as
	 * atividades de lazer em geral. É iniciado, por padrão, como 0 horas.
	 */
	private int horasDescanso;
	/**
	 * Número de Semanas é um atributo do tipo int que armazena a representação em
	 * semanas a serem levadas em consideração para definir o estado de descanso de
	 * um aluno. É iniciado, por padrão, como 0 semanas.
	 */
	private int numeroSemanas;
	/**
	 * Emoji é um tributo do tipo String que armazena um comentário do aluno sobre
	 * sua própria rotina de descanso, descrevendo a sua última sensação em geral.
	 */
	private String emoji;

	/**
	 * Contrói uma representação da Rotina de Descando de um aluno, sem parâmetros.
	 * Inicializa somente o atributo emoji como uma String vazia já que os demais
	 * atributos, horasDescanso e numeroSemanas, por serem do tipo int, já são
	 * inicializado com o valor 0.
	 */
	public Descanso() {
		this.emoji = "";
	}

	/**
	 * Define o valor do atributo horasDescanso através do valor do tipo int passado
	 * como parâmetro. Antes de alterar o atributo é necessário armazenar o status
	 * geral atual em uma variável. Após, realiza-se a alteração e verifica, através
	 * do método {@link #verificaMudancaStatus(String) verifica mudança de status},
	 * se o status geral sofreu mudança após a alteração do valor das horas de
	 * descanso para a devida apresentação do emoji.
	 * 
	 * @param valor int contendo o novo valor do atributo de horas de descanso.
	 * @see #verificaMudancaStatus(String) Método que verifica se houve mudança no
	 *      status após alteração no número de semanas.
	 */
	public void defineHorasDescanso(int valor) {
		String statusAnterior = this.getStatusGeral();
		this.horasDescanso = valor;
		this.verificaMudancaStatus(statusAnterior);
	}

	/**
	 * Define o valor do atributo numeroSemanas através do valor do tipo int passado
	 * como parâmetro. Antes de alterar o atributo é necessário armazenar o status
	 * geral atual em uma variável. Após, realiza-se a alteração e verifica, através
	 * do método {@link #verificaMudancaStatus(String) verifica mudança de status}
	 * se o status geral sofreu mudança após a alteração do valor das horas de
	 * descanso para a devida apresentação do emoji.
	 * 
	 * @param valor int contendo o novo valor do atributo de numero de semanas.
	 * @see #verificaMudancaStatus(String) Método que verifica se houve mudança no
	 *      status após alteração no número de semanas.
	 */
	public void defineNumeroSemanas(int valor) {
		String statusAnterior = this.getStatusGeral();
		this.numeroSemanas = valor;
		this.verificaMudancaStatus(statusAnterior);
	}

	/**
	 * Retorna uma String que define o status geral de descanso de um aluno.
	 * Inicialmente o estado é definido como “cansado” caso o aluno ainda não tenha
	 * registrado horas de descanso ou número de semanas. Para que o aluno seja
	 * considerado “descansado” ele deve descansar 26 horas por semana, ou mais. O
	 * status geral pode ser retornado, ainda, acompanhado de um emoji quando
	 * definido.
	 * 
	 * @return String que expressa o status geral do aluno, podendo ser “cansado” ou
	 *         “descansado”, além de poder possuir um emoji ao final.
	 */
	public String getStatusGeral() {
		if (this.horasDescanso != 0 && this.numeroSemanas != 0) {
			if ((this.horasDescanso / this.numeroSemanas) >= 26) {
				return "descansado" + this.emoji;
			}
		}
		return "cansado" + this.emoji;
	}

	/**
	 * Define um Emoji em formato de String através da String valor passada como
	 * parâmetro. O emoji não tem relação com o cálculo da rotina de descanso do
	 * aluno. Ele expressa o sentimento da aluno no momento, estando cansado ou não.
	 * É exibido depois do status geral separado por um hífen. Os emojis são em
	 * formato livre, mas seguem exemplos: “:(”, “*_*”, “:o)”, “¯\_(ツ)_/¯”
	 * 
	 * @param valor String contendo um emoji que descreve a sensação do aluno.
	 */
	public void definirEmoji(String valor) {
		this.emoji = " - " + valor;
	}

	/**
	 * Verifica se houve mudança no status geral recebendo o status anterior como
	 * parâmetro. Verificação realizada sempre que é feita alteração no número de
	 * horas de descanso e no número de semanas. Caso essa alteração provoque
	 * mudança no status, o valor do último emoji registrado é removido.
	 * 
	 * @param statusAnterior String com o resultado da função getStatusGeral() antes
	 *                       de uma alteração de horas de descanso ou de número de
	 *                       semanas.
	 * @see #getStatusGeral() Método que retorna o status de descanso do aluno.
	 */
	private void verificaMudancaStatus(String statusAnterior) {
		if (!this.getStatusGeral().equals(statusAnterior)) {
			this.emoji = "";
		}
	}
}
