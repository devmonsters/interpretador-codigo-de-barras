package com.devmonsters.interpretador.codigodebarras.titulo;

import com.devmonsters.interpretador.codigodebarras.titulo.impl.InterpretadorTituloBradesco;
import com.devmonsters.interpretador.codigodebarras.titulo.impl.InterpretadorTituloGenerico;
import com.devmonsters.interpretador.codigodebarras.titulo.impl.InterpretadorTituloHsbc;
import com.devmonsters.interpretador.codigodebarras.titulo.impl.InterpretadorTituloItau;
import com.devmonsters.interpretador.codigodebarras.titulo.impl.InterpretadorTituloSantander;

public enum InstituicaoFinanceira {

    GENERICO("000", InterpretadorTituloGenerico.class),
    BRADESCO("237", InterpretadorTituloBradesco.class),
    HSBC("399", InterpretadorTituloHsbc.class),
    ITAU("341", InterpretadorTituloItau.class),
    SANTANDER("033", InterpretadorTituloSantander.class);

    private final String codigo;
    private final Class<? extends AbstractInterpretadorTitulo> interpretador;

    private InstituicaoFinanceira(final String codigo, final Class<? extends AbstractInterpretadorTitulo> interpretador) {
        this.codigo = codigo;
        this.interpretador = interpretador;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public Class<? extends AbstractInterpretadorTitulo> getInterpretador() {
        return this.interpretador;
    }

    public static InstituicaoFinanceira valueOfCodigo(final String codigo) {
        if (!codigo.matches("[0-9]{3}")) {
            throw new IllegalArgumentException("O c\u00f3digo da institui\u00e7\u00e3o financeira deve ser 3 d\u00edgitos num\u00e9ricos.");
        }
        for (final InstituicaoFinanceira instituicaoFinanceira : InstituicaoFinanceira.values()) {
            if (instituicaoFinanceira.getCodigo().equals(codigo)) {
                return instituicaoFinanceira;
            }
        }
        return GENERICO;
    }
}