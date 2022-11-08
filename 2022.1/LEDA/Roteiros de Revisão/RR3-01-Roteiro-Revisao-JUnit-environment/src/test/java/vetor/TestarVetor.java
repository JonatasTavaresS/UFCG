package vetor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestarVetor {

    private Vetor<Aluno> vetor;
    private Aluno aluno;

    @Before
    public void setUp() throws Exception {
        vetor = new Vetor<Aluno>(10);
        ComparadorMaximo comparadorMaximo = new ComparadorMaximo();
        vetor.setComparadorMaximo(comparadorMaximo);
        ComparadorMinimo comparadorMinimo = new ComparadorMinimo();
        vetor.setComparadorMinimo(comparadorMinimo);
        aluno = new Aluno("Jônatas", 10.0);
    }

    @Test
    public void testInserir() {
        assertTrue(vetor.isVazio());
        vetor.inserir(aluno);
        assertFalse(vetor.isVazio());
        assertEquals(aluno, vetor.procurar(aluno));
    }

    @Test
    public void testRemover() {
        vetor.inserir(aluno);
        assertEquals(aluno, vetor.procurar(aluno));
        assertNull(vetor.remover(aluno));
    }

    @Test
    public void testProcurar() {
        assertNull(vetor.procurar(aluno));
        vetor.inserir(aluno);
        assertEquals(aluno, vetor.procurar(aluno));
    }

    @Test
    public void testIsVazio() {
        assertTrue(vetor.isVazio());
        vetor.inserir(aluno);
        assertFalse(vetor.isVazio());
    }
}
