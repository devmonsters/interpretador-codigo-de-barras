package com.devmonsters.interpretador.codigodebarras;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Interface basica para interpretacao.<br>
 * Retorna apenas os dados mais basicos e que permitam ser coletados de titulos e arrecadacoes.
 * 
 * @author Fernando M. Pinheiro
 */
public interface Interpretador {

    TipoDocumento getTipoDocumento();

    BigDecimal getValor();

    Date getDataVencimento();
}