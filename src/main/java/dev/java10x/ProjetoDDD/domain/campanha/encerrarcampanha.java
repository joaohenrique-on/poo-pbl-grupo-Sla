package dev.java10x.ProjetoDDD.domain.campanha;

public class encerrarcampanha {

    public String executar(String nomeCampanha, boolean estavaAtiva) {
        if (nomeCampanha == null || nomeCampanha.isBlank()) {
            throw new IllegalArgumentException("Nome da campanha não pode ser vazio");
        }
        if (!estavaAtiva) {
            return "Campanha já estava encerrada";
        }
        return "Campanha '" + nomeCampanha + "' encerrada com sucesso";
    }
}

