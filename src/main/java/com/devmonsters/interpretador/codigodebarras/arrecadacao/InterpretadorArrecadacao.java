package com.devmonsters.interpretador.codigodebarras.arrecadacao;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Date;
import java.util.GregorianCalendar;

import com.devmonsters.interpretador.codigodebarras.Interpretador;
import com.devmonsters.interpretador.codigodebarras.TipoDocumento;

public class InterpretadorArrecadacao implements Interpretador {
    
    private static final long serialVersionUID = 5332167521165636981L;
    private final String codigoDeBarras;
    
    public InterpretadorArrecadacao(final String codigoBarras) {
        this.codigoDeBarras = codigoBarras;
    }
    
    @Override
    public TipoDocumento getTipoDocumento() {
        return TipoDocumento.ARRECADACAO;
    }
    
    @Override
    public boolean isValidoParaInterpretacao() {
        return this.getCodigoDeBarras().startsWith("8");
    }
    
    @Override
    public String getCodigoDeBarras() {
        return this.codigoDeBarras;
    }
    
    @Override
    public BigDecimal getValor() {
        return new BigDecimal(this.codigoDeBarras.substring(4, 15)).divide(new BigDecimal("100"), new MathContext(18)).setScale(2, RoundingMode.HALF_UP);
    }
    
    public int getCodigoIdentificacaoProduto() {
        return Integer.parseInt(this.codigoDeBarras.substring(0, 1));
    }
    
    public Segmento getSegmento() {
        return Segmento.valueOfCodigo(Integer.parseInt(this.codigoDeBarras.substring(1, 2)));
    }
    
    public int getIdentificacaoValor() {
        return Integer.parseInt(this.codigoDeBarras.substring(2, 3));
    }
    
    public int getDigitoVerificadorGeral() {
        return Integer.parseInt(this.codigoDeBarras.substring(3, 4));
    }
    
    public String getIdentificacaoEmpresaOrgao() {
        return this.codigoDeBarras.substring(15, 19);
    }
    
    public String getCampoLivre1UtilizacaoEmpresaOrgao() {
        return this.codigoDeBarras.substring(19, 44);
    }
    
    public String getCnpjMf() {
        return this.codigoDeBarras.substring(15, 23);
    }
    
    public String getCampoLivre2UtilizacaoEmpresaOrgao() {
        return this.codigoDeBarras.substring(23, 44);
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