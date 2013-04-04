package com.ewmix.interpretador.codigodebarras.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.ewmix.interpretador.codigodebarras.AbstractInterpretador;
import com.ewmix.interpretador.codigodebarras.AbstractInterpretadorTest;
import com.ewmix.interpretador.codigodebarras.InstituicaoFinanceira;

public class InterpretadorGenericoTest extends AbstractInterpretadorTest {

    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.GENERICO;
    }

    @Test
    public void interpretarBoletoTeste() {
        final AbstractInterpretador leitorGenerico = new InterpretadorGenerico("39995567200001119002843306779912340123456001");
        Assert.assertEquals("39995567200001119002843306779912340123456001", leitorGenerico.getCodigoBarras());
        Assert.assertEquals("399", leitorGenerico.getBanco());
        Assert.assertEquals(9, leitorGenerico.getMoeda());
        Assert.assertEquals(5, leitorGenerico.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5672, leitorGenerico.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("1119.00"), leitorGenerico.getValor());
        Assert.assertNull(leitorGenerico.getNossoNumero());
        Assert.assertNull(leitorGenerico.getAgencia());
        Assert.assertNull(leitorGenerico.getContaCobranca());
        Assert.assertNull(leitorGenerico.getCodigoCarteira());
        Assert.assertFalse(leitorGenerico.isContaCobrancaRastreavel());
    }
}