package br.com.digix.pokedigix.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@Entity
@NoArgsConstructor

		
	
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude(Include.NON_NULL)
    private Long id;
    
   @Column(length = 20 , nullable = false)
    private String nome = "eletrico";
    @Column(length = 20 , nullable = false)
    private String cor = "amarelo";
    @Lob
    private byte [] simbolo;
  

    public Tipo(String nome, String cor, byte[] simbolo) {
        this.nome = nome;
        this.cor = cor;
        this.simbolo = simbolo;
    }

}