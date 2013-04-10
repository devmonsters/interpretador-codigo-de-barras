package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloItau extends AbstractInterpretadorTitulo {

    public InterpretadorTituloItau(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.ITAU;
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return super.getCodigoDeBarras().startsWith(this.getInstituicaoFinanceira().getCodigo());
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