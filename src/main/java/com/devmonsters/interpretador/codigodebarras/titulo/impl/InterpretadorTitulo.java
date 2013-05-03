package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.devmonsters.interpretador.codigodebarras.Interpretador;
import com.devmonsters.interpretador.codigodebarras.TipoDocumento;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public abstract class InterpretadorTitulo implements Interpretador {

    private static final long serialVersionUID = 4437522256398278698L;
    private static final Calendar DATA_BASE_VENCIMENTO = new GregorianCalendar(1997, Calendar.OCTOBER, 7);
    private final String codigoDeBarras;

    public InterpretadorTitulo(final String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    @Override
    public TipoDocumento getTipoDocumento() {
        return TipoDocumento.TITULO;
    }

    @Override
    public String getCodigoDeBarras() {
        return this.codigoDeBarras;
    }

    public String getBanco() {
        return this.codigoDeBarras.substring(0, 3);
    }

    public Moeda getMoeda() {
        return Moeda.valueOfCodigo(Integer.parseInt(this.codigoDeBarras.substring(3, 4)));
    }

    public int getDigitoAutoConferenciaCodigoBarras() {
        return Integer.parseInt(this.codigoDeBarras.substring(4, 5));
    }

    public int getFatorVencimento() {
        return Integer.parseInt(this.codigoDeBarras.substring(5, 9));
    }

    @Override
    public Date getDataVencimento() {
        final Calendar dataVencimento = (Calendar) InterpretadorTitulo.DATA_BASE_VENCIMENTO.clone();
        dataVencimento.add(Calendar.DAY_OF_MONTH, this.getFatorVencimento());
        return dataVencimento.getTime();
    }

    @Override
    public BigDecimal getValor() {
        return new BigDecimal(this.codigoDeBarras.substring(9, 19)).divide(new BigDecimal("100"), new MathContext(18)).setScale(2, RoundingMode.HALF_UP);
    }

    public String getCampoLivre() {
        return this.codigoDeBarras.substring(19, 44);
    }

    public final InstituicaoFinanceira getInstituicaoFinanceira() {
        return InstituicaoFinanceira.valueOfCodigo(this.codigoDeBarras.substring(0, 3));
    }

    public abstract String getNossoNumero();

    public abstract String getAgencia();

    public abstract String getContaCobranca();

    public abstract String getCodigoCarteira();

    public abstract boolean isContaCobrancaRastreavel();
}