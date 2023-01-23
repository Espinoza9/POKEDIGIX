package br.com.digix.builders;

import br.com.digix.pokedigix.models.AcuraciaInvalidaException;
import br.com.digix.pokedigix.models.Ataque;
import br.com.digix.pokedigix.models.Categoria;
import br.com.digix.pokedigix.models.ForcaInvalidaException;
import br.com.digix.pokedigix.models.PontosDePoderInvalidaException;

public class AtaqueBuilder {

    int forca = 50;
    Categoria categoria = Categoria.FISICO;
    int acuracia = 100;
    String nome = "chams da paixao";
    String descricao = "deixa o inimigo apaixonado";
    int pontosDePoder = 15;
    
    

    
    

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

    public Ataque construir() throws AcuraciaInvalidaException,PontosDePoderInvalidaException, ForcaInvalidaException {
        return new Ataque(forca, categoria, acuracia, nome, descricao, pontosDePoder );
    }

}
