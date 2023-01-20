package br.com.digix.pokedigix.models;

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

    
    public Pokemon(String nome, char genero, float altura, float peso, int felicidade, int nivel) throws FelicidadeInvalidaException, InvalidaAlturaException,PesoInvalidaException,NivelInvalidaException{
        verificarFelicidadeEntreZeroECem(felicidade);
        verificarAlturaMenorQueZero(altura);
        verificarPesoMenorQueZero(peso);
        verificarNivelMenorQueZero(nivel);
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.peso = peso;
        this.felicidade = felicidade;
        this.nivel = nivel;
        
    }
    
        private void verificarFelicidadeEntreZeroECem(int felicidade) throws FelicidadeInvalidaException {
        if (felicidade < 0 || felicidade > 100) {
            throw new FelicidadeInvalidaException();
        }
    }

    private void verificarAlturaMenorQueZero(float altura) throws InvalidaAlturaException {
        if (altura < 0 ) {
            throw new InvalidaAlturaException();
        }
    }
    private void verificarPesoMenorQueZero(float peso) throws PesoInvalidaException {
        if (peso < 0 ) {
            throw new PesoInvalidaException();
        }
    }

    private void verificarNivelMenorQueZero(float nivel) throws NivelInvalidaException {
        if (nivel < 1 || nivel > 100 ) {
            throw new NivelInvalidaException();
        }
    }
}






