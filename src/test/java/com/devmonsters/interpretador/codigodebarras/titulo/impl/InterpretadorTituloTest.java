package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.InterpretadorFactory;
import com.devmonsters.interpretador.codigodebarras.TipoDocumento;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

/**
 * Classe abstrata para testes de interpretadores. As implementacoes devem estender esta.
 *
 * @author Fernando M. Pinheiro
 */
public abstract class InterpretadorTituloTest {

    private static final String CODIGO_BARRAS_PADRAO_TESTE = "%s95567200001119002843306779912340123456001";
    protected InterpretadorTitulo interpretadorAbstrato;

    protected abstract InstituicaoFinanceira getInstituicaoFinanceira();

    protected String getCodigoBarras() {
        return String.format(InterpretadorTituloTest.CODIGO_BARRAS_PADRAO_TESTE, this.getInstituicaoFinanceira().getCodigo());
    }

    @Before
    public void interpretadorAbstrato() throws Exception {
        this.interpretadorAbstrato = (InterpretadorTitulo) new InterpretadorFactory().getInterpretador(this.getCodigoBarras());
    }

    @Test
    public void codigoBarrasDeveRetornarIgual() throws Exception {
        Assert.assertEquals(this.getCodigoBarras(), this.interpretadorAbstrato.getCodigoDeBarras());
    }

    @Test
    public void tipoDocumentoDeveSerTitulo() {
        Assert.assertEquals(TipoDocumento.TITULO, this.interpretadorAbstrato.getTipoDocumento());
    }

    @Test
    public void instituicaoFinanceiraLidaDeveSerAMesmaQueEnviamos() throws Exception {
        Assert.assertEquals(this.getInstituicaoFinanceira(), this.interpretadorAbstrato.getInstituicaoFinanceira());
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
        Assert.assertEquals(LocalDate.of(2037, 12, 8), this.interpretadorAbstrato.getDataVencimento());
    }

    @Test
    public void valor() throws Exception {
        Assert.assertEquals(new BigDecimal("1119.00"), this.interpretadorAbstrato.getValor());
    }

    @Test
    public void campoLivre() throws Exception {
        Assert.assertEquals("2843306779912340123456001", this.interpretadorAbstrato.getCampoLivre());
    }

    @Test
    public void dataVencimentoCodigoBarrasAnterior22022025() throws Exception {
        Assert.assertEquals(LocalDate.of(2025, 2, 10), new InterpretadorFactory().getInterpretador("00197998800000030000000003128557100012378017").getDataVencimento());
    }

    @Test
    public void dataVencimentoLinhaDigitavelAnterior22022025() throws Exception {
        Assert.assertEquals(LocalDate.of(2025, 2, 7), new InterpretadorFactory().getInterpretador("00190000090312855710900123780173799850000003000").getDataVencimento());
    }

    @Test
    public void dataVencimentoCodigoBarrasPosterior22022025() throws Exception {
        Assert.assertEquals(LocalDate.of(2025, 2, 24), new InterpretadorFactory().getInterpretador("00197100200000030000000003128557100012378017").getDataVencimento());
    }

    @Test
    public void dataVencimentoLinhaDigitavelPosterior22022025() throws Exception {
        Assert.assertEquals(LocalDate.of(2025, 2, 24), new InterpretadorFactory().getInterpretador("00190000090312855710900123780173710020000003000").getDataVencimento());
    }

    @Test
    public void dataVencimentoLinhaDigitavel2Posterior22022025() throws Exception {
        Assert.assertEquals(LocalDate.of(2025, 6, 4), new InterpretadorFactory().getInterpretador("34191090080027254849699978910000711020000066689").getDataVencimento());
    }

    @Test
    public void dataVencimentoLinhaDigitavel3Posterior22022025() throws Exception {
        Assert.assertEquals(LocalDate.of(2022, 11, 22), new InterpretadorFactory().getInterpretador("74891140127872810100301142001054791770000054103").getDataVencimento());
    }
}