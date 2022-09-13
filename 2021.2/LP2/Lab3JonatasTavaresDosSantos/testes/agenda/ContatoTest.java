package agenda;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe JUnit test case para testar os métodos que compõem a classe
 * {@link Contato}.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 * @see Contato Classe Contato.
 */
class ContatoTest {

	/**
	 * Atributo que mantém um objeto do tipo Contato para ser usado nos casos de
	 * teste.
	 */
	private Contato contato;

	/**
	 * Método a ser executado antes de cada um dos casos de teste. Define um novo
	 * objeto do tipo Contato de nome "Matheus", sobrenone "Gaudencio" e telefone
	 * "(83) 99999-0000" ao atributo contato.
	 */
	@BeforeEach
	void preparaAgenda() {
		this.contato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
	}

	// Testes dos métodos get()

	/**
	 * Testa se o método getNome() retorna o nome do contato corretamente.
	 */
	@Test
	void testgetNome() {
		assertEquals("Matheus", this.contato.getNome());
	}

	/**
	 * Testa se o método getobrenome() retorna o nome do contato corretamente.
	 */
	@Test
	void testgetSobrenome() {
		assertEquals("Gaudencio", this.contato.getSobrenome());
	}

	/**
	 * Testa se o método getTags() retorna as tags do contato corretamente em um
	 * contato sem tags.
	 */
	@Test
	void testgetTagsSemTag() {
		String[] tags = new String[] { null, null, null, null, null };
		assertEquals(true, Arrays.equals(this.contato.getTags(), tags));
	}

	/**
	 * Testa se o método getTags() retorna as tags do contato corretamente em um
	 * contato com tags.
	 */
	@Test
	void testgetTagsComTags() {
		this.contato.aplicaTag("professor-ufcg", 1);
		String[] tags = new String[] { "professor-ufcg", null, null, null, null };
		assertEquals(true, Arrays.equals(this.contato.getTags(), tags));

	}

	// Testes do método getContato()

