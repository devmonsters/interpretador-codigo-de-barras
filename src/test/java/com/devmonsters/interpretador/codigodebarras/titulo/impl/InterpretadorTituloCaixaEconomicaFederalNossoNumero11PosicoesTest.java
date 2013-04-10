package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTituloTest;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorTituloCaixaEconomicaFederalNossoNumero11PosicoesTest extends AbstractInterpretadorTituloTest {

    @Override
    protected String getCodigoInstituicaoFinanceira() {
        return InstituicaoFinanceira.CAIXA_ECONOMICA_FEDERAL.getCodigo();
    }

    @Test
    public void tituloDeOutroBancoNaoEValido() {
        Assert.assertFalse(new InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes("03391569400000842649123456772000010239510102").isValidoParaInterpretacao());
    }

    @Test
    public void interpretarBoletoTesteCarteiraRapida() {
        final InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes leitorCEF = new InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes("10493567800000380009000004369025500300012340");
        Assert.assertEquals("10493567800000380009000004369025500300012340", leitorCEF.getCodigoDeBarras());
        Assert.assertEquals("104", leitorCEF.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorCEF.getMoeda());
        Assert.assertEquals(3, leitorCEF.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5678, leitorCEF.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("380.00"), leitorCEF.getValor());
        Assert.assertEquals("9000004369025500300012340", leitorCEF.getCampoLivre());

        Assert.assertEquals("9", leitorCEF.getCodigoCarteira());
        Assert.assertEquals("000004369", leitorCEF.getNossoNumero());
        Assert.assertEquals("0255", leitorCEF.getAgencia());
        Assert.assertEquals("003", leitorCEF.getOperacao());
        Assert.assertEquals("00012340", leitorCEF.getContaCobranca());
        Assert.assertTrue(leitorCEF.isContaCobrancaRastreavel());
    }

    @Test
    public void interpretarBoletoTesteCarteiraSemRegistro() {
        final InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes leitorCEF = new InterpretadorTituloCaixaEconomicaFederalNossoNumero11Posicoes("10492563800001113838210881967099600312345678");
        Assert.assertEquals("10492563800001113838210881967099600312345678", leitorCEF.getCodigoDeBarras());
        Assert.assertEquals("104", leitorCEF.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorCEF.getMoeda());
        Assert.assertEquals(2, leitorCEF.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5638, leitorCEF.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("1113.83"), leitorCEF.getValor());
        Assert.assertEquals("8210881967099600312345678", leitorCEF.getCampoLivre());

        Assert.assertEquals("82", leitorCEF.getCodigoCarteira());
        Assert.assertEquals("10881967", leitorCEF.getNossoNumero());
        Assert.assertEquals("0996", leitorCEF.getAgencia());
        Assert.assertEquals("003", leitorCEF.getOperacao());
        Assert.assertEquals("12345678", leitorCEF.getContaCobranca());
        Assert.assertTrue(leitorCEF.isContaCobrancaRastreavel());
    }
}