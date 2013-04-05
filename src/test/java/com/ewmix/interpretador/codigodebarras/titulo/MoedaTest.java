package com.ewmix.interpretador.codigodebarras.titulo;

import org.junit.Assert;
import org.junit.Test;

public class MoedaTest {
    
    @Test
    public void moedaNaoIdentificada() {
        Assert.assertEquals(null, Moeda.valueOfCodigo(0));
    }
    
    @Test
    public void real() {
        Assert.assertEquals(Moeda.REAL, Moeda.valueOfCodigo(9));
    }
}
