package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloHsbc extends AbstractInterpretadorTitulo {
    
    private static final long serialVersionUID = -8952645125625675145L;
    
    public InterpretadorTituloHsbc(final String codigoDeBarras) {
        super(codigoDeBarras);
    }
    
    @Override
    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.HSBC;
    }
    
    @Override
    public boolean isValidoParaInterpretacao() {
        return super.getCodigoDeBarras().startsWith(this.getInstituicaoFinanceira().getCodigo());
    }
    
    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(19, 30);
    }
    
    @Override
    public String getAgencia() {
        return super.getCodigoDeBarras().substring(30, 34);
    }
    
    @Override
    public String getContaCobranca() {
        return super.getCodigoDeBarras().substring(34, 41);
    }
    
    @Override
    public String getCodigoCarteira() {
        return super.getCodigoDeBarras().substring(41, 43);
    }
    
    public String getCodigoAplicativoCobranca() {
        return super.getCodigoDeBarras().substring(43, 44);
    }
    
    @Override
    public boolean isContaCobrancaRastreavel() {
        return "1".equals(this.getCodigoAplicativoCobranca());
    }
}