package br.com.digix.pokedigix.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.builders.TipoBuilder;
import br.com.digix.pokedigix.models.Tipo;

@DataJpaTest
public class TipoRepositoryTest {

    @Autowired
    private TipoRepository tipoRepository;
    @Test
    public void dve_salvar_um_tipo() throws Exception{
        Tipo tipo = new TipoBuilder().construir();

        tipoRepository.save(tipo);

        Assertions.assertNotNull(tipo.getId());
        
    }
}
