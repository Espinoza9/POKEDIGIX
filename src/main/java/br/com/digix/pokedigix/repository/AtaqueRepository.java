package br.com.digix.pokedigix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.models.Ataque;
import br.com.digix.pokedigix.models.Categoria;

public interface AtaqueRepository extends CrudRepository<Ataque , Long>{

    List<Ataque> findByNomeContainingIgnoreCase(String nome);

    List<Ataque> findByCategoria(Categoria categoria);
    
}
