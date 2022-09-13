package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe JUnit test case para testar os métodos que compõem a classe
 * {@link Agenda}.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 * @see Agenda Classe Agenda.
 */
class AgendaTest {

	/**
	 * Atributo que mantém um objeto do tipo Agenda para ser usado nos casos de
	 * teste.
	 */
	private Agenda agenda;

	/**
	 * Método a ser executado antes de cada um dos casos de teste. Define um novo
	 * objeto do tipo Agenda ao atributo Agenda.
	 */
	@BeforeEach
	void preparaAgenda() {
		this.agenda = new Agenda();
	}

	// Testes do método listaContatos()

	/**
	 * Testa o método de listar contatos quando não há nenhum contato adicionado na
	 * agenda. Espera-se retornar uma String vazia.
	 */
	@Test
	void testListaContatosVazio() {
		assertEquals("", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de listar contatos quando há somente 1 contato adicionado na
	 * agenda. Espera-se retornar a lista com o contato cadastrado.
	 */
	@Test
	void testListaContato() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de listar contatos quando há mais de 1 contato adicionado na
	 * agenda na primeira posição e na última posição. Espera-se retornar a lista
	 * com os contatos cadastrados.
	 */
	@Test
	void testListaContatos() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(100, "Livia", "Sampaio", "(83) 99873-7383");
		assertEquals("1 - Matheus Gaudencio\n100 - Livia Sampaio", this.agenda.listaContatos());
	}

	// Testes do método cadastraContato(int posicao, String nome, String sobrenome,
	// String telefone)

	/**
	 * Testa o método de cadastrar contato em uma posição vazia esperando retornar
	 * "CADASTRO REALIZADO". Usa o método listaContatos() para verificar se o
	 * contato realmente foi cadastrado na agenda.
	 */
	@Test
	void testNovoContatoPosicaoVazia() {
		assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de cadastrar contato em uma posição que já tem um contato
	 * esperando sobrescrever o contato anterior e retornar "CADASTRO REALIZADO".
	 * Usa o método listaContatos() para verificar se o contato realmente foi
	 * sobrescrito na agenda.
	 */
	@Test
	void testNovoContatoPosicaoExistente() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111"));
		assertEquals("1 - Pedro Silva", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de cadastrar contato passando um contato já cadastrado em uma
	 * outra posição esperando retornar "CONTATO JA CADASTRADO". Usa o método
	 * listaContatos() para verificar se o contato não foi cadastrado novamente.
	 */
	@Test
	void testNovoContatoJaCadastradoPosicaoDiferente() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CONTATO JA CADASTRADO",
				this.agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000"));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de cadastrar contato passando um contato já cadastrado na
	 * mesma posição esperando retornar "CONTATO JA CADASTRADO". Usa o método
	 * listaContatos() para verificar se o contato não foi cadastrado novamente.
	 */
	@Test
	void testNovoContatoJaCadastradoMesmaPosicao() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CONTATO JA CADASTRADO",
				this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de cadastrar contato na posição limite, ou seja 100, esperando
	 * retornar "CADASTRO REALIZADO". Usa o método listaContatos() para verificar se
	 * o contato foi devidamente cadastrado.
	 */
	@Test
	void testNovoContatoPosicaoLimite() {
		assertEquals("CADASTRO REALIZADO", this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000"));
		assertEquals("100 - Matheus Gaudencio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de cadastrar contato em uma posição acima do limite (100),
	 * 101, esperando retornar "POSIÇÃO INVÁLIDA". Usa o método listaContatos() para
	 * verificar se o contato não foi cadastrado.
	 */
	@Test
	void testNovoContatoPosicaoAcimaLimite() {
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000"));
		assertEquals("", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de cadastrar contato em uma posição abaixo do limite (1), 0,
	 * esperando retornar "POSIÇÃO INVÁLIDA". Usa o método listaContatos() para
	 * verificar se o contato não foi cadastrado.
	 */
	@Test
	void testNovoContatoPosicaoAbaixoLimite() {
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000"));
		assertEquals("", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de cadastrar contato passando um telefone vazio esperando uma
	 * exceção IllegalArgumentException.
	 */
	@Test
	void testNovoContatoTelefoneVazio() {
		try {
			this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "");
			fail("Era esperada uma exceção ao passar telefone vazio");
		} catch (IllegalArgumentException iae) {

		}
	}

	/**
	 * Testa o método de cadastrar contato passando um telefone nulo esperando uma
	 * exceção NullPointerException.
	 */
	@Test
	void testNovoContatoTelefoneNulo() {
		try {
			this.agenda.cadastraContato(1, "Matheus", "Gaudencio", null);
			fail("Era esperada uma exceção ao passar telefone nulo");
		} catch (NullPointerException npe) {

		}
	}

	/**
	 * Testa o método de cadastrar contato passando um nome vazio esperando uma
	 * exceção IllegalArgumentException.
	 */
	@Test
	void testNovoContatoNomeVazio() {
		try {
			this.agenda.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000");
			fail("Era esperada uma exceção ao passar nome vazio");
		} catch (IllegalArgumentException iae) {

		}
	}

	/**
	 * Testa o método de cadastrar contato passando um nome nulo esperando uma
	 * exceção NullPointerException.
	 */
	@Test
	void testNovoContatoNomeNulo() {
		try {
			this.agenda.cadastraContato(1, null, "Gaudencio", "(83) 99999-0000");
			fail("Era esperada uma exceção ao passar nome nulo");
		} catch (NullPointerException npe) {

		}
	}

	/**
	 * Testa o método de cadastrar contato passando um sobrenome nulo esperando uma
	 * exceção NullPointerException.
	 */
	@Test
	void testNovoContatoSobrenomeNulo() {
		try {
			this.agenda.cadastraContato(1, "Matheus", null, "(83) 99999-0000");
			fail("Era esperada uma exceção ao passar nome nulo");
		} catch (NullPointerException npe) {

		}
	}

	/**
	 * Testa o método de cadastrar contato passando um sobrenome vazio esperando que
	 * seja cadastrado. Usa o método listaContatos() para varificar se o contato
	 * realmente foi cadastrado.
	 */
	@Test
	void testNovoContatoSobrenomeVazio() {
		this.agenda.cadastraContato(1, "Matheus", "", "(83) 99999-0000");
		assertEquals("1 - Matheus ", this.agenda.listaContatos());
	}

	// Testes do método exibeContato(int posicao)

	/**
	 * Testa se o método de exibir todos os dados do contato está retornando os
	 * dados corretamente.
	 */
	@Test
	void testExibeContatoCadastradoTodosDados() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de exibir contato de um contato inexistente. Espera-se obter
	 * "POSIÇÃO INVÁLIDA!".
	 */
	@Test
	void testExibeContatoPosicaoSemContato() {
		assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.exibeContato(100));
	}

	/**
	 * Testa o método de exibir contato de um contato na posição limite, ou seja,
	 * 100. Espera-se obter o contato corretamente.
	 */
	@Test
	void testExibeContatoPosicaoLimite() {
		this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(100));
	}

	/**
	 * Testa o método de exibir contato de um contato em uma posição abaixo do
	 * limite (1), 0. Espera-se obter "POSIÇÃO INVÁLIDA!".
	 */
	@Test
	void testExibeContatoPosicaoInvalidaInferior() {
		assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.exibeContato(0));
	}

	/**
	 * Testa o método de exibir contato de um contato em uma posição acima do limite
	 * (100), 101. Espera-se obter "POSIÇÃO INVÁLIDA!".
	 */
	@Test
	void testExibeContatoPosicaoInvalidaSuperior() {
		assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.exibeContato(101));
	}

	/**
	 * Testa o método de exibir contato de um contato que foi favoritado. Espera-se
	 * obter a representação do contato precedida de um emoji de coração "❤️".
	 */
	@Test
	void testExibeContatoFavoritado() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(1, 1);
		assertEquals("❤️ Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de exibir contato de um contato que já foi favoritado mas não
	 * é mais. Espera-se obter a representação do contato sem ser precedida por um
	 * emoji de coração "❤️".
	 */
	@Test
	void testExibeContatoExFavoritado() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(1, 1);
		this.agenda.removeFavorito(1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa se método de exibir contato de um contato que possui uma tag retorna a
	 * exibição do contato corretamente com a tag.
	 */
	@Test
	void testExibeContatoComTag() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(1));
	}

	/**
	 * Testa se método de exibir contato de um contato que possuia uma tag e não
	 * possui mais retorna a exibição do contato corretamente sem a tag.
	 */
	@Test
	void testExibeContatoExTag() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		this.agenda.removeTag(1, 1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa se método de exibir contato de um contato que possui mais de uma tag
	 * retorna a exibição do contato corretamente com as tags.
	 */
	@Test
	void testExibeContatoComTags() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor", 1);
		this.agenda.aplicaTag("1", "ufcg", 5);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor ufcg", this.agenda.exibeContato(1));
	}

	/**
	 * Testa se método de exibir contato de um contato que é favoritado e possui uma
	 * tag retorna a exibição do contato favoritado e com tag.
	 */
	@Test
	void testExibeContatoFavoritadoComTag() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(1, 1);
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		assertEquals("❤️ Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(1));
	}

	// Testes do método exibeContatoResumido(int posicao)

	/**
	 * Testa se o método de exibir contato resumido está retornando os dados
	 * corretamente, sem o telefone.
	 */
	@Test
	void testExibeContatoSemTelefone() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio", this.agenda.exibeContatoResumido(1));
	}

	/**
	 * Testa se o método de exibir contato resumido, na posição limite, ou seja,
	 * 100, está retornando os dados corretamente, sem o telefone.
	 */
	@Test
	void testExibeContatoSemTelefonePosicaoLimite() {
		this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio", this.agenda.exibeContatoResumido(100));
	}

	/**
	 * Testa o método de exibir contato resumido, acima da posição limite (100),
	 * 101. Espera-se obter "POSIÇÃO INVÁLIDA!".
	 */
	@Test
	void testExibeContatoSemTelefoneAcimaPosicaoLimite() {
		assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.exibeContatoResumido(101));
	}

	/**
	 * Testa o método de exibir contato resumido, abaixo da posição limite (1).
	 * Espera-se obter "POSIÇÃO INVÁLIDA!".
	 */
	@Test
	void testExibeContatoSemTelefoneAbaixoPosicaoLimite() {
		assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.exibeContatoResumido(0));
	}

	/**
	 * Testa o método de exibir contato resumido de um contato inexistente.
	 * Espera-se obter "POSIÇÃO INVÁLIDA!".
	 */
	@Test
	void testExibeContatoSemTelefoneContatoInexistente() {
		assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.exibeContatoResumido(1));
	}

	// Testes do método listaFavoritos()

	/**
	 * Testa o método de listar favoritos quando há um único contato favoritado.
	 * Espera-se retornar uma listagem do contato favoritado.
	 */
	@Test
	void testListaFavorito() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(1, 1);
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de listar favoritos quando há mais de um contato favoritado,
	 * na posição inicial e final. Espera-se retornar uma listagem de todos os
	 * contatos favoritados.
	 */
	@Test
	void testListaFavoritos() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(100, "Livia", "Sampaio", "(83) 99873-7383");
		this.agenda.adicionaFavorito(1, 1);
		this.agenda.adicionaFavorito(100, 10);
		assertEquals("1 - Matheus Gaudencio\n10 - Livia Sampaio", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de listar favoritos quando não há nenhum contato favoritado.
	 * Espera-se retornar uma String vazia.
	 */
	@Test
	void testListaFavoritosVazio() {
		assertEquals("", this.agenda.listaFavoritos());
	}

	// Testes do método adicionaFavoritos(int contatoAdd, int posicao)

	/**
	 * Testa o método de adicionar contato a lista de favoritos em uma posição vazia
	 * esperando retornar "CONTATO FAVORITADO NA POSIÇÃO 1!". Usa o método
	 * listaFavoritos() para verificar se o contato realmente foi adicionado na
	 * lista de favoritos.
	 */
	@Test
	void testAdicionaFavoritosPocicaoVazia() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", this.agenda.adicionaFavorito(1, 1));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de adicionar contato a lista de favoritos em uma posição que
	 * já possi contato favoritado esperando sobrescrever esse contato esperando
	 * retornar "CONTATO FAVORITADO NA POSIÇÃO 1!". Usa o método listaFavoritos()
	 * para verificar se o contato realmente foi sobrescrito na lista de favoritos.
	 */
	@Test
	void testAdicionaFavoritosPosicaoExistente() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(100, "Pedro", "Silva", "(84) 98888-1111");
		this.agenda.adicionaFavorito(1, 1);
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 1!", this.agenda.adicionaFavorito(100, 1));
		assertEquals("1 - Pedro Silva", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de adicionar contato a lista de favoritos de um contato que já
	 * está cadastrado nessa posição, nessa mesma posição esperando retornar
	 * "CONTATO JÁ FAVORITADO NA POSIÇÃO 1!". Usa o método listaFavoritos() para
	 * verificar se o contato realmente não foi cadastrado novamente.
	 */
	@Test
	void testAdicionaFavoritosJaCadastradoMesmaPosicao() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(1, 1);
		assertEquals("CONTATO JÁ FAVORITADO NA POSIÇÃO 1!", this.agenda.adicionaFavorito(1, 1));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de adicionar contato a lista de favoritos de um contato que já
	 * está cadastrado, em uma posição diferente esperando retornar "CONTATO JÁ
	 * FAVORITADO NA POSIÇÃO 1!". Usa o método listaFavoritos() para verificar se o
	 * contato realmente não foi cadastrado novamente.
	 */
	@Test
	void testAdicionaFavoritosJaCadastradoPosicaoDiferente() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(1, 1);
		assertEquals("CONTATO JÁ FAVORITADO NA POSIÇÃO 1!", this.agenda.adicionaFavorito(1, 10));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de adicionar contato a lista de favoritos em uma posição sem
	 * contato esperando retornar "null". Usa o método listaFavoritos() para
	 * verificar se realmente não existem contatos favoritados.
	 */
	@Test
	void testAdicionaFavoritosPosicaoSemContato() {
		assertEquals(null, this.agenda.adicionaFavorito(1, 1));
		assertEquals("", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de adicionar contato a lista de favoritos em uma posição
	 * limite, ou seja, 10, esperando retornar "CONTATO FAVORITADO NA POSIÇÃO 10!".
	 * Usa o método listaFavoritos() para verificar se o contato foi realmente
	 * favoritado.
	 */
	@Test
	void testAdicionaFavoritosPosicaoLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("CONTATO FAVORITADO NA POSIÇÃO 10!", this.agenda.adicionaFavorito(1, 10));
		assertEquals("10 - Matheus Gaudencio", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de adicionar contato a lista de favoritos em uma posição acima
	 * do limite (10), 11, esperando retornar "null". Usa o método listaFavoritos()
	 * para verificar se o contato realmente não foi favoritado.
	 */
	@Test
	void testAdicionaFavoritosPosicaoAcimaLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(null, this.agenda.adicionaFavorito(1, 11));
		assertEquals("", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de adicionar contato a lista de favoritos em uma posição
	 * abaixo do limite (1), 0, esperando retornar "null". Usa o método
	 * listaFavoritos() para verificar se o contato realmente não foi favoritado.
	 */
	@Test
	void testAdicionaFavoritosAbaixoLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(null, this.agenda.adicionaFavorito(1, 0));
		assertEquals("", this.agenda.listaFavoritos());
	}

	// Testes do método aplicaTag(String contatosStr, String tag, int posicaoTag)

	/**
	 * Testa o método de aplicar tag em uma posição vazia. Usa o método
	 * exibeContato(int posicao) para verificar se a tag realmente foi adicionada ao
	 * contato.
	 */
	@Test
	void testAplicaTagPosicaoVazia() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de aplicar tag em uma posição existente espeando sobrescrever
	 * a tag. Usa o método exibeContato(int posicao) para verificar se a tag
	 * realmente foi sobrescrita no contato.
	 */
	@Test
	void testAplicaTagPosicaoExistente() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor", 1);
		this.agenda.aplicaTag("1", "ufcg", 1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nufcg", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de aplicar tag em mais de um contato ao mesmo tempo. Usa o
	 * método exibeContato(int posicao) para verificar se as tags realmente foram
	 * aplicadas nos contatos.
	 */
	@Test
	void testAplicaTags() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		this.agenda.aplicaTag("1 2", "professor-ufcg", 1);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(1));
		assertEquals("Livia Sampaio\n(83) 99873-7383\nprofessor-ufcg", this.agenda.exibeContato(2));
	}

	/**
	 * Testa o método de aplicar tag em uma contato inexistente. Usa o método
	 * exibeContato(int posicao)esperando retornar "POSIÇÃO INVÁLIDA!".
	 */
	@Test
	void testAplicaTagPosicaoSemContato() {
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		assertEquals("POSIÇÃO INVÁLIDA!", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de aplicar tag na posição limite, ou seja, 5. Usa o método
	 * exibeContato(int posicao) para verificar se a tag realmente foi aplicada.
	 */
	@Test
	void testAplicaTagPosicaoLimite() {
		this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("100", "professor-ufcg", 5);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(100));
	}

	/**
	 * Testa o método de aplicar tag em uma posição acima do limite (5), 6. Usa o
	 * método exibeContato(int posicao) para verificar se a tag realmente não foi
	 * aplicada.
	 */
	@Test
	void testAplicaTagPosicaoAcimaLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 6);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de aplicar tag em uma posição abaixo do limite (1), 0. Usa o
	 * método exibeContato(int posicao) para verificar se a tag realmente não foi
	 * aplicada.
	 */
	@Test
	void testAplicaTagPosicaoAbaixoLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 0);
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de aplicar tag em um contato abaixo do limite (1), 0. Usa o
	 * método consultaTag(string tag) para verificar se a tag realmente não foi
	 * aplicada esperando obter "Não há contatos com a tag".
	 */
	@Test
	void testAplicaTagContatoAbaixoLimite() {
		this.agenda.aplicaTag("0", "professor-ufcg", 1);
		assertEquals("Não há contatos com a tag professor-ufcg", this.agenda.consultaTag("professor-ufcg"));
	}

	/**
	 * Testa o método de aplicar tag em um contato acima do limite (100), 101. Usa o
	 * método consultaTag(string tag) para verificar se a tag realmente não foi
	 * aplicada esperando obter "Não há contatos com a tag".
	 */
	@Test
	void testAplicaTagContatoAcimaLimite() {
		this.agenda.aplicaTag("101", "professor-ufcg", 1);
		assertEquals("Não há contatos com a tag professor-ufcg", this.agenda.consultaTag("professor-ufcg"));
	}

	// Testes do método removeContatos(String contatosStr)

	/**
	 * Testa o método de remover contatos para remover apenas 1 contato esperando
	 * retornar true. Usa o método listaContatos() para verificar se o contato foi
	 * realmente removido.
	 */
	@Test
	void testRemoveContato() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		assertEquals(true, this.agenda.removeContatos("1"));
		assertEquals("2 - Livia Sampaio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover contatos para remover mais de 1 contato esperando
	 * retornar true. Usa o método listaContatos() para verificar se os contatos
	 * foram realmente removidos.
	 */
	@Test
	void testRemoveContatos() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		assertEquals(true, this.agenda.removeContatos("1 2"));
		assertEquals("", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover contatos para renover um contato inexistente
	 * esperando retornar false. Usa o método listaContatos() para verificar se não
	 * houve alteração na lista de contatos.
	 */
	@Test
	void testRemoveContatoInexistente() {
		assertEquals(false, this.agenda.removeContatos("1"));
		assertEquals("", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover contatos para renover um contato inexistente
	 * esperando retornar false. Usa o método listaContatos() para verificar se
	 * foram removidos apenas os contatos até a aparição do contato inexistente.
	 */
	@Test
	void testRemoveContatosComUmaPosicaoInexistente() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(3, "Livia", "Sampaio", "(83) 99873-7383");
		assertEquals(false, this.agenda.removeContatos("1 2 3"));
		assertEquals("3 - Livia Sampaio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover contatos para renover um contato inválido esperando
	 * retornar false. Usa o método listaContatos() para verificar se foram
	 * removidos apenas os contatos até a aparição do contato inválido.
	 */
	@Test
	void testRemoveContatosComUmaPosicaoInvalida() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(3, "Livia", "Sampaio", "(83) 99873-7383");
		assertEquals(false, this.agenda.removeContatos("1 0 3"));
		assertEquals("3 - Livia Sampaio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover um contato favoritado esperando retornar true. Usa
	 * o método listaContatos() e o método listaFavoritos() para verificar se o
	 * contato foi realmente removido.
	 */
	@Test
	void testRemoveContatoFavoritado() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(1, 1);
		assertEquals(true, this.agenda.removeContatos("1"));
		assertEquals("", this.agenda.listaFavoritos());
		assertEquals("", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover um contato na posição limite, ou seja, 100,
	 * esperando retornar true. Usa o método listaContatos() para verificar se o
	 * contato foi realmente removido.
	 */
	@Test
	void testRemoveContatoPosicaoLimite() {
		this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(true, this.agenda.removeContatos("100"));
		assertEquals("", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover um contato em uma posição acima do limite (100),
	 * 101, esperando receber false. Usa o método listaContatos() para verificar se
	 * não houve contato removido.
	 */
	@Test
	void testRemoveContatoPosicaoAcimaLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(false, this.agenda.removeContatos("101"));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaContatos());
	}

	/**
	 * Testa o método de remover um contato em uma posição abaixo do limite (1), 0,
	 * esperando remover false. Usa o método listaContatos() para verificar se não
	 * houve contato removido.
	 */
	@Test
	void testRemoveContatoAbaixoPosicaoAcimaLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals(false, this.agenda.removeContatos("0"));
		assertEquals("1 - Matheus Gaudencio", this.agenda.listaContatos());
	}

	// Testes do método mudaTelefone(int posicao, String telefone)

	/**
	 * Testa o método de mudar telefone passando um telefone válido esperando
	 * receber "TELEFONE ALTERADO". Usa o método exibeContato(int posicao) para
	 * verificar se o telefone foi realmente alterado.
	 */
	@Test
	void testMudaTelefoneValido() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("TELEFONE ALTERADO PARA (83) 99873-7383", this.agenda.mudaTelefone(1, "(83) 99873-7383"));
		assertEquals("Matheus Gaudencio\n(83) 99873-7383", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de mudar telefone passando um contato na posição limite, ou
	 * seja, 100, esperando receber "TELEFONE ALTERADO". Usa o método
	 * exibeContato(int posicao) para verificar se o telefone foi realmente
	 * alterado.
	 */
	@Test
	void testMudaTelefonePosicaoLimite() {
		this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("TELEFONE ALTERADO PARA (83) 99873-7383", this.agenda.mudaTelefone(100, "(83) 99873-7383"));
		assertEquals("Matheus Gaudencio\n(83) 99873-7383", this.agenda.exibeContato(100));
	}

	/**
	 * Testa o método de mudar telefone passando um contato acima da posição limite
	 * (100), 101, esperando receber "POSIÇÃO INVÁLIDA". Usa o método
	 * exibeContato(int posicao) para verificar se o telefone não foi alterado.
	 */
	@Test
	void testMudaTelefoneAcimaPosicaoLimite() {
		this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.mudaTelefone(101, "(83) 99873-7383"));
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(100));
	}

	/**
	 * Testa o método de mudar telefone passando um contato abaixo da posição limite
	 * (1), 0, esperando receber "POSIÇÃO INVÁLIDA". Usa o método exibeContato(int
	 * posicao) para verificar se o telefone não foi alterado.
	 */
	@Test
	void testMudaTelefoneAbaixoPosicaoLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.mudaTelefone(0, "(83) 99873-7383"));
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de mudar telefone passando um telefone nulo esperando uma
	 * exceção NullPointerException.
	 */
	@Test
	void testMudaTelefoneNulo() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		try {
			this.agenda.mudaTelefone(1, null);
		} catch (NullPointerException npe) {

		}
	}

	/**
	 * Testa o método de mudar telefone passando um telefone vazio esperando uma
	 * exceção IllegalArgumentException.
	 */
	@Test
	void testMudaTelefoneVazio() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		try {
			this.agenda.mudaTelefone(1, "");
		} catch (IllegalArgumentException iae) {

		}
	}

	// Testes do método removeTag(int posicaoContato, int posicaoTag)

	/**
	 * Testa o método de remover tag esperando obter "TAG NA POSICAO 1 REMOVIDA COM
	 * SUCESSO". Usa o método exibeContato(int posicao) para verificar se a tag foi
	 * realmente removida.
	 */
	@Test
	void testRemoveTag() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		assertEquals("TAG NA POSICAO 1 REMOVIDA COM SUCESSO", this.agenda.removeTag(1, 1));
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de remover tag para remover tag na posição limite, ou seja, 5,
	 * esperando obter "TAG NA POSICAO REMOVIDA COM SUCESSO". Usa o método
	 * exibeContato(int posicao) para verificar se a tag foi realmente removida.
	 */
	@Test
	void testRemoveTagPosicaoLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 5);
		assertEquals("TAG NA POSICAO 5 REMOVIDA COM SUCESSO", this.agenda.removeTag(1, 5));
		assertEquals("Matheus Gaudencio\n(83) 99999-0000", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de remover tag para remover tag na posição abaixo do limite
	 * (1), 0, esperando obter "POSIÇÃO INVÁLIDA". Usa o método exibeContato(int
	 * posicao) para verificar se a tag não foi removida.
	 */
	@Test
	void testRemoveTagAbaixoPosicaoLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.removeTag(1, 0));
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de remover tag para remover tag na posição acima do limite
	 * (5), 6, esperando obter "POSIÇÃO INVÁLIDA". Usa o método exibeContato(int
	 * posicao) para verificar se a tag não foi removida.
	 */
	@Test
	void testRemoveTagAcimaPosicaoLimite() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 5);
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.removeTag(1, 6));
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(1));
	}

	/**
	 * Testa o método de remover tag para remover tag de um contato inexistente,
	 * esperando obter "POSIÇÃO INVÁLIDA".
	 */
	@Test
	void testRemoveTagContatoInexistente() {
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.removeTag(1, 1));
	}

