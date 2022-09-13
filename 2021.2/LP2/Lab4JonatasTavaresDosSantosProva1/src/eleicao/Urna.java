package eleicao;

/**
 * Representação de uma Urna Eletrônica para eleição do(a) presidente do milho.
 * Possui lista de eleitores, lista de candidatos, status da votação e
 * quantidade de voctos depositados.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Urna {

	private Eleitor[] eleitores;
	private Candidato[] candidatos;
	private String status;

	public Urna(int quantidadeEleitores, int quantidadeCandidatos) {
		this.eleitores = new Eleitor[quantidadeEleitores];
		this.candidatos = new Candidato[quantidadeCandidatos];
		this.status = "NÃO INICIADA";
	}

	private Eleitor getEleitor(String cpf) {
		Eleitor outroEleitor = new Eleitor(cpf, "Verifica Iguais");
		for (int i = 0; i < this.eleitores.length; i++) {
			if (this.eleitores[i] == null) {
				return null;
			} else if (this.eleitores[i].equals(outroEleitor)) {
				return this.eleitores[i];
			}
		}
		return null;
	}

	private Candidato getCandidato(String nome) {
		Candidato outroCandidato = new Candidato(0, nome);
		for (int i = 0; i < this.eleitores.length; i++) {
			if (this.eleitores[i] == null) {
				return null;
			} else if (this.candidatos[i].equals(outroCandidato)) {
				return this.candidatos[i];
			}
		}
		return null;
	}

	public String adicionaEleitor(String cpf, String nome) {
		if (this.status.equals("NÃO INICIADA")) {
			if (cpf == null || nome == null) {
				throw new NullPointerException();
			} else if (cpf.isBlank() || nome.isBlank()) {
				throw new IllegalArgumentException();
			}
			Eleitor novoEleitor = new Eleitor(cpf, nome);
			for (int i = 0; i < this.eleitores.length; i++) {
				if (this.eleitores[i] == null) {
					this.eleitores[i] = novoEleitor;
					return "Eleitor Cadastrado corretamente";
				} else if (this.eleitores[i].equals(novoEleitor)) {
					return "CPF já cadastrado - Eleitor não adicionado";
				}
			}
			return "Limite de eleitores atingido - Eleitor não adicionado";
		} else if (this.status.equals("EM ANDAMENTO")) {
			return "Votação em andamento - Eleitor não adicionado";
		} else {
			return "Votação já encerrada - Eleitor não adicionado";
		}
	}

	public int adicionaCandidato(String nome) {
		if (this.status.equals("NÃO INICIADA")) {
			if (nome == null) {
				throw new NullPointerException();
			} else if (nome.isBlank()) {
				throw new IllegalArgumentException();
			}
			for (int i = 0; i < this.candidatos.length; i++) {
				Candidato novoCandidato = new Candidato(i, nome);
				if (this.candidatos[i] == null) {
					this.candidatos[i] = novoCandidato;
					return i;
				} else if (this.candidatos[i].equals(novoCandidato)) {
					return -1;
				}
			}
			return -1;
		}
		return -1;
	}

	public String iniciaVotacao() {
		if (this.status.equals("NÃO INICIADA")) {
			if (this.quantidadeCandidatos() == 0 && this.quantidadeEleitores() == 0) {
				return "Votação não iniciada: não há candidatos nem eleitores cadastrados.";
			} else if (this.quantidadeCandidatos() == 0) {
				return "Votação não iniciada: não há candidatos cadastrados.";
			} else if (this.quantidadeEleitores() == 0) {
				return "Votação não iniciada: não há eleitores cadastrados.";
			} else {
				this.status = "EM ANDAMENTO";
				for (int i = 0; i < this.candidatos.length; i++) {
					if (this.candidatos[i] != null) {
						this.candidatos[i].zeraVotos();
					} else {
						break;
					}
				}
				for (int i = 0; i < this.eleitores.length; i++) {
					if (this.eleitores[i] != null) {
						this.eleitores[i].ajustaStatus();
					} else {
						break;
					}
				}
				return "—----------------- Urna —-----------------\n" + this.toString()
						+ "\n\n—----------------- Candidatos —-----------------\n"
						+ this.representacaoTextualCandidatos() + "\n—----------------- Eleitores  —-----------------\n"
						+ this.representacaoTextualEleitores();

			}
		} else if (this.status.equals("EM ANDAMENTO")) {
			return "Votação já em andamento.";
		} else {
			return "Votação já encerrada.";
		}
	}

	public String registraVoto(String cpfEleitor, String nomeCandidato) {
		if (this.status.equals("EM ANDAMENTO")) {
			Eleitor eleitor = this.getEleitor(cpfEleitor);
			Candidato candidato = this.getCandidato(nomeCandidato);
			if (eleitor == null) {
				return "Eleitor não cadastrado - Voto não Cadastrado";
			} else if (candidato == null) {
				return "Candidato não cadastrado - Voto não Cadastrado";
			} else if (eleitor.getStatus().equals("VOTO DEPOSITADO")) {
				return "Eleitor já votou anteriormente - Voto desconsiderado";
			} else {
				eleitor.registraVoto();
				candidato.registraVoto();
				return "Voto cadastrado corretamente";
			}
		} else if (this.status.equals("NÃO INICIADA")) {
			return "Votação ainda não iniciada.";
		} else {
			return "Votação já encerrada.";
		}
	}
	
	public int listaFaltantes() {
		int faltantes = 0;
		for (int i = 0; i < this.eleitores.length; i++) {
			if (this.eleitores[i] == null) {
				return faltantes;
			} else if (this.eleitores[i].getStatus().equals("VOTO NÃO DEPOSITADO")) {
				faltantes++;
			}
		}
		return faltantes;
		
	}

	public void encerraVotacao() {
		this.status = "ENCERRADA";
	}

	public String informaVencedor() {
		if (this.status.equals("ENCERRADA")) {
			int maior = 0;
			int vencedor = 0;
			for (int i = 0; i < this.candidatos.length; i++) {
				if (this.candidatos[i] == null) {
					break;
				}
				if (this.candidatos[i].getQuantidadeVotosRecebidos() >= maior) {
					maior = this.candidatos[i].getQuantidadeVotosRecebidos();
					vencedor = i;
				}
			}
			int porcentagem = (maior * 100) / this.quantidadeVotosdepositados();
			return this.candidatos[vencedor].getNome() + " " + porcentagem;
		} else {
			return "Votação ainda não foi encerrada";
		}
	}

	public String emiteBoletim() {
		if (this.status.equals("ENCERRADA")) {
			return "—----------------- Urna —-----------------\n" + this.toString()
					+ "\n\n—----------------- Candidatos —-----------------\n" + this.representacaoTextualCandidatos();
		}
		return "Eleição ainda não encerrada";
	}

	private int quantidadeVotosdepositados() {
		int quantidadeVotosdepositados = 0;
		for (int i = 0; i < this.candidatos.length; i++) {
			if (this.candidatos[i] == null) {
				return quantidadeVotosdepositados;
			}
			quantidadeVotosdepositados += this.candidatos[i].getQuantidadeVotosRecebidos();
		}
		return quantidadeVotosdepositados;
	}

	private String representacaoTextualCandidatos() {
		String candidatos = "";
		for (int i = 0; i < this.candidatos.length; i++) {
			if (this.candidatos[i] == null) {
				return candidatos;
			}
			candidatos += this.candidatos[i].toString() + "\n";
		}
		return candidatos;
	}

	private String representacaoTextualEleitores() {
		String eleitores = "";
		for (int i = 0; i < this.eleitores.length; i++) {
			if (this.eleitores[i] == null) {
				break;
			}
			eleitores += this.eleitores[i].toString() + "\n";
		}
		return eleitores;
	}

	private int quantidadeCandidatos() {
		int i = 0;
		for (i = 0; i < this.candidatos.length; i++) {
			if (this.candidatos[i] == null) {
				return i;
			}
		}
		return i;
	}

	private int quantidadeEleitores() {
		int i = 0;
		for (i = 0; i < this.eleitores.length; i++) {
			if (this.eleitores[i] == null) {
				return i;
			}
		}
		return i;
	}

	@Override
	public String toString() {
		return "Quantidade de Eleitores Permitidos: " + this.eleitores.length
				+ " - Quantidade de Candidatos Permitidos: " + this.candidatos.length + " - " + this.status
				+ " - Quantidade de Votos Depositados: " + this.quantidadeVotosdepositados();
	}
}
