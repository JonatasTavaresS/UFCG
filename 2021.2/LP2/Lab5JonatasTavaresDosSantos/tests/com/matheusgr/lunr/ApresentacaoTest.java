package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class ApresentacaoTest extends BaseTest {

	@Test
	void testApresentaMetodoInvalido() {
		try {
			apresentacaoController.apresenta(TEXTO1_ID, "invalido");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testPrimeirasLinhasLimiteTxt() {
		this.documentoController.adicionaDocumentoTxt("txt", "Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5");
		assertEquals("Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5",
				apresentacaoController.apresenta("txt", "primeiras"));
	}

	@Test
	void testPrimeirasLinhasAcimaLimiteTxt() {
		this.documentoController.adicionaDocumentoTxt("txt", "Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5\nLinha6");
		assertEquals("Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5",
				apresentacaoController.apresenta("txt", "primeiras"));
	}

	@Test
	void testPrimeirasLinhasAbaixoLimiteTxt() {
		this.documentoController.adicionaDocumentoTxt("txt", "Linha 1\nLinha 2\nLinha 3\nLinha 4");
		assertEquals("Linha 1\nLinha 2\nLinha 3\nLinha 4", apresentacaoController.apresenta("txt", "primeiras"));
	}

	@Test
	void testPrimeirasLinhasJava() {
		assertEquals(
				"package com.matheusgr.lunr;\r\n" + "\r\n" + "import java.util.Optional;\r\n" + "\r\n"
						+ "import com.matheusgr.lunr.busca.BuscaController;\r",
				apresentacaoController.apresenta(JAVA_ID, "primeiras"));
	}

	@Test
	void testPrimeirasLinhasHTML() {
		assertEquals(
				"<!doctype html>\r\n" + "<html>\r\n" + "<head>\r\n" + "    <title>Example Domain</title>\r\n" + "\r",
				apresentacaoController.apresenta(HTML_ID, "primeiras"));
	}

	@Test
	void testApresentaPrimeirasLinhasDocumentoInexistente() {
		try {
			apresentacaoController.apresenta("inexistente", "primeiras");
		} catch (NoSuchElementException nsee) {

		}
	}

	@Test
	void testUltimasLinhasLimiteTxt() {
		this.documentoController.adicionaDocumentoTxt("txt", "Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5");
		assertEquals("Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5", apresentacaoController.apresenta("txt", "ultimas"));
	}

	@Test
	void testUltimasLinhasAcimaLimiteTxt() {
		this.documentoController.adicionaDocumentoTxt("txt", "Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5\nLinha 6");
		assertEquals("Linha 2\nLinha 3\nLinha 4\nLinha 5\nLinha 6", apresentacaoController.apresenta("txt", "ultimas"));
	}

	@Test
	void testUltimasLinhasAbaixoLimiteTxt() {
		this.documentoController.adicionaDocumentoTxt("txt", "Linha 1\nLinha 2\nLinha 3\nLinha 4");
		assertEquals("Linha 1\nLinha 2\nLinha 3\nLinha 4", apresentacaoController.apresenta("txt", "ultimas"));
	}

	@Test
	void testUltimasLinhasHTML() {
		assertEquals(
				"    domain in literature without prior coordination or asking for permission.</p>\r\n"
						+ "    <p><a href=\"https://www.iana.org/domains/example\">More information...</a></p>\r\n"
						+ "</div>\r\n" + "</body>\r\n" + "</html>\r",
				apresentacaoController.apresenta(HTML_ID, "ultimas"));
	}

	@Test
	void testUltimasLinhasJava() {
		assertEquals(
				"	\r\n" + "	public void adicionaDocumentoTxt(String id, String use) {\r\n"
						+ "		this.dc.adicionaDocumentoTxt(id, use);\r\n" + "	}\r\n" + "}",
				apresentacaoController.apresenta(JAVA_ID, "ultimas"));
	}

	@Test
	void testApresentaUltimasLinhasDocumentoInexistente() {
		try {
			apresentacaoController.apresenta("inexistente", "ultimas");
		} catch (NoSuchElementException nsee) {

		}
	}

	@Test
	void testCaixaAltaTxt() {
		this.documentoController.adicionaDocumentoTxt("txt", "Linha 1\nLinha 2\nLinha 3\nLinha 4\nLinha 5");
		assertEquals("LINHA 1\nLINHA 2\nLINHA 3\nLINHA 4\nLINHA 5",
				apresentacaoController.apresenta("txt", "caixa alta"));
	}

	@Test
	void testCaixaAltaJava() {
		var exemplo = new DocumentoExemplos();
		assertEquals(exemplo.sampleJava().toUpperCase(), apresentacaoController.apresenta(JAVA_ID, "caixa alta"));
	}

	@Test
	void testApresentaCaixaAltaDocumentoInexistente() {
		try {
			apresentacaoController.apresenta("inexistente", "caixa alta");
		} catch (NoSuchElementException nsee) {

		}
	}
}
