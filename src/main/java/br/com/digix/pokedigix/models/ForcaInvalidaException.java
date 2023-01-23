package br.com.digix.pokedigix.models;

public class ForcaInvalidaException extends Exception {

    public ForcaInvalidaException() {
        super("forca nao poder ser menor que 0");
    }

}
