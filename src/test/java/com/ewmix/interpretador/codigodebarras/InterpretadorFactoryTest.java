package com.ewmix.interpretador.codigodebarras;

import com.ewmix.interpretador.codigodebarras.impl.InterpretadorHsbc;
import org.junit.Assert;
import org.junit.Test;

public class InterpretadorFactoryTest {

    @Test
    public void bancoInvalidoDeveRetornarNulo() throws Exception {
        Assert.assertNull(new InterpretadorFactory().getInterpretador("00095567200001119002843306779912340123456001"));
    }

    @Test
    public void banco399deveRetornarHSBC() throws Exception {
        Assert.assertEquals(InterpretadorHsbc.class, new InterpretadorFactory().getInterpretador("39995567200001119002843306779912340123456001").getClass());
    }
}