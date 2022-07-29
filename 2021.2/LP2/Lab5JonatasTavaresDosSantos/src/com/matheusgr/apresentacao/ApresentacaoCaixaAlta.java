package com.matheusgr.apresentacao;

import com.matheusgr.lunr.documento.Documento;

/**
 * Classe relativa a apresentação de um documento em caixa alta.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class ApresentacaoCaixaAlta implements Apresentacao {

	/**
	 * Define a quantas das primeiras linhas de um documento serão exibidas.
	 */
	private Documento doc;

	/**
	 * Constrói uma Apresentação em caixa alta a partir de um documento.
	 * 
	 * @param doc Objeto Documento a ser apresentado.
	 */
	public ApresentacaoCaixaAlta(Documento doc) {
		this.doc= doc;
	}

	/**
	 * Método que retorna uma String que apresenta a o documento em caixa alta.
	 * 
	 * @return Retorna uma string de apresentação.
	 */
	@Override
	public String apresenta() {
		return this.doc.getOriginal().toUpperCase();
	}
}
