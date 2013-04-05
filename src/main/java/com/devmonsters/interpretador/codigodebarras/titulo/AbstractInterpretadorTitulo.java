package com.devmonsters.interpretador.codigodebarras.titulo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.devmonsters.interpretador.codigodebarras.Interpretador;
import com.devmonsters.interpretador.codigodebarras.TipoDocumento;

public abstract class AbstractInterpretadorTitulo implements Interpretador {
    
    private static final Calendar DATA_BASE_VENCIMENTO = new GregorianCalendar(1997, Calendar.OCTOBER, 7);
    private final String codigoBarras;
    
    public AbstractInterpretadorTitulo(final String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    
    @Override
    public TipoDocumento getTipoDocumento() {
        return TipoDocumento.TITULO;
    }
    
    public String getCodigoBarras() {
        return this.codigoBarras;
    }
    
    public String getBanco() {
        return this.codigoBarras.substring(0, 3);
    }
    
    public Moeda getMoeda() {
        return Moeda.valueOfCodigo(Integer.parseInt(this.codigoBarras.substring(3, 4)));
    }
    
    public int getDigitoAutoConferenciaCodigoBarras() {
        return Integer.parseInt(this.codigoBarras.substring(4, 5));
    }
    
    public int getFatorVencimento() {
        return Integer.parseInt(this.codigoBarras.substring(5, 9));
    }
    
    @Override
    public Date getDataVencimento() {
        final Calendar dataVencimento = (Calendar) AbstractInterpretadorTitulo.DATA_BASE_VENCIMENTO.clone();
        dataVencimento.add(Calendar.DAY_OF_MONTH, this.getFatorVencimento());
        return dataVencimento.getTime();
    }
    
    @Override
    public BigDecimal getValor() {
        return new BigDecimal(this.codigoBarras.substring(9, 19)).divide(new BigDecimal("100"), new MathContext(18)).setScale(2, RoundingMode.HALF_UP);
    }
    
    public String getCampoLivre() {
        return this.codigoBarras.substring(19, 44);
    }
    
    public abstract String getNossoNumero();
    
    public abstract String getAgencia();
    
    public abstract String getContaCobranca();
    
    public abstract String getCodigoCarteira();
    
    public abstract boolean isContaCobrancaRastreavel();
}