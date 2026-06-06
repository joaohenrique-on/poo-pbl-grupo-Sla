package dev.java10x.ProjetoDDD.domain.campanha;

public class cancelarcampanha {

    public void executar(Campanha campanha) {
        if (campanha == null) {
            throw new IllegalArgumentException("Campanha não pode ser nula");
        }
        campanha.encerrar();
    }

    public static class Campanha {
        private boolean ativa = true;

        public boolean isAtiva() {
            return ativa;
        }

        public void encerrar() {
            this.ativa = false;
        }
    }
}

