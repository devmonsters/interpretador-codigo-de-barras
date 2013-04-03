package com.ewmix.interpretador.codigodebarras;

import java.lang.reflect.Constructor;

public class InterpretadorFactory {

    public Interpretador getInterpretador(final String codigoDeBarras) throws Exception {
        for (InstituicaoFinanceira instituicaoFinanceira : InstituicaoFinanceira.values()) {
            if (codigoDeBarras.startsWith(instituicaoFinanceira.getCodigo())) {
                Class<?> classe = Class.forName(instituicaoFinanceira.getInterpretador().getName());
                Constructor<?> construtor = classe.getConstructor(String.class);
                return (Interpretador) construtor.newInstance(codigoDeBarras);
            }
        }
        return null;
    }
}