package eleicao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe JUnit Test Case para testar os atributos da classe Candidato.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
class CandidatoTest {

	Candidato candidato;

	@BeforeEach
	void preparaCandidato() {
		this.candidato = new Candidato(0, "Flocão");
	}

	// Testes do construtor

	@Test
	void testCandidatoCasoBase() {
		new Candidato(1, "Milharina");
	}

	@Test
	void testCandidatoNomeNulo() {
		try {
			new Candidato(1, null);
		} catch (NullPointerException npe) {

		}
	}
	
	@Test
	void testCandidatoNomeVazio() {
		try {
			new Candidato(1, "");
		} catch (IllegalArgumentException iae) {

		}
	}

	// Testes do método toString()

	@Test
	void testToString() {
		assertEquals("0 - Flocão - Quantidade de Votos Recebidos: 0", this.candidato.toString());
	}

	@Test
	void testToStringComVotos() {
		this.candidato.registraVoto();
		assertEquals("0 - Flocão - Quantidade de Votos Recebidos: 1", this.candidato.toString());
	}

	// Testes do método zeraVotos()

	@Test
	void testZeraVotosSemVotos() {
		this.candidato.zeraVotos();
		assertEquals("0 - Flocão - Quantidade de Votos Recebidos: 0", this.candidato.toString());
	}

	@Test
	void testZeraVotosComVotos() {
		this.candidato.registraVoto();
		this.candidato.zeraVotos();
		assertEquals("0 - Flocão - Quantidade de Votos Recebidos: 0", this.candidato.toString());
	}

	// Testes do método registraVoto()

	@Test
	void testRegistraVoto() {
		this.candidato.registraVoto();
		assertEquals("0 - Flocão - Quantidade de Votos Recebidos: 1", this.candidato.toString());
	}

	@Test
	void testRegistraVotos() {
		this.candidato.registraVoto();
		this.candidato.registraVoto();
		this.candidato.registraVoto();
		assertEquals("0 - Flocão - Quantidade de Votos Recebidos: 3", this.candidato.toString());
	}

	// Testes do método hashCode()

	@Test
	void testHashCodeNomesIguais() {
		Candidato outroCandidato = new Candidato(1, "Flocão");
		assertEquals(this.candidato.hashCode(), outroCandidato.hashCode());
	}

	@Test
	void testHashCodeNomeDiferente() {
		Candidato outroCandidato = new Candidato(1, "Milharina");
		assertNotEquals(this.candidato.hashCode(), outroCandidato.hashCode());
	}

	// Testes do método equals()

	@Test
	void testEqualsProprioObjeto() {
		assertTrue(this.candidato.equals(this.candidato));
	}

	@Test
	void testEqualsNull() {
		assertFalse(this.candidato.equals(null));
	}

	@Test
	void testEqualsObjectClasseDiferente() {
		assertFalse(this.candidato.equals(new Object()));
	}

	@Test
	void testEqualsNomesIguais() {
		Candidato outroCandidato = new Candidato(1, "Flocão");
		assertTrue(this.candidato.equals(outroCandidato));
	}

	@Test
	void testEqualsNomesDiferentes() {
		Candidato outroCandidato = new Candidato(1, "Milharina");
		assertFalse(this.candidato.equals(outroCandidato));
	}
}
