package com.devmonsters.interpretador.codigodebarras;

import com.devmonsters.interpretador.codigodebarras.arrecadacao.InterpretadorArrecadacao;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorFactory {

    public Interpretador getInterpretador(final String codigoDeBarrasOriginal) throws Exception {
        String codigoDeBarrasSanitizado = codigoDeBarrasOriginal;
        if (codigoDeBarrasSanitizado.matches("[0-9]{47}")) {
            codigoDeBarrasSanitizado = this.converteLinhaDigitavelEmCodigoDeBarras(codigoDeBarrasSanitizado);
        }

        //linha digitavel com digitos
        if (codigoDeBarrasSanitizado.matches("[0-9]{48}")) {
            codigoDeBarrasSanitizado = codigoDeBarrasSanitizado.substring(0, 11) + codigoDeBarrasSanitizado.substring(12, 23) + codigoDeBarrasSanitizado.substring(24, 35) + codigoDeBarrasSanitizado.substring(36, 47);
        }

        if (!codigoDeBarrasSanitizado.matches("[0-9]{44}")) {
            throw new IllegalArgumentException("Um c\u00f3digo de barras deve possuir 44 d\u00edgitos.");
        }

        // codigo de barras de arrecadacao
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao(codigoDeBarrasSanitizado);
        if (interpretadorArrecadacao.isValidoParaInterpretacao()) {
            return interpretadorArrecadacao;
        }

        // codigo de barras de boleto
        return InstituicaoFinanceira.valueOfCodigo(codigoDeBarrasSanitizado.substring(0, 3)).getInterpretadorCodigoDeBarras(codigoDeBarrasSanitizado);
    }

    private String converteLinhaDigitavelEmCodigoDeBarras(final String linhaDigitavel) {
        final StringBuilder codigoDeBarras = new StringBuilder();
        codigoDeBarras.append(linhaDigitavel, 0, 3); // 01-03 Identificação do banco (001 = Banco do Brasil)
        codigoDeBarras.append(linhaDigitavel, 3, 4); // 04 Código de moeda (9 = Real)
        codigoDeBarras.append(linhaDigitavel, 32, 35); // Fator de vencimento
        codigoDeBarras.append(linhaDigitavel.substring(35)); // Valor nominal do título
        codigoDeBarras.append(linhaDigitavel, 4, 9); // 5 primeiras posições do campo livre
        codigoDeBarras.append(linhaDigitavel, 10, 20); // 6ª a 15ª posições do campo livre
        codigoDeBarras.append(linhaDigitavel, 21, 30); // 16ª a 25ª posições do campo livre
        codigoDeBarras.append(linhaDigitavel, 30, 31); // Dígito verificador geral
        return codigoDeBarras.toString();
    }
}