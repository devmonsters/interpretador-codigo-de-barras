package com.devmonsters.interpretador.codigodebarras.titulo.impl;

public class InterpretadorTituloGenerico extends InterpretadorTitulo {

    private static final long serialVersionUID = 5427247970406977495L;

    public InterpretadorTituloGenerico(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return true;
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