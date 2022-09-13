package lab2;

/**
 * Classe com um {@link #main(String[]) main} que exercita as funcionalidades
 * implementadas para as atividades bônus. Exercita 3 das 4 atividades bônus
 * propostas, sendo elas: 5.1 - Mais Notas na Disciplina; 5.2 - Registro
 * Detalhado de Estágios; e 5.3 - Comentário sobre a rotina de descanso.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class CoisaBonus {

	/**
	 * Método main Java que exercita as funcionalidades aplicadas nas atividades
	 * bônus.
	 * 
	 * @param args Representa os argumentos da linha de comando. Mas, nesse caso,
	 *             ele não está sendo usado.
	 */
	public static void main(String[] args) {
		disciplina();
		System.out.println("-----");
		atividadesComplementares();
		System.out.println("-----");
		descanso();
	}

	/**
	 * Método que exercita o bônus 5.1 - Mais Notas na Disciplina. Permite verificar
	 * se a execução a classe {@link Disciplina} e seus métodos permancem
	 * funcionando como deveriam após as modificações. Atentando-se a diferenças de
	 * quando ela é inicializada com números de notas diferentes, além de com ou sem
	 * pesos.
	 * 
	 * @see Disciplina Classe Disciplina
	 */
	private static void disciplina() {
		Disciplina p2 = new Disciplina("PROGRAMAÇÃO 2", 3);
		p2.cadastraHoras(4);
		p2.cadastraNota(1, 8.0);
		p2.cadastraNota(2, 7.0);
		System.out.println(p2.aprovado());
		p2.cadastraNota(3, 9.0);
		System.out.println(p2.aprovado());
		System.out.println(p2.toString());
		int[] pesos = new int[] { 6, 4 };
		Disciplina lp2 = new Disciplina("LABORATÓRIO DE PROGRAMAÇÃO 2", 2, pesos);
		lp2.cadastraHoras(8);
		lp2.cadastraNota(1, 6.0);
		lp2.cadastraNota(2, 8.0);
		System.out.println(lp2.aprovado());
		System.out.println(lp2.toString());
	}

	/**
	 * Método que exercita o bônus 5.2 - Registro Detalhado de Estágios. Permite
	 * verificar se a execução da classe {@link AtividadesComplementares} e seus
	 * métodos permancem funcionando como deveriam após as modificações. Verificado
	 * o resultado das atividades complementares com a implementação de um cálculo
	 * de créditos contados também pelos meses de execução dos estágios.
	 * 
	 * @see AtividadesComplementares Classe de Atividades Complementares.
	 */
	private static void atividadesComplementares() {
		AtividadesComplementares minhasAtividades = new AtividadesComplementares();
		minhasAtividades.adicionarEstagio(600, 4);
		minhasAtividades.adicionarEstagio(300, 8);
		String[] atividades = minhasAtividades.pegaAtividades();
		for (int i = 0; i < atividades.length; i++) {
			System.out.println(minhasAtividades.pegaAtividades()[i]);
		}
		System.out.println(minhasAtividades.contaCreditos());
	}

	/**
	 * Método que exercita o bônus 5.3 - Comentário sobre a rotina de descanso.
	 * Permite verificar se a execução a classe {@link Descanso} e seus métodos
	 * permancem funcionando como deveriam após as modificações. Verificando o
	 * acréscimo de emojis e se sua saída é a esperada a depender das modificações
	 * feitas nas horas de descanso e no número de semanas, alterando o status geral
	 * de descanso do aluno.
	 * 
	 * @see Descanso Classe Descanso.
	 */
	private static void descanso() {
		Descanso descanso = new Descanso();
		descanso.definirEmoji(":(");
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(30);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
		descanso.definirEmoji("<(^_^<)");
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		System.out.println(descanso.getStatusGeral());
		descanso.defineNumeroSemanas(2);
		System.out.println(descanso.getStatusGeral());
		descanso.defineHorasDescanso(26);
		descanso.defineNumeroSemanas(1);
		System.out.println(descanso.getStatusGeral());
	}
}
