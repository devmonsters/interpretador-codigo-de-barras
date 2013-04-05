package com.devmonsters.interpretador.codigodebarras;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.InterpretadorFactory;
import com.devmonsters.interpretador.codigodebarras.arrecadacao.InterpretadorArrecadacao;
import com.devmonsters.interpretador.codigodebarras.titulo.impl.InterpretadorTituloGenerico;
import com.devmonsters.interpretador.codigodebarras.titulo.impl.InterpretadorTituloHsbc;

public class InterpretadorFactoryTest {

    @Test(expected = NullPointerException.class)
    public void nullPointerSeParametroNulo() throws Exception {
        new InterpretadorFactory().getInterpretador(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void oCodigoDeBarrasDevePossuir44Digitos() throws Exception {
        new InterpretadorFactory().getInterpretador("399955672000011190028433067799");
    }

    @Test
    public void bancoDesconhecidoDeveRetornarGenerico() throws Exception {
        Assert.assertEquals(InterpretadorTituloGenerico.class, new InterpretadorFactory().getInterpretador("00095567200001119002843306779912340123456001").getClass());
    }

    @Test
    public void banco399deveRetornarHSBC() throws Exception {
        Assert.assertEquals(InterpretadorTituloHsbc.class, new InterpretadorFactory().getInterpretador("39995567200001119002843306779912340123456001").getClass());
    }

    @Test
    public void pagamentoDeArrecadacao() throws Exception {
        Assert.assertEquals(InterpretadorArrecadacao.class, new InterpretadorFactory().getInterpretador("85850000001045402941309401000000130151769700").getClass());
    }
}