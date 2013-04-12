package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloGenerico extends AbstractInterpretadorTitulo {
    
    private static final long serialVersionUID = 5427247970406977495L;
    
    public InterpretadorTituloGenerico(final String codigoDeBarras) {
        super(codigoDeBarras);
    }
    
    @Override
    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.GENERICO;
    }
    
    /**
     * Caso especial, somente sera valido caso nao exista a instituicao financeira implementada.
     */
    @Override
    public boolean isValidoParaInterpretacao() {
        for (final InstituicaoFinanceira instituicao : InstituicaoFinanceira.values()) {
            if (super.getCodigoDeBarras().startsWith(instituicao.getCodigo())) {
                return false;
            }
        }
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