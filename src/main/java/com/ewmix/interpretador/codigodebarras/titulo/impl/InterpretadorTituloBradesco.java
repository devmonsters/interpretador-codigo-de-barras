package com.ewmix.interpretador.codigodebarras.titulo.impl;

import com.ewmix.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;

public class InterpretadorTituloBradesco extends AbstractInterpretadorTitulo {
    
    public InterpretadorTituloBradesco(final String codigoBarras) {
        super(codigoBarras);
    }
    
    @Override
    public String getNossoNumero() {
        return super.getCodigoBarras().substring(23, 36);
    }
    
    @Override
    public String getAgencia() {
        return super.getCodigoBarras().substring(19, 23);
    }
    
    @Override
    public String getContaCobranca() {
        return super.getCodigoBarras().substring(36, 43);
    }
    
    @Override
    public String getCodigoCarteira() {
        return super.getCodigoBarras().substring(23, 25);
    }
    
    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }
}