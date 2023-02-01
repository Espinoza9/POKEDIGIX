package br.com.digix.pokedigix.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@NoArgsConstructor
public class Ataque {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
    private int forca;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    private int acuracia;
    private String nome;
    private String descricao;
    private int pontosDePoder;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Tipo tipo;

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
        this.tipo = tipo;

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
