package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloCaixaEconomicaFederalNossoNumero16Posicoes extends AbstractInterpretadorTitulo {

    private static final String CONSTANTE = "87";

    public InterpretadorTituloCaixaEconomicaFederalNossoNumero16Posicoes(final String codigoDeBarras) {
        super(codigoDeBarras);
    }

    @Override
    public boolean isValidoParaInterpretacao() {
        return super.getCodigoDeBarras().startsWith(this.getInstituicaoFinanceira().getCodigo()) && InterpretadorTituloCaixaEconomicaFederalNossoNumero16Posicoes.CONSTANTE.equals(this.getConstante());
    }

    @Override
    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.CAIXA_ECONOMICA_FEDERAL;
    }

    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(30, 44);
    }

    @Override
    public String getAgencia() {
        return super.getCodigoDeBarras().substring(24, 28);
    }

    @Override
    public String getContaCobranca() {
        return super.getCodigoDeBarras().substring(19, 24);
    }

    @Override
    public String getCodigoCarteira() {
        return null;
    }

    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }

    public String getConstante() {
        return super.getCodigoDeBarras().substring(28, 30);
    }
}