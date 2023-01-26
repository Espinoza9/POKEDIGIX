package br.com.digix.pokedigix.models;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.builders.AtaqueBuilder;
import br.com.digix.pokedigix.builders.PokemonBuilder;
import br.com.digix.pokedigix.builders.TipoBuilder;

public class PokemonTest {

    
    @Test
    public void deve_criar_um_pokemon()
            throws Exception {
        // Arranger
        String nome = "pikachu";
        char genero = 'f';
        float altura = 0.3f;
        float peso = 2.1f;
        int felicidade = 70;
        int nivel = 5;
        int velocidade = 50;
        
        // Act
        Pokemon pokemon = new PokemonBuilder().construir();
        
      //Assertion
        Assertions.assertEquals(nome, pokemon.getNome());
        Assertions.assertEquals(genero, pokemon.getGenero());
        Assertions.assertEquals(altura, pokemon.getAltura());
        Assertions.assertEquals(peso, pokemon.getPeso());
        Assertions.assertEquals(felicidade, pokemon.getFelicidade());
        Assertions.assertEquals(nivel, pokemon.getNivel());
        Assertions.assertEquals(velocidade, pokemon.getVelocidade());
    }

    @Test
    public void nao_deve_ter_felicidade_menor_que_zero() {

        // Action $ assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(-1).construir();

        });
    }

    @Test
    public void nao_deve_ter_felicidade_acima_de_cem() {

        // Action $ assert
        Assertions.assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(101).construir();

        });

    }

    @Test
    public void altura_nao_pode_ser_menor_que_zero() {

        Assertions.assertThrows(InvalidaAlturaException.class, () -> {
            new PokemonBuilder().comAltura(-1).construir();

        });

    }

    @Test
    public void peso_nao_pode_ser_menor_que_zero() {

        Assertions.assertThrows(PesoInvalidaException.class, () -> {
            new PokemonBuilder().comPeso(-1).construir();
        });
    }

    @Test
    public void nivel_nao_pode_ser_menor_que_um() {

        Assertions.assertThrows(NivelInvalidaException.class, () -> {
            new PokemonBuilder().comNivel(0).construir();
        });
    }

    @Test
    public void nivel_nao_pode_ser_maior_que_cem() {

        Assertions.assertThrows(NivelInvalidaException.class, () -> {
            new PokemonBuilder().comNivel(101).construir();
        });
    }

    @Test
    public void deve_pelo_menos_um_ataque()
            throws AcuraciaInvalidaException, PontosDePoderInvalidaException, ForcaInvalidaException,
            QuantidadesDeAtaquesInvalidaException ,QuantidadeDeTiposInvalidaException ,VelocidadeInvalidaException{

        Assertions.assertThrows(NaoPossuiAtaqueException.class, () -> {
            new PokemonBuilder().semAtaque().construir();

        });
    }
    
    @Test
    public void nao_deve_ter_velocidade_menor_um() throws Exception{
       Assertions.assertThrows(VelocidadeInvalidaException.class, () -> {
           new PokemonBuilder().comVelocidade(0).construir();
       });

    }

    @Test
    public void deve_poder_ter_quatro_ataque()
            throws Exception {
        Ataque ataque1 = new AtaqueBuilder().construir();
        Ataque ataque2 = new AtaqueBuilder().construir();
        Ataque ataque3 = new AtaqueBuilder().construir();
        Ataque ataque4 = new AtaqueBuilder().construir();

        List<Ataque> ataques = new ArrayList<>();

        ataques.add(ataque1);
        ataques.add(ataque2);
        ataques.add(ataque3);
        ataques.add(ataque4);
        
        Pokemon pokemon = new PokemonBuilder().comAtaques(ataques).construir();

        Assertions.assertTrue(ataques.containsAll(pokemon.getAtaques()));

    }

    @Test
    public void nao_deve_possuir_mais_que_quatro_ataques()
            throws Exception{
        List<Ataque> ataques = new ArrayList<>();
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());
        ataques.add(new AtaqueBuilder().construir());

        Assertions.assertThrows(QuantidadesDeAtaquesInvalidaException.class, () -> {
            new PokemonBuilder().comAtaques(ataques).construir();
        });
    }
    @Test
    public void deve_ter_dois_tipo()throws Exception{

       Tipo tipo1 = new TipoBuilder().construir();
       Tipo tipo2 = new TipoBuilder().construir();
       

       List<Tipo> tipos = new ArrayList<>();

        tipos.add(tipo1);
        tipos.add(tipo2);

         Pokemon pokemon = new PokemonBuilder().comTipo(tipos).construir();

         Assertions.assertTrue(tipos.containsAll(pokemon.getTipos()));
    }

    @Test
    public void nao_deve_ter_mais_de_dois_tipos() throws Exception {
        List<Tipo> tipos = new ArrayList<>();

        tipos.add(new TipoBuilder().construir());
        tipos.add(new TipoBuilder().construir());
        tipos.add(new TipoBuilder().construir());
       

        Assertions.assertThrows(QuantidadeDeTiposInvalidaException.class, () -> {
            new PokemonBuilder().comTipo(tipos).construir();
        } );
   
      
    }
     
   
    }

