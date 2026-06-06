package dev.java10x.ProjetoDDD.domain.usuario;

public class receberrecompença {

    public receberrecompença() {
    }

    public Recompensa receber(String nomeUsuario, String nomeRecompensa) {
        if (nomeUsuario == null || nomeUsuario.isBlank()) {
            throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
        }
        if (nomeRecompensa == null || nomeRecompensa.isBlank()) {
            throw new IllegalArgumentException("Nome da recompensa não pode ser vazio");
        }

        return new Recompensa(nomeUsuario, nomeRecompensa, true);
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
