package br.com.digix.pokedigix.models;

import net.bytebuddy.implementation.bind.annotation.Super;

public class PontosDePoderInvalidaException extends Exception{
    public PontosDePoderInvalidaException() {
        super("Pontos de poder deve ficar ente 0 e 100");

    }


}

