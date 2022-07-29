package com.matheusgr.apresentacao;

import com.matheusgr.lunr.documento.Documento;

public class ApresentacaoUltimasLinhas implements Apresentacao {

	private static final int NUMERO_LINHAS = 5;
	
	private Documento doc;

	public ApresentacaoUltimasLinhas(Documento doc) {
		this.doc = doc;
	}
	
	private int linhas(int numeroLinhas) {
		if (numeroLinhas < NUMERO_LINHAS) {
			return 0;
		}
		return numeroLinhas - NUMERO_LINHAS;
	}

	@Override
	public String apresenta() {
		String ultimasLinhas = "";
		String[] original = doc.getOriginal().split("\n");
		for (int i = linhas(original.length); i < original.length; i++) {
			if (i != linhas(original.length)) {
				ultimasLinhas += "\n";
			}
			ultimasLinhas += original[i];
		}
		return ultimasLinhas;
	}
}
