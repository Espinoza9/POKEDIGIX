package br.com.digix.pokedigix.models;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.builders.AtaqueBuilder;
import br.com.digix.pokedigix.builders.TipoBuilder;

public class AtaqueTest {
  @Test
  public void deve_criar_um_ataque()
      throws AcuraciaInvalidaException, PontosDePoderInvalidaException, ForcaInvalidaException, IOException, QuantidadeDeTiposInvalidaException {
    int forca = 50;
    Categoria categoria = Categoria.FISICO;
    int acuracia = 100;
    String nome = "chamas da paixao";
    String descricao = "deixa o inimigo apaixonado";
    int pontosDePoder = 15;


    Ataque ataque = new AtaqueBuilder().construir();

   

    Assertions.assertEquals(forca, ataque.getForca());
    Assertions.assertEquals(categoria, ataque.getCategoria());
    Assertions.assertEquals(acuracia, ataque.getAcuracia());
    Assertions.assertEquals(nome, ataque.getNome());
    Assertions.assertEquals(descricao, ataque.getDescricao());
    Assertions.assertEquals(pontosDePoder, ataque.getPontosDePoder());
  }

  @Test
  public void acuracia_nao_deve_ser_maior_que_cem() {

    Assertions.assertThrows(AcuraciaInvalidaException.class, () -> {
      new AtaqueBuilder().comAcuracia(101).construir();

    });
  }

  @Test
  public void acuracia_nao_deve_ser_menor_que_zero() {

    Assertions.assertThrows(AcuraciaInvalidaException.class, () -> {
      new AtaqueBuilder().comAcuracia(-1).construir();

    });
  }

  @Test
  public void pontosDePoder_menor_que_menos_um() {

    Assertions.assertThrows(PontosDePoderInvalidaException.class, () -> {
      new AtaqueBuilder().comPontosDePoder(-2).construir();
    });

  }

  @Test
  public void pontosDePoder_nao_ser_maior_que_quarenta() {

    Assertions.assertThrows(PontosDePoderInvalidaException.class, () -> {
      new AtaqueBuilder().comPontosDePoder(41).construir();
    });

  }

  @Test
  public void forca_nao_pode_ser_menor_que_zero() {

    Assertions.assertThrows(ForcaInvalidaException.class, () -> {
      new AtaqueBuilder().comforca(-1).construir();
    });

  }

  @Test
  public void deve_ter_um_tipo() throws Exception {



    Tipo tipos = new TipoBuilder().construir();
     Ataque ataque = new AtaqueBuilder().comTipo(tipos).construir();
    
    Assertions.assertEquals(tipos, ataque.getTipo());
  }
  

  }
