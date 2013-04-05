package com.ewmix.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.ewmix.interpretador.codigodebarras.titulo.AbstractInterpretadorTituloTest;
import com.ewmix.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.ewmix.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorBradescoTest extends AbstractInterpretadorTituloTest {
    
    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.BRADESCO;
    }
    
    @Test
    public void interpretarBoletoTeste() {
        final InterpretadorTituloBradesco leitorBradesco = new InterpretadorTituloBradesco("23796565100000658712657090008068809100000120");
        Assert.assertEquals("23796565100000658712657090008068809100000120", leitorBradesco.getCodigoBarras());
        Assert.assertEquals("237", leitorBradesco.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorBradesco.getMoeda());
        Assert.assertEquals(6, leitorBradesco.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(new BigDecimal("658.71"), leitorBradesco.getValor());
        Assert.assertEquals("2657090008068809100000120", leitorBradesco.getCampoLivre());
        
        Assert.assertEquals(5651, leitorBradesco.getFatorVencimento());
        Assert.assertEquals("2657", leitorBradesco.getAgencia());
        Assert.assertEquals("0900080688091", leitorBradesco.getNossoNumero());
        
        Assert.assertEquals("0000012", leitorBradesco.getContaCobranca());
        
        Assert.assertEquals("09", leitorBradesco.getCodigoCarteira());
        Assert.assertTrue(leitorBradesco.isContaCobrancaRastreavel());
    }
}