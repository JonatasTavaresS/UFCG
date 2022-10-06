package produto;

import java.util.NoSuchElementException;

public class RepositorioProdutoArray implements RepositorioProduto {

    private Produto[] produtos;

    /**
     * A posicao do ultimo elemento inserido no array de produtos. o valor
     * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
     */
    private int index = -1;

    public RepositorioProdutoArray(int size) {
        this.produtos = new Produto[size];
    }

    /**
     * Recebe o codigo do produto e devolve o indice desse produto no array ou
     * -1 caso ele nao se encontre no array. Esse método é util apenas na
     * implementacao com arrays por questoes de localizacao. Outras classes que
     * utilizam outras estruturas internas podem nao precisar desse método.
     * 
     * @param codigo
     * @return
     */
    private int procurarIndice(int codigo) {
        for (int i = 0; i < this.produtos.length; i++) {
            if (this.produtos[i].getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Recebe o codigo e diz se tem produto com esse codigo armazenado
     * 
     * @param codigo
     * @return
     */
    @Override
    public boolean existe(int codigo) {
        if (procurarIndice(codigo) == -1) {
            return false;
        }
        return true;
    }

    /**
     * Insere um novo produto (sem se preocupar com duplicatas)
     */
    @Override
    public void inserir(Produto produto) {
        if (this.index != this.produtos.length) {
            this.index++;
            this.produtos[index] = produto;
        }
    }

    /**
     * Atualiza um produto armazenado ou retorna um erro caso o produto nao
     * esteja no array. Note que, para localizacao, o código do produto será
     * utilizado.
     */
    @Override
    public void atualizar(Produto produto) {
        if (this.existe(produto.getCodigo())) {
            this.produtos[this.procurarIndice(produto.getCodigo())] = produto;
        } else {
            throw new NoSuchElementException("Produto não existente");
        }
    }

    /**
     * Remove produto com determinado codigo, se existir, ou entao retorna um
     * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
     * array.
     * 
     * @param codigo
     */
    @Override
    public void remover(int codigo) {
        if (this.existe(codigo)) {
            this.produtos[this.procurarIndice(codigo)] = null;
        } else {
            throw new NoSuchElementException("Produto não existente");
        }
    }

    /**
     * Retorna um produto com determinado codigo ou entao um erro, caso o
     * produto nao esteja armazenado
     * 
     * @param codigo
     * @return
     */
    @Override
    public Produto procurar(int codigo) {
        if (this.existe(codigo)) {
            return this.produtos[this.procurarIndice(codigo)];
        }
        return null;
    }
}
