package br.com.digix.pokedigix.models;

public class VelocidadeInvalidaException  extends Exception{

    public VelocidadeInvalidaException() {
        super("velocidade deve ser entre 1 e 100");
    }

}
