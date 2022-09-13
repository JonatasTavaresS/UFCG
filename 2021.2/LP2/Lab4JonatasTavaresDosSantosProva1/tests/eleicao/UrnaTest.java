package eleicao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe JUnit Test Case para testar os atributos da classe Urna.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
class UrnaTest {

	Urna urna;

	@BeforeEach
	void preparaUrna() {
		urna = new Urna(10, 4);
	}

	// Testes do construtor

	void testUrna() {
		new Urna(10, 4);
	}

	// Testes do método toString()

	void testToString() {
		assertEquals(
				"Quantidade de Eleitores Permitidos: 10 - Quantidade de Candidatos Permitidos: 4 - NÃO INICIADA - Quantidade de Votos Depositados: 0",
				this.urna.toString());
	}

	// Testes do método adicionaCandidato()

	@Test
	void testAdicionaCandidato() {
		assertEquals(0, this.urna.adicionaCandidato("Flocão"));
	}

	@Test
	void testAdicionaCandidatoExistente() {
		this.urna.adicionaCandidato("Flocão");
		assertEquals(-1, this.urna.adicionaCandidato("Flocão"));
	}

	@Test
	void testAdicionaCandidatoNomeNulo() {
		try {
			this.urna.adicionaCandidato(null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testAdicionaCandidatoNomeVazio() {
		try {
			this.urna.adicionaCandidato(" ");
		} catch (IllegalArgumentException iae) {

		}
	}
	// Testes do método adicionaEleitor()

	@Test
	void testAdicionaEleitor() {
		assertEquals("Eleitor Cadastrado corretamente", this.urna.adicionaEleitor("111.111.111-11", "José"));
	}

	@Test
	void testAdicionaEleitorExistente() {
		this.urna.adicionaEleitor("111.111.111-11", "José");
		assertEquals("CPF já cadastrado - Eleitor não adicionado", this.urna.adicionaEleitor("111.111.111-11", "José"));
	}

	@Test
	void testAdicionaEleitorCpfNulo() {
		try {
			this.urna.adicionaEleitor(null, "José");
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testAdicionaEleitorNomeNulo() {
		try {
			this.urna.adicionaEleitor("111.111.111-11", null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testAdicionaEleitorCpfVazio() {
		try {
			this.urna.adicionaEleitor("", "José");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testAdicionaEleitorNomeVazio() {
		try {
			this.urna.adicionaEleitor("111.111.111-11", "");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testAdicionaEleitorEleicaoIniciada() {
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.adicionaCandidato("Flocão");
		this.urna.iniciaVotacao();
		assertEquals("Votação em andamento - Eleitor não adicionado",
				this.urna.adicionaEleitor("111.111.111-11", "José"));
	}

	@Test
	void testAdicionaEleitorEleicaoEncerrada() {
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.adicionaCandidato("Flocão");
		this.urna.iniciaVotacao();
		this.urna.encerraVotacao();
		assertEquals("Votação já encerrada - Eleitor não adicionado",
				this.urna.adicionaEleitor("111.111.111-11", "José"));
	}

	@Test
	void testAdicionaEleitorLimite() {
		this.urna.adicionaEleitor("111.111.111-10", "José");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.adicionaEleitor("111.111.111-12", "José");
		this.urna.adicionaEleitor("111.111.111-13", "José");
		this.urna.adicionaEleitor("111.111.111-14", "José");
		this.urna.adicionaEleitor("111.111.111-15", "José");
		this.urna.adicionaEleitor("111.111.111-16", "José");
		this.urna.adicionaEleitor("111.111.111-17", "José");
		this.urna.adicionaEleitor("111.111.111-18", "José");
		this.urna.adicionaEleitor("111.111.111-19", "José");
		assertEquals("Limite de eleitores atingido - Eleitor não adicionado",
				this.urna.adicionaEleitor("111.111.111-20", "José"));
	}

	// Testes do método registraVoto()
	
	@Test
	void testRegistraVotoNaoIniciada() {
		assertEquals("Votação ainda não iniciada.", this.urna.registraVoto("111.111.111-11", "Cuscuz"));
		
	}
	
	@Test
	void testRegistraVotoEncerrada() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.iniciaVotacao();
		this.urna.encerraVotacao();
		assertEquals("Votação já encerrada.", this.urna.registraVoto("111.111.111-11", "Cuscuz"));
	}
	
	@Test
	void testRegistraEleitorNaoCadastrado() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.iniciaVotacao();
		assertEquals("Eleitor não cadastrado - Voto não Cadastrado", this.urna.registraVoto("111.111.119-11", "Cuscuz"));
	}
	
	// Testes do método iniciaVotacao

	@Test
	void testIniciaVotacaoSemEleitoresECandidatos() {
		assertEquals("Votação não iniciada: não há candidatos nem eleitores cadastrados.", this.urna.iniciaVotacao());
	}

	@Test
	void testIniciaVotacaoSemEleitores() {
		this.urna.adicionaCandidato("Flocão");
		assertEquals("Votação não iniciada: não há eleitores cadastrados.", this.urna.iniciaVotacao());
	}

	@Test
	void testIniciaVotacaoSemCandidatos() {
		this.urna.adicionaEleitor("111.111.111-11", "José");
		assertEquals("Votação não iniciada: não há candidatos cadastrados.", this.urna.iniciaVotacao());
	}

	@Test
	void testIniciaVotacaoValida() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaCandidato("Milharina");
		this.urna.adicionaCandidato("Branco");
		this.urna.adicionaCandidato("Nulo");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.adicionaEleitor("222.222.222-22", "Maria");
		assertEquals("—----------------- Urna —-----------------\n"
				+ "Quantidade de Eleitores Permitidos: 10 - Quantidade de Candidatos Permitidos: 4 - EM ANDAMENTO - Quantidade de Votos Depositados: 0\n"
				+ "\n—----------------- Candidatos —-----------------\n"
				+ "0 - Flocão - Quantidade de Votos Recebidos: 0\n"
				+ "1 - Milharina - Quantidade de Votos Recebidos: 0\n"
				+ "2 - Branco - Quantidade de Votos Recebidos: 0\n" + "3 - Nulo - Quantidade de Votos Recebidos: 0\n"
				+ "\n—----------------- Eleitores  —-----------------\n"
				+ "111.111.111-11 - José - VOTO NÃO DEPOSITADO\n" + "222.222.222-22 - Maria - VOTO NÃO DEPOSITADO\n",
				this.urna.iniciaVotacao());
	}

	@Test
	void testIniciaVotacaoJaEmAndamento() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.iniciaVotacao();
		assertEquals("Votação já em andamento.", this.urna.iniciaVotacao());
	}

	@Test
	void testIniciaVotacaoJaEncerrada() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.iniciaVotacao();
		this.urna.encerraVotacao();
		assertEquals("Votação já encerrada.", this.urna.iniciaVotacao());
	}

	// Testes do método listFaltantes()

	@Test
	void testListaFaltantes() {
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.adicionaEleitor("222.222.222-22", "Maria");
		assertEquals(2, this.urna.listaFaltantes());
	}

	// Testes do método informaVencedor()

	@Test
	void testInformaVencedorVotacaoNaoEncerrada() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.iniciaVotacao();
		assertEquals("Votação ainda não foi encerrada", this.urna.informaVencedor());
	}

	@Test
	void testInformaVencedor() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaCandidato("Milharina");
		this.urna.adicionaCandidato("Branco");
		this.urna.adicionaCandidato("Nulo");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.adicionaEleitor("222.222.222-22", "Maria");
		this.urna.iniciaVotacao();
		this.urna.registraVoto("111.111.111-11", "Flocão");
		this.urna.registraVoto("222.222.222-22", "Flocão");
		this.urna.encerraVotacao();
		assertEquals("Flocão 100", this.urna.informaVencedor());
	}

	// Testes do método emitirBoletim()

	@Test
	void testEmiteBoletimValido() {
		this.urna.adicionaCandidato("Flocão");
		this.urna.adicionaCandidato("Milharina");
		this.urna.adicionaCandidato("Branco");
		this.urna.adicionaCandidato("Nulo");
		this.urna.adicionaEleitor("111.111.111-11", "José");
		this.urna.adicionaEleitor("222.222.222-22", "Maria");
		this.urna.iniciaVotacao();
		this.urna.registraVoto("111.111.111-11", "Flocão");
		this.urna.encerraVotacao();
		assertEquals("—----------------- Urna —-----------------\n"
				+ "Quantidade de Eleitores Permitidos: 10 - Quantidade de Candidatos Permitidos: 4 - ENCERRADA - Quantidade de Votos Depositados: 1\n"
				+ "\n—----------------- Candidatos —-----------------\n"
				+ "0 - Flocão - Quantidade de Votos Recebidos: 1\n"
				+ "1 - Milharina - Quantidade de Votos Recebidos: 0\n"
				+ "2 - Branco - Quantidade de Votos Recebidos: 0\n" + "3 - Nulo - Quantidade de Votos Recebidos: 0\n",
				this.urna.emiteBoletim());
	}
}
