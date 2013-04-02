package com.ewmix.interpretador.codigodebarras;

import org.junit.Assert;
import org.junit.Test;

import com.ewmix.interpretador.codigodebarras.impl.InterpretadorHsbc;

public class InterpretadorFactoryTest {

    @Test
    public void banco399deveRetornarHSBC() {
        Assert.assertEquals(InterpretadorHsbc.class, new InterpretadorFactory().getInterpretador("39995567200001119002843306779912340123456001").getClass());
    }

    @Test
    public void bancoInvalidoDeveRetornarNulo() {
        Assert.assertNull(new InterpretadorFactory().getInterpretador("00095567200001119002843306779912340123456001"));
    }
}