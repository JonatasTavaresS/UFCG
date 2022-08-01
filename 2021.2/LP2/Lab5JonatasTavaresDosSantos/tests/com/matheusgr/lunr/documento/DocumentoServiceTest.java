package com.matheusgr.lunr.documento;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DocumentoServiceTest {

	private DocumentoService documentoService;

	@BeforeEach
	void setUp() {
		this.documentoService = new DocumentoService();
	}

	@Test
	void testAdicionaDocumento() {
		this.documentoService.adicionaDocumento(new DocumentoTexto("txt1", "Uma casa feliz é uma casa bonita"));
		assertEquals(1, this.documentoService.totalDocumentos());
	}

	@Test
	void testAdicionaDocumentoNulo() {
		try {
			this.documentoService.adicionaDocumento(null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testRecuperaDocumento() {
		Documento doc = new DocumentoTexto("txt1", "Uma casa feliz é uma casa bonita");
		this.documentoService.adicionaDocumento(doc);
		assertEquals(doc, this.documentoService.recuperaDocumento("txt1").get());
	}

	@Test
	void testRecuperaDocumentoNulo() {
		try {
			this.documentoService.recuperaDocumento(null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testRecuperaDocumentoVazio() {
		try {
			this.documentoService.recuperaDocumento("");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testRecuperaDocumentoInexistente() {
		try {
			this.documentoService.recuperaDocumento("inexistente");
		} catch (NoSuchElementException nsee) {

		}
	}

	@Test
	void testRecuperaDocumentoOuFalhe() {
		Documento doc = new DocumentoTexto("txt1", "Uma casa feliz é uma casa bonita");
		this.documentoService.adicionaDocumento(doc);
		assertEquals(doc, this.documentoService.recuperaDocumentoOuFalhe("txt1"));
	}

	@Test
	void testRecuperaDocumentoOuFalheNulo() {
		try {
			this.documentoService.recuperaDocumentoOuFalhe(null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testRecuperaDocumentoOuFalheInexistente() {
		try {
			this.documentoService.recuperaDocumentoOuFalhe("inexistente");
		} catch (NoSuchElementException nsee) {

		}
	}

	@Test
	void testTotalDocumentos() {
		assertEquals(0, this.documentoService.totalDocumentos());
		this.documentoService.adicionaDocumento(new DocumentoTexto("conjunto1", "Uma casa feliz é uma casa bonita"));
		assertEquals(1, this.documentoService.totalDocumentos());
		this.documentoService.adicionaDocumento(new DocumentoTexto("conjunto2", "bonita casa uma é feliz casa Uma"));
		assertEquals(2, this.documentoService.totalDocumentos());
	}

	@Test
	void testConcatena() {
		this.documentoService.adicionaDocumento(new DocumentoTexto("conjunto1", "Uma casa feliz é uma casa bonita"));
		this.documentoService.adicionaDocumento(new DocumentoTexto("conjunto2", "bonita casa uma é feliz casa Uma"));
		assertEquals("_MERGEconjunto1|conjunto2", this.documentoService.concatena("conjunto1", "conjunto2"));
	}

	@Test
	void testConcatenaDocumentoInexistente() {
		try {
			this.documentoService.concatena("inexistente", "invalido");
		} catch (NoSuchElementException nsee) {

		}
	}

	@Test
	void testConcatenaDocumentoVazio() {
		try {
			this.documentoService.concatena("", "");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testConcatenaDocumentoNulo() {
		try {
			this.documentoService.concatena(null, null);
		} catch (NullPointerException npe) {

		}
	}

	@Test
	void testSumariza() {
		this.documentoService.adicionaDocumento(new DocumentoTexto("conjunto1", "Uma casa feliz é uma casa bonita"));
		assertArrayEquals(new String[] { "bonita" }, this.documentoService.sumariza("conjunto1"));
	}

	@Test
	void testSumarizaVazio() {
		try {
			this.documentoService.sumariza("");
		} catch (IllegalArgumentException iae) {

		}
	}

	@Test
	void testSumarizaNulo() {
		try {
			this.documentoService.sumariza(null);
		} catch (NullPointerException npe) {

		}
	}
}
