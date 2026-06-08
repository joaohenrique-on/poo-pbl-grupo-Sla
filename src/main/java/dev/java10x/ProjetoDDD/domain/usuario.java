package dev.java10x.ProjetoDDD.domain;

public class Usuario {

    private final String id;

    public Usuario(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID do usuário não pode ser vazio");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Campanha criarCampanha(String id, String titulo, String descricao) {
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

    public Doacao realizarDoacao(String nomeDoador, double valor) {
        if (nomeDoador == null || nomeDoador.isBlank()) {
            throw new IllegalArgumentException("Nome do doador não pode ser vazio");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da doação deve ser maior que zero");
        }
        return new Doacao(nomeDoador, valor);
    }

    public Recompensa receberRecompensa(String nomeUsuario, String nomeRecompensa) {
        if (nomeUsuario == null || nomeUsuario.isBlank()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }
        if (nomeRecompensa == null || nomeRecompensa.isBlank()) {
            throw new IllegalArgumentException("Nome da recompensa não pode ser vazio");
        }
        return new Recompensa(nomeUsuario, nomeRecompensa, true);
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
            ativa = false;
        }
    }

    public static class Doacao {
        private final String doador;
        private final double valor;
        private final String dataHora;

        public Doacao(String doador, double valor) {
            this.doador = doador;
            this.valor = valor;
            this.dataHora = java.time.LocalDateTime.now().toString();
        }

        public String getDoador() {
            return doador;
        }

        public double getValor() {
            return valor;
        }

        public String getDataHora() {
            return dataHora;
        }
    }

    public static class Recompensa {
        private final String usuario;
        private final String recompensa;
        private final boolean entregue;

        public Recompensa(String usuario, String recompensa, boolean entregue) {
            this.usuario = usuario;
            this.recompensa = recompensa;
            this.entregue = entregue;
        }

        public String getUsuario() {
            return usuario;
        }

        public String getRecompensa() {
            return recompensa;
        }

        public boolean isEntregue() {
            return entregue;
        }
    }
}
