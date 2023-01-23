package br.com.digix.pokedigix.models;

public class AcuraciaInvalidaException extends Exception {

    public AcuraciaInvalidaException() {
        super("Acuracia nao deve ser menor que 0 ou maior que 100");

    }
    
    
}
