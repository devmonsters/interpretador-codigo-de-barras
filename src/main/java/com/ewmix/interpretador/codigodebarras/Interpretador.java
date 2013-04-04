package com.ewmix.interpretador.codigodebarras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Interface basica para interpretacao. Retorna apenas os dados mais basicos e que permitam ser coletados de titulos e arrecadacoes.
 * 
 * @author Fernando M. Pinheiro
 */
public interface Interpretador {

    public TipoDocumento getTipoDocumento();

    public BigDecimal getValor();

    public Date getDataVencimento();
}