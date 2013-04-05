package com.ewmix.interpretador.codigodebarras.titulo;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ewmix.interpretador.codigodebarras.InterpretadorFactory;
import com.ewmix.interpretador.codigodebarras.TipoDocumento;

/**
 * Classe abstrata para testes de interpretadores. As implementacoes devem estender esta.
 * 
 * @author Fernando M. Pinheiro
 */
public abstract class AbstractInterpretadorTituloTest {
    
    private static final String CODIGO_BARRAS_PADRAO_TESTE = "%s95567200001119002843306779912340123456001";
    private AbstractInterpretadorTitulo interpretadorAbstrato;
    
    protected abstract InstituicaoFinanceira getInstituicaoFinanceira();
    
    protected String getCodigoBarras() {
        return String.format(AbstractInterpretadorTituloTest.CODIGO_BARRAS_PADRAO_TESTE, this.getInstituicaoFinanceira().getCodigo());
    }
    
    @Before
    public void interpretadorAbstrato() throws Exception {
        this.interpretadorAbstrato = (AbstractInterpretadorTitulo) new InterpretadorFactory().getInterpretador(this.getCodigoBarras());
    }
    
    @Test
    public void codigoBarrasDeveRetornarIgual() throws Exception {
        Assert.assertEquals(this.getCodigoBarras(), this.interpretadorAbstrato.getCodigoBarras());
    }
    
    @Test
    public void tipoDocumentoDeveSerTitulo() {
        Assert.assertEquals(TipoDocumento.TITULO, this.interpretadorAbstrato.getTipoDocumento());
    }
    
    @Test
    public void instituicaoFinanceiraLidaDeveSerAMesmaQueEnviamos() throws Exception {
        Assert.assertEquals(this.getInstituicaoFinanceira().getCodigo(), this.interpretadorAbstrato.getBanco());
    }
    
    @Test
    public void moeda() throws Exception {
        Assert.assertEquals(Moeda.REAL, this.interpretadorAbstrato.getMoeda());
    }
    
    @Test
    public void digitoAutoConferenciaCodigoBarras() throws Exception {
        Assert.assertEquals(5, this.interpretadorAbstrato.getDigitoAutoConferenciaCodigoBarras());
    }
    
    @Test
    public void fatorVencimento() throws Exception {
        Assert.assertEquals(5672, this.interpretadorAbstrato.getFatorVencimento());
    }
    
    @Test
    public void dataDeVencimento() throws Exception {
        Assert.assertEquals(new GregorianCalendar(2013, Calendar.APRIL, 18).getTime(), this.interpretadorAbstrato.getDataVencimento());
    }
    
    @Test
    public void valor() throws Exception {
        Assert.assertEquals(new BigDecimal("1119.00"), this.interpretadorAbstrato.getValor());
    }
    
    @Test
    public void campoLivre() throws Exception {
        Assert.assertEquals("2843306779912340123456001", this.interpretadorAbstrato.getCampoLivre());
    }
}