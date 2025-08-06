package controller;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoController {
    private List<Produto> produtos;

    public ProdutoController() {
        this.produtos = new ArrayList<>();
    }

    public void cadastrarProduto(String nome, double preco, String tipo) {
        produtos.add(new Produto(nome, preco, tipo));
        System.out.println("Produto cadastrado com sucesso!");
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}
