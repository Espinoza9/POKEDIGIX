package br.com.digix.pokedigix.builders;

import java.util.ArrayList;
import java.util.List;

import br.com.digix.pokedigix.models.Ataque;
import br.com.digix.pokedigix.models.FelicidadeInvalidaException;
import br.com.digix.pokedigix.models.InvalidaAlturaException;
import br.com.digix.pokedigix.models.NaoPossuiAtaqueException;
import br.com.digix.pokedigix.models.NivelInvalidaException;
import br.com.digix.pokedigix.models.PesoInvalidaException;
import br.com.digix.pokedigix.models.Pokemon;
import br.com.digix.pokedigix.models.QuantidadeDeTiposInvalidaException;
import br.com.digix.pokedigix.models.QuantidadesDeAtaquesInvalidaException;
import br.com.digix.pokedigix.models.Tipo;
import br.com.digix.pokedigix.models.VelocidadeInvalidaException;

public class PokemonBuilder {
    private String nome = "pikachu";
    private char genero = 'f';
    private float altura = 0.3f;
    private float peso = 2.1f;
    private int felicidade = 70;
    private int nivel = 5;
    private List<Ataque> ataques = new ArrayList<>();
    private List<Tipo> tipos = new ArrayList<>();
    private int velocidade = 50;

   
    
    

    public PokemonBuilder() throws Exception {
        this.ataques.add(new AtaqueBuilder().construir());
        this.tipos.add(new TipoBuilder().construir());
    }

    public PokemonBuilder comFelicidade(int felicidade) {
        this.felicidade = felicidade;
        return this;
    }

    public PokemonBuilder comAltura(float altura) {
        this.altura = altura;
        return this;
    }

    public PokemonBuilder comPeso(float peso) {
        this.peso = peso;

        return this;
    }

    public PokemonBuilder comNivel(int nivel) {
        this.nivel = nivel;

        return this;
    }

    public PokemonBuilder semAtaque() {

        this.ataques = new ArrayList<>();
        return this;

    }
    public PokemonBuilder comVelocidade(int velocidade) {
        this.velocidade = velocidade;
        return this;
    }


    public Pokemon construir()
            throws FelicidadeInvalidaException, InvalidaAlturaException, PesoInvalidaException, NivelInvalidaException,
            NaoPossuiAtaqueException, QuantidadesDeAtaquesInvalidaException,VelocidadeInvalidaException, QuantidadeDeTiposInvalidaException {
        return new Pokemon(nome, genero, altura, peso, felicidade, nivel, ataques,tipos,velocidade);
    }

    public PokemonBuilder comAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
        return this;
    }

    public PokemonBuilder comTipo(List<Tipo> tipos) {
        this.tipos = tipos;
        return this;
    }

    
   
}
