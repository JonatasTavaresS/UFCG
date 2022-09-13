package eleicao;

import java.util.Objects;

public class Eleitor {

	private String cpf;
	private String nome;
	private String status;

	public Eleitor(String cpf, String nome) {
		if (cpf == null || nome == null) {
			throw new NullPointerException();
		} else if (cpf.isBlank() || nome.isBlank()) {
			throw new IllegalArgumentException();
		}
		this.cpf = cpf;
		this.nome = nome;
		this.status = "VOTO NÃO DEPOSITADO";
	}

	public String getStatus() {
		return this.status;
	}

	public void ajustaStatus() {
		this.status = "VOTO NÃO DEPOSITADO";
	}

	public void registraVoto() {
		this.status = "VOTO DEPOSITADO";
	}

	@Override
	public String toString() {
		return this.cpf + " - " + this.nome + " - " + this.status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eleitor other = (Eleitor) obj;
		return Objects.equals(cpf, other.cpf);
	}
}
