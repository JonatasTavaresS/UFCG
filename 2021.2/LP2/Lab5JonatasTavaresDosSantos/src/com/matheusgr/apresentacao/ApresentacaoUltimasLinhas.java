package com.matheusgr.apresentacao;

import com.matheusgr.lunr.documento.Documento;

/**
 * Classe relativa a apresentação das 5 últimas linhas de um documento.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ApresentacaoUltimasLinhas implements Apresentacao {

	/**
	 * Define a quantas das últimas linhas de um documento serão exibidas.
	 */
	private static final int NUMERO_LINHAS = 5;

	/**
	 * Documento a ser apresentado.
	 */
	private Documento doc;

	/**
	 * Constrói uma Apresentação das últimas linhas a partir de um documento.
	 * 
	 * @param doc Objeto Documento a ser apresentado.
	 */
	public ApresentacaoUltimasLinhas(Documento doc) {
		this.doc = doc;
	}

	/**
	 * Caso o númerode linhas de um documento seja inferior ao número de linhas a
	 * serem apresentadas, define que o documento será apresentado da linha 0 até a
	 * linha final. Caso seja maior ou igual ao número de linhas definido,
	 * apresentará de numeroLinhas - NUMERO_LINHAS até a última linha.
	 * 
	 * @param numeroLinhas Quantidade de linhas do documento.
	 * @return O número de linhas a ser realmente apresentado.
	 */
	private int linhas(int numeroLinhas) {
		if (numeroLinhas < NUMERO_LINHAS) {
			return 0;
		}
		return numeroLinhas - NUMERO_LINHAS;
	}

	/**
	 * Método que retorna uma String que apresenta as 5 últimas linhas do documento.
	 * 
	 * @return Retorna uma string de apresentação.
	 */
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
