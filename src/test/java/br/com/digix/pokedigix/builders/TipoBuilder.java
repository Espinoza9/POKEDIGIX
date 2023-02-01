package br.com.digix.pokedigix.builders;


import java.io.IOException;

import br.com.digix.pokedigix.models.Tipo;


public class TipoBuilder {

    private String nome = "Water";
    private String cor = "#4592c4";
    private byte[] simbolo;

    public TipoBuilder() throws IOException {
        this.simbolo = ArquivoUtils.abrirArquivo("src\\test\\java\\br\\com\\digix\\pokedigix\\icons\\Pokemon_Type_Icon_Water.png");
    }

    public Tipo construir() {
        return new Tipo(nome, cor, simbolo);
    }

    public TipoBuilder comNome(String nome) {
        this.nome = nome;
        return this;
    }

  
}