package com.controle;

import com.controle.implementacao.Radio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes da classe Rádio")
public class RadioTest {

    private Radio radio;

    @BeforeEach
    void setUp() {
        radio = new Radio();
    }

    @Test
    @DisplayName("Rádio deve iniciar desligado")
    void testRadioIniciaDesligado() {
        assertEquals(false, radio.isLigado());
    }

    @Test
    @DisplayName("Rádio deve ligar corretamente")
    void testLigar() {
        radio.ligar();
        assertEquals(true, radio.isLigado());
    }

    @Test
    @DisplayName("Rádio deve desligar corretamente")
    void testDesligar() {
        radio.ligar();
        radio.desligar();
        assertEquals(false, radio.isLigado());
    }

    @Test
    @DisplayName("Volume inicial do rádio deve ser 20")
    void testVolumeInicial() {
        assertEquals(20, radio.getVolume());
    }

    @Test
    @DisplayName("Deve ajustar volume corretamente")
    void testSetVolume() {
        radio.setVolume(60);
        assertEquals(60, radio.getVolume());
    }

    @Test
    @DisplayName("Volume não deve ultrapassar 100")
    void testVolumeLimiteMaximo() {
        radio.setVolume(200);
        assertEquals(100, radio.getVolume());
    }

    @Test
    @DisplayName("Volume não deve ser negativo")
    void testVolumeLimiteMinimo() {
        radio.setVolume(-5);
        assertEquals(0, radio.getVolume());
    }

    @Test
    @DisplayName("Frequência inicial deve ser 87 MHz")
    void testFrequenciaInicial() {
        assertEquals(87, radio.getCanal());
    }

    @Test
    @DisplayName("Deve ajustar frequência válida")
    void testSetFrequenciaValida() {
        radio.setCanal(100);
        assertEquals(100, radio.getCanal());
    }

    @Test
    @DisplayName("Frequência abaixo do mínimo não deve ser aceita")
    void testFrequenciaAbaixoDoMinimo() {
        radio.setCanal(50);
        assertEquals(87, radio.getCanal());
    }

    @Test
    @DisplayName("Frequência acima do máximo não deve ser aceita")
    void testFrequenciaAcimaDoMaximo() {
        radio.setCanal(120);
        assertEquals(87, radio.getCanal());
    }

    @Test
    @DisplayName("Status deve conter informações corretas")
    void testGetStatus() {
        radio.ligar();
        radio.setVolume(35);
        radio.setCanal(98);
        String status = radio.getStatus();
        assertTrue(status.contains("Rádio"));
        assertTrue(status.contains("true"));
        assertTrue(status.contains("35"));
        assertTrue(status.contains("98"));
    }
}
