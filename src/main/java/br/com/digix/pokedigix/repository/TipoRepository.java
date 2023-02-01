package br.com.digix.pokedigix.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.digix.pokedigix.models.Tipo;

public interface TipoRepository  extends CrudRepository<Tipo , Long>{

    public List<Tipo> findByNomeContainingIgnoreCase(String nome);
    
}
