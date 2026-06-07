package dev.java10x.ProjetoDDD.domain;

import lombok.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class campanha {

    private final @Getter String campanhaId;
    private @Getter @Setter String campanhaNome;
    private @Getter @Setter boolean ativa;
    private @Getter @Setter double objetivo;
    private @Getter @Setter double totalRecebido;
    private final List<Doacao> doacoes = new ArrayList<>();

    public campanha(String campanhaId, String campanhaNome, double objetivo) {
        if (campanhaId == null || campanhaId.isBlank()) {
            throw new IllegalArgumentException("ID da campanha não pode ser vazio");
        }
        if (campanhaNome == null || campanhaNome.isBlank()) {
            throw new IllegalArgumentException("Nome da campanha não pode ser vazio");
        }
        this.campanhaId = campanhaId;
        this.campanhaNome = campanhaNome;
        this.objetivo = objetivo;
        this.ativa = true;
        this.totalRecebido = 0.0;
    }

    public void abrirCampanha() {
        ativa = true;
    }

    public void fecharCampanha() {
        ativa = false;
    }

    public String encerrarCampanha(String nomeCampanha, boolean estaAtiva) {
        if (nomeCampanha == null || nomeCampanha.isBlank()) {
            throw new IllegalArgumentException("Nome da campanha não pode ser vazio");
        }
        if (!estaAtiva) {
            return "Campanha já estava encerrada";
        } else {
            fecharCampanha();
            return "Campanha '" + nomeCampanha + "' encerrada com sucesso";
        }
    }

    public String bateuMeta(double totalRecebido, double objetivo) {
        if (totalRecebido >= objetivo) {
            return "Meta atingida";
        } else {
            return "Meta ainda não foi atingida";
        }
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
        } else {
            Doacao doacao = new Doacao(nomeDoador, valor);
            doacoes.add(doacao);
            totalRecebido += valor;
        }
    }

    public void receber(double valor) {
        receber("Doador anônimo", valor);
    }

    public List<Doacao> listarDoacoes() {
        return Collections.unmodifiableList(doacoes);
    }

    public String statusCampanha(boolean ativa) {
        if (ativa) {
            return "Ativa";
        } else {
            return "Inativa";
        }
    }

    public String statusCampanha() {
        return statusCampanha(this.ativa);
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
