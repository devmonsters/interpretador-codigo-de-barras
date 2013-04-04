package com.ewmix.interpretador.codigodebarras;

public enum TipoDocumento {

    TITULO("T\u00edtulo"),
    ARRECADACAO("Arrecada\u00e7\u00e3o");

    private final String descricao;

    private TipoDocumento(final String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}