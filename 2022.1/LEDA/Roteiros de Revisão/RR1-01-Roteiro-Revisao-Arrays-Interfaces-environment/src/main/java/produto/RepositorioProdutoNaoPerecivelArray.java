package produto;

/**
 * Classe que representa um repositório de produtos usando arrays como estrutura
 * sobrejacente. Alguns métodos (atualizar, remover e procurar) ou executam com
 * sucesso ou retornam um erro. Para o caso desde exercício, o erro será
 * representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" do mos metodos.
 * 
 * Obs: Note que você deve utilizar a estrutura de dados array e não
 * implementações de array prontas da API Collections de Java (como ArrayList,
 * por exemplo).
 * 
 * @author Adalberto
 *
 */
public class RepositorioProdutoNaoPerecivelArray extends RepositorioProdutoArray {

    public RepositorioProdutoNaoPerecivelArray(int size) {
        super(size);
    }

    /**
     * Insere um novo produto (sem se preocupar com duplicatas)
     */
    @Override
    public void inserir(Produto produto) {
        if (produto.getClass() == ProdutoNaoPerecivel.class) {
            super.inserir(produto);
        }
    }

    /**
     * Atualiza um produto armazenado ou retorna um erro caso o produto nao
     * esteja no array. Note que, para localizacao, o código do produto será
     * utilizado.
     */
    @Override
    public void atualizar(Produto produto) {
        if (produto.getClass() == ProdutoNaoPerecivel.class) {
            super.atualizar(produto);
        }
    }
}
