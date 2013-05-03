package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloItau extends InterpretadorTitulo {

    private static final long serialVersionUID = 1149029518526291480L;

    public InterpretadorTituloItau(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return InstituicaoFinanceira.ITAU.equals(this.getInstituicaoFinanceira());
    }

    @Override
    public String getCodigoCarteira() {
        return super.getCodigoDeBarras().substring(19, 22);
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(22, 30);
    }

    public int getDacAgenciaContaCarteiraNossoNumero() {
        return Integer.parseInt(super.getCodigoDeBarras().substring(30, 31));
    }

    @Override
    public String getAgencia() {
        return super.getCodigoDeBarras().substring(31, 35);
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoDeBarras().substring(35, 40);
    }

    public int getDacAgenciaConta() {
        return Integer.parseInt(super.getCodigoDeBarras().substring(40, 41));
    }

    public String getZeros() {
        return super.getCodigoDeBarras().substring(41, 44);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }
}