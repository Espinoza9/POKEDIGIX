package br.com.digix.pokedigix.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public void dve_salvar_um_tipo() throws Exception {
        Tipo tipo = new TipoBuilder().construir();

        tipoRepository.save(tipo);

        Assertions.assertNotNull(tipo.getId());

    }

    @Test
    public void deve_remover_um_tipo_cadastrado() throws IOException {

        Tipo tipo = new TipoBuilder().construir();
        tipoRepository.save(tipo);

        tipoRepository.deleteById(tipo.getId());

        Optional<Tipo> tipoBuscado = tipoRepository.findById(tipo.getId());
        Assertions.assertFalse(tipoBuscado.isPresent());
    }

    @Test
    public void deve_buscar_pelo_nome() throws IOException {
        String nome = "water";
        Tipo tipo = new TipoBuilder().comNome(nome).construir();
        tipoRepository.save(tipo);

        List<Tipo> tipoRetornado = tipoRepository.findByNomeContainingIgnoreCase(nome);
        Assertions.assertTrue(tipoRetornado.contains(tipo));

    }
}
