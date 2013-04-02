package com.ewmix.interpretador.codigodebarras;

public enum InstituicaoFinanceira {
    HSBC("399");

    private final String codigo;

    private InstituicaoFinanceira(final String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }
}