	/**
	 * Testa se um método que retorna todos os dados de um contato está fazendo isso
	 * corretamente.
	 */
	@Test
	void testExibeTodosDadosContato() {
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.contato.getContato());
	}

	// Testes do método setTelefone(String telefone)

	/**
	 * Testa se o método de alterar telefone está realmente alterando o telefone do
	 * contato.
	 */
	@Test
	void testSetTelefone() {
		this.contato.setTelefone("(84) 98888-1111");
		assertEquals("Matheus Gaudencio\n(84) 98888-1111", this.contato.getContato());
	}

	/**
	 * Testa o método de mudar telefone passando um telefone nulo. Espera receber
	 * uma exceção NullPointerException.
	 */
	@Test
	void testSetTelefoneNulo() {
		try {
			this.contato.setTelefone(null);
			fail("Era esperada uma exceção ao passar telefone nulo");
		} catch (NullPointerException npe) {

		}
	}

	/**
	 * Testa o método de mudar telefone passando um telefone vazio. Espera receber
	 * uma exceção IllegalArgumentException.
	 */
	@Test
	void testSetTelefoneVazio() {
		try {
			this.contato.setTelefone("");
			fail("Era esperada uma exceção ao passar telefone vazio");
		} catch (IllegalArgumentException iae) {

		}
	}

	// Testes do método aplicaTag(String tag, int posicaoTag)

	/**
	 * Testa o método aplica tag em uma posição vazia de um contato. Usa o método
	 * getContato() para verificar se a tag foi realmente adicionada.
	 */
	@Test
	void testAplicaTagPosicaoVazia() {
		this.contato.aplicaTag("professor-ufcg", 1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.contato.getContato());
	}

	/**
	 * Testa o método aplica tag em uma posição onde já tem uma tag em um contato
	 * esperando sobrescrever a tag anterior. Usa o método getContato() para
	 * verificar se a tag foi realmente sobrescrita.
	 */
	@Test
	void testAplicaTagPosicaoExistente() {
		this.contato.aplicaTag("professor", 1);
		this.contato.aplicaTag("professor-ufcg", 1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.contato.getContato());
	}

	/**
	 * Testa o método aplica tag adicionando na posição limite, ou seja, 5. Usa o
	 * método getContato() para verificar se a tag foi realmente adicionada.
	 */
	@Test
	void testAplicaTagPosicaoLimite() {
		this.contato.aplicaTag("professor-ufcg", 5);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.contato.getContato());
	}

	/**
	 * Testa o método aplica tag adicionando abaixo da posição limite (1), 0. Usa o
	 * método getContato() para verificar se a tag realmente não foi adicionada.
	 */
	@Test
	void testAplicaTagPosicaoAbaixoLimite() {
		this.contato.aplicaTag("professor-ufcg", 0);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.contato.getContato());
	}

	/**
	 * Testa o método aplica tag adicionando acima da posição limite (5), 6. Usa o
	 * método getContato() para verificar se a tag realmente não foi adicionada.
	 */
	@Test
	void testAplicaTagPosicaoAcimaLimite() {
		this.contato.aplicaTag("professor-ufcg", 6);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.contato.getContato());
	}

	// Testes do método removeTag(int posicaoTag)

	/**
	 * Testa o método de remover tag passando uma posição válida. Usa o método
	 * getContato() para verificar se a tag foi realmente removida.
	 */
	@Test
	void testRemoveTag() {
		this.contato.aplicaTag("professor-ufcg", 1);
		this.contato.removeTag(1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.contato.getContato());
	}

	/**
	 * Testa o método de remover tag passando uma posição onde não há tag. Usa o
	 * método getContato() para verificar se não houve alteração nas tags do
	 * contato.
	 */
	@Test
	void testRemoveTagAcimaPosicaoInexistente() {
		this.contato.aplicaTag("professor-ufcg", 1);
		this.contato.removeTag(2);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.contato.getContato());
	}

	/**
	 * Testa o método de remover tag em uma posição limite, ou seja, 5. Usa o método
	 * getContato() para verificar se a tag foi realmente removida.
	 */
	@Test
	void testRemoveTagPosicaoLimite() {
		this.contato.aplicaTag("professor-ufcg", 5);
		this.contato.removeTag(5);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.contato.getContato());
	}

	/**
	 * Testa o método de remover tag passando uma posição acima do limite (5), 6.
	 * Usa o método getContato() para verificar se não houve alteração nas tags do
	 * contato.
	 */
	@Test
	void testRemoveTagAcimaPosicaoLimite() {
		this.contato.aplicaTag("professor-ufcg", 5);
		this.contato.removeTag(6);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.contato.getContato());
	}

	/**
	 * Testa o método de remover tag passando uma posição abaixo do limite (1), 0.
	 * Usa o método getContato() para verificar se não houve alteração nas tags do
	 * contato.
	 */
	@Test
	void testRemoveTagAbaixoPosicaoLimite() {
		this.contato.aplicaTag("professor-ufcg", 1);
		this.contato.removeTag(0);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.contato.getContato());
	}

	// Testes do método toString()

	/**
	 * Verifica se o método toString() está retornando a representação textual do
	 * contato corretamente.
	 */
	@Test
	void testRepresentacaoTextualContato() {
		assertEquals("Matheus Gaudencio", this.contato.toString());
	}

	// Testes do método hashCode()

	/**
	 * Testa o método hashCode() quando são passados objetos iguais esperando obter
	 * hash codes iguais.
	 */
	@Test
	void testHashCodeObjetosIguais() {
		Contato outroContato = new Contato("Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(this.contato.hashCode(), outroContato.hashCode());
	}

	/**
	 * Testa o método hashCode() quando são passados objetos diferentes, esperando
	 * obter hash code diferentes.
	 */
	@Test
	void testHashCodeObjetosDiferentes() {
		Contato outroContato = new Contato("Livia", "Sampaio", "(84) 91234-5678");
		assertNotEquals(this.contato.hashCode(), outroContato.hashCode());
	}

	/**
	 * Testa o método hashCode() quando são passados nomes diferentes, esperando
	 * obter hash codes diferentes.
	 */
	@Test
	void testHashCodeObjetosNomesDiferenrtes() {
		Contato outroContato = new Contato("Reinaldo", "Gaudencio", "(83) 99999-0000");
		assertNotEquals(this.contato.hashCode(), outroContato.hashCode());
	}

	/**
	 * Testa o método hashCode() quando são passados sobrenomes diferentes,
	 * esperando obter hash codes diferentes.
	 */
	@Test
	void testHashCodeObjetosSobrenomesDiferenrtes() {
		Contato outroContato = new Contato("Matheus", "", "(83) 99999-0000");
		assertNotEquals(this.contato.hashCode(), outroContato.hashCode());
	}

	/**
	 * Testa o método hashCode() quando são passados telefones diferentes, esperando
	 * obter hash codes iguais.
	 */
	@Test
	void testHashCodeObjetoTelefoneDiferente() {
		Contato outroContato = new Contato("Matheus", "Gaudencio", "(84) 91234-5678");
		assertEquals(this.contato.hashCode(), outroContato.hashCode());
	}

	// Testes do método equals(Object obj)

	/**
	 * Testa o método equals() quando o próprio contato é passado como parâmetro,
	 * esperando receber true.
	 */
	@Test
	void testEqualsProprioContato() {
		assertEquals(true, this.contato.equals(this.contato));
	}

	/**
	 * Testa o método equals() quando é passado um objeto null como parâmetro,
	 * esperando receber false.
	 */
	@Test
	void testEqualsNull() {
		assertEquals(false, this.contato.equals(null));
	}

	/**
	 * Testa o método equals() quando é passado um objeto de uma classe diferente
	 * como parâmetro, esperando receber false.
	 */
	@Test
	void testEqualsClasseDiferente() {
		assertEquals(false, this.contato.equals(new Object()));
	}

	/**
	 * Testa o método equals() quando é passado um contato com nome e sobrenome
	 * iguais como parâmetro, esperando receber true.
	 */
	@Test
	void testEqualsNomesSobrenomesIguais() {
		Contato outroContato = new Contato("Matheus", "Gaudencio", "(84) 91234-5678");
		assertEquals(true, this.contato.equals(outroContato));
	}

	/**
	 * Testa o método equals() quando é passado um contato com nomes diferentes e
	 * sobrenomes iguais como parâmetro, esperando receber false.
	 */
	@Test
	void testEqualsNomesDiferentes() {
		Contato outroContato = new Contato("Livia", "Gaudencio", "(84) 91234-5678");
		assertEquals(false, this.contato.equals(outroContato));
	}

	/**
	 * Testa o método equals() quando é passado um contato com nomes iguais e
	 * sobrenomes diferentes como parâmetro, esperando receber false.
	 */
	@Test
	void testEqualsSobrenomesDiferentes() {
		Contato outroContato = new Contato("Matheus", "Sampaio", "(84) 91234-5678");
		assertEquals(false, this.contato.equals(outroContato));
	}
}
