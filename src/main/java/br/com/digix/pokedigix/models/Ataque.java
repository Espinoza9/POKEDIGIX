package br.com.digix.pokedigix.models;

import lombok.Getter;

@Getter
public class Ataque {

    private int forca;
    private Categoria categoria;
    private int acuracia;
    private String nome;
    private String descricao;
    private int pontosDePoder;
    private Tipo tipos;

    public Ataque(int forca, Categoria categoria, int acuracia, String nome, String descricao, int pontosDePoder,
            Tipo tipo) throws AcuraciaInvalidaException, PontosDePoderInvalidaException, ForcaInvalidaException,
            QuantidadeDeTiposInvalidaException {
        verificarAcuraciaEntreZeroECem(acuracia);
        verificarPontosDePoderEntreMenosUmEQuarenta(pontosDePoder);
        verificarForcaMenorQueZero(forca);
       
        this.forca = forca;
        this.categoria = categoria;
        this.nome = nome;
        this.acuracia = acuracia;
        this.descricao = descricao;
        this.pontosDePoder = pontosDePoder;
        this.tipos = tipo;

    }

    private void verificarAcuraciaEntreZeroECem(int acuracia) throws AcuraciaInvalidaException {
        if (acuracia > 100 || acuracia < 0) {

            throw new AcuraciaInvalidaException();
        }
    }

    private void verificarPontosDePoderEntreMenosUmEQuarenta(int pontosDePoder) throws PontosDePoderInvalidaException {
        if (pontosDePoder < -1 || pontosDePoder > 40) {

            throw new PontosDePoderInvalidaException();
        }
    }

    private void verificarForcaMenorQueZero(int forca) throws ForcaInvalidaException {
        if (forca < 0) {

            throw new ForcaInvalidaException();
        }
    }

}
