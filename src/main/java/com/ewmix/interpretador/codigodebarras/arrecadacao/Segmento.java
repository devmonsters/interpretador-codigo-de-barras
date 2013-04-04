package com.ewmix.interpretador.codigodebarras.arrecadacao;

public enum Segmento {
    PREFEITURAS(1, "Prefeituras"),
    SANEAMENTO(2, "Saneamento"),
    ENERGIA_ELETRICA_E_GAS(3, "Energia el\u00e9trica e g\u00e1s"),
    TELECOMUNICACOES(4, "Telecomunica\u00e7\u00f5es"),
    ORGAOS_GOVERNAMENTAIS(5, "\u00d3rg\u00e3os governamentais"),
    CARNES_DEMAIS_EMPRESAS_ORGAOS(6, "Carnes e assemelhados ou demais empresas / \u00f3rg\u00e3os que ser\u00e3o identificadas atrav\u00e9s do CNPJ"),
    MULTAS_TRANSITO(7, "Multas de tr\u00e2nsito"),
    USO_EXCLUSIVO_BANCO(9, "Uso exclusivo do banco");

    private final int codigo;
    private final String descricao;

    private Segmento(final int codigo, final String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public static Segmento valueOfCodigo(final int codigo) {
        for (final Segmento segmento : Segmento.values()) {
            if (codigo == segmento.getCodigo()) {
                return segmento;
            }
        }
        return null;
    }
}