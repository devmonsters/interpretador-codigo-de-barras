package com.ewmix.interpretador.codigodebarras.impl;

import com.ewmix.interpretador.codigodebarras.Interpretador;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class InterpretadorHsbc implements Interpretador {

    private final String codigoBarras;

    public InterpretadorHsbc(final String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoBarras() {
        return this.codigoBarras;
    }

    public String getBanco() {
        return this.codigoBarras.substring(0, 3);
    }

    public int getMoeda() {
        return Integer.parseInt(this.codigoBarras.substring(3, 4));
    }

    public int getDigitoAutoConferenciaCodigoBarras() {
        return Integer.parseInt(this.codigoBarras.substring(4, 5));
    }

    public int getFatorVencimento() {
        return Integer.parseInt(this.codigoBarras.substring(5, 9));
    }

    public BigDecimal getValor() {
        return new BigDecimal(this.codigoBarras.substring(9, 19)).divide(new BigDecimal("100"), new MathContext(18)).setScale(2, RoundingMode.HALF_UP);
    }

    public String getNossoNumero() {
        return this.codigoBarras.substring(19, 30);
    }

    public String getAgencia() {
        return this.codigoBarras.substring(30, 34);
    }

    public String getContaCobranca() {
        return this.codigoBarras.substring(34, 41);
    }

    public String getCodigoCarteira() {
        return this.codigoBarras.substring(41, 43);
    }

    public String getCodigoAplicativoCobranca() {
        return this.codigoBarras.substring(43, 44);
    }
}