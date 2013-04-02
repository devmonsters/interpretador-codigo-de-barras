package com.ewmix.interpretador.codigodebarras;

import com.ewmix.interpretador.codigodebarras.impl.InterpretadorHsbc;

public enum InstituicaoFinanceira {

    HSBC("399", InterpretadorHsbc.class);

    private final String codigo;
    private final Class<? extends Interpretador> interpretador;

    private InstituicaoFinanceira(final String codigo, final Class<? extends Interpretador> interpretador) {
        this.codigo = codigo;
        this.interpretador = interpretador;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public Class<? extends Interpretador> getInterpretador() {
        return this.interpretador;
    }

    public static InstituicaoFinanceira valueOfCodigo(String codigo) {
        for (InstituicaoFinanceira instituicaoFinanceira : values()) {
            if (instituicaoFinanceira.getCodigo().equals(codigo)) {
                return instituicaoFinanceira;
            }
        }
        return null;
    }
}