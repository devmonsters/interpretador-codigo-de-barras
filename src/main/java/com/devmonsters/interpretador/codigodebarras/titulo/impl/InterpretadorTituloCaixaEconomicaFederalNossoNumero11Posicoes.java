package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

public class InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes extends AbstractInterpretadorTitulo {
    
    private static final long serialVersionUID = 4352222547232783629L;
    private static final String CODIGO_CARTEIRA_RAPIDA = "9";
    private static final String CODIGO_CARTEIRA_SEM_REGISTRO = "82";
    
    public InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes(final String codigoDeBarras) {
        super(codigoDeBarras);
    }
    
    @Override
    public boolean isValidoParaInterpretacao() {
        return super.getCodigoDeBarras().startsWith(this.getInstituicaoFinanceira().getCodigo()) && (InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes.CODIGO_CARTEIRA_RAPIDA.equals(this.getCodigoCarteira()) || InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes.CODIGO_CARTEIRA_SEM_REGISTRO.equals(this.getCodigoCarteira()));
    }
    
    @Override
    public InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.CAIXA_ECONOMICA_FEDERAL;
    }
    
    @Override
    public String getNossoNumero() {
        return super.getCodigoDeBarras().substring(InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes.CODIGO_CARTEIRA_SEM_REGISTRO.equals(this.getCodigoCarteira()) ? 21 : 20, 29);
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
        if (InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes.CODIGO_CARTEIRA_RAPIDA.equals(super.getCodigoDeBarras().substring(19, 20))) {
            return InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes.CODIGO_CARTEIRA_RAPIDA;
        }
        return super.getCodigoDeBarras().substring(19, 21);
    }
    
    @Override
    public boolean isContaCobrancaRastreavel() {
        return true;
    }
    
    public String getOperacao() {
        return super.getCodigoDeBarras().substring(33, 36);
    }
}