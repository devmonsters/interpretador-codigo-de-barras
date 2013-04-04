package com.ewmix.interpretador.codigodebarras.titulo;

import com.ewmix.interpretador.codigodebarras.titulo.impl.InterpretadorTituloGenerico;
import com.ewmix.interpretador.codigodebarras.titulo.impl.InterpretadorTituloHsbc;

public enum InstituicaoFinanceira {

    GENERICO("000", InterpretadorTituloGenerico.class),
    HSBC("399", InterpretadorTituloHsbc.class);

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