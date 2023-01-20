package br.com.digix.pokedigix.models;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.beans.Transient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PokemonTest {

    @Test
    public void deve_criar_um_pokemon()
            throws FelicidadeInvalidaException, InvalidaAlturaException, PesoInvalidaException, NivelInvalidaException {
        // Arranger
        String nome = "pikachu";
        char genero = 'f';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 70;
        int nivel = 5;

        // Act
        Pokemon pokemon = new Pokemon(nome, genero, altura, peso, felicidade, nivel);

        // Assertion
        Assertions.assertEquals(nome, pokemon.getNome());
        Assertions.assertEquals(genero, pokemon.getGenero());
        Assertions.assertEquals(altura, pokemon.getAltura());
        Assertions.assertEquals(peso, pokemon.getPeso());
        Assertions.assertEquals(felicidade, pokemon.getFelicidade());
        Assertions.assertEquals(nivel, pokemon.getNivel());

    }

    @Test
    public void nao_deve_ter_felicidade_menor_que_zero() {
        String nome = "pikachu";
        char genero = 'f';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = -1;
        int nivel = 5;

        // Action $ assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);

        });
    }

    @Test
    public void nao_deve_ter_felicidade_acima_de_cem() {
        String nome = "pikachu";
        char genero = 'f';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 101;
        int nivel = 5;

        // Action $ assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);

        });

    }

    @Test
    public void altura_nao_pode_ser_menor_que_zero() {
        String nome = "pikachu";
        char genero = 'f';
        var altura = -1f;
        float peso = 2.1f;
        int felicidade = 80;
        int nivel = 5;

        Assertions.assertThrows(InvalidaAlturaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);

        });

    }

    @Test
    public void peso_nao_pode_ser_menor_que_zero() {
        String nome = "pikachu";
        char genero = 'f';
        var altura = 0.3f;
        float peso = -1f;
        int felicidade = 80;
        int nivel = 5;

        Assertions.assertThrows(PesoInvalidaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }

    @Test
    public void nivel_nao_pode_ser_menor_que_um() {
        String nome = "pikachu";
        char genero = 'f';
        var altura = 0.3f;
        float peso = 0.5f;
        int felicidade = 80;
        int nivel = 0;

        Assertions.assertThrows(NivelInvalidaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }

    @Test
    public void nivel_nao_pode_ser_maior_que_cem() {
        String nome = "pikachu";
        char genero = 'f';
        var altura = 0.3f;
        float peso = 0.5f;
        int felicidade = 80;
        int nivel = 101;

        Assertions.assertThrows(NivelInvalidaException.class, () -> {
            new Pokemon(nome, genero, altura, peso, felicidade, nivel);
        });
    }
}
