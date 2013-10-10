package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorTituloBancoDoBrasilNossoNumero17PosicoesTest extends InterpretadorTituloTest {

    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.BANCO_DO_BRASIL;
    }

    @Test
    public void interpretarBoletoTeste() {
        final InterpretadorTituloBancoDoBrasilNossoNumero17Posicoes leitorBancoDoBrasil = new InterpretadorTituloBancoDoBrasilNossoNumero17Posicoes("00192433400003818174568230456823090000000821");
        Assert.assertEquals("00192433400003818174568230456823090000000821", leitorBancoDoBrasil.getCodigoDeBarras());
        Assert.assertEquals("001", leitorBancoDoBrasil.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorBancoDoBrasil.getMoeda());
        Assert.assertEquals(2, leitorBancoDoBrasil.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(4334, leitorBancoDoBrasil.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("3818.17"), leitorBancoDoBrasil.getValor());
        Assert.assertEquals("4568230456823090000000821", leitorBancoDoBrasil.getCampoLivre());
        Assert.assertNull(leitorBancoDoBrasil.getAgencia());
        Assert.assertEquals("04568230900000008", leitorBancoDoBrasil.getNossoNumero());
        Assert.assertEquals("456823", leitorBancoDoBrasil.getContaCobranca());
        Assert.assertEquals("21", leitorBancoDoBrasil.getCodigoCarteira());
        Assert.assertEquals("456823", leitorBancoDoBrasil.getNumeroConvenio());
        Assert.assertTrue(leitorBancoDoBrasil.isContaCobrancaRastreavel());
    }

    @Test
    public void boletoBancoDoBrasilOutroFormatoNaoEValido() {
        Assert.assertFalse(new InterpretadorTituloBancoDoBrasilNossoNumero17Posicoes("00196565100000658712657090008068809100000120").isValidoParaInterpretacao());
    }

    @Test
    public void boletoDeOutroBancoNaoEValido() {
        Assert.assertFalse(new InterpretadorTituloBancoDoBrasilNossoNumero17Posicoes("23796565100000658712657090008068809100000120").isValidoParaInterpretacao());
    }
}