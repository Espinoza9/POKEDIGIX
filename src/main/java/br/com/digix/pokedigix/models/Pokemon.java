package br.com.digix.pokedigix.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class Pokemon {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @JsonInclude(Include.NON_NULL)
    private Long id;
    private String nome;
    private char genero;
    private float altura;
    private float peso;
    private int felicidade;
    private int nivel;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Ataque> ataques;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Tipo> tipos;
    private int velocidade;

    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel, List<Ataque> ataques, List<Tipo> tipos , int velocidade)
            throws FelicidadeInvalidaException, InvalidaAlturaException, PesoInvalidaException, NivelInvalidaException,
            NaoPossuiAtaqueException, QuantidadesDeAtaquesInvalidaException,QuantidadeDeTiposInvalidaException,VelocidadeInvalidaException{
                verificarFelicidadeEntreZeroECem(felicidade);
                verificarAlturaMenorQueZero(altura);
                verificarPesoMenorQueZero(peso);
                verificarNivelMenorQueZero(nivel);
                verificarSePossuiAoMenosUmAtaque(ataques);
                verificarSeAtaqueMenorQueQuatro(ataques);
                verificarQuantidadesDeTipos(tipos);
                verificarSeVelocidadeMenorQueUm(velocidade);
                this.velocidade = velocidade;
                this.ataques = ataques;
                this.nome = nome;
                this.genero = genero;
                this.altura = altura;
                this.peso = peso;
                this.felicidade = felicidade;
                this.nivel = nivel;
                this.tipos = tipos;
            }

    private void verificarSePossuiAoMenosUmAtaque(List<Ataque> ataques) throws NaoPossuiAtaqueException {
        if (ataques.size() == 0) {
            throw new NaoPossuiAtaqueException();
        }
    }

    private void verificarFelicidadeEntreZeroECem(int felicidade) throws FelicidadeInvalidaException {
        if (felicidade < 0 || felicidade > 100) {
            throw new FelicidadeInvalidaException();
        }
    }

    private void verificarAlturaMenorQueZero(float altura) throws InvalidaAlturaException {
        if (altura < 0) {
            throw new InvalidaAlturaException();
        }
    }

    private void verificarPesoMenorQueZero(float peso) throws PesoInvalidaException {
        if (peso < 0) {
            throw new PesoInvalidaException();
        }
    }

    private void verificarNivelMenorQueZero(float nivel) throws NivelInvalidaException {
        if (nivel < 1 || nivel > 100) {
            throw new NivelInvalidaException();
        }
    }

    private void verificarSeAtaqueMenorQueQuatro(List<Ataque> ataques) throws QuantidadesDeAtaquesInvalidaException {
        if (ataques.size() > 4) {
            throw new QuantidadesDeAtaquesInvalidaException();
        }
    }

    private  void verificarQuantidadesDeTipos(List<Tipo> tipos) throws QuantidadeDeTiposInvalidaException{
        if ( tipos.size() > 2 || tipos.size() <1){
            throw new QuantidadeDeTiposInvalidaException();
        }
    }
    private void verificarSeVelocidadeMenorQueUm(int velocidade) throws VelocidadeInvalidaException{
        if (velocidade <1){
            throw new VelocidadeInvalidaException();
        }
    }
   
    

    }

