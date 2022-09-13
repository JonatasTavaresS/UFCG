package eleicao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe JUnit Test Case para testar os atributos da classe Eleitor.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
class EleitorTest {

	Eleitor eleitor;

	@BeforeEach
	void eleitorBase() {
		eleitor = new Eleitor("111.111.111-11", "José");
	}

	@Test
	void testEleitorCasoBase() {
		new Eleitor("111.111.111-11", "José");
	}

	@Test
	void testAjustaStatusNaoVotou() {
		this.eleitor.ajustaStatus();
		assertEquals("VOTO NÃO DEPOSITADO", this.eleitor.getStatus());
	}

	@Test
	void testAjustaStatusVotou() {
		this.eleitor.registraVoto();
		this.eleitor.ajustaStatus();
		assertEquals("VOTO NÃO DEPOSITADO", this.eleitor.getStatus());
	}

	@Test
	void testRegistraVoto() {
		this.eleitor.registraVoto();
		assertEquals("VOTO DEPOSITADO", this.eleitor.getStatus());
	}

	@Test
	void testToString() {
		assertEquals("111.111.111-11 - José - VOTO NÃO DEPOSITADO", this.eleitor.toString());
	}

	@Test
	void testEleitorCpfNulo() {
		try {
			new Eleitor(null, "José");
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testEleitorNomeNulo() {
		try {
			new Eleitor("111.111.111-11", null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testEleitorCpfVazio() {
		try {
			new Eleitor("", "José");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testEleitorNomeVazio() {
		try {
			new Eleitor("111.111.111-11", "");
		} catch (IllegalArgumentException iae) {

		}
	}

	// Testes do método hashCode()

	@Test
	void testHashCodeCpfIguais() {
		Eleitor outroEleitor = new Eleitor("111.111.111-11", "Maria");
		assertEquals(this.eleitor.hashCode(), outroEleitor.hashCode());
	}

	@Test
	void testHashCodeCpfDiferente() {
		Eleitor outroEleitor = new Eleitor("222.222.222-22", "José");
		assertNotEquals(this.eleitor.hashCode(), outroEleitor.hashCode());
	}

	// Testes do método equals()

	@Test
	void testEqualsProprioObjeto() {
		assertTrue(this.eleitor.equals(this.eleitor));
	}

	@Test
	void testEqualsNull() {
		assertFalse(this.eleitor.equals(null));
	}

	@Test
	void testEqualsObjectClasseDiferente() {
		assertFalse(this.eleitor.equals(new Object()));
	}

	@Test
	void testEqualsCpfIguais() {
		Eleitor outroEleitor = new Eleitor("111.111.111-11", "José");
		assertTrue(this.eleitor.equals(outroEleitor));
	}

	@Test
	void testEqualsCpfDiferentes() {
		Eleitor outroEleitor = new Eleitor("222.222.222-22", "José");
		assertFalse(this.eleitor.equals(outroEleitor));
	}
}
