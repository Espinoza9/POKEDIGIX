package br.com.digix.pokedigix.models;

import lombok.Getter;

@Getter
public class Tipo {
    private String nome = "eletrico";
    private String cor = "amarelo";
    private byte [] simbolo;

    public Tipo(String nome, String cor, byte[] simbolo) {
        this.nome = nome;
        this.cor = cor;
        this.simbolo = simbolo;
    }

}