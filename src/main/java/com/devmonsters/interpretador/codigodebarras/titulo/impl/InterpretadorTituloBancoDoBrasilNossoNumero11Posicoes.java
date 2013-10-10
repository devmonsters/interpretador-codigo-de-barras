package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloBancoDoBrasilNossoNumero11Posicoes extends InterpretadorTitulo {

    private static final long serialVersionUID = -3527598342657604683L;

    public InterpretadorTituloBancoDoBrasilNossoNumero11Posicoes(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return InstituicaoFinanceira.BANCO_DO_BRASIL.equals(this.getInstituicaoFinanceira()) && !this.getCodigoDeBarras().endsWith("21") && !this.getCodigoDeBarras().substring(19, 25).equals("000000");
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(19, 30);
    }

    @Override
    public String getAgencia() {
        return super.getCodigoDeBarras().substring(30, 34);
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoDeBarras().substring(34, 42);
    }

    @Override
    public String getCodigoCarteira() {
        return super.getCodigoDeBarras().substring(43, 44);
    }

    public String getNumeroConvenio() {
        return super.getCodigoDeBarras().substring(19, 23);
    }

    public String getComplementoNossoNumero() {
        return super.getCodigoDeBarras().substring(23, 30);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }
}
