package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorTituloItauTest extends InterpretadorTituloTest {

    @Override
    protected InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.ITAU;
    }

    @Test
    public void interpretarBoletoTeste() {
        final InterpretadorTituloItau leitorItau = new InterpretadorTituloItau("34196568300043759501572273150081234987655000");
        Assert.assertEquals("34196568300043759501572273150081234987655000", leitorItau.getCodigoDeBarras());
        Assert.assertEquals("341", leitorItau.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorItau.getMoeda());
        Assert.assertEquals(6, leitorItau.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5683, leitorItau.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("43759.50"), leitorItau.getValor());
        Assert.assertEquals("1572273150081234987655000", leitorItau.getCampoLivre());

        Assert.assertEquals("157", leitorItau.getCodigoCarteira());
        Assert.assertEquals("22731500", leitorItau.getNossoNumero());
        Assert.assertEquals(8, leitorItau.getDacAgenciaContaCarteiraNossoNumero());
        Assert.assertEquals("1234", leitorItau.getAgencia());
        Assert.assertEquals("98765", leitorItau.getContaCobranca());
        Assert.assertEquals(5, leitorItau.getDacAgenciaConta());
        Assert.assertEquals("000", leitorItau.getZeros());
        Assert.assertTrue(leitorItau.isContaCobrancaRastreavel());
    }
}