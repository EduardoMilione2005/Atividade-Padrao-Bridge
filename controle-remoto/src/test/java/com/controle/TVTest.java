package com.controle;

import com.controle.implementacao.TV;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe TV")
public class TVTest {

    private TV tv;

    @BeforeEach
    void setUp() {
        tv = new TV();
    }

    @Test
    @DisplayName("TV deve iniciar desligada")
    void testTVIniciaDesligada() {
        assertEquals(false, tv.isLigado());
    }

    @Test
    @DisplayName("TV deve ligar corretamente")
    void testLigar() {
        tv.ligar();
        assertEquals(true, tv.isLigado());
    }

    @Test
    @DisplayName("TV deve desligar corretamente")
    void testDesligar() {
        tv.ligar();
        tv.desligar();
        assertEquals(false, tv.isLigado());
    }

    @Test
    @DisplayName("Volume inicial deve ser 30")
    void testVolumeInicial() {
        assertEquals(30, tv.getVolume());
    }

    @Test
    @DisplayName("Deve ajustar volume corretamente")
    void testSetVolume() {
        tv.setVolume(50);
        assertEquals(50, tv.getVolume());
    }

    @Test
    @DisplayName("Volume não deve ultrapassar 100")
    void testVolumeLimiteMaximo() {
        tv.setVolume(150);
        assertEquals(100, tv.getVolume());
    }

    @Test
    @DisplayName("Volume não deve ser menor que 0")
    void testVolumeLimiteMinimo() {
        tv.setVolume(-10);
        assertEquals(0, tv.getVolume());
    }

    @Test
    @DisplayName("Canal inicial deve ser 1")
    void testCanalInicial() {
        assertEquals(1, tv.getCanal());
    }

    @Test
    @DisplayName("Deve mudar de canal corretamente")
    void testSetCanal() {
        tv.setCanal(10);
        assertEquals(10, tv.getCanal());
    }

    @Test
    @DisplayName("Canal inválido não deve ser aceito")
    void testCanalInvalido() {
        tv.setCanal(0);
        assertEquals(1, tv.getCanal());
    }

    @Test
    @DisplayName("Status deve conter informações corretas")
    void testGetStatus() {
        tv.ligar();
        tv.setVolume(45);
        tv.setCanal(7);
        String status = tv.getStatus();
        assertTrue(status.contains("TV"));
        assertTrue(status.contains("true"));
        assertTrue(status.contains("45"));
        assertTrue(status.contains("7"));
    }
}
