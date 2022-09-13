package agenda;

/**
 * Representação de uma Agenda que mantém uma lista de {@link Contato contatos}.
 * Podem ser adicionados até 100 contatos diferentes e, também é possível
 * favoritar até 10 desses contatos.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 * @see Contato Classe Contato
 */
public class Agenda {

	/**
	 * Tamanho da Agenda. Um núemro do tipo int que define o limite máximo de
	 * posições de contatos que podem ser cadastrados na agenda.
	 */
	private static final int TAMANHO_AGENDA = 100;
	/**
	 * Tamanho dos Favoritos. Um número do tipo int que define o limite máximo de
	 * contatos que podem ser favoritados na agenda.
	 */
	private static final int TAMANHO_FAVORITOS = 10;

	/**
	 * Array de Contatos. Um array de objetos do tipo {@link Contato} que serve como
	 * um repositório de todos os contatos salvos na agenda. Os contatos são
	 * cadastrados de acordo com a sua respectiva posição, que pode ir de 0 até 100.
	 */
	private Contato[] contatos;
	/**
	 * Array de Favoritos. Um array de objetos do tipo {@link Contato} que registra
	 * contatos que já estão salvos na agenda como favoritos. Os contatos são
	 * favoritados de acordo com a sua respectiva posição, que pode ir de 0 até 10.
	 */
	private Contato[] favoritos;

	/**
	 * Constrói uma Agenda. Não são necessários atributos para esse construtor.
	 * Inicializa o array de contatos com o tamanho definido no atibuto
	 * "TAMANHO_AGENDA", definindo o limite máximo de 100 contatos para a agenda.
	 * Inicializa o array de favoritos com o tamanho definido no atibuto
	 * "TAMANHO_FAVORITOS", definindo o limite de 10 contatos favoritados na agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}

	/**
	 * Acessa os dados de um contato específico já existente a partir da sua
	 * respectiva posição na agenda.
	 * 
	 * @param posicao Número do tipo int que representa a posição do contato na
	 *                agenda.
	 * @return O próprio contato na posição desejada. Null se não há contato na
	 *         posição.
	 */
	private Contato getContato(int posicao) {
		if (posicao < 1 || posicao > 100) {
			return null;
		}
		return this.contatos[posicao - 1];
	}

