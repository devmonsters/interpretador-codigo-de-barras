package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;


public class InterpretadorTituloBancoDoBrasilNossoNumero11Posicoes extends AbstractInterpretadorTitulo {

    private static final long serialVersionUID = -3527598342657604683L;

    public InterpretadorTituloBancoDoBrasilNossoNumero11Posicoes(String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.BANCO_DO_BRASIL;
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
        return super.getCodigoDeBarras().substring(34, 42);
    }

    @Override
    public String getCodigoCarteira() {
        return super.getCodigoDeBarras().substring(43, 44);
    }

    public String getNumeroConvenio() {
        return super.getCodigoDeBarras().substring(19, 23);
    }

    public String getComplementoNossoNumero(){
        return super.getCodigoDeBarras().substring(23, 30);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }
}
