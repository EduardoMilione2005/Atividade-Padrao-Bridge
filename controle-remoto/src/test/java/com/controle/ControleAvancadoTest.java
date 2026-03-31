package com.controle;

import com.controle.controle.ControleAvancado;
import com.controle.implementacao.Radio;
import com.controle.implementacao.TV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Controle Avançado")
public class ControleAvancadoTest {

    private TV tv;
    private ControleAvancado controle;

    @BeforeEach
    void setUp() {
        tv = new TV();
        controle = new ControleAvancado(tv);
    }

    @Test
    @DisplayName("Silenciar deve zerar o volume")
    void testSilenciarZeraVolume() {
        tv.setVolume(50);
        controle.silenciar();
        assertEquals(0, controle.getDispositivo().getVolume());
    }

    @Test
    @DisplayName("Silenciar deve ativar o estado mudo")
    void testSilenciarAtivaMudo() {
        controle.silenciar();
        assertEquals(true, controle.isMudo());
    }

    @Test
    @DisplayName("Silenciar duas vezes deve restaurar o volume original")
    void testSilenciarDuasVezesRestauaVolume() {
        tv.setVolume(60);
        controle.silenciar(); 
        controle.silenciar(); 
        assertEquals(60, controle.getDispositivo().getVolume());
    }

    @Test
    @DisplayName("Silenciar duas vezes deve desativar o mudo")
    void testSilenciarDuasVezesDesativaMudo() {
        controle.silenciar();
        controle.silenciar();
        assertEquals(false, controle.isMudo());
    }

    @Test
    @DisplayName("Canal favorito padrão deve ser 1")
    void testCanalFavoritoPadrao() {
        assertEquals(1, controle.getCanalFavorito());
    }

    @Test
    @DisplayName("Deve salvar o canal atual como favorito")
    void testSalvarCanalFavorito() {
        tv.setCanal(8);
        controle.salvarCanalFavorito();
        assertEquals(8, controle.getCanalFavorito());
    }

    @Test
    @DisplayName("Deve ir para o canal favorito salvo")
    void testIrParaCanalFavorito() {
        tv.setCanal(12);
        controle.salvarCanalFavorito();
        tv.setCanal(1);
        controle.irParaCanalFavorito();
        assertEquals(12, controle.getDispositivo().getCanal());
    }

    @Test
    @DisplayName("Deve definir um canal favorito diretamente")
    void testDefinirCanalFavorito() {
        controle.definirCanalFavorito(20);
        assertEquals(20, controle.getCanalFavorito());
    }

    @Test
    @DisplayName("Deve ajustar volume via controle avançado")
    void testAjustarVolume() {
        controle.ajustarVolume(80);
        assertEquals(80, controle.getDispositivo().getVolume());
    }

    @Test
    @DisplayName("Padrão Bridge: controle avançado deve funcionar com Rádio")
    void testBridgeControleAvancadoComRadio() {
        Radio radio = new Radio();
        ControleAvancado controleRadio = new ControleAvancado(radio);

        controleRadio.ligar();
        controleRadio.getDispositivo().setCanal(98);
        controleRadio.salvarCanalFavorito();
        controleRadio.getDispositivo().setCanal(100);
        controleRadio.irParaCanalFavorito();

        assertEquals(true, controleRadio.getDispositivo().isLigado());
        assertEquals(98, controleRadio.getDispositivo().getCanal());
        assertEquals(98, controleRadio.getCanalFavorito());
    }
}
