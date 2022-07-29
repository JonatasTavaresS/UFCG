package com.matheusgr.lunr.documento;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Repositório de documentos. O repositório pode ter opreações simples de busca,
 * mas a lógica de ranking, limitação e ordenação deve ficar em outra entidade.
 * 
 * O ID de um documento é único.
 */
class DocumentoRepository {

	private Map<String, Documento> documentos;
	private ValidadorDocumentos validador;

	/**
	 * Construção padrão do repositório de documentos.
	 */
	DocumentoRepository() {
		this.documentos = new HashMap<>();
		this.validador = new ValidadorDocumentos();
	}

	/**
	 * Adiciona o documento. O documento é validado para garantir a consistência do
	 * documento (sem termos e id vazios).
	 * 
	 * @param d Documento a ser adicionado.
	 */
	void adiciona(Documento d) {
		this.validador.validacao(d.getId(), d.getTexto());
		this.documentos.put(d.getId(), d);
	}

	/**
	 * Recupera um documento do repositório.
	 * 
	 * @param id ID do documento.
	 * @return Documento, caso exista.
	 */
	Optional<Documento> recupera(String id) {
		Documento doc = null;
		this.validador.validacao(id);
		doc = this.documentos.get(id);
		return Optional.ofNullable(doc);
	}

	/**
	 * Retorna o total de documentos cadastrados.
	 * 
	 * @return O total de documentos cadastrados.
	 */
	int totalDocumentos() {
		return this.documentos.size();
	}

	/**
	 * Realiza uma busca pelos termos.
	 * 
	 * @param termo Termo a ser buscado.
	 * @return Conjunto de documentos com o termo.
	 */
	public Set<Documento> busca(String termo) {
		Set<Documento> docs = new HashSet<>();
		for (String key : this.documentos.keySet()) {
			for (int i = 0; i < this.documentos.get(key).getTexto().length; i++) {
				if (this.documentos.get(key).getTexto()[i].equals(termo)) {
					docs.add(this.documentos.get(key));
					break;
				}
			}
		}
		return docs;
	}

	public Set<Documento> busca(Map<String, String> metadados) {
		Set<Documento> docs = new HashSet<>();
		for (String key : this.documentos.keySet()) {
			int contador = 0;
			for (String keyMetadado : metadados.keySet()) {
				if (!metadados.get(keyMetadado).equals(this.documentos.get(key).getMetadados().get(keyMetadado))) {
					break;
				} else {
					contador++;
				}
			}
			if (contador == metadados.size()) {
				docs.add(this.documentos.get(key));
			}
		}
		return docs;
	}
}
