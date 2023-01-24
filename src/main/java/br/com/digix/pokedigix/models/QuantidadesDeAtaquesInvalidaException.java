package br.com.digix.pokedigix.models;

public class QuantidadesDeAtaquesInvalidaException extends Exception{

    public QuantidadesDeAtaquesInvalidaException() {
        super("nao pode conter mais de 4 ataques");
    }


}
