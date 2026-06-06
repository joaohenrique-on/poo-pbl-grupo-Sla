package dev.java10x.ProjetoDDD.domain.usuario;

public class realizardoaçao {

    public realizardoaçao() {
    }

    public Doacao doar(String nomeDoador, double valor) {
        if (nomeDoador == null || nomeDoador.isBlank()) {
            throw new IllegalArgumentException("Nome do doador não pode ser vazio");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da doação deve ser maior que zero");
        }

        return new Doacao(nomeDoador, valor);
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
}
