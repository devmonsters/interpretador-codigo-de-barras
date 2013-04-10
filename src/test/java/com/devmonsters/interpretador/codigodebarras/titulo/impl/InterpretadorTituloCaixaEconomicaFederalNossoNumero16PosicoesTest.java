package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.titulo.AbstractInterpretadorTituloTest;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public class InterpretadorTituloCaixaEconomicaFederalNossoNumero16PosicoesTest extends AbstractInterpretadorTituloTest {

    @Override
    protected String getCodigoInstituicaoFinanceira() {
        return InstituicaoFinanceira.CAIXA_ECONOMICA_FEDERAL.getCodigo();
    }

    /**
     * O leitor da CEF, para ser valido, precisa atender a um formato padrao, portanto vamos sobrescrever o codigo de barras de teste.
     */
    @Override
    protected String getCodigoBarras() {
        return "10495567200001119001234503698700000010238279";
    }

    /**
     * Em razao da alteracao do codigo de barras, o campo livre e diferente.
     */
    @Override
    public void campoLivre() throws Exception {
        Assert.assertEquals("1234503698700000010238279", super.interpretadorAbstrato.getCampoLivre());
    }

    @Test
    public void tituloDeOutroBancoNaoEValido() {
        Assert.assertFalse(new InterpretadorTituloCaixaEconomicaFederalNossoNumero16Posicoes("03391569400000842649123456772000010239510102").isValidoParaInterpretacao());
    }

    @Test
    public void interpretarBoletoTeste() {
        final InterpretadorTituloCaixaEconomicaFederalNossoNumero16Posicoes leitorCEF = new InterpretadorTituloCaixaEconomicaFederalNossoNumero16Posicoes("10491567300000146811234503698700000010238279");
        Assert.assertEquals("10491567300000146811234503698700000010238279", leitorCEF.getCodigoDeBarras());
        Assert.assertEquals("104", leitorCEF.getBanco());
        Assert.assertEquals(Moeda.REAL, leitorCEF.getMoeda());
        Assert.assertEquals(1, leitorCEF.getDigitoAutoConferenciaCodigoBarras());
        Assert.assertEquals(5673, leitorCEF.getFatorVencimento());
        Assert.assertEquals(new BigDecimal("146.81"), leitorCEF.getValor());
        Assert.assertEquals("1234503698700000010238279", leitorCEF.getCampoLivre());

        Assert.assertEquals("12345", leitorCEF.getContaCobranca());
        Assert.assertEquals("0369", leitorCEF.getAgencia());
        Assert.assertEquals("87", leitorCEF.getConstante());
        Assert.assertEquals("00000010238279", leitorCEF.getNossoNumero());
        Assert.assertNull(leitorCEF.getCodigoCarteira());
        Assert.assertTrue(leitorCEF.isContaCobrancaRastreavel());
    }
}