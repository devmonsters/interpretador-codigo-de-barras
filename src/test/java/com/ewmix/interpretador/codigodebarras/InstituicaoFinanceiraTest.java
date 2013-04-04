package com.ewmix.interpretador.codigodebarras;

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
}