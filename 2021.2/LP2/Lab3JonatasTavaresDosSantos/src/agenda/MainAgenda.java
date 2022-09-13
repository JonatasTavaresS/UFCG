package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus de texto que permitem manipular métodos de uma
 * {@link Agenda agenda} de {@link Contato contatos}.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 * @see Agenda Classe Agenda.
 * @see Contato Classe Contato.
 */
public class MainAgenda {

	/**
	 * Método public static void main Java que exercita as funcionalidades da classe
	 * agenda. Cria uma agenda carregando contatos de um arquivo csv e exibe o menu
	 * de opções esperando comandos da pessoa que está usando o sistema.
	 * 
	 * @param args Representa os argumentos da linha de comando. Mas, nesse caso,
	 *             ele não está sendo usado.
	 */
	public static void main(String[] args) {
		Agenda agenda = new Agenda();
		System.out.println("Carregando agenda inicial");
		try {
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}
		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}

	/**
	 * Exibe o menu com todas as opções de ações possíveis da classe agenda e
	 * captura a escolha da pessoa que está usando o sistema. Os comandos podem ser
	 * digitados tanto em letras maiúsculas, quanto em letras minúsculas.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido em letras maiúsculas.
	 */
	private static String menu(Scanner scanner) {
		System.out.print("\n---\nMENU\n" + "(C)adastrar Contato\n" + "(L)istar Contatos\n" + "(E)xibir Contato\n"
				+ "(F)avoritos\n" + "(A)dicionar Favorito\n" + "(T)ags\n" + "(R)Remover Contato\n" + "(M)uda Telefone\n"
				+ "(RT)Remove Tag\n" + "(RF)Remove Favorito\n" + "(CN)Consulta Nome\n" + "(CS)Consulta Sobrenome\n"
				+ "(CT)Consulta Tag\n" + "(S)air\n" + "\n" + "Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema. Para cada tipo
	 * de opção possícel executa uma função da agenda. Caso seja informada uma opção
	 * inválida, é exibida a mensagem "Opção inválida!" e o menu de opções é
	 * carregado novamente.
	 * 
	 * @param opcao   Opção digitada pela pessoa que está usando o sistema.
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Objeto do tipo Scanner para o caso do comando precisar ler
	 *                mais dados da entrada.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "T":
			aplicaTag(agenda, scanner);
			break;
		case "R":
			removeContato(agenda, scanner);
			break;
		case "M":
			mudaTelefone(agenda, scanner);
			break;
		case "RT":
			removeTag(agenda, scanner);
			break;
		case "RF":
			removeFavorito(agenda, scanner);
			break;
		case "CN":
			consultaNome(agenda, scanner);
			break;
		case "CS":
			consultaSobrenome(agenda, scanner);
			break;
		case "CT":
			consultaTag(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Cadastra um contato em uma posição específica agenda a partir do nome,
	 * sobrenone e telefone. Só são aceitas posições no intervalo entre 1 e 100,
	 * incluindo-os. Caso seja informado uma posição inválida é exibida a mensagem
	 * "POSIÇÃO INVÁLIDA" e o menu reaparece.
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		if (posicao < 1 || posicao > 100) {
			System.out.println("POSIÇÃO INVÁLIDA");
			return;
		}
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		System.out.println(agenda.cadastraContato(posicao, nome, sobrenome, telefone));
	}

	/**
	 * Imprime uma lista com todos os contatos da agenda e suas respectivas
	 * posições. Os contatos são impressos 1 por linha no formato "{posição} - Nome
	 * Sobrenome".
	 * 
	 * @param agenda A própria Agenda que está sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		System.out.println(agenda.listaContatos());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. Imprime um contato com
	 * todos os dados a partir da posição do contato na agenda. Imprime um contato
	 * especificado pela posição passada como parâmetro, uma posição válida está no
	 * intervalo entre 1 e 100, incluindo-os. Caso o contato naquela posição seja
	 * null é uma posição inválida. Caso seja uma posição inválida imprime "POSIÇÃO
	 * INVÁLIDA!" e exibe novamente o menu de opções. Exibe nome e sobrenome na
	 * primeira linha, exibe telefone na linha seguinte e, na última linha, exibe
	 * todas as tags do contato separadas por um espaço entre cada uma. Ademais,
	 * caso o contato em questão esteja na lista de favoritos, o nome desse contato
	 * é precedido por um emoji de coração "❤️".
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar qual contato a ser exibido.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("Contato> ");
		int posicao = scanner.nextInt();
		System.out.println("\n" + agenda.exibeContato(posicao));
	}

	/**
	 * Imprime uma lista com todos os contatos favoritados da agenda e suas
	 * respectivas posições na lista de favoritos. Os contatos são impressos 1 por
	 * linha no formato "{posição} - Nome Sobrenome".
	 * 
	 * @param agenda A própria Agenda que está sendo manipulada.
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println("\nLista de favoritos: ");
		System.out.println(agenda.listaFavoritos());
	}

	/**
	 * Adiciona um contato a lista de favoritos da agenda a partir da posição do
	 * contato e da posicão a ser adicionado na lista de favoritos. Caso a posição
	 * do contato na agenda esteja fora do intervalo entre 1 e 100 (incluindo-os),
	 * ou se a posição para lista de favoritos estiver fora do intervalo entre 1 e
	 * 10 (incluindo-os), o método não imprime nada. Caso o contato já esteja
	 * favoritado em uma outra posição específica é impresso "CONTATO JÁ FAVORITADO
	 * NA POSIÇÃO {posição onde está favoritado}!". Caso o processo de favoritar
	 * seja concluído com êxito, é impresso "CONTATO FAVORITADO NA POSIÇÃO
	 * {posição}!". Caso já haja um contato na posição a ser favoritada, o contato
	 * anterior existente naquela posição é sobrescrito.
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar qual contato e qual a posição da tag.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		System.out.print("\nPosicao> ");
		int posicao = scanner.nextInt();
		System.out.println(agenda.adicionaFavorito(contato, posicao));
	}

	/**
	 * Adiciona tag à 1 ou múltiplos contatos da agenda. Adiciona uma tag em uma
	 * posição específica nos contatos das posições passadas como parâmetro. Tags
	 * não são cadastradas caso a posição da tag não esteja no intervalo entre 1 e
	 * 5, incluindo-os. Caso a posição do contato esteja no intervalo entre 1 e 100,
	 * incluindo-os, e exista contato cadastrado naquela posição da agenda, a tag é
	 * adicionada ao contato na posição indicada.
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar qual contato, qual tal e qual a posição
	 *                da tag.
	 */
	private static void aplicaTag(Agenda agenda, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nContato(s)> ");
		String contatos = scanner.nextLine();
		System.out.print("\nTag> ");
		String tag = scanner.nextLine();
		System.out.print("\nPosicao tag> ");
		int posicaoTag = scanner.nextInt();
		agenda.aplicaTag(contatos, tag, posicaoTag);
	}

	/**
	 * Remove 1 ou mais contatos da agenda a partir das posições dos contatos
	 * passadas como parâmetro. Só são permitidas posições que estejam no intervalo
	 * de 1 até 100, incluindo-os. Caso haja contato na posição especificada é
	 * verificado se ele está na lista de favoritos para removê-lo em caso posivo.
	 * Os contatos são removidos normalmente, mas caso encontre pelo menos uma
	 * posição inválida ou um contato que não existe, o método para de remover,
	 * imprime "POSIÇÃO INVÁLIDA!" e exibe o menu novamente.
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar qual contato deve ser removido.
	 */
	private static void removeContato(Agenda agenda, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nContato(s)> ");
		String contatos = scanner.nextLine();
		boolean valido = agenda.removeContatos(contatos);
		if (valido == false) {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Altera o telefone de um contato da agenda. Caso a posição do contato
	 * informada esteja fora do intervalo entre 1 e 100, incluindo-os, ou se o
	 * contato na posição for null, retorna "POSIÇÃO INVÁLIDA". Caso o telefone
	 * passado seja null, lança um NullPointerException. Caso o telefone passado
	 * seja vazio lança um IllegalArgumentException. Caso tudo esteja certo, o
	 * telefone é enfim alterado.
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar qual contato deve ser alterado e qual o
	 *                novo telefone.
	 */
	private static void mudaTelefone(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();
		System.out.println(agenda.mudaTelefone(contato, telefone));
	}

	/**
	 * Remove a tag de um contato a partir da posição do contato na agenda e da
	 * posição da tag no contato. Caso a posição do contato informada esteja fora do
	 * intervalo entre 1 e 100, incluindo-os, ou se o contato na posição for null,
	 * retorna "POSIÇÃO INVÁLIDA". Caso a posição da tag informada informada esteja
	 * fora do intervalo entre 1 e 5, incluindo-os, retorna "POSIÇÃO INVÁLIDA". Caso
	 * não haja tags na posição informada, retorna "NÃO HÁ TAG NA POSIÇÃO". Caso
	 * esteja tudo certo, a tag é removida e é informado que foi removida com
	 * sucesso.
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar qual contato deve ter a tag removida o e
	 *                qual a posição da tag.
	 */
	private static void removeTag(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		System.out.print("\nPosição Tag> ");
		int posicaoTag = scanner.nextInt();
		System.out.println(agenda.removeTag(contato, posicaoTag));
	}

	/**
	 * Remove um contato da lista de favoritos a partir da posição do contato na
	 * lista de favoritos. Caso a posição informada esteja fora do intervalo entre 1
	 * e 10, incluindo-os, é impresso "POSIÇÃO INVÁLIDA". Caso não haja contato
	 * favoritado na posição indicada, é impresso "NÃO HÁ CONTATO FAVORITADO NA
	 * POSIÇÃO {posicao}". Caso esteja tudo certo, o contato é enfim removido e é
	 * impresso "CONTATO DESFAVORITADO".
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar a posição do favorito a ser removido.
	 */
	private static void removeFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição Favorito> ");
		int posicaoFavorito = scanner.nextInt();
		System.out.println(agenda.removeFavorito(posicaoFavorito));
	}

	/**
	 * Imprime todos os contatos da agenda que contém o nome especificado. Caso o
	 * nome passado como parâmetro seja nulo ou vazio, imprime "Nome Inválido". Caso
	 * não haja nenhum contato com o nome especificado, imprime "Não há contatos com
	 * o nome {nome}".
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar o nome a ser consultado.
	 */
	private static void consultaNome(Agenda agenda, Scanner scanner) {
		System.out.print("\nNome> ");
		String nome = scanner.next();
		System.out.println("\nContatos com o nome '" + nome + "':");
		System.out.println(agenda.consultaNome(nome));
	}

	/**
	 * Imprime todos os contatos da agenda que contém o sobrenome especificado. Caso
	 * o sobrenome passado como parâmetro seja nulo ou vazio, imprime "Sobrenome
	 * Inválido". Caso não haja nenhum contato com o sobrenome especificado, imprime
	 * "Não há contatos com o sobrenome {sobrenome}".
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar o sobrenome a ser consultado.
	 */
	private static void consultaSobrenome(Agenda agenda, Scanner scanner) {
		scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.println("\nContatos com o sobrenome '" + sobrenome + "':");
		System.out.println(agenda.consultaSobrenome(sobrenome));
	}

	/**
	 * Imprime todos os contatos da agenda que contém a tag especificada. Caso a tag
	 * passada como parâmetro seja nula ou vazia, imprime "Tag Inválida". Caso não
	 * haja nenhum contato com a tag especificada, imprime "Não há contatos com a
	 * tag {tag}".
	 * 
	 * @param agenda  A própria Agenda que está sendo manipulada.
	 * @param scanner Scanner para capturar a tag a ser consultada.
	 */
	private static void consultaTag(Agenda agenda, Scanner scanner) {
		System.out.print("\nTag> ");
		String tag = scanner.next();
		System.out.println("\nContatos com a tag '" + tag + "':");
		System.out.println(agenda.consultaTag(tag));
	}

	/**
	 * Exibe a mensagem "Vlw flw o/" e sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê os contatos de uma agenda a partir de um arquivo csv.
	 * 
	 * @param arquivoContatos O caminho para o arquivo cdv.
	 * @param agenda          A agenda que deve ser populada com os dados.
	 * @throws FileNotFoundException Caso o arquivo não exista.
	 * @throws IOException           Caso o arquivo não exista ou não possa ser
	 *                               lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		int carregados = leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
