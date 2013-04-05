package com.devmonsters.interpretador.codigodebarras.arrecadacao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;

import com.devmonsters.interpretador.codigodebarras.TipoDocumento;
import com.devmonsters.interpretador.codigodebarras.arrecadacao.InterpretadorArrecadacao;
import com.devmonsters.interpretador.codigodebarras.arrecadacao.Segmento;

public class InterpretadorArrecadacaoTest {

    @Test
    public void interpretarArrecadacaoPrefeitura() {
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao("81690000000638834332012073104002012980062101");
        Assert.assertEquals(8, interpretadorArrecadacao.getCodigoIdentificacaoProduto());
        Assert.assertEquals(1, interpretadorArrecadacao.getIdentificacaoSegmento());
        Assert.assertEquals(Segmento.PREFEITURAS, interpretadorArrecadacao.getSegmento());
        Assert.assertEquals(6, interpretadorArrecadacao.getIdentificacaoValor());
        Assert.assertEquals(9, interpretadorArrecadacao.getDigitoVerificadorGeral());
        Assert.assertEquals(new BigDecimal("63.88"), interpretadorArrecadacao.getValor());
        Assert.assertEquals("3433", interpretadorArrecadacao.getIdentificacaoEmpresaOrgao());
        Assert.assertEquals("2012073104002012980062101", interpretadorArrecadacao.getCampoLivre1UtilizacaoEmpresaOrgao());
        Assert.assertEquals("34332012", interpretadorArrecadacao.getCnpjMf());
        Assert.assertEquals("073104002012980062101", interpretadorArrecadacao.getCampoLivre2UtilizacaoEmpresaOrgao());
        Assert.assertEquals(new GregorianCalendar(2012, Calendar.JULY, 31).getTime(), interpretadorArrecadacao.getDataVencimento());
        Assert.assertEquals(TipoDocumento.ARRECADACAO, interpretadorArrecadacao.getTipoDocumento());
    }

    @Test
    public void interpretarArrecadacaoSaneamento() {
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao("82690000004127600130000000000102257321303445");
        Assert.assertEquals(8, interpretadorArrecadacao.getCodigoIdentificacaoProduto());
        Assert.assertEquals(2, interpretadorArrecadacao.getIdentificacaoSegmento());
        Assert.assertEquals(Segmento.SANEAMENTO, interpretadorArrecadacao.getSegmento());
        Assert.assertEquals(6, interpretadorArrecadacao.getIdentificacaoValor());
        Assert.assertEquals(9, interpretadorArrecadacao.getDigitoVerificadorGeral());
        Assert.assertEquals(new BigDecimal("412.76"), interpretadorArrecadacao.getValor());
        Assert.assertEquals("0013", interpretadorArrecadacao.getIdentificacaoEmpresaOrgao());
        Assert.assertEquals("0000000000102257321303445", interpretadorArrecadacao.getCampoLivre1UtilizacaoEmpresaOrgao());
        Assert.assertEquals("00130000", interpretadorArrecadacao.getCnpjMf());
        Assert.assertEquals("000000102257321303445", interpretadorArrecadacao.getCampoLivre2UtilizacaoEmpresaOrgao());
        Assert.assertNull(interpretadorArrecadacao.getDataVencimento());
        Assert.assertEquals(TipoDocumento.ARRECADACAO, interpretadorArrecadacao.getTipoDocumento());
    }

    @Test
    public void interpretarArrecadacaoEnergiaEletrica() {
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao("83630000000490601620000010100201382824675826");
        Assert.assertEquals(8, interpretadorArrecadacao.getCodigoIdentificacaoProduto());
        Assert.assertEquals(3, interpretadorArrecadacao.getIdentificacaoSegmento());
        Assert.assertEquals(Segmento.ENERGIA_ELETRICA_E_GAS, interpretadorArrecadacao.getSegmento());
        Assert.assertEquals(6, interpretadorArrecadacao.getIdentificacaoValor());
        Assert.assertEquals(3, interpretadorArrecadacao.getDigitoVerificadorGeral());
        Assert.assertEquals(new BigDecimal("49.06"), interpretadorArrecadacao.getValor());
        Assert.assertEquals("0162", interpretadorArrecadacao.getIdentificacaoEmpresaOrgao());
        Assert.assertEquals("0000010100201382824675826", interpretadorArrecadacao.getCampoLivre1UtilizacaoEmpresaOrgao());
        Assert.assertEquals("01620000", interpretadorArrecadacao.getCnpjMf());
        Assert.assertEquals("010100201382824675826", interpretadorArrecadacao.getCampoLivre2UtilizacaoEmpresaOrgao());
        Assert.assertNull(interpretadorArrecadacao.getDataVencimento());
        Assert.assertEquals(TipoDocumento.ARRECADACAO, interpretadorArrecadacao.getTipoDocumento());
    }

