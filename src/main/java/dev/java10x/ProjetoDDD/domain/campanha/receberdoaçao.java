package dev.java10x.ProjetoDDD.domain.campanha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class receberdoaçao {

    private final String campanhaId;
    private final String campanhaNome;
    private boolean ativa;
    private double totalRecebido;
    private final List<Doacao> doacoes = new ArrayList<>();

    public receberdoaçao(String campanhaId, String campanhaNome) {
        if (campanhaId == null || campanhaId.isBlank()) {
            throw new IllegalArgumentException("ID da campanha não pode ser vazio");
        }
        if (campanhaNome == null || campanhaNome.isBlank()) {
            throw new IllegalArgumentException("Nome da campanha não pode ser vazio");
        }
        this.campanhaId = campanhaId;
        this.campanhaNome = campanhaNome;
        this.ativa = true;
        this.totalRecebido = 0.0;
    }

    public void receber(String nomeDoador, double valor) {
        if (nomeDoador == null || nomeDoador.isBlank()) {
            throw new IllegalArgumentException("Nome do doador não pode ser vazio");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da doação deve ser maior que zero");
        }
        if (!ativa) {
            throw new IllegalStateException("Campanha inativa não pode receber doações");
        }

        Doacao doacao = new Doacao(nomeDoador, valor);
        doacoes.add(doacao);
        totalRecebido += valor;
    }

    public List<Doacao> listarDoacoes() {
        return Collections.unmodifiableList(doacoes);
    }

    public double getTotalRecebido() {
        return totalRecebido;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void encerrarCampanha() {
        this.ativa = false;
    }

    public String getCampanhaId() {
        return campanhaId;
    }

    public String getCampanhaNome() {
        return campanhaNome;
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
