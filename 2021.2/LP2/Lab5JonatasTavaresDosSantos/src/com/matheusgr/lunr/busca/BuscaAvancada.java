package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaAvancada realiza uma operação de busca a partir de metadados.
 * 
 * Dado os termos, deve se buscar por tais documentos e ordená-los de acordo com
 * a quantidade de termos que são atendidos pela busca.
 * 
 * Quanto mais termos da busca estão presentes, mais relevância tem o documento.
 * 
 * Não importa a quantidade de vezes que um termo aparece no documento, apenas
 * se o documento tem ou não o termo pelo menos uma vez.
 * 
 * Os documentos que não tem nenhum dos termos pesquisados, não devem ser
 * retornados.
 */
class BuscaAvancada implements Busca {

	private Map<String, String> metadados;

	/**
	 * Construtor padrão com os termos a serem encontrados.
	 * 
	 * Os termos não vazios são ignorados. Pelo menos 1 termo deve ser não vazio.
	 * 
	 * @param termos Termos a serem pesquisados.
	 */
	public BuscaAvancada(Map<String, String> metadados) {
		(new ValidadorBusca()).valida(metadados);
		this.metadados = metadados;
	}

	/**
	 * Realiza a busca a partir da consulta ao DocumentoService.
	 * 
	 * O DocumentoService realiza apenas operações simples de busca, mas sem
	 * ordenação ou tratamento da lógica de relevância.
	 * 
	 * @param ds DocumentoService a ser utilizado para busca.
	 * @return Mapa com os documentos encontrados e o fator de relevância de cada
	 *         operação.
	 */
	public Map<Documento, Integer> busca(DocumentoService ds) {
		Map<Documento, Integer> respostaDocumento = new HashMap<>();
		for (Documento d : ds.busca(this.metadados)) {
			respostaDocumento.put(d, respostaDocumento.getOrDefault(d, 0) + 1);
		}
		return respostaDocumento;
	}

	/**
	 * Descreve uma consulta para explicar a consulta que foi feita.
	 * 
	 * @return Descrição da busca, onde cada linha representa um parâmetro de busca
	 *         e as colunas representam um detelhamento de cada parâmetro.
	 */
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		String[] chaves = (String[]) this.metadados.keySet().toArray();
		for (int i = 0; i < resultado.length; i++) {
			resultado[i] = new String[] { "METADADO " + chaves[i], this.metadados.get(chaves[i]) };
		}
		return resultado;
	}

}
