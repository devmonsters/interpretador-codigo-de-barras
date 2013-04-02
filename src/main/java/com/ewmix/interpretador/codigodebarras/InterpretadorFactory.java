package com.ewmix.interpretador.codigodebarras;

import com.ewmix.interpretador.codigodebarras.impl.InterpretadorHsbc;

public class InterpretadorFactory {

    public Interpretador getInterpretador(final String codigoDeBarras) {
        if (codigoDeBarras.startsWith(InstituicaoFinanceira.HSBC.getCodigo())) {
            return new InterpretadorHsbc(codigoDeBarras);
        }
        return null;
    }
}