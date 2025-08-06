package controller;

import model.Pedido;
import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class PedidoController {
    private List<Pedido> pedidos;

    public PedidoController() {
        this.pedidos = new ArrayList<>();
    }

    public Pedido criarPedido() {
        Pedido novo = new Pedido();
        pedidos.add(novo);
        return novo;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
