package com.matheusgr.lunr.busca;

import java.util.HashMap;
import java.util.Map;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * BuscaAvancada realiza uma operação de busca a partir de metadados.
 * 
 * A busca avançada deve selecionar TODOS os documentos que tenham TODOS OS
 * METADADOS indicados.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
class BuscaAvancada implements Busca {

	private Map<String, String> metadados;

	/**
	 * Construtor padrão com os metadados a serem encontrados.
	 * 
	 * Não podem haver metadados com chaves nulas ou com valores nulos ou vazios.
	 * 
	 * @param metadados Metadados a serem pesquisados.
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
	 * @return Descrição da busca, onde cada linha representa a chave de um metadado
	 *         de busca e as colunas representam um detelhamento de chave.
	 */
	public String[][] descreveConsulta() {
		String[][] resultado = new String[this.metadados.size()][];
		int cont = 0;
		for (String key : this.metadados.keySet()) {
			resultado[cont] = new String[] { "METADADO " + key, this.metadados.get(key) };
			cont++;
		}
		return resultado;
	}

}
