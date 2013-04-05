package com.ewmix.interpretador.codigodebarras.titulo;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;

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