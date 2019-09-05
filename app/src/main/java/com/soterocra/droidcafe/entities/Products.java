package com.soterocra.droidcafe.entities;

public class Products {

    private String produto;
    private String descricao;
    private String valor;

    /**
     * No args constructor for use in serialization
     */
    public Products() {
    }

    /**
     * @param produto
     * @param valor
     * @param descricao
     */
    public Products(String produto, String descricao, String valor) {
        super();
        this.produto = produto;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

}