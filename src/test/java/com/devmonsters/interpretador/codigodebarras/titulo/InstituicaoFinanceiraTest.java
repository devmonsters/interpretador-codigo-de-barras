package com.devmonsters.interpretador.codigodebarras.titulo;

import org.junit.Assert;
import org.junit.Test;

public class InstituicaoFinanceiraTest {

    @Test(expected = IllegalArgumentException.class)
    public void geraExcecaoSeCodigoInvalido() {
        InstituicaoFinanceira.valueOfCodigo("");
    }

    @Test
    public void retornaHSBCPeloCodigo() {
        Assert.assertEquals(InstituicaoFinanceira.HSBC, InstituicaoFinanceira.valueOfCodigo("399"));
    }

    @Test
    public void codigoNaoConhecidoRetornaGenerico() {
        Assert.assertEquals(InstituicaoFinanceira.GENERICO, InstituicaoFinanceira.valueOfCodigo("999"));
    }

    @Test
    public void hsbcPeloNome() {
        Assert.assertEquals(InstituicaoFinanceira.HSBC, InstituicaoFinanceira.valueOf("HSBC"));
    }

    public void verificaCodigos(){
        Assert.assertEquals(InstituicaoFinanceira.GENERICO.getCodigo(), "000");
        Assert.assertEquals(InstituicaoFinanceira.BANCO_DO_BRASIL.getCodigo(), "001");
        Assert.assertEquals(InstituicaoFinanceira.BRADESCO.getCodigo(), "237");
        Assert.assertEquals(InstituicaoFinanceira.CAIXA_ECONOMICA_FEDERAL.getCodigo(), "104");
        Assert.assertEquals(InstituicaoFinanceira.HSBC.getCodigo(), "399");
        Assert.assertEquals(InstituicaoFinanceira.ITAU.getCodigo(), "341");
        Assert.assertEquals(InstituicaoFinanceira.SANTANDER.getCodigo(), "033");
    }
}