package br.com.digix.pokedigix.models;

public class FelicidadeInvalidaException extends Exception {

    public FelicidadeInvalidaException() {
        super("A felicidade deve estar entre 0 e 100");
       
    }
    
}
