package com.ewmix.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.ewmix.interpretador.codigodebarras.titulo.AbstractInterpretadorTituloTest;
import com.ewmix.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.ewmix.interpretador.codigodebarras.titulo.impl.InterpretadorTituloHsbc;

public class InterpretadorHsbcTest extends AbstractInterpretadorTituloTest {

    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.HSBC;
    }

    @Test
    public void interpretarBoletoTesteApp1Rastreavel() {
        final InterpretadorTituloHsbc leitorHsbc = new InterpretadorTituloHsbc("39995567200001119002843306779912340123456001");
        Assert.assertEquals("39995567200001119002843306779912340123456001", leitorHsbc.getCodigoBarras());
        Assert.assertEquals("399", leitorHsbc.getBanco());
        Assert.assertEquals(9, leitorHsbc.getMoeda());
        Assert.assertEquals(5, leitorHsbc.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5672, leitorHsbc.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("1119.00"), leitorHsbc.getValor());
        Assert.assertEquals("28433067799", leitorHsbc.getNossoNumero());
        Assert.assertEquals("1234", leitorHsbc.getAgencia());
        Assert.assertEquals("0123456", leitorHsbc.getContaCobranca());
        Assert.assertEquals("00", leitorHsbc.getCodigoCarteira());
        Assert.assertEquals("1", leitorHsbc.getCodigoAplicativoCobranca());
        Assert.assertTrue(leitorHsbc.isContaCobrancaRastreavel());
    }

    @Test
    public void interpretarBoletoTesteApp2NaoRastreavel() {
        final InterpretadorTituloHsbc leitorHsbc = new InterpretadorTituloHsbc("39995567200001119002843306779912340123456002");
        Assert.assertEquals("39995567200001119002843306779912340123456002", leitorHsbc.getCodigoBarras());
        Assert.assertEquals("399", leitorHsbc.getBanco());
        Assert.assertEquals(9, leitorHsbc.getMoeda());
        Assert.assertEquals(5, leitorHsbc.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5672, leitorHsbc.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("1119.00"), leitorHsbc.getValor());
        Assert.assertEquals("28433067799", leitorHsbc.getNossoNumero());
        Assert.assertEquals("1234", leitorHsbc.getAgencia());
        Assert.assertEquals("0123456", leitorHsbc.getContaCobranca());
        Assert.assertEquals("00", leitorHsbc.getCodigoCarteira());
        Assert.assertEquals("2", leitorHsbc.getCodigoAplicativoCobranca());
        Assert.assertFalse(leitorHsbc.isContaCobrancaRastreavel());
    }
}