    @Test
    public void interpretarArrecadacaoTelecomunicacoes() {
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao("84660000001356000690011210978294803130130410");
        Assert.assertEquals(8, interpretadorArrecadacao.getCodigoIdentificacaoProduto());
        Assert.assertEquals(4, interpretadorArrecadacao.getIdentificacaoSegmento());
        Assert.assertEquals(Segmento.TELECOMUNICACOES, interpretadorArrecadacao.getSegmento());
        Assert.assertEquals(6, interpretadorArrecadacao.getIdentificacaoValor());
        Assert.assertEquals(6, interpretadorArrecadacao.getDigitoVerificadorGeral());
        Assert.assertEquals(new BigDecimal("135.60"), interpretadorArrecadacao.getValor());
        Assert.assertEquals("0069", interpretadorArrecadacao.getIdentificacaoEmpresaOrgao());
        Assert.assertEquals("0011210978294803130130410", interpretadorArrecadacao.getCampoLivre1UtilizacaoEmpresaOrgao());
        Assert.assertEquals("00690011", interpretadorArrecadacao.getCnpjMf());
        Assert.assertEquals("210978294803130130410", interpretadorArrecadacao.getCampoLivre2UtilizacaoEmpresaOrgao());
        Assert.assertNull(interpretadorArrecadacao.getDataVencimento());
        Assert.assertEquals(TipoDocumento.ARRECADACAO, interpretadorArrecadacao.getTipoDocumento());
    }

    @Test
    public void interpretarArrecadacaoOrgaosGovernamentais() {
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao("85850000001045402941309401000000130151769700");
        Assert.assertEquals(8, interpretadorArrecadacao.getCodigoIdentificacaoProduto());
        Assert.assertEquals(5, interpretadorArrecadacao.getIdentificacaoSegmento());
        Assert.assertEquals(Segmento.ORGAOS_GOVERNAMENTAIS, interpretadorArrecadacao.getSegmento());
        Assert.assertEquals(8, interpretadorArrecadacao.getIdentificacaoValor());
        Assert.assertEquals(5, interpretadorArrecadacao.getDigitoVerificadorGeral());
        Assert.assertEquals(new BigDecimal("104.54"), interpretadorArrecadacao.getValor());
        Assert.assertEquals("0294", interpretadorArrecadacao.getIdentificacaoEmpresaOrgao());
        Assert.assertEquals("1309401000000130151769700", interpretadorArrecadacao.getCampoLivre1UtilizacaoEmpresaOrgao());
        Assert.assertEquals("02941309", interpretadorArrecadacao.getCnpjMf());
        Assert.assertEquals("401000000130151769700", interpretadorArrecadacao.getCampoLivre2UtilizacaoEmpresaOrgao());
        Assert.assertNull(interpretadorArrecadacao.getDataVencimento());
        Assert.assertEquals(TipoDocumento.ARRECADACAO, interpretadorArrecadacao.getTipoDocumento());
    }

    @Test
    public void interpretarArrecadacaoCarnesOrgaosCnpj() {
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao("86630000001056509248608000304745847102111325");
        Assert.assertEquals(8, interpretadorArrecadacao.getCodigoIdentificacaoProduto());
        Assert.assertEquals(6, interpretadorArrecadacao.getIdentificacaoSegmento());
        Assert.assertEquals(Segmento.CARNES_DEMAIS_EMPRESAS_ORGAOS, interpretadorArrecadacao.getSegmento());
        Assert.assertEquals(6, interpretadorArrecadacao.getIdentificacaoValor());
        Assert.assertEquals(3, interpretadorArrecadacao.getDigitoVerificadorGeral());
        Assert.assertEquals(new BigDecimal("105.65"), interpretadorArrecadacao.getValor());
        Assert.assertEquals("0924", interpretadorArrecadacao.getIdentificacaoEmpresaOrgao());
        Assert.assertEquals("8608000304745847102111325", interpretadorArrecadacao.getCampoLivre1UtilizacaoEmpresaOrgao());
        Assert.assertEquals("09248608", interpretadorArrecadacao.getCnpjMf());
        Assert.assertEquals("000304745847102111325", interpretadorArrecadacao.getCampoLivre2UtilizacaoEmpresaOrgao());
        Assert.assertNull(interpretadorArrecadacao.getDataVencimento());
        Assert.assertEquals(TipoDocumento.ARRECADACAO, interpretadorArrecadacao.getTipoDocumento());
    }

    @Test
    public void interpretarArrecadacaoUsoExclusivoBanco() {
        final InterpretadorArrecadacao interpretadorArrecadacao = new InterpretadorArrecadacao("89980005702129300010109552316988150427822511");
        Assert.assertEquals(8, interpretadorArrecadacao.getCodigoIdentificacaoProduto());
        Assert.assertEquals(9, interpretadorArrecadacao.getIdentificacaoSegmento());
        Assert.assertEquals(Segmento.USO_EXCLUSIVO_BANCO, interpretadorArrecadacao.getSegmento());
        Assert.assertEquals(9, interpretadorArrecadacao.getIdentificacaoValor());
        Assert.assertEquals(8, interpretadorArrecadacao.getDigitoVerificadorGeral());
        Assert.assertEquals(new BigDecimal("570212.93"), interpretadorArrecadacao.getValor());
        Assert.assertEquals("0001", interpretadorArrecadacao.getIdentificacaoEmpresaOrgao());
        Assert.assertEquals("0109552316988150427822511", interpretadorArrecadacao.getCampoLivre1UtilizacaoEmpresaOrgao());
        Assert.assertEquals("00010109", interpretadorArrecadacao.getCnpjMf());
        Assert.assertEquals("552316988150427822511", interpretadorArrecadacao.getCampoLivre2UtilizacaoEmpresaOrgao());
        Assert.assertNull(interpretadorArrecadacao.getDataVencimento());
        Assert.assertEquals(TipoDocumento.ARRECADACAO, interpretadorArrecadacao.getTipoDocumento());
    }
}