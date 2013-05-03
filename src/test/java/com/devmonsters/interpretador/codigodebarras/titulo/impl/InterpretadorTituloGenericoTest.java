package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorTituloGenericoTest extends InterpretadorTituloTest {

    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.GENERICO;
    }

    @Test
    public void interpretarGenericoRetornaBancoGenericoQuandoNaoConsegueIndentificarTest() {
        final InterpretadorTitulo leitorGenerico = new InterpretadorTituloGenerico("66695567200001119002843306779912340123456001");
        Assert.assertEquals("66695567200001119002843306779912340123456001", leitorGenerico.getCodigoDeBarras());
        Assert.assertEquals("666", leitorGenerico.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorGenerico.getMoeda());
        Assert.assertEquals(5, leitorGenerico.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5672, leitorGenerico.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("1119.00"), leitorGenerico.getValor());
        Assert.assertNull(leitorGenerico.getNossoNumero());
        Assert.assertNull(leitorGenerico.getAgencia());
        Assert.assertNull(leitorGenerico.getContaCobranca());
        Assert.assertNull(leitorGenerico.getCodigoCarteira());
        Assert.assertFalse(leitorGenerico.isContaCobrancaRastreavel());
        Assert.assertEquals(InstituicaoFinanceira.GENERICO, leitorGenerico.getInstituicaoFinanceira());
    }

    @Test
    public void interpretarGenericoRetornaBancoEspecificoQuandoConsegueIndentificarTest() {
        final InterpretadorTitulo leitorGenerico = new InterpretadorTituloGenerico("39995567200001119002843306779912340123456001");
        Assert.assertEquals("39995567200001119002843306779912340123456001", leitorGenerico.getCodigoDeBarras());
        Assert.assertEquals("399", leitorGenerico.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorGenerico.getMoeda());
        Assert.assertEquals(5, leitorGenerico.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5672, leitorGenerico.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("1119.00"), leitorGenerico.getValor());
        Assert.assertNull(leitorGenerico.getNossoNumero());
        Assert.assertNull(leitorGenerico.getAgencia());
        Assert.assertNull(leitorGenerico.getContaCobranca());
        Assert.assertNull(leitorGenerico.getCodigoCarteira());
        Assert.assertFalse(leitorGenerico.isContaCobrancaRastreavel());
        Assert.assertEquals(InstituicaoFinanceira.HSBC, leitorGenerico.getInstituicaoFinanceira());
    }
}