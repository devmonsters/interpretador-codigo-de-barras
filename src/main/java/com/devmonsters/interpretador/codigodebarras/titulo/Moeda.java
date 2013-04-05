package com.devmonsters.interpretador.codigodebarras.titulo;

public enum Moeda {
    
    REAL(9, "Real");
    
    private final int codigo;
    private final String descricao;
    
    private Moeda(final int codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public String getDescricao() {
        return this.descricao;
    }
    
    public static Moeda valueOfCodigo(final int codigo) {
        for (final Moeda moeda : Moeda.values()) {
            if (moeda.getCodigo() == codigo) {
                return moeda;
            }
        }
        return null;
    }
}
