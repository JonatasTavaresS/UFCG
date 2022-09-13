package lab2;

/**
 * Representação das atividades complementares de um aluno. Gerencia a obtenção
 * de créditos pelas atividades de estágio, pela participação em projetos e
 * pelos cursos para que o aluno possa completar os 22 créditos em atividades
 * complementares necessários.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class AtividadesComplementares {

	/**
	 * Atributo do tipo array com valores do tipo {@link Estagio Estágio} que
	 * armazena, uma a uma, até 9 atividades de estágio do aluno.
	 * 
	 * @see Estagio Classe Estágio
	 */
	private Estagio[] estagios;
	/**
	 * Atributo do tipo array com valores do tipo int que armazena, um a um, o tempo
	 * de execução em meses de cada participação em projeto do aluno. Pode
	 * armazernar o tempo de excução em meses de até 16 projetos.
	 */
	private int[] mesesProjeto;
	/**
	 * Atributo do tipo int que armazena de forma cumulativa as horas de duração dos
	 * cursos que o aluno fez. Sempre é inicializado, por padrão, com 0 horas.
	 */
	private double horasCurso;

	/**
	 * Constói a classe sem se sejam necessários passar parâmetros. Inicializa o
	 * array de estágios com até 9 estágios. Inicializa o array com meses de
	 * execução de cada projeto com até 16 projetos.
	 */
	public AtividadesComplementares() {
		this.estagios = new Estagio[9];
		this.mesesProjeto = new int[16];
	}

	/**
	 * O método adicionar estágio cria um objeto da classe {@link Estagio Estágio} e
	 * adiciona ao atributo estágios. O objeto estágio é criado a partir das horas
	 * passadas como parâmetro. Como a duração em meses não é informada é chamado
	 * outro {@link #adicionarEstagio(int, int) método adicionarEstagio que recebe,
	 * também o número de meses} passando, por padrão, o estágio definindo-o como
	 * sendo de 4 meses de execução.
	 * 
	 * @param horas Valor do tipo int com o tempo em horas de participação no
	 *              estágio.
	 */
	public void adicionarEstagio(int horas) {
		this.adicionarEstagio(horas, 4);
	}

	/**
	 * O método adicionar estágio cria um objeto da classe {@link Estagio Estágio} e
	 * adiciona ao atributo estágios. O objeto estágio é criado a partir dos valoes
	 * das horas e dos meses passados como parâmetros. Caso já tenham sido
	 * adicionados 9 estágios, novos estágios não serão adicionados.
	 * 
	 * @param horas Valor do tipo int com o tempo em horas de participação no
	 *              estágio.
	 * @param meses Valor do tipo int com o tempo em meses de execução do estágio.
	 */
	public void adicionarEstagio(int horas, int meses) {
		for (int i = 0; i < this.estagios.length; i++) {
			if (this.estagios[i] == null) {
				this.estagios[i] = new Estagio(horas, meses);
				return;
			}
		}
	}

	/**
	 * O método adicionar projeto adiciona os meses de um projeto no array que
	 * armazena projetos a partir do valor do tipo int passado como parâmetro. Caso
	 * já tenham sido adicionados 16 projetos, novos projetos não serão adicionados.
	 * 
	 * @param meses Valor do tipo int com o tempo em meses de execução do projeto.
	 */
	public void adicionarProjeto(int meses) {
		for (int i = 0; i < this.mesesProjeto.length; i++) {
			if (this.mesesProjeto[i] == 0) {
				this.mesesProjeto[i] = meses;
				return;
			}
		}
	}

	/**
	 * Método adiciona curso soma o valor de horas do tipo int passado como
	 * parâmetro com as horas de curso já cadastradas. As horas de curso são
	 * cumulativas.
	 * 
	 * @param horas Valor do tipo int com as horas de curso a serem acrescidas no
	 *              atributo horas curso.
	 */
	public void adicionarCurso(double horas) {
		this.horasCurso += horas;
	}

	/**
	 * Conta os créditos totais do aluno a partir da soma dos
	 * {@link #creditosEstagio() créditos de atividades de estágio}, dos
	 * {@link #creditosProjeto() créditos de participação em projetos} e dos
	 * {@link #creditosCurso() créditos de cursos}.
	 * 
	 * @return Valor do tipo int com o total geral de créditos de aluno.
	 */
	public int contaCreditos() {
		int creditos = this.creditosEstagio() + this.creditosProjeto() + this.creditosCurso();
		return creditos;
	}

	/**
	 * O método pega atividades retorna uma representação em um array de String da
	 * classe. Os até 9 primeiros elementos do array, dependendo da quantidade de
	 * estágios cadastrados, mostram cada estágio do aluno no formato "Estagio
	 * horasEstagio mesesEstagio". Os demais até 16 próximos elementos do array, a
	 * depender de quantidade de projetos, mostram cada projeto do aluno no formato
	 * "Projeto mesesProjeto". Os últimos 4 elementos do array motram,
	 * respectivamente: as horas de curso no formato "Cursos horasCurso"; os
	 * créditos de estágios no formato "Creditos_Estagio creditosEstagio()" créditos
	 * de projetos no formato "Creditos_Projeto creditosProjeto()"; e os créditos de
	 * curso no formato "Creditos_Cursos creditosCurso()".
	 * 
	 * @return Array com valores do tipo String que representam, cada um, um
	 *         elemento importante da classe.
	 */
	public String[] pegaAtividades() {
		String atividades = "";
		for (int i = 0; i < this.estagios.length; i++) {
			if (this.estagios[i] == null) {
				break;
			}
			atividades += "Estagio " + this.estagios[i].getHoras() + " " + this.estagios[i].getMeses() + ", ";
		}
		for (int i = 0; i < this.mesesProjeto.length; i++) {
			if (this.mesesProjeto[i] == 0) {
				break;
			}
			atividades += "Projeto " + this.mesesProjeto[i] + ", ";
		}
		atividades += "Cursos " + this.horasCurso + ", Creditos_Estagio " + this.creditosEstagio()
				+ ", Creditos_Projeto " + this.creditosProjeto() + ", Creditos_Cursos " + this.creditosCurso();
		return atividades.split(", ");
	}

	/**
	 * Método créditos estágio contabiliza e retorna o valor total de créditos
	 * obtidos a partir das atividades de estágio. Os créditos são contabilizados a
	 * cada 300 horas de estágio tem o valor de 5 créditos e, a cada 4 meses de
	 * estágio também tem o valor de 5 créditos. Entretanto, se o aluno, por
	 * exemplo, fizer 600 horas de estágio em 4 meses, ele só receberá 5 créditos.
	 * Bem como caso ele faça 300 horas em 8 meses, ele só receberá 5 créditos. Ou
	 * seja, a função retorna o menor valor entre os créditos por horas de estágio e
	 * por meses de estágio. Ademais, não há proporcionalidade entre as horas e os
	 * meses de estágio não aproveitados
	 * 
	 * @return Valor do tipo int com os créditos obtidos a partir da execução de
	 *         atividades de estágio.
	 */
	private int creditosEstagio() {
		int horasEstagio = 0;
		int mesesEstagio = 0;
		for (int i = 0; i < this.estagios.length; i++) {
			if (this.estagios[i] == null) {
				break;
			}
			horasEstagio += this.estagios[i].getHoras();
			mesesEstagio += this.estagios[i].getMeses();
		}
		int creditosEstagio = Math.min((horasEstagio / 300) * 5, (mesesEstagio / 4) * 5);
		return creditosEstagio;
	}

	/**
	 * Método créditos de projeto retorna o valor de créditos obtidos a partir da
	 * participação em projetos. Para cada 3 meses de participação em projeto o
	 * aluno recebe 2 créditos, não havendo proporcionalidade aplicada aos meses não
	 * aproveitados.
	 * 
	 * @return Valor do tipo int com o total de créditos obtidos a partir da
	 *         participação em projetos.
	 */
	private int creditosProjeto() {
		int mesesProjeto = 0;
		for (int i = 0; i < this.mesesProjeto.length; i++) {
			if (this.mesesProjeto[i] == 0) {
				break;
			}
			mesesProjeto += this.mesesProjeto[i];
		}
		int creditosProjeto = (mesesProjeto / 3) * 2;
		return creditosProjeto;
	}

	/**
	 * Método créditos de curso calcula quantos céditos a atividade em cursos do
	 * aluno gerou. A cada 30 horas de curso o aluno recebe 1 crédito, não havendo
	 * proporcionalidade aplicada às horas não aproveitadas.
	 * 
	 * @return Valor do tipo int com o total de créditos obtidos a partir da
	 *         participação em cursos.
	 */
	private int creditosCurso() {
		int creditosCurso = (int) (this.horasCurso / 30);
		return creditosCurso;
	}
}
