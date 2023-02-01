package br.com.digix.pokedigix.builders;

import java.io.IOException;

import br.com.digix.pokedigix.models.AcuraciaInvalidaException;
import br.com.digix.pokedigix.models.Ataque;
import br.com.digix.pokedigix.models.Categoria;
import br.com.digix.pokedigix.models.ForcaInvalidaException;
import br.com.digix.pokedigix.models.PontosDePoderInvalidaException;
import br.com.digix.pokedigix.models.QuantidadeDeTiposInvalidaException;
import br.com.digix.pokedigix.models.Tipo;

public class AtaqueBuilder {

    private int forca = 50;
    private Categoria categoria = Categoria.FISICO;
    private int acuracia = 100;
    private String nome = "chamas da paixao";
    private String descricao = "deixa o inimigo apaixonado";
    private int pontosDePoder = 15;
    private Tipo tipos;

    public AtaqueBuilder() throws IOException {
        this.tipos = new TipoBuilder().construir();
    }
 

    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuracia = acuracia;

        return this;
    }

    public AtaqueBuilder comPontosDePoder(int pontosDePoder) {
        this.pontosDePoder = pontosDePoder;
        return this;
    }

    public AtaqueBuilder comforca(int forca) {
        this.forca = forca;
        return this;
    }

    public Ataque construir() throws AcuraciaInvalidaException, PontosDePoderInvalidaException, ForcaInvalidaException, QuantidadeDeTiposInvalidaException {
        return new Ataque(forca, categoria, acuracia, nome, descricao, pontosDePoder,tipos);
    }

    public AtaqueBuilder comTipo(Tipo tipos) {
        this.tipos = tipos;

        return this;
    }


    public AtaqueBuilder comNome(String nome) {
        this.nome = nome;
        return this;

    }


    public AtaqueBuilder comCategoria(Categoria categoria) {
        this.categoria = categoria;
        return this;
    }

}
