package com.matheusgr.lunr.busca;

import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Interface de Busca que é implementada por diferentes tipos de busca.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public interface Busca {

	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada
	 *         operação.
	 */
	Map<Documento, Integer> busca(DocumentoService ds);

	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	public String[][] descreveConsulta();
}