	/**
	 * Testa o método de remover tag para remover tag na posição onde não existe tag
	 * esperando obter "NÃO HÁ TAG NA POSIÇÃO". Usa o método exibeContato(int
	 * posicao) para verificar se a tag não foi removida.
	 */
	@Test
	void testRemovePosicaoSemTag() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.aplicaTag("1", "professor-ufcg", 1);
		assertEquals("NÃO HÁ TAG NA POSIÇÃO 2", this.agenda.removeTag(1, 2));
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor-ufcg", this.agenda.exibeContato(1));
	}

	// Testes do método removeFavorito(int posicao)

	/**
	 * Testa o método de remover favorito esperando obter "CONTATO DESFAVORITADO".
	 * Usa o método listaFavoritos() para verificar se o contato foi realmente
	 * desfavoritado.
	 */
	@Test
	void testRemoveFavorito() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(100, "Livia", "Sampaio", "(83) 99873-7383");
		this.agenda.adicionaFavorito(1, 1);
		this.agenda.adicionaFavorito(100, 10);
		assertEquals("CONTATO DESFAVORITADO", this.agenda.removeFavorito(1));
		assertEquals("10 - Livia Sampaio", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de remover favorito em uma posição que não há favoritos
	 * esperando obter "NÃO HÁ CONTATO FAVORITADO NA POSIÇÃO". Usa o método
	 * listaFavoritos() para verificar se realmente não há favoritos.
	 */
	@Test
	void testRemoveFavoritoForaLista() {
		assertEquals("NÃO HÁ CONTATO FAVORITADO NA POSIÇÃO 1", this.agenda.removeFavorito(1));
		assertEquals("", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de remover favorito em uma posição limite, ou seja, 10,
	 * esperando obter "CONTATO DESFAVORITADO". Usa o método listaFavoritos() para
	 * verificar se o contato realmente foi desaforitado.
	 */
	@Test
	void testRemoveFavoritoPosicaoLimite() {
		this.agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.adicionaFavorito(100, 10);
		assertEquals("CONTATO DESFAVORITADO", this.agenda.removeFavorito(10));
		assertEquals("", this.agenda.listaFavoritos());
	}

	/**
	 * Testa o método de remover favorito em uma posição acima do limite (10), 11,
	 * esperando obter "POSIÇÃO INVÁLIDA".
	 */
	@Test
	void testRemoveFavoritoAcimaPosicaoLimite() {
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.removeFavorito(11));
	}

	/**
	 * Testa o método de remover favorito em uma posição abaixo do limite (1), 0,
	 * esperando obter "POSIÇÃO INVÁLIDA".
	 */
	@Test
	void testRemoveFavoritoAbaixoPosicaoLimite() {
		assertEquals("POSIÇÃO INVÁLIDA", this.agenda.removeFavorito(0));
	}

	// Testes do método consultaNome(String nome)

	/**
	 * Testa o método consulta nome quando há contatos com esse nome. Espera
	 * retornar todos os contatos qeu possuem o nome.
	 */
	@Test
	void testConsultaNome() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		this.agenda.cadastraContato(3, "Matheus", "Sampaio", "(84) 98888-1111");
		assertEquals("1 - Matheus Gaudencio\n3 - Matheus Sampaio", this.agenda.consultaNome("Matheus"));
	}

	/**
	 * Testa o método consulta nomes quando não há contatos com esse nome. Espera
	 * retornar "Não há contatos com o nome".
	 */
	@Test
	void testConsultaNomeNenhum() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		this.agenda.cadastraContato(3, "Matheus", "Sampaio", "(84) 98888-1111");
		assertEquals("Não há contatos com o nome Pedro", this.agenda.consultaNome("Pedro"));
	}

	/**
	 * Testa o método consulta nomes com o nome nulo. Espera retornar "Nome
	 * Inválido".
	 */
	@Test
	void testConsultaNomeNulo() {
		assertEquals("Nome Inválido", this.agenda.consultaNome(null));
	}

	/**
	 * Testa o método consulta nomes com o nome vazio. Espera retornar "Nome
	 * Inválido".
	 */
	@Test
	void testConsultaNomeVazio() {
		assertEquals("Nome Inválido", this.agenda.consultaNome(""));
	}

	// Testes do método consultaSobrenome(String sobrenome)

	/**
	 * Testa o método consulta sobrenome quando há contatos com esse sobrenome.
	 * Espera retornar todos os contatos qeu possuem o sobrenome.
	 */
	@Test
	void testConsultaSobrenome() {
		this.agenda.cadastraContato(1, "Matheus", "Sampaio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		assertEquals("1 - Matheus Sampaio\n2 - Livia Sampaio", this.agenda.consultaSobrenome("Sampaio"));
	}

	/**
	 * Testa o método consulta sobrenome quando não há contatos com esse sobrenome.
	 * Espera retornar "Não há contatos com o nome".
	 */
	@Test
	void testConsultaSobrenomeNenhum() {
		this.agenda.cadastraContato(1, "Matheus", "Sampaio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		assertEquals("Não há contatos com o sobrenome Gaudencio", this.agenda.consultaSobrenome("Gaudencio"));
	}

	/**
	 * Testa o método consulta sobrenomes com o sobrenome nulo. Espera retornar
	 * "Sobrenome Inválido".
	 */
	@Test
	void testConsultaSobrenomeNulo() {
		assertEquals("Sobrenome Inválido", this.agenda.consultaSobrenome(null));
	}

	/**
	 * Testa o método consulta sobrenomes com o sobrenome vazio. Espera retornar a
	 * listagem de todos os contatos que possuem o sobrenome vazio.
	 */
	@Test
	void testConsultaSobrenomeVazio() {
		this.agenda.cadastraContato(1, "Matheus", "", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "", "(83) 99873-7383");
		assertEquals("1 - Matheus \n2 - Livia ", this.agenda.consultaSobrenome(""));
	}

	// Testes do método consultaTag(String tag)

	/**
	 * Testa o método consulta tags quando há contatos com essa tag. Espera retornar
	 * todos os contatos qeu possuem a tag.
	 */
	@Test
	void testConsultaTag() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		this.agenda.aplicaTag("1 2", "professores", 1);
		assertEquals("1 - Matheus Gaudencio\n2 - Livia Sampaio", this.agenda.consultaTag("professores"));
	}

	/**
	 * Testa o método consulta tag quando não há contatos com essa tag. Espera
	 * retornar "Não há contatos com a tag".
	 */
	@Test
	void testConsultaTagNenhum() {
		this.agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		this.agenda.cadastraContato(2, "Livia", "Sampaio", "(83) 99873-7383");
		this.agenda.aplicaTag("1 2", "ufcg", 1);
		assertEquals("Não há contatos com a tag professores", this.agenda.consultaTag("professores"));
	}

	/**
	 * Testa o método consulta tag com a tag nula. Espera retornar "Tag Inválida".
	 */
	@Test
	void testConsultaTagNula() {
		assertEquals("Tag Inválida", this.agenda.consultaTag(null));
	}

	/**
	 * Testa o método consulta tag com a tag vazia. Espera retornar "Tag Inválida".
	 */
	@Test
	void testConsultaTagVazia() {
		assertEquals("Tag Inválida", this.agenda.consultaTag(""));
	}
}
