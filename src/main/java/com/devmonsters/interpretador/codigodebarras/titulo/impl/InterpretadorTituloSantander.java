package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloSantander extends InterpretadorTitulo {

    private static final long serialVersionUID = 1106429571338902413L;

    public InterpretadorTituloSantander(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return InstituicaoFinanceira.SANTANDER.equals(this.getInstituicaoFinanceira());
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(27, 40);
    }

    @Override
    public String getAgencia() {
        return null;
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoDeBarras().substring(20, 27);
    }

    @Override
    public String getCodigoCarteira() {
        return this.getCodigoDeBarras().substring(41, 44);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }

    public int getFixo() {
        return Integer.parseInt(super.getCodigoDeBarras().substring(19, 20));
    }

    public int getIOS() {
        return Integer.parseInt(super.getCodigoDeBarras().substring(40, 41));
    }
}