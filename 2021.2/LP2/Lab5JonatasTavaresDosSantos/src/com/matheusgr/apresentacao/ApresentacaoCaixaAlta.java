package com.matheusgr.apresentacao;

import com.matheusgr.lunr.documento.Documento;

public class ApresentacaoCaixaAlta implements Apresentacao {

	private Documento doc;

	public ApresentacaoCaixaAlta(Documento doc) {
		this.doc= doc;
	}

	@Override
	public String apresenta() {
		return this.doc.getOriginal().toUpperCase();
	}
}
