package br.com.digix.pokedigix.models;

public class NivelInvalidaException extends Exception {

    public NivelInvalidaException() {
        super("O nivel deve estar entre 1 e 100");
    }

}
