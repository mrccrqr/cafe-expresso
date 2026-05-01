package cafeexpresso;

public class Produto {

    private String nome;
    private double precoUnitario;

    public Produto(String nome, double precoUnitario) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto nao pode ser vazio.");
        }
        if (precoUnitario <= 0) {
            throw new IllegalArgumentException("Preco deve ser maior que zero.");
        }
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }
}