package br.com.digix.pokedigix.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter

@Setter
public class Pokemon {

    private String nome;
    private char genero;
    private float altura;
    private float peso;
    private int felicidade;
    private int nivel;
    private List<Ataque> ataques;

    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel, List<Ataque> ataques)
            throws FelicidadeInvalidaException, InvalidaAlturaException, PesoInvalidaException, NivelInvalidaException,
            NaoPossuiAtaqueException, QuantidadesDeAtaquesInvalidaException {
        verificarFelicidadeEntreZeroECem(felicidade);
        verificarAlturaMenorQueZero(altura);
        verificarPesoMenorQueZero(peso);
        verificarNivelMenorQueZero(nivel);
        verificarSePossuiAoMenosUmAtaque(ataques);
        verificarSeAtaqueMenorQueQuatro(ataques);
        this.ataques = ataques;
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.felicidade = felicidade;
        this.nivel = nivel;
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
}
