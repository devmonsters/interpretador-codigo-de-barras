package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorTituloBancoDoBrasilConvenio7PosicoesTest extends InterpretadorTituloTest {

    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.BANCO_DO_BRASIL;
    }

    @Test
    public void interpretarBoletoTeste() {
        final InterpretadorTituloBancoDoBrasilConvenio7Posicoes leitorBancoDoBrasil = new InterpretadorTituloBancoDoBrasilConvenio7Posicoes("00199442700000270500000001535175000021679818");
        Assert.assertEquals("00199442700000270500000001535175000021679818", leitorBancoDoBrasil.getCodigoDeBarras());
        Assert.assertEquals("001", leitorBancoDoBrasil.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorBancoDoBrasil.getMoeda());
        Assert.assertEquals(9, leitorBancoDoBrasil.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(4427, leitorBancoDoBrasil.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("270.50"), leitorBancoDoBrasil.getValor());
        Assert.assertEquals("0000001535175000021679818", leitorBancoDoBrasil.getCampoLivre());
        Assert.assertNull(leitorBancoDoBrasil.getAgencia());
        Assert.assertEquals("15351750000216798", leitorBancoDoBrasil.getNossoNumero());
        Assert.assertEquals("1535175", leitorBancoDoBrasil.getContaCobranca());
        Assert.assertEquals("1535175", leitorBancoDoBrasil.getNumeroConvenio());
        Assert.assertEquals("0000216798", leitorBancoDoBrasil.getComplementoNossoNumero());
        Assert.assertEquals("18", leitorBancoDoBrasil.getCodigoCarteira());
        Assert.assertTrue(leitorBancoDoBrasil.isContaCobrancaRastreavel());
    }

    @Test
    public void boletoBancoDoBrasilOutroFormatoNaoEValido() {
        Assert.assertFalse(new InterpretadorTituloBancoDoBrasilConvenio7Posicoes("00192433400003818174568230456823090000000821").isValidoParaInterpretacao());
    }

    @Test
    public void boletoDeOutroBancoNaoEValido() {
        Assert.assertFalse(new InterpretadorTituloBancoDoBrasilConvenio7Posicoes("23796565100000658712657090008068809100000120").isValidoParaInterpretacao());
    }
}