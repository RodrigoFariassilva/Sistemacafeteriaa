import controller.PedidoController;
import controller.ProdutoController;
import model.Pedido;
import model.Produto;
import service.RelatorioService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProdutoController produtoController = new ProdutoController();
        PedidoController pedidoController = new PedidoController();
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando) {
            System.out.println("\n==== CAFETERIA MENU ====");
            System.out.println("1. Cadastrar produto");
            System.out.println("2. Listar produtos");
            System.out.println("3. Criar pedido");
            System.out.println("4. Gerar relatório de pedidos");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Tipo (bebida, comida...): ");
                    String tipo = scanner.nextLine();
                    produtoController.cadastrarProduto(nome, preco, tipo);
                    break;

                case 2:
                    System.out.println("\n--- Produtos Disponíveis ---");
                    int i = 1;
                    for (Produto p : produtoController.listarProdutos()) {
                        System.out.println(i++ + ". " + p);
                    }
                    break;

                case 3:
                    Pedido pedido = pedidoController.criarPedido();
                    boolean adicionando = true;
                    while (adicionando) {
                        System.out.println("\nEscolha um produto para adicionar:");
                        int j = 1;
                        for (Produto p : produtoController.listarProdutos()) {
                            System.out.println(j++ + ". " + p);
                        }
                        System.out.println("0. Finalizar pedido");
                        int escolha = scanner.nextInt();
                        if (escolha == 0) {
                            adicionando = false;
                        } else {
                            Produto selecionado = produtoController.listarProdutos().get(escolha - 1);
                            System.out.print("Quantidade: ");
                            int qtd = scanner.nextInt();
                            pedido.adicionarItem(selecionado, qtd);
                        }
                    }
                    System.out.println("Pedido finalizado. Total: R$" + pedido.calcularTotal());
                    break;

                case 4:
                    RelatorioService.gerarRelatorio(pedidoController.getPedidos());
                    break;

                case 0:
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }

        scanner.close();
        System.out.println("Sistema encerrado.");
    }
}
