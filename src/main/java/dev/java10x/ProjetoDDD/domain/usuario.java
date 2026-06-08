package dev.java10x.ProjetoDDD.domain;

public class Usuario {

    private final String id;
    private String nome;

    public Usuario(String id, String nome) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID do usuário não pode ser vazio");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }
        this.id = id;
        this.nome = nome;
    }

    // Métodos manuais que o VS Code lê sem precisar da extensão ativa
    public String getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Doacao realizarDoacao(Campanha campanha, double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido");
        }

        Doacao doacao = new Doacao(this, valor);
        campanha.receberdoacao(doacao);

        return doacao;
    }
}
