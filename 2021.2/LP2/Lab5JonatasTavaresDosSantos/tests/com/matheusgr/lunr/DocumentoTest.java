package com.matheusgr.lunr;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class DocumentoTest extends BaseTest {

	@Test
	void testAusente() {
		var documentoOpt = this.documentoController.recuperarDocumento("IDNaoExistente");
		assertTrue(documentoOpt.isEmpty());
	}

	@Test
	void testHTML() {
		var documentoOpt = this.documentoController.recuperarDocumento(HTML_ID);
		assertTrue(documentoOpt.isPresent());
		var doc = documentoOpt.get();
		assertEquals(HTML_ID, doc.getId(), "ID padrão do HTML");
		assertEquals("158", "" + doc.getTexto().length);
		assertEquals("46", doc.getMetadados().get("LINHAS"));
		assertEquals("html", doc.getMetadados().get("TIPO"));
		assertEquals("24", doc.getMetadados().get("BRUTE_TAGS"));
		assertTrue(doc.getMetadados().get("HEAD").length() > 10);
		assertEquals(0.59, doc.metricaTextoUtil(), 0.01);
	}

	@Test
	void testJava() {
		var documentoOpt = this.documentoController.recuperarDocumento(JAVA_ID);
		assertTrue(documentoOpt.isPresent());
		var doc = documentoOpt.get();
		assertEquals(JAVA_ID, doc.getId(), "ID padrão do Java");
		assertEquals(110, doc.getTexto().length);
		assertEquals("43", doc.getMetadados().get("LINHAS"));
		assertEquals("java", doc.getMetadados().get("TIPO"));
		assertEquals("10", doc.getMetadados().get("IMPORTS"));
		assertEquals("TRUE", doc.getMetadados().get("AUTHOR"));
		assertEquals(0.54, doc.metricaTextoUtil(), 0.01);
	}

	@Test
	void testTexto1() {
		var documentoOpt = this.documentoController.recuperarDocumento(TEXTO1_ID);
		assertTrue(documentoOpt.isPresent());
		var doc = documentoOpt.get();
		assertEquals(TEXTO1_ID, doc.getId(), "ID padrão do Texto");
		assertEquals(8, doc.getTexto().length, "Tamanho de 107 termos");
		assertArrayEquals(new String[] { "DUAS", "apenas", "arquivo", "linhas", "simples", "texto", "um", "use" },
				doc.getTexto());
		assertEquals(0.80, doc.metricaTextoUtil(), 0.01);
	}

	@Test
	void testTotalDocumentos() {
		assertEquals(4, this.documentoController.totalDocumentos());
		this.documentoController.adicionaDocumentoTxt("conjunto1", "Uma casa feliz é uma casa bonita");
		assertEquals(5, this.documentoController.totalDocumentos());
		this.documentoController.adicionaDocumentoTxt("conjunto2", "Um dia feliz é um bom dia");
		assertEquals(6, this.documentoController.totalDocumentos());
	}

	@Test
	void testConcatena() {
		this.documentoController.adicionaDocumentoTxt("conjunto1", "Uma casa feliz é uma casa bonita");
		this.documentoController.adicionaDocumentoTxt("conjunto2", "Um dia feliz é um bom dia");
		assertEquals("_MERGEconjunto1|conjunto2",
				this.documentoController.concatenaDocumentos("conjunto1", "conjunto2"));
	}

	@Test
	void testConcatenaDocumento1Inexistente() {
		try {
			this.documentoController.concatenaDocumentos("inexistente", TEXTO1_ID);
		} catch (NoSuchElementException nsee) {

		}
	}

	@Test
	void testConcatenaDocumento1Vazio() {
		try {
			this.documentoController.concatenaDocumentos("", TEXTO1_ID);
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testConcatenaDocumento1Nulo() {
		try {
			this.documentoController.concatenaDocumentos(null, TEXTO1_ID);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testConcatenaDocumento2Inexistente() {
		try {
			this.documentoController.concatenaDocumentos(TEXTO1_ID, "inexistente");
		} catch (NoSuchElementException nsee) {

		}
	}

	@Test
	void testConcatenaDocumento2Vazio() {
		try {
			this.documentoController.concatenaDocumentos("", "inexistente");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testConcatenaDocumento2Nulo() {
		try {
			this.documentoController.concatenaDocumentos(TEXTO1_ID, null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testSumariza() {
		this.documentoController.adicionaDocumentoTxt("conjunto1", "Uma casa feliz é uma casa bonita");
		assertArrayEquals(new String[] { "bonita" }, this.documentoController.sumariza("conjunto1"));
	}

	@Test
	void testSumarizaVazio() {
		try {
			this.documentoController.sumariza("");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testSumarizaNulo() {
		try {
			this.documentoController.sumariza(null);
		} catch (NullPointerException npe) {

		}
	}
}
