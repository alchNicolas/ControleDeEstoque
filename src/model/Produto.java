package model;

public class Produto {

    private final String nome ;
    private final double valor;
    private int quantidade;

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public Produto(String nome, double valor, int quantidade) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;

    }

    public void exibirProduto() {
        System.out.println("Nome: " + nome);
        System.out.println("Valor: " + valor);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("---------------------");
    }
}
