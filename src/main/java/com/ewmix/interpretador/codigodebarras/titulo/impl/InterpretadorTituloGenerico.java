package com.ewmix.interpretador.codigodebarras.titulo.impl;

import com.ewmix.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;

public class InterpretadorTituloGenerico extends AbstractInterpretadorTitulo {

    public InterpretadorTituloGenerico(final String codigoBarras) {
        super(codigoBarras);
    }

    @Override
    public String getNossoNumero() {
        return null;
    }

    @Override
    public String getAgencia() {
        return null;
    }

    @Override
    public String getContaCobranca() {
        return null;
    }

    @Override
    public String getCodigoCarteira() {
        return null;
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return false;
    }
}