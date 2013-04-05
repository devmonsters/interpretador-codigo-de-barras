package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;

public class InterpretadorTituloHsbc extends AbstractInterpretadorTitulo {

    public InterpretadorTituloHsbc(final String codigoBarras) {
        super(codigoBarras);
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoBarras().substring(19, 30);
    }

    @Override
    public String getAgencia() {
        return super.getCodigoBarras().substring(30, 34);
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoBarras().substring(34, 41);
    }

    @Override
    public String getCodigoCarteira() {
        return super.getCodigoBarras().substring(41, 43);
    }

    public String getCodigoAplicativoCobranca() {
        return super.getCodigoBarras().substring(43, 44);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return "1".equals(this.getCodigoAplicativoCobranca());
    }
}