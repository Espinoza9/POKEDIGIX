package br.com.digix.pokedigix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import br.com.digix.pokedigix.models.Pokemon;
import br.com.digix.pokedigix.models.Tipo;

public interface PokemonRepository extends CrudRepository<Pokemon , Long>{

    List<Pokemon> findByNomeContainingIgnoreCase(String nome);

    List<Pokemon> findByTiposIn(List<Tipo> tipoGrama);
    
}
