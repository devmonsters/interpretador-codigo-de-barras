package com.ewmix.interpretador.codigodebarras.arrecadacao;

import org.junit.Assert;
import org.junit.Test;

public class SegmentoTest {

    @Test
    public void orgaosGovernamentaisPeloCodigo() {
        Assert.assertEquals(Segmento.ORGAOS_GOVERNAMENTAIS, Segmento.valueOfCodigo(5));
    }

    @Test
    public void codigoInvalidoRetornaNulo() {
        Assert.assertNull(Segmento.valueOfCodigo(10));
    }

    @Test
    public void todosDevemPossuirDescricao() {
        for (final Segmento segmento : Segmento.values()) {
            Assert.assertNotNull(segmento.getDescricao());
        }
    }

    @Test
    public void prefeituraPeloNome() {
        Assert.assertEquals(Segmento.PREFEITURAS, Segmento.valueOf("PREFEITURAS"));
    }
}