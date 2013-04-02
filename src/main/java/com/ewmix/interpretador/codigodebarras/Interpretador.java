package com.ewmix.interpretador.codigodebarras;

import java.math.BigDecimal;

public interface Interpretador {

    public String getCodigoBarras();

    public String getBanco();

    public int getMoeda();

    public int getDigitoAutoConferenciaCodigoBarras();

    public int getFatorVencimento();

    public BigDecimal getValor();

    public String getNossoNumero();

    public String getAgencia();

    public String getContaCobranca();

    public String getCodigoCarteira();

    public String getCodigoAplicativoCobranca();
}