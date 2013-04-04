package com.ewmix.interpretador.codigodebarras;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * Classe abstrata para testes de interpretadores. As implementacoes devem estender esta.
 * 
 * @author Fernando M. Pinheiro
 */
public abstract class AbstractInterpretadorTest {
    private static final String CODIGO_BARRAS_PADRAO_TESTE = "%s95567200001119002843306779912340123456001";

    protected abstract InstituicaoFinanceira getInstituicaoFinanceira();

    protected String getCodigoBarras() {
        return String.format(AbstractInterpretadorTest.CODIGO_BARRAS_PADRAO_TESTE, this.getInstituicaoFinanceira().getCodigo());
    }

    @Test
    public void codigoBarrasDeveRetornarIgual() throws Exception {
        Assert.assertEquals(this.getCodigoBarras(), new InterpretadorFactory().getInterpretador(this.getCodigoBarras()).getCodigoBarras());
    }

    @Test
    public void instituicaoFinanceiraLidaDeveSerAMesmaQueEnviamos() throws Exception {
        Assert.assertEquals(this.getInstituicaoFinanceira().getCodigo(), new InterpretadorFactory().getInterpretador(this.getCodigoBarras()).getBanco());
    }

    @Test
    public void moeda() throws Exception {
        Assert.assertEquals(9, new InterpretadorFactory().getInterpretador(this.getCodigoBarras()).getMoeda());
    }

    @Test
    public void digitoAutoConferenciaCodigoBarras() throws Exception {
        Assert.assertEquals(5, new InterpretadorFactory().getInterpretador(this.getCodigoBarras()).getDigitoAutoConferenciaCodigoBarras());
    }

    @Test
    public void fatorVencimento() throws Exception {
        Assert.assertEquals(5672, new InterpretadorFactory().getInterpretador(this.getCodigoBarras()).getFatorVencimento());
    }

    @Test
    public void dataDeVencimento() throws Exception {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.APRIL, 18).getTime(), new InterpretadorFactory().getInterpretador(this.getCodigoBarras()).getDataVencimento());
    }

    @Test
    public void valor() throws Exception {
        Assert.assertEquals(new BigDecimal("1119.00"), new InterpretadorFactory().getInterpretador(this.getCodigoBarras()).getValor());
    }
}