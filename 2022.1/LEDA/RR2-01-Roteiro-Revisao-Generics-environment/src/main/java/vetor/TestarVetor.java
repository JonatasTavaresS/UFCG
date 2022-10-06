package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo
		// também será modificado.
		Vetor<Aluno> vetor = new Vetor<>(2);
		System.out.println("Vetor vazio: " + vetor.isVazio());
		vetor.inserir(new Aluno("Jônatas", 10));
		System.out.println("Vetor vazio: " + vetor.isVazio());
		System.out.println("Vetor cheio: " + vetor.isCheio());
		vetor.inserir(new Aluno("Alex", 8.9));
		System.out.println("Vetor cheio: " + vetor.isCheio());
	}
}
