package eleicao;

import java.util.Objects;

/**
 * Representação de um cadidato para eleição do(a) presidente do milho. Possui
 * id, nome e quantidade de votos.
 * 
 * @author Jônatas Tavares dos Santos - 121110769
 */
public class Candidato {

	private int id;
	private String nome;
	private int quantidadeVotosRecebidos;

	public Candidato(int id, String nome) {
		if (nome == null) {
			throw new NullPointerException();
		} else if (nome.isBlank()) {
			throw new IllegalArgumentException();
		}
		this.id = id;
		this.nome = nome;
		this.quantidadeVotosRecebidos = 0;
	}

	public String getNome() {
		return this.nome;
	}

	public int getQuantidadeVotosRecebidos() {
		return this.quantidadeVotosRecebidos;
	}

	public void zeraVotos() {
		this.quantidadeVotosRecebidos = 0;
	}

	public void registraVoto() {
		this.quantidadeVotosRecebidos++;
	}

	@Override
	public String toString() {
		return this.id + " - " + this.nome + " - Quantidade de Votos Recebidos: " + this.quantidadeVotosRecebidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidato other = (Candidato) obj;
		return Objects.equals(this.nome, other.nome);
	}
}
