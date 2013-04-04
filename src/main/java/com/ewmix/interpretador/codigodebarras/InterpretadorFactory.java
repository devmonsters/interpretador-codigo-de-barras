package com.ewmix.interpretador.codigodebarras;

import java.lang.reflect.Constructor;

public class InterpretadorFactory {

    public AbstractInterpretador getInterpretador(final String codigoDeBarras) throws Exception {
        if (!codigoDeBarras.matches("[0-9]{44}")) {
            throw new IllegalArgumentException("Um c\u00f3digo de barras deve possuir 44 d\u00edgitos.");
        }

        final InstituicaoFinanceira instituicaoFinanceira = InstituicaoFinanceira.valueOfCodigo(codigoDeBarras.substring(0, 3));
        final Class<?> classe = Class.forName(instituicaoFinanceira.getInterpretador().getName());
        final Constructor<?> construtor = classe.getConstructor(String.class);
        return (AbstractInterpretador) construtor.newInstance(codigoDeBarras);
    }
}