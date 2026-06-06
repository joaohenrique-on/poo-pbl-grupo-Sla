package dev.java10x.ProjetoDDD.domain.campanha;

public class statusdacampanha {

    public String verificar(boolean ativa) {
        return ativa ? "Ativa" : "Inativa";
    }
}

