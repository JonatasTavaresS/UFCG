package vetor;

public class TestarVetor {

	public static void main(String[] args) {
		// preencha esse metodo com codigo para testar a classe vetor.
		// À medida que voce evoluir no exercício o conteúdo deste mpetodo
		// também será modificado.
		Vetor<Aluno> vetor = new Vetor<Aluno>(2);
		ComparadorMaximo compMax = new ComparadorMaximo();
		vetor.setComparadorMaximo(compMax);
		ComparadorMinimo compMin = new ComparadorMinimo();
		vetor.setComparadorMinimo(compMin);
		// pode acrescentar testes a partir deste ponto
		System.out.println("Vetor vazio: " + vetor.isVazio());
		Aluno aluno1 = new Aluno("Aluno 1", 10.0);
		Aluno aluno2 = new Aluno("Aluno 2", 7.7);
		vetor.inserir(aluno1);
		System.out.println("Vetor vazio: " + vetor.isVazio());
		System.out.println("Vetor cheio: " + vetor.isCheio());
		vetor.inserir(aluno2);
		System.out.println("Vetor cheio: " + vetor.isCheio());
		System.out.println(vetor.procurar(aluno2).getNome());
		System.out.println(vetor.maximo().getNome());
		System.out.println(vetor.minimo().getNome());
		vetor.remover(aluno2);
		System.out.println(vetor.procurar(aluno2));
		System.out.println("Vetor cheio: " + vetor.isCheio());
	}
}
