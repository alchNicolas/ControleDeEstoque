package app;

import model.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[10];
        int qtdProdutos = 0;
        int opcao = 0;

        String menu = """
                Sistema controle de estoque
                
                1- Cadastrar produto
                2- Listar produtos
                3- Atualizar quantidade
                4- Remover produto
                5- sair
                """;

        while (opcao != 5) {
            System.out.println(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Nome do produto:");
                    String nome = scanner.nextLine();

                    System.out.println("Preço:");
                    double preco = scanner.nextDouble();

                    System.out.println("Quantidade:");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (qtdProdutos < produtos.length) {
                        produtos[qtdProdutos] = new Produto(nome, preco, quantidade);
                        qtdProdutos++;
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Limite de produtos atingido!");
                    }
                    break;

                case 2:
                    if (qtdProdutos == 0) {
                        System.out.println("Não há produtos em estoque");
                    } else {
                        System.out.println("=== LISTA DE PRODUTOS ===");
                        for (int i = 0; i < qtdProdutos; i++) {
                            produtos[i].exibirProduto();
                        }
                    }
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.println("Qual produto que deseja atualizar quantidade:");
                    String nomeBusca = scanner.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < qtdProdutos; i++) {

                        if (produtos[i].getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Produto encontrado: ");
                            produtos[i].exibirProduto();

                            System.out.println("Nova quantidade: ");
                            int novaQuantidade = scanner.nextInt();
                            scanner.nextLine();

                            produtos[i].setQuantidade(novaQuantidade);
                            System.out.println("Quantidade atualizada com sucesso");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.println("Qual produto deseja remover?");
                    String nomeRemove = scanner.nextLine();

                    boolean localizado = false;

                    for (int i = 0; i < qtdProdutos; i++) {

                        if (produtos[i].getNome().equalsIgnoreCase(nomeRemove)) {
                            System.out.println("Produto encontrado: ");
                            produtos[i].exibirProduto();

                            System.out.println("Confirma exclusão do produto? (Sim/Nao)");
                            String confirm = scanner.nextLine();
                            if (confirm.equalsIgnoreCase("sim")) {
                                for (int j = i; j < qtdProdutos - 1; j++) {
                                    produtos[j] = produtos[j + 1];
                                }

                                produtos[qtdProdutos - 1] = null; // limpa última posição
                                qtdProdutos--;
                                System.out.println("Produto excluido do estoque!");
                            }
                                localizado = true;

                    }
                }

                    if (!localizado) {
                        System.out.println("Produto não encontrado");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente");
            }
        }
    }
}
