package br.com.digix.pokedigix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.digix.pokedigix.models.Pokemon;
@Repository
public interface PokemonRepository extends CrudRepository<Pokemon , Long>{

    List<Pokemon> findByNomeContainingIgnoreCase(String nome);
    
}
