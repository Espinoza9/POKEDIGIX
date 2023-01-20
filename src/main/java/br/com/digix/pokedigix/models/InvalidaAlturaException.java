package br.com.digix.pokedigix.models;

public class InvalidaAlturaException extends Exception {

    public InvalidaAlturaException() {

        super("Altura nao pode ser menor que zero");
    }

    
}
