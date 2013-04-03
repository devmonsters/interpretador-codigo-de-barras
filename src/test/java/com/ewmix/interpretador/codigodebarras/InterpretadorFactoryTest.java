package com.ewmix.interpretador.codigodebarras;

import org.junit.Assert;
import org.junit.Test;

import com.ewmix.interpretador.codigodebarras.impl.InterpretadorHsbc;

public class InterpretadorFactoryTest {

    @Test
    public void bancoInvalidoDeveRetornarNulo() throws Exception {
        Assert.assertNull(new InterpretadorFactory().getInterpretador("00095567200001119002843306779912340123456001"));
    }

    @Test
    public void banco399deveRetornarHSBC() throws Exception {
        Assert.assertEquals(InterpretadorHsbc.class, new InterpretadorFactory().getInterpretador("39995567200001119002843306779912340123456001").getClass());
    }

    @Test(expected = NullPointerException.class)
    public void nullPointerSeParametroNulo() throws Exception {
        new InterpretadorFactory().getInterpretador(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oCodigoDeBarrasDevePossuir44Digitos() throws Exception {
        new InterpretadorFactory().getInterpretador("399955672000011190028433067799");
    }
}