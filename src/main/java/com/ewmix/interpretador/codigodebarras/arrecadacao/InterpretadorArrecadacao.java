package com.ewmix.interpretador.codigodebarras.arrecadacao;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ewmix.interpretador.codigodebarras.Interpretador;
import com.ewmix.interpretador.codigodebarras.TipoDocumento;

public class InterpretadorArrecadacao implements Interpretador {

    private final String codigoBarras;

    public InterpretadorArrecadacao(final String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public TipoDocumento getTipoDocumento() {
        return TipoDocumento.ARRECADACAO;
    }

    @Override
    public BigDecimal getValor() {
        return new BigDecimal(this.codigoBarras.substring(4, 15)).divide(new BigDecimal("100"), new MathContext(18)).setScale(2, RoundingMode.HALF_UP);
    }

    public int getCodigoIdentificacaoProduto() {
        return Integer.parseInt(this.codigoBarras.substring(0, 1));
    }

    public int getIdentificacaoSegmento() {
        return Integer.parseInt(this.codigoBarras.substring(1, 2));
    }

    public Segmento getSegmento() {
        return Segmento.valueOfCodigo(this.getIdentificacaoSegmento());
    }

    public int getIdentificacaoValor() {
        return Integer.parseInt(this.codigoBarras.substring(2, 3));
    }

    public int getDigitoVerificadorGeral() {
        return Integer.parseInt(this.codigoBarras.substring(3, 4));
    }

    public String getIdentificacaoEmpresaOrgao() {
        return this.codigoBarras.substring(15, 19);
    }

    public String getCampoLivre1UtilizacaoEmpresaOrgao() {
        return this.codigoBarras.substring(19, 44);
    }

    public String getCnpjMf() {
        return this.codigoBarras.substring(15, 23);
    }

    public String getCampoLivre2UtilizacaoEmpresaOrgao() {
        return this.codigoBarras.substring(23, 44);
    }

    @Override
    public Date getDataVencimento() {
        if (this.isCampoLivrePossuiVencimento()) {
            return new GregorianCalendar(this.getCampoLivreVencimentoAno(), this.getCampoLivreVencimentoMes() - 1, this.getCampoLivreVencimentoDia()).getTime();
        }
        return null;
    }

    private boolean isCampoLivrePossuiVencimento() {
        return this.getCampoLivreVencimento().matches("^(19|20)\\d\\d(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$");
    }

    private String getCampoLivreVencimento() {
        return this.getCampoLivre1UtilizacaoEmpresaOrgao().substring(0, 8);
    }

    private int getCampoLivreVencimentoAno() {
        return Integer.parseInt(this.getCampoLivreVencimento().substring(0, 4));
    }

    private int getCampoLivreVencimentoMes() {
        return Integer.parseInt(this.getCampoLivreVencimento().substring(4, 6));
    }

    private int getCampoLivreVencimentoDia() {
        return Integer.parseInt(this.getCampoLivreVencimento().substring(6, 8));
    }
}