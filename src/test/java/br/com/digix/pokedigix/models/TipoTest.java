package br.com.digix.pokedigix.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TipoTest {
    @Test
    public void deve_cria_um_tipo() {
        String nome = "eletrico";
        String cor = "amarelo";
        String simbolo="";
    
    Tipo tipo = new Tipo(nome,cor,simbolo);
    
        assertEquals(nome , tipo.getNome());
        assertEquals(cor , tipo.getCor());
        assertEquals(simbolo, tipo.getSimbolo());
}
}
