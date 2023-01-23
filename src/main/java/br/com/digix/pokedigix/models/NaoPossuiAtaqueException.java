package br.com.digix.pokedigix.models;

public class NaoPossuiAtaqueException extends Exception {

    public NaoPossuiAtaqueException() {
        super("O pokemom deve ter pelomenos 1 ataque");
    }

}
