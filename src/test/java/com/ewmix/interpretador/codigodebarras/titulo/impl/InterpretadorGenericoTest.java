package com.ewmix.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.ewmix.interpretador.codigodebarras.titulo.AbstractInterpretadorTitulo;
import com.ewmix.interpretador.codigodebarras.titulo.AbstractInterpretadorTituloTest;
import com.ewmix.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.ewmix.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorGenericoTest extends AbstractInterpretadorTituloTest {
    
    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.GENERICO;
    }
    
    @Test
    public void interpretarBoletoTeste() {
        final AbstractInterpretadorTitulo leitorGenerico = new InterpretadorTituloGenerico("39995567200001119002843306779912340123456001");
        Assert.assertEquals("39995567200001119002843306779912340123456001", leitorGenerico.getCodigoBarras());
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
    }
}