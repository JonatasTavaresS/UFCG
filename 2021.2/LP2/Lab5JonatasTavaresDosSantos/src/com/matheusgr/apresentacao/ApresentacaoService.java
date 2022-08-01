package com.matheusgr.apresentacao;

import com.matheusgr.lunr.documento.Documento;
import com.matheusgr.lunr.documento.DocumentoService;

/**
 * Componente para tratamento da lógica de negócio relativa a apresentação de
 * documentos.
 */
public class ApresentacaoService {

	private DocumentoService documentoService;

	/**
	 * Inicialização da lógica de serviço.
	 * 
	 * @param documentoService DocumentoService a ser utilizado pelo
	 *                         ApresentacaoService.
	 */
	public ApresentacaoService(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	/**
	 * Realiza a apresentação do documento indicado.
	 * 
	 * 
	 * @param docId            Documento a ser apresentado.
	 * @param tipoApresentacao modo de apresentacao a ser aplicado sobre o
	 *                         documento.
	 */
	public String apresenta(String docId, String tipoApresentacao) {
		Documento doc = this.documentoService.recuperaDocumentoOuFalhe(docId);
		Apresentacao apresentacao;
		switch (tipoApresentacao) {
		case ("primeiras"):
			apresentacao = new ApresentacaoPrimeirasLinhas(doc);
			break;
		case ("ultimas"):
			apresentacao = new ApresentacaoUltimasLinhas(doc);
			break;
		case ("caixa alta"):
			apresentacao = new ApresentacaoCaixaAlta(doc);
			break;
		default:
			throw new IllegalArgumentException("Maneira de apresentação inválida");
		}
		return apresentacao.apresenta();
	}
}
