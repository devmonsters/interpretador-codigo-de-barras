package com.devmonsters.interpretador.codigodebarras;

import com.devmonsters.interpretador.codigodebarras.arrecadacao.InterpretadorArrecadacao;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorFactory {

    public Interpretador getInterpretador(final String codigoDeBarras) throws Exception {
        if (!codigoDeBarras.matches("[0-9]{44}")) {
            throw new IllegalArgumentException("Um c\u00f3digo de barras deve possuir 44 d\u00edgitos.");
        }

        // codigo de barras de arrecadacao
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao(codigoDeBarras);
        if (interpretadorArrecadacao.isValidoParaInterpretacao()) {
            return interpretadorArrecadacao;
        }

        // codigo de barras de boleto
        return InstituicaoFinanceira.valueOfCodigo(codigoDeBarras.substring(0, 3)).getInterpretadorCodigoDeBarras(codigoDeBarras);
    }
}