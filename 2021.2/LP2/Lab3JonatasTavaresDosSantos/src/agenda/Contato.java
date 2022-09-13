package agenda;

import java.util.Objects;

/**
 * Representação de um Contato. Cada contato possui um nome, sobrenome, telefone
 * e pode ter até 5 tags.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Contato {

	/**
	 * Atibuto do tipo int que define o limite máximo de tags que um contato pode
	 * ter.
	 */
	private static final int TAMANHO_TAGS = 5;

	/**
	 * Atributo do tipo String que armazena o nome do contato. Não pode ser vazio ou
	 * nulo.
	 */
	private String nome;
	/**
	 * Atributo do tipo String que armazena o sobrenome do contato. Pode ser vazio.
	 */
	private String sobrenome;
	/**
	 * Atributo do tipo String que armazena o telefone do contato. Não pode ser
	 * vazio ou nulo.
	 */
	private String telefone;
	/**
	 * Atributo do tipo array de objetos do tipo String que armazena as tags do
	 * contato. Cada contato pode possuir de nenhuma até 5 tags. O contato pode ter
	 * tags iguais.
	 */
	private String[] tags;

	/**
	 * Constrói um contato a partir do nome, sobrenone e telefone. Nome e telefone
	 * não podem assumir valores vazios. Inicializa o array de tags com o limite de
	 * 5 tags definido no atributo "TAMANHO_TAGS".
	 * 
	 * @param nome      String contendo o nome do contato parar definir o atributo
	 *                  nome.
	 * @param sobrenome String contendo o sobrenome do contato parar definir o
	 *                  atributo sobrenome.
	 * @param telefone  String contendo o telefone do contato parar definir o
	 *                  atributo telefone.
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tags = new String[TAMANHO_TAGS];
	}

	/**
	 * Acessa e retorna o atributo que armazena o nome do contato.
	 * 
	 * @return O nome do contato.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Acessa e retorna o atributo que armazena sobrenome do contato.
	 * 
	 * @return O sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}

	/**
	 * Acessa e retorna o atributo que armazena o array de tags do contato.
	 * 
	 * @return As tags do contato.
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * Altera o valor do atributo telefone do contato a partir do telefone passado
	 * como parâmetro. Lança uma NullPointerException caso o telefone seja nulo.
	 * Lança um IllegalArgumentException caso o telefone seja vazio.
	 * 
	 * @param telefone String com o novo telefone a ser atribuído ao atributo
	 *                 telefone.
	 */
	public void setTelefone(String telefone) {
		if (telefone == null) {
			throw new NullPointerException("TELEFONE INVÁLIDO");
		} else if (telefone.isBlank()) {
			throw new IllegalArgumentException("TELEFONE INVÁLIDO");
		}
		this.telefone = telefone;
	}

	/**
	 * Exibe um contato com todos os dados. Exibe nome e sobrenome na primeira
	 * linha, exibe telefone na linha seguinte e, na última linha, exibe todas as
	 * tags do contato separadas por um espaço entre cada uma.
	 * 
	 * @return Retorna uma representação textual completa dos dados do contato.
	 */
	public String getContato() {
		String tags = "";
		for (int i = 0; i < this.tags.length; i++) {
			if (this.tags[i] != null) {
				tags += this.tags[i] + " ";
			}
		}
		if (tags == "") {
			return this + "\n" + this.telefone;
		}
		return this + "\n" + this.telefone + "\n" + tags.trim();
	}

	/**
	 * Aplica uma tag em uma posição específica do contato. Caso a posição passada
	 * não esteja no intervalo de 1 até 5, incluindo-os, não é possível adicionar a
	 * tag. Caso já haja uma tag na posição especificada, ela é sobrescrita. Podem
	 * haver tags iguais.
	 * 
	 * @param tag        String que recebe a tag.
	 * @param posicaoTag int que representa a posição onde a tag deve ser
	 *                   adicionada.
	 */
	public void aplicaTag(String tag, int posicaoTag) {
		if (posicaoTag < 1 || posicaoTag > 5) {
			return;
		}
		this.tags[posicaoTag - 1] = tag;
	}

	/**
	 * Remove a tag a partir da posição. Caso a posição passada como parâmetro não
	 * esteja no intervalo de 1 até 5, incluindo-os, não é possível remover a tag. A
	 * tag na posição passada recebe o valor null, excluindo-a.
	 * 
	 * @param posicaoTag int que carega a posição da tag a ser excluída.
	 */
	public void removeTag(int posicaoTag) {
		if (posicaoTag < 1 || posicaoTag > 5) {
			return;
		}
		this.tags[posicaoTag - 1] = null;
	}

	/**
	 * Retorna a representação textual do objeto Contato. Contato é represetado
	 * textualemente por seu nome e sobrenome separados por um espaço em branco.
	 * 
	 * @return Uma representação em String do objeto Contato.
	 */
	@Override
	public String toString() {
		return this.nome + " " + this.sobrenome;
	}

	/**
	 * Retorna o valor do hash code do objeto Contato. O valor do hash code é
	 * montado a partir dos atributos nome e sobrenome do objeto Contato.
	 * 
	 * @return Um int com o valor do hash code para o objeto Contato.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}

	/**
	 * Indica se um outro objeto é igual a este. Caso o objeto passado como
	 * parâmetro seja o próprio objeto, então eles são iguais e é retornado o
	 * boolean true. Caso o objeto como parâmetro seja null, então eles são
	 * diferentes e o é retornado o boolean false. Caso a classe do objeto passado
	 * como parâmetro não seja do tipo Contato, então eles são diferentes e é
	 * retornado o boolean false. Caso contrário, são considerados iguais objetos da
	 * classe Contato que possuam o nome e sobrenome iguais.
	 * 
	 * @param obj Object que representa o objeto que se quer comparar.
	 * @return Retorna o boolean true, caso sejam contatos iguais. Retorna false
	 *         caso não seja.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(this.nome, other.nome) && Objects.equals(this.sobrenome, other.sobrenome);
	}
}
