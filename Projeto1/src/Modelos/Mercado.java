package Modelos;

import java.util.ArrayList;
import java.util.List;

public class Mercado {

    private List<Produto> produtos;

    public Mercado() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        if (produto != null) {
            produtos.add(produto);
        }
    }

    public void removerProduto(Produto produto) {
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }

    public void setProdutos(List<Produto> produtos) {
        if (produtos != null) {
            this.produtos = new ArrayList<>(produtos);
        }
    }
}
