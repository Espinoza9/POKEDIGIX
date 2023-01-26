package br.com.digix.pokedigix.models;

public class PontosDePoderInvalidaException extends Exception{
    public PontosDePoderInvalidaException() {
        super("Pontos de poder deve ficar ente 0 e 100");

    }


}

