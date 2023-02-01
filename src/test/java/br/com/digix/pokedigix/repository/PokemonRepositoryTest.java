package br.com.digix.pokedigix.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.builders.PokemonBuilder;
import br.com.digix.pokedigix.models.Pokemon;

@DataJpaTest
public class PokemonRepositoryTest {
    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() throws Exception {

        Pokemon pokemon = new PokemonBuilder().construir();
        pokemonRepository.save(pokemon);

    Assertions.assertNotNull(pokemon.getId());

    }
    @Test
    public void deve_remover_um_pokemon() throws Exception {

        Pokemon pokemon= new PokemonBuilder().construir();
        pokemonRepository.save(pokemon);

        pokemonRepository.deleteById(pokemon.getId());

        Optional<Pokemon> tipoBuscado = pokemonRepository.findById(pokemon.getId());
        Assertions.assertFalse(tipoBuscado.isPresent());
    }
    @Test
    public void deve_buscar_pelo_nome() throws Exception {
        String nome="water";
        Pokemon pokemon = new PokemonBuilder().comNome(nome).construir();
        pokemonRepository.save(pokemon);

      List<Pokemon> pokemonRetornado=  pokemonRepository.findByNomeContainingIgnoreCase(nome);
      Assertions.assertTrue(pokemonRetornado.contains(pokemon));

    }

}
