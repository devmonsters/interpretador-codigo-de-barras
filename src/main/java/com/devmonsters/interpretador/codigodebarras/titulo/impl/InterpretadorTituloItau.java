package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;

public class InterpretadorTituloItau extends AbstractInterpretadorTitulo {

    public InterpretadorTituloItau(final String codigoBarras) {
        super(codigoBarras);
    }

    @Override
    public String getCodigoCarteira() {
        return super.getCodigoBarras().substring(19, 22);
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoBarras().substring(22, 30);
    }

    public int getDacAgenciaContaCarteiraNossoNumero() {
        return Integer.parseInt(super.getCodigoBarras().substring(30, 31));
    }

    @Override
    public String getAgencia() {
        return super.getCodigoBarras().substring(31, 35);
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoBarras().substring(35, 40);
    }

    public int getDacAgenciaConta() {
        return Integer.parseInt(super.getCodigoBarras().substring(40, 41));
    }

    public String getZeros() {
        return super.getCodigoBarras().substring(41, 44);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }
}