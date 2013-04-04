package com.ewmix.interpretador.codigodebarras.impl;

import com.ewmix.interpretador.codigodebarras.AbstractInterpretador;

public class InterpretadorGenerico extends AbstractInterpretador {

    public InterpretadorGenerico(final String codigoBarras) {
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