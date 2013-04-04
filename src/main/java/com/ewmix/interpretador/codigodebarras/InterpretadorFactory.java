package com.ewmix.interpretador.codigodebarras;

import java.lang.reflect.Constructor;

import com.ewmix.interpretador.codigodebarras.arrecadacao.InterpretadorArrecadacao;
import com.ewmix.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorFactory {

    public Interpretador getInterpretador(final String codigoDeBarras) throws Exception {
        if (!codigoDeBarras.matches("[0-9]{44}")) {
            throw new IllegalArgumentException("Um c\u00f3digo de barras deve possuir 44 d\u00edgitos.");
        }

        // codigo de barras de arrecadacao
        if (codigoDeBarras.startsWith("8")) {
            return new InterpretadorArrecadacao(codigoDeBarras);
        }

        // codigo de barras de boleto
        final InstituicaoFinanceira instituicaoFinanceira = InstituicaoFinanceira.valueOfCodigo(codigoDeBarras.substring(0, 3));
        final Class<?> classe = Class.forName(instituicaoFinanceira.getInterpretador().getName());
        final Constructor<?> construtor = classe.getConstructor(String.class);
        return (Interpretador) construtor.newInstance(codigoDeBarras);
    }
}