package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloBancoDoBrasilNossoNumero17Posicoes extends InterpretadorTitulo {

    private static final long serialVersionUID = -3527598342657604683L;

    public InterpretadorTituloBancoDoBrasilNossoNumero17Posicoes(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return InstituicaoFinanceira.BANCO_DO_BRASIL.equals(this.getInstituicaoFinanceira());
    }

    public String getZeros() {
        return super.getCodigoDeBarras().substring(19, 25);
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(25, 42);
    }

    public String getNumeroConvenio() {
        return super.getCodigoDeBarras().substring(25, 32);
    }

    public String getComplementoNossoNumero() {
        return super.getCodigoDeBarras().substring(32, 42);
    }

    @Override
    public String getCodigoCarteira() {
        return super.getCodigoDeBarras().substring(43, 44);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }

    @Override
    public String getAgencia() {
        return null;
    }

    @Override
    public String getContaCobranca() {
        return null;
    }
}
