package br.com.digix.pokedigix.models;

public class QuantidadeDeTiposInvalidaException extends Exception{

    public QuantidadeDeTiposInvalidaException() {
        super("Nao deve ter mais que 2 tipos");
    }

}
