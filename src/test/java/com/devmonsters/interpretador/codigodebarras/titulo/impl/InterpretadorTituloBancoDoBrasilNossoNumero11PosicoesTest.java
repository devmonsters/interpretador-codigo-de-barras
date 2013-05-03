package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorTituloBancoDoBrasilNossoNumero11PosicoesTest extends InterpretadorTituloTest {

    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.BANCO_DO_BRASIL;
    }

    @Test
    public void interpretarBoletoTeste() {
        final InterpretadorTituloBancoDoBrasilNossoNumero11Posicoes leitorBancoDoBrasil = new InterpretadorTituloBancoDoBrasilNossoNumero11Posicoes("00196565100000658712657090008068809100000120");
        Assert.assertEquals("00196565100000658712657090008068809100000120", leitorBancoDoBrasil.getCodigoDeBarras());
        Assert.assertEquals("001", leitorBancoDoBrasil.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorBancoDoBrasil.getMoeda());
        Assert.assertEquals(6, leitorBancoDoBrasil.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5651, leitorBancoDoBrasil.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("658.71"), leitorBancoDoBrasil.getValor());
        Assert.assertEquals("2657090008068809100000120", leitorBancoDoBrasil.getCampoLivre());
        Assert.assertEquals("6880", leitorBancoDoBrasil.getAgencia());
        Assert.assertEquals("26570900080", leitorBancoDoBrasil.getNossoNumero());
        Assert.assertEquals("91000001", leitorBancoDoBrasil.getContaCobranca());
        Assert.assertEquals("0", leitorBancoDoBrasil.getCodigoCarteira());
        Assert.assertEquals("2657", leitorBancoDoBrasil.getNumeroConvenio());
        Assert.assertEquals("0900080", leitorBancoDoBrasil.getComplementoNossoNumero());
        Assert.assertTrue(leitorBancoDoBrasil.isContaCobrancaRastreavel());
    }
}
