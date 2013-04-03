package com.ewmix.interpretador.codigodebarras;

import org.junit.Assert;
import org.junit.Test;

public class InstituicaoFinanceiraTest {

    @Test
    public void retornaNuloPeloCodigoInvalido() {
        Assert.assertEquals(null, InstituicaoFinanceira.valueOfCodigo(""));
    }

    @Test
    public void retornaHSBCPeloCodigo() {
        Assert.assertEquals(InstituicaoFinanceira.HSBC, InstituicaoFinanceira.valueOfCodigo("399"));
    }
}
