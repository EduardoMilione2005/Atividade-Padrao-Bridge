package com.controle;

import com.controle.controle.ControleBasico;
import com.controle.implementacao.TV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do Controle Básico")
public class ControleBasicoTest {

    private TV tv;
    private ControleBasico controle;

    @BeforeEach
    void setUp() {
        tv = new TV();
        controle = new ControleBasico(tv);
    }

    @Test
    @DisplayName("Deve ligar o dispositivo")
    void testLigar() {
        controle.ligar();
        assertEquals(true, controle.getDispositivo().isLigado());
    }

    @Test
    @DisplayName("Deve desligar o dispositivo")
    void testDesligar() {
        controle.ligar();
        controle.desligar();
        assertEquals(false, controle.getDispositivo().isLigado());
    }

    @Test
    @DisplayName("Deve aumentar o volume em 10")
    void testAumentarVolume() {
        int volumeInicial = tv.getVolume();
        controle.aumentarVolume();
        assertEquals(volumeInicial + 10, controle.getDispositivo().getVolume());
    }

    @Test
    @DisplayName("Deve diminuir o volume em 10")
    void testDiminuirVolume() {
        int volumeInicial = tv.getVolume();
        controle.diminuirVolume();
        assertEquals(volumeInicial - 10, controle.getDispositivo().getVolume());
    }

    @Test
    @DisplayName("Deve mudar para o próximo canal")
    void testProximoCanal() {
        int canalInicial = tv.getCanal();
        controle.proximoCanal();
        assertEquals(canalInicial + 1, controle.getDispositivo().getCanal());
    }

    @Test
    @DisplayName("Deve ir para o canal anterior")
    void testCanalAnterior() {
        tv.setCanal(5);
        controle.canalAnterior();
        assertEquals(4, controle.getDispositivo().getCanal());
    }

    @Test
    @DisplayName("Deve mudar para um canal específico")
    void testMudarCanal() {
        controle.mudarCanal(15);
        assertEquals(15, controle.getDispositivo().getCanal());
    }

    @Test
    @DisplayName("Deve ajustar para um volume específico")
    void testAjustarVolume() {
        controle.ajustarVolume(75);
        assertEquals(75, controle.getDispositivo().getVolume());
    }

    @Test
    @DisplayName("Deve retornar o dispositivo associado")
    void testGetDispositivo() {
        assertNotNull(controle.getDispositivo());
        assertEquals(tv, controle.getDispositivo());
    }
}
