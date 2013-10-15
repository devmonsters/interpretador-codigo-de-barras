package com.devmonsters.interpretador.codigodebarras;

import com.devmonsters.interpretador.codigodebarras.arrecadacao.InterpretadorArrecadacao;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorFactory {

    public Interpretador getInterpretador(String codigoDeBarras) throws Exception {
        if (codigoDeBarras.matches("[0-9]{47}")) {
            codigoDeBarras = this.converteLinhaDigitavelEmCodigoDeBarras(codigoDeBarras);
        }

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

    private String converteLinhaDigitavelEmCodigoDeBarras(final String linhaDigitavel) {
        final StringBuilder codigoDeBarras = new StringBuilder();
        codigoDeBarras.append(linhaDigitavel.substring(0, 3)); // 01-03 Identificação do banco (001 = Banco do Brasil)
        codigoDeBarras.append(linhaDigitavel.substring(3, 4)); // 04 Código de moeda (9 = Real)
        codigoDeBarras.append(linhaDigitavel.substring(32, 35)); // Fator de vencimento
        codigoDeBarras.append(linhaDigitavel.substring(35)); // Valor nominal do título
        codigoDeBarras.append(linhaDigitavel.substring(4, 9)); // 5 primeiras posições do campo livre
        codigoDeBarras.append(linhaDigitavel.substring(10, 20)); // 6ª a 15ª posições do campo livre
        codigoDeBarras.append(linhaDigitavel.substring(21, 30)); // 16ª a 25ª posições do campo livre
        codigoDeBarras.append(linhaDigitavel.substring(30, 31)); // Dígito verificador geral
        return codigoDeBarras.toString();
    }
}