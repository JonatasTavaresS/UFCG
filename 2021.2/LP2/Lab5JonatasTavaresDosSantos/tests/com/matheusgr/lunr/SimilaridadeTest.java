package com.matheusgr.lunr;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class SimilaridadeTest extends BaseTest  {
	
	@Test
	void testSimilaridade() {
		this.documentoController.adicionaDocumentoTxt("conjunto1", "Uma casa feliz é uma casa bonita");
		this.documentoController.adicionaDocumentoTxt("conjunto2", "Um dia feliz é um bom dia");
		assertEquals(20, similaridadeController.similaridade("conjunto1", "conjunto2"));
	}
	
	@Test
	void testSimilaridadeIguais() {
		this.documentoController.adicionaDocumentoTxt("conjunto1", "Uma casa feliz é uma casa bonita");
		assertEquals(100, similaridadeController.similaridade("conjunto1", "conjunto1"));
	}
	
	@Test
	void testSimilaridadeInexistente() {
		try {
			similaridadeController.similaridade(TEXTO1_ID, "inexistente");
		} catch (NoSuchElementException nsee) {
			
		}
	}

}
