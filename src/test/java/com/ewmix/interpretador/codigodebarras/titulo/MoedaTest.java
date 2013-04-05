package com.ewmix.interpretador.codigodebarras.titulo;

import org.junit.Assert;
import org.junit.Test;

public class MoedaTest {
    
    @Test
    public void moedaNaoIdentificada() {
        Assert.assertEquals(null, Moeda.valueOfCodigo(0));
    }
    
    @Test
    public void identificadorPorNome() {
        Assert.assertEquals(Moeda.REAL, Moeda.valueOf("REAL"));
    }
    
    @Test
    public void real() {
        final Moeda moeda = Moeda.valueOfCodigo(9);
        Assert.assertEquals(Moeda.REAL, moeda);
        Assert.assertEquals(9, moeda.getCodigo());
        Assert.assertEquals("Real", moeda.getDescricao());
    }
}
