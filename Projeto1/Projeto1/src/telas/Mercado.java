package telas;

import java.util.ArrayList;

public class Mercado {
    private ArrayList<Produto> produtos;

    public Mercado() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto p) { // público
        produtos.add(p);
    }

    public void removerProduto(Produto p) { // público
        produtos.remove(p);
    }

    public ArrayList<Produto> getProdutos() { // público
        return produtos;
    }
}


