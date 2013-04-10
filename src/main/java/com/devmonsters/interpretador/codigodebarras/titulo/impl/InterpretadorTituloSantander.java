package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;

public class InterpretadorTituloSantander extends AbstractInterpretadorTitulo {

    public InterpretadorTituloSantander(final String codigoBarras) {
        super(codigoBarras);
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoBarras().substring(27, 40);
    }

    @Override
    public String getAgencia() {
        return null;
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoBarras().substring(20, 27);
    }

    @Override
    public String getCodigoCarteira() {
        return this.getCodigoBarras().substring(41, 44);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }

    public int getFixo() {
        return Integer.parseInt(super.getCodigoBarras().substring(19, 20));
    }

    public int getIOS() {
        return Integer.parseInt(super.getCodigoBarras().substring(40, 41));
    }
}