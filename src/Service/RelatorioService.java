package service;

import model.Pedido;

import java.util.List;

public class RelatorioService {
    public static void gerarRelatorio(List<Pedido> pedidos) {
        System.out.println("\n===== RELATÓRIO DE PEDIDOS =====");
        double totalGeral = 0;
        int count = 1;
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido #" + count++);
            pedido.getItens().forEach(System.out::println);
            double total = pedido.calcularTotal();
            totalGeral += total;
            System.out.println("Total: R$" + total + "\n");
        }
        System.out.println("Total Geral de Vendas: R$" + totalGeral);
    }
}
