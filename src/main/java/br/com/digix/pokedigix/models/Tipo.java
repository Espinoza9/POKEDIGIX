package br.com.digix.pokedigix.models;

import lombok.Getter;

@Getter
public class Tipo {
    String nome = "eletrico";
    String cor = "amarelo";
    String simbolo="";

    public Tipo(String nome, String cor, String simbolo) {
        this.nome = nome;
        this.cor = cor;
        this.simbolo = simbolo;
    }
    
}
