package dev.java10x.ProjetoDDD.domain.usuario;

public class criarcampanha {

    public criarcampanha() {
    }

    public Campanha criar(String id, String titulo, String descricao) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID da campanha não pode ser vazio");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título da campanha não pode ser vazio");
        }
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição da campanha não pode ser vazia");
        }

        return new Campanha(id, titulo, descricao);
    }

    public static class Campanha {
        private final String id;
        private final String titulo;
        private final String descricao;
        private boolean ativa;

        public Campanha(String id, String titulo, String descricao) {
            this.id = id;
            this.titulo = titulo;
            this.descricao = descricao;
            this.ativa = true;
        }

        public String getId() {
            return id;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getDescricao() {
            return descricao;
        }

        public boolean isAtiva() {
            return ativa;
        }

        public void encerrar() {
            this.ativa = false;
        }
    }
}
