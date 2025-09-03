package Modelos;

import java.sql.Timestamp;

public class Compra {
    private int id;
    private int usuarioId;
    private String produtoNome;
    private double produtoPreco;
    private int quantidade;
    private Timestamp dataCompra;
    
    public Compra(int id, int usuarioId, String produtoNome, double produtoPreco, int quantidade, Timestamp dataCompra) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.produtoNome = produtoNome;
        this.produtoPreco = produtoPreco;
        this.quantidade = quantidade;
        this.dataCompra = dataCompra;
    }

    // Getters
    public int getId() { return id; }
    public int getUsuarioId() { return usuarioId; }
    public String getProdutoNome() { return produtoNome; }
    public double getProdutoPreco() { return produtoPreco; }
    public int getQuantidade() { return quantidade; }
    public Timestamp getDataCompra() { return dataCompra; }
}