	/**
	 * Cadastra um contato em uma posição definida. Um contato possui nome,
	 * sobrenone e telefone. A posição não pode ter um valor fora do intervalo entre
	 * 1 e 100, incluindo-os. Contatos com argumentos nulos são considerados
	 * inválidos e lançam NullPointerException. Contatos com nome ou telefone vazios
	 * são considerados inválidos e lançam uma IllegalArgumentException. Contatos
	 * com o mesmo nome e sobrenome são considerados contatos iguais e não são
	 * cadastrados. Um cadastro de um contato em uma posição que já existe
	 * sobrescreve o contato anterior existente naquela posição.
	 * 
	 * @param posicao   Posição onde o contato deve ser cadastrado.
	 * @param nome      Nome que o contato deve possuir.
	 * @param sobrenome Sobrenome que o contato deve possuir.
	 * @param telefone  Telefone que o contato deve possuir.
	 * @return Retorna uma String que indica se foi passada uma "POSIÇÃO INVÁLIDA",
	 *         se é um "CONTATO JA CADASTRADO" ou se o contato teve o "CADASTRO
	 *         REALIZADO"
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 1 || posicao > 100) {
			return "POSIÇÃO INVÁLIDA";
		} else if (nome == null || sobrenome == null || telefone == null) {
			throw new NullPointerException("CONTATO INVALIDO");
		} else if (nome.isBlank() || telefone.isBlank()) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}
		Contato contato = new Contato(nome, sobrenome, telefone);
		for (int i = 0; i < this.contatos.length; i++) {
			if (contato.equals(this.contatos[i])) {
				return "CONTATO JA CADASTRADO";
			}
		}
		this.contatos[posicao - 1] = contato;
		return "CADASTRO REALIZADO";
	}

	/**
	 * Retorna uma String com todos os contatos da agenda e suas respectivas
	 * posições. Os contatos são incrementados linha a linha, com 1 contato por
	 * linha no formato "{posição} - Nome Sobrenome".
	 * 
	 * @return String com uma lista de todos os contatos de agenda.
	 */
	public String listaContatos() {
		String contatos = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				if (!contatos.equals("")) {
					contatos += "\n";
				}
				contatos += (i + 1) + " - " + this.exibeContatoResumido(i + 1);
			}
		}
		return contatos;
	}

	/**
	 * Exibe um contato com todos os dados a partir da posição do contato na agenda.
	 * Exibe um contato especificado pela posição passada como parâmetro, uma
	 * posição válida está no intervalo entre 1 e 100, incluindo-os. Caso o contato
	 * naquela posição seja null é uma posição inválida. Exibe nome e sobrenome na
	 * primeira linha, exibe telefone na linha seguinte e, na última linha, exibe
	 * todas as tags do contato separadas por um espaço entre cada uma. Ademais,
	 * caso o contato em questão esteja na lista de favoritos, o nome desse contato
	 * é precedido por um emoji de coração "❤️".
	 * 
	 * @param posicao Posição do contato que se deseja exibir.
	 * @return Retorna uma representação textual completa dos dados do contato na
	 *         posição desejada.
	 */
	public String exibeContato(int posicao) {
		Contato contato = this.getContato(posicao);
		if (contato == null) {
			return "POSIÇÃO INVÁLIDA!";
		}
		for (int i = 0; i < this.favoritos.length; i++) {
			if (contato.equals(this.favoritos[i])) {
				return "❤️ " + contato.getContato();
			}
		}
		return contato.getContato();
	}

	/**
	 * Exibe o contato de forma resumida a partir da posição dele na agenda. Exibe
	 * um contato especificado pela posição passada como parâmetro, uma posição
	 * válida está no intervalo entre 1 e 100, incluindo-os. Caso o contato naquela
	 * posição seja null é uma posição inválida. Exibe nome e sobrenome do contato
	 * separados por um espaço.
	 * 
	 * @param posicao Posição do contato que se deseja exibir de forma resumida.
	 * @return Retorna uma representação textual resumida dos dados do contato na
	 *         posição desejada.
	 */
	public String exibeContatoResumido(int posicao) {
		if (this.getContato(posicao) == null) {
			return "POSIÇÃO INVÁLIDA!";
		}
		return this.getContato(posicao).toString();
	}

	/**
	 * Retorna uma String com todos os contatos favoritados da agenda e suas
	 * respectivas posições na lista de favoritos. Os contatos são incrementados
	 * linha a linha, com 1 contato por linha no formato "{posição} - Nome
	 * Sobrenome".
	 * 
	 * @return String com uma lista de todos os contatos favoritados da agenda.
	 */
	public String listaFavoritos() {
		String favoritos = "";
		for (int i = 0; i < this.favoritos.length; i++) {
			if (this.favoritos[i] != null) {
				if (!favoritos.equals("")) {
					favoritos += "\n";
				}
				favoritos += (i + 1) + " - " + this.favoritos[i].toString();
			}
		}
		return favoritos;
	}

	/**
	 * Adiciona um contato a lista de favoritos a partir da posição do contato e da
	 * posicão a ser adicionado na lista de favoritos. Caso a posição do contato na
	 * agenda esteja fora do intervalo entre 1 e 100 (incluindo-os), ou se a posição
	 * para lista de favoritos estiver fora do intervalo entre 1 e 10
	 * (incluindo-os), o método não retorna nada. Caso o contato já esteja
	 * favoritado em uma outra posição específica é retornado "CONTATO JÁ FAVORITADO
	 * NA POSIÇÃO {posição onde está favoritado}!". Caso o processo de favoritar
	 * seja concluído com êxito, é retornado "CONTATO FAVORITADO NA POSIÇÃO
	 * {posição}!". Caso já haja um contato na posição a ser favoritada, o contato
	 * anterior existente naquela posição é sobrescrito.
	 * 
	 * @param contatoAdd Posição do contato a ser favoritado na agenda.
	 * @param posicao    Posição onde o contato deve ser favoritado
	 * @return Retorna uma String informando que o contato foi favoritado, caso seja
	 *         concluído com êxito. Retorna uma String informando que o contato já
	 *         está favoritado caso ele já esteja favoritdo em alguma posição. Em
	 *         caso de parâmetros inválidos, não retorna nada (null).
	 */
	public String adicionaFavorito(int contatoAdd, int posicao) {
		Contato contato = this.getContato(contatoAdd);
		if ((contato == null) || (posicao < 1 || posicao > 10)) {
			return null;
		}
		for (int i = 0; i < this.favoritos.length; i++) {
			if (contato.equals(this.favoritos[i])) {
				return "CONTATO JÁ FAVORITADO NA POSIÇÃO " + (i + 1) + "!";
			}
		}
		this.favoritos[posicao - 1] = contato;
		return "CONTATO FAVORITADO NA POSIÇÃO " + posicao + "!";
	}

	/**
	 * Aplica tag à 1 ou múltiplos contatos. Adiciona uma tag em uma posição
	 * específica nos contatos das posições passadas como parâmetro. Tags não são
	 * cadastradas caso a posição da tag não esteja no intervalo entre 1 e 5,
	 * incluindo-os. Caso a posição do contato esteja no intervalo entre 1 e 100,
	 * incluindo-os, e exista contato cadastrado naquela posição da agenda, a tag é
	 * adicionada ao contato na posição indicada.
	 * 
	 * @param contatosStr String com as posições do(s) contato(s) na agenda.
	 * @param tag         String com a própria tag a ser adionado ao(s) contato(s).
	 * @param posicaoTag  Posição onde a tag deve
	 */
	public void aplicaTag(String contatosStr, String tag, int posicaoTag) {
		if (posicaoTag < 1 || posicaoTag > 5) {
			return;
		}
		String[] contatos = contatosStr.split(" ");
		for (int i = 0; i < contatos.length; i++) {
			int posicao = Integer.parseInt(contatos[i]);
			if (posicao >= 1 && posicao <= 100 && (this.contatos[posicao - 1] != null)) {
				this.contatos[posicao - 1].aplicaTag(tag, posicaoTag);
			}
		}
	}

	/**
	 * Remove 1 ou mais contatos da agenda a partir das posições dos contatos
	 * passadas como parâmetro. Só são permitidas posições que estejam no intervalo
	 * de 1 até 100, incluindo-os. Caso haja contato na posição especificada é
	 * verificado se ele está na lista de favoritos para removê-lo em caso posivo.
	 * Ao fim, o contato é removido da agenda. Os contatos são removidos
	 * normalmente, mas caso encontre uma posição inválida ou um contato que não
	 * existe, a função para e retorna false.
	 * 
	 * @param contatosStr String contendo as posições de 1 ou mais contatos a serem
	 *                    removidos.
	 * @return Retorna true caso todos os contatos passados como parâmetro sejam
	 *         removidos. Retorna false caso pelo menos um contato esteja inválido.
	 */
	public boolean removeContatos(String contatosStr) {
		String[] contatos = contatosStr.split(" ");
		for (int i = 0; i < contatos.length; i++) {
			int posicao = Integer.parseInt(contatos[i]);
			Contato contato = this.getContato(posicao);
			if (contato == null) {
				return false;
			} else {
				for (int j = 0; j < this.favoritos.length; j++) {
					if (contato.equals(this.favoritos[j])) {
						this.removeFavorito(j + 1);
						break;
					}
				}
				this.contatos[posicao - 1] = null;
			}
		}
		return true;
	}

	/**
	 * Altera o telefone de um contato da agenda. Caso a posição do contato
	 * informada esteja fora do intervalo entre 1 e 100, incluindo-os, ou se o
	 * contato na posição for null, retorna "POSIÇÃO INVÁLIDA". Caso o telefone
	 * passado seja null, lança um NullPointerException. Caso o telefone passado
	 * seja vazio lança um IllegalArgumentException. Caso tudo esteja certo, o
	 * telefone é enfim alterado.
	 * 
	 * @param posicao  int com a posição dp contato a ter o telefone alterado.
	 * @param telefone String com o novo telefone do contato.
	 * @return Retorna uma String que informa caso a posição passada seja inválida
	 *         ou se o telfone foi alterado.
	 */
	public String mudaTelefone(int posicao, String telefone) {
		Contato contato = this.getContato(posicao);
		if (contato == null) {
			return "POSIÇÃO INVÁLIDA";
		} else if (telefone == null) {
			throw new NullPointerException("TELEFONE INVÁLIDO");
		} else if (telefone.isBlank()) {
			throw new IllegalArgumentException("TELEFONE INVÁLIDO");
		}
		contato.setTelefone(telefone);
		return "TELEFONE ALTERADO PARA " + telefone;
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
	 * @param posicaoContato int contendo a posição do contatdo na agenda a ter a
	 *                       tag removida.
	 * @param posicaoTag     int com a posição da tag no contato a ser removida.
	 * @return Retorna uma String que informa se a posição passada foi inválida, se
	 *         não há tag na posição ou se a tag foi removida com sucesso.
	 */
	public String removeTag(int posicaoContato, int posicaoTag) {
		Contato contato = this.getContato(posicaoContato);
		if (contato == null || posicaoTag < 1 || posicaoTag > 5) {
			return "POSIÇÃO INVÁLIDA";
		} else if (contato.getTags()[posicaoTag - 1] == null) {
			return "NÃO HÁ TAG NA POSIÇÃO " + posicaoTag;
		}
		contato.removeTag(posicaoTag);
		return "TAG NA POSICAO " + posicaoTag + " REMOVIDA COM SUCESSO";
	}

	/**
	 * Remove um contato da lista de favoritos a partir da posição do contato na
	 * lista de favoritos. Caso a posição informada esteja fora do intervalo entre 1
	 * e 10, incluindo-os, retorna "POSIÇÃO INVÁLIDA". Caso não haja contato
	 * favoritado na posição indicada, retorna "NÃO HÁ CONTATO FAVORITADO NA POSIÇÃO
	 * {posicao}". Caso esteja tudo certo, o contato é enfim removido e é retornado
	 * "CONTATO DESFAVORITADO".
	 * 
	 * @param posicaoFavorito int que representa a posição do favorito a ser
	 *                        removido da lista de favoritos.
	 * @return Retorna uma String que informa favorito passado está em uma posição
	 *         inválida, se o contato foi desfavoritado com sucesso ou se o não
	 *         existe contato favoritado nessa posição.
	 */
	public String removeFavorito(int posicaoFavorito) {
		if (posicaoFavorito < 1 || posicaoFavorito > 10) {
			return "POSIÇÃO INVÁLIDA";
		} else if (this.favoritos[posicaoFavorito - 1] == null) {
			return "NÃO HÁ CONTATO FAVORITADO NA POSIÇÃO " + posicaoFavorito;
		}
		this.favoritos[posicaoFavorito - 1] = null;
		return "CONTATO DESFAVORITADO";
	}

	/**
	 * Consulta e lista todos os contatos da agenda que contém o nome especificado.
	 * Caso o nome passado como parâmetro seja nulo ou vazio, retorna "Nome
	 * Inválido". Caso não haja nenhum contato com o nome especificado, é retornado
	 * "Não há contatos com o nome {nome}".
	 * 
	 * @param nome Nome a ser consultado na agenda.
	 * @return Retorna lista de todos os contatos com o nome. Em caso de erro,
	 *         retona mensagens que explicam.
	 */
	public String consultaNome(String nome) {
		if (nome == null || nome.isBlank()) {
			return "Nome Inválido";
		}
		String contatos = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null && nome.equals(this.contatos[i].getNome())) {
				if (!contatos.equals("")) {
					contatos += "\n";
				}
				contatos += (i + 1) + " - " + this.contatos[i].toString();
			}
		}
		if (contatos.equals("")) {
			return "Não há contatos com o nome " + nome;
		}
		return contatos;
	}

	/**
	 * Consulta e lista todos os contatos da agenda que contém o sobrenome
	 * especificado. Caso o sobrenome passado como parâmetro seja nulo, retorna
	 * "Sobrenome Inválido". Caso não haja nenhum contato com o sobrenome
	 * especificado, é retornado "Não há contatos com o sobrenome {sobrenome}".
	 * 
	 * @param sobrenome Sobrenome a ser consultado na agenda.
	 * @return Retorna lista de todos os contatos com o sobrenome. Em caso de erro,
	 *         retona mensagens que explicam.
	 */
	public String consultaSobrenome(String sobrenome) {
		if (sobrenome == null) {
			return "Sobrenome Inválido";
		}
		String contatos = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null && sobrenome.equals(this.contatos[i].getSobrenome())) {
				if (!contatos.equals("")) {
					contatos += "\n";
				}
				contatos += (i + 1) + " - " + this.contatos[i].toString();
			}
		}
		if (contatos.equals("")) {
			return "Não há contatos com o sobrenome " + sobrenome;
		}
		return contatos;
	}

	/**
	 * Consulta e lista todos os contatos da agenda que contém a tag especificada.
	 * Caso a tag passada como parâmetro seja nula ou vazia, retorna "Tag Inválida".
	 * Caso não haja nenhum contato com a tag especificada, é retornado "Não há
	 * contatos com a tag {tag}".
	 * 
	 * @param tag Tag a ser consultada na agenda.
	 * @return Retorna lista de todos os contatos com a tag. Em caso de erro, retona
	 *         mensagens que explicam.
	 */
	public String consultaTag(String tag) {
		if (tag == null || tag.isBlank()) {
			return "Tag Inválida";
		}
		String contatos = "";
		for (int i = 0; i < this.contatos.length; i++) {
			if (this.contatos[i] != null) {
				for (int j = 0; j < this.contatos[i].getTags().length; j++) {
					if (tag.equals(this.contatos[i].getTags()[j])) {
						if (!contatos.equals("")) {
							contatos += "\n";
						}
						contatos += (i + 1) + " - " + this.contatos[i].toString();
					}
				}
			}
		}
		if (contatos.equals("")) {
			return "Não há contatos com a tag " + tag;
		}
		return contatos;
	}
}
