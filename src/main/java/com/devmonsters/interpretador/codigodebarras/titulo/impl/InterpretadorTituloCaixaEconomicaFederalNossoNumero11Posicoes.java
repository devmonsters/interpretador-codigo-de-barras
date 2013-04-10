package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes extends AbstractInterpretadorTitulo {

    public InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return super.getCodigoDeBarras().startsWith(this.getInstituicaoFinanceira().getCodigo());
    }

    @Override
    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.CAIXA_ECONOMICA_FEDERAL;
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(20, 29);
    }

    @Override
    public String getAgencia() {
        return super.getCodigoDeBarras().substring(29, 33);
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoDeBarras().substring(36, 44);
    }

    @Override
    public String getCodigoCarteira() {
        return super.getCodigoDeBarras().substring(19, 20);
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }

    public String getOperacao() {
        return super.getCodigoDeBarras().substring(33, 36);
    }
}