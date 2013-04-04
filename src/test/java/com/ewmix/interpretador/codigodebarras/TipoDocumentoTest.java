package com.ewmix.interpretador.codigodebarras;

import org.junit.Assert;
import org.junit.Test;

public class TipoDocumentoTest {

    @Test
    public void todosDevemPossuirDescricao() {
        for (final TipoDocumento tipoDocumento : TipoDocumento.values()) {
            Assert.assertNotNull(tipoDocumento.getDescricao());
        }
    }

    @Test
    public void tituloPeloNome() {
        Assert.assertEquals(TipoDocumento.TITULO, TipoDocumento.valueOf("TITULO"));
    }
}