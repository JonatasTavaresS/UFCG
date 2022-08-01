package com.matheusgr.apresentacao;

import com.matheusgr.lunr.documento.Documento;

/**
 * Classe relativa a apresentação das 5 primeiras linhas de um documento.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
class ApresentacaoPrimeirasLinhas implements Apresentacao {

	/**
	 * Define a quantas das primeiras linhas de um documento serão exibidas.
	 */
	private static final int NUMERO_LINHAS = 5;

	/**
	 * Documento a ser apresentado.
	 */
	private Documento doc;

	/**
	 * Constrói uma Apresentação das Primeiras linhas a partir de um documento.
	 * 
	 * @param doc Objeto Documento a ser apresentado.
	 */
	public ApresentacaoPrimeirasLinhas(Documento doc) {
		this.doc = doc;
	}

	/**
	 * Caso o númerode linhas de um documento seja inferior ao número de linhas a
	 * serem apresentadas, define que o número de linhas a serem apresentadas como o
	 * número de linhas do documento. Ou seja, serão exbidas todas as linhas do
	 * documento caso o número de linhas seja inferior ao padrão. Qualquer documento
	 * com o número de linhas igual ao superior ao número de linhas do documento
	 * especificado exibira o número de linhas padrão.
	 * 
	 * @param numeroLinhas Quantidade de linhas do documento.
	 * @return O número de linhas a ser realmente apresentado.
	 */
	private int linhas(int numeroLinhas) {
		if (numeroLinhas < NUMERO_LINHAS) {
			return numeroLinhas;
		}
		return NUMERO_LINHAS;
	}

	/**
	 * Método que retorna uma String que apresenta as 5 primeiras linhas do
	 * documento. Ou, caso o documento tenha menos de 5 linhas, exibe todas as
	 * linahs do documento.
	 * 
	 * @return Retorna uma string de apresentação.
	 */
	@Override
	public String apresenta() {
		String primeirasLinhas = "";
		String[] original = doc.getOriginal().split("\n");
		for (int i = 0; i < linhas(original.length); i++) {
			if (i != 0) {
				primeirasLinhas += "\n";
			}
			primeirasLinhas += original[i];

		}
		return primeirasLinhas;
	}
}
