package dev.java10x.ProjetoDDD.domain;

public class Recompensa {

    private final String id;
    private final String nome;
    private final double valorMinimo;

    public Recompensa(String id, String nome, double valorMinimo) {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID inválido");
        }

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome inválido");
        }

        if (valorMinimo <= 0) {
            throw new IllegalArgumentException("Valor mínimo inválido");
        }

        this.id = id;
        this.nome = nome;
        this.valorMinimo = valorMinimo;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public boolean verificar(double valorDoado) {
        return valorDoado >= valorMinimo;
    }
}