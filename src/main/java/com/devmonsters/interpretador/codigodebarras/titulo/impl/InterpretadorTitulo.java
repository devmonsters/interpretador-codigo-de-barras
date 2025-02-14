package com.devmonsters.interpretador.codigodebarras.titulo.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;

import com.devmonsters.interpretador.codigodebarras.Interpretador;
import com.devmonsters.interpretador.codigodebarras.TipoDocumento;
import com.devmonsters.interpretador.codigodebarras.titulo.InstituicaoFinanceira;
import com.devmonsters.interpretador.codigodebarras.titulo.Moeda;

public abstract class InterpretadorTitulo implements Interpretador {

    private static final long serialVersionUID = 4437522256398278698L;
    private static final LocalDate DATA_BASE_VENCIMENTO = LocalDate.of(1997, 10, 7);
    private static final LocalDate DATA_BASE_VENCIMENTO_POS_22022025 = LocalDate.of(2025, 2, 22);
    public static final int VALOR_INICIAL_FATOR_VENCIMENTO_POS_22022025 = 1000;
    public static final int LIMITE_MINIMO_DIAS = 3000;
    public static final int LIMITE_MAXIMO_DIAS = 5500;
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
        //A posição do fator vencimento varia de codigo de barras para linha digitavel, vide em https://www.boletobancario-codigodebarras.com/2016/04/linha-digitavel.html
        if (this.codigoDeBarras.length() == 47) {// é linha digitavel
            return Integer.parseInt(this.codigoDeBarras.substring(33, 37));
        }
        //é código de barras
        return Integer.parseInt(this.codigoDeBarras.substring(5, 9));
    }

    @Override
    public LocalDate getDataVencimento() {
        int fatorVencimento = this.getFatorVencimento();
        if (fatorVencimento > 0) {
            final var dataAtual = LocalDate.now();
            //São considerados válidos (e com possibilidade de pagamento) os boletos cujo fator de vencimento esteja entre 3.000 dias anteriores e 5.500 dias posteriores à data
            //Com isso, estabelecemos limites no vencimento do boleto e desconsideramos boletos antigos, https://forum.casadodesenvolvedor.com.br/topic/49188-22-de-fevereiro-de-2025-por-que-emissores-de-boletos-precisam-se-atentar-a-esta-data/
            final var dataBaseMin = dataAtual.minusDays(LIMITE_MINIMO_DIAS);
            final var dataBaseMax = dataAtual.plusDays(LIMITE_MAXIMO_DIAS);

            final var dataVencimento = DATA_BASE_VENCIMENTO.plusDays(fatorVencimento);
            if (!(dataVencimento.isAfter(dataBaseMin) && dataVencimento.isBefore(dataBaseMax))) {
                final var dataVencimentoPos2025 = DATA_BASE_VENCIMENTO_POS_22022025.plusDays(fatorVencimento - VALOR_INICIAL_FATOR_VENCIMENTO_POS_22022025);
                return dataVencimentoPos2025;
            }
            return dataVencimento;
        }
        return null;
    }

    /**
     * Se o valor do codigo de barras for 0, e porque nao ha valor, neste caso fica acertado que retorna nulo. <br>
     * Nao ha cobranca - real - de valor 0, isto e uma forma de indicar que nao ha valor e este deve ser informado no pagamento.
     */
    @Override
    public BigDecimal getValor() {
        final BigDecimal valorNoCodigoDeBarras = new BigDecimal(this.codigoDeBarras.substring(9, 19)).divide(new BigDecimal("100"), new MathContext(18)).setScale(2, RoundingMode.HALF_UP);
        return valorNoCodigoDeBarras.signum() == 0 ? null : valorNoCodigoDeBarras;
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