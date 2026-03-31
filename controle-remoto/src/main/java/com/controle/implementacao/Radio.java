package com.controle.implementacao;

import com.controle.dispositivo.Dispositivo;

/**
 * Implementação Concreta (ConcreteImplementor) do padrão Bridge.
 * Representa um rádio com suas características específicas.
 */
public class Radio implements Dispositivo {

    private boolean ligado = false;
    private int volume = 20;
    private int canal = 87; // frequência FM em MHz
    private static final int VOLUME_MAX = 100;
    private static final int VOLUME_MIN = 0;
    private static final int FREQUENCIA_MIN = 87;
    private static final int FREQUENCIA_MAX = 108;

    @Override
    public boolean isLigado() {
        return ligado;
    }

    @Override
    public void ligar() {
        ligado = true;
        System.out.println("[Rádio] Ligando o rádio...");
    }

    @Override
    public void desligar() {
        ligado = false;
        System.out.println("[Rádio] Desligando o rádio...");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        if (volume < VOLUME_MIN) {
            this.volume = VOLUME_MIN;
        } else if (volume > VOLUME_MAX) {
            this.volume = VOLUME_MAX;
        } else {
            this.volume = volume;
        }
        System.out.println("[Rádio] Volume ajustado para: " + this.volume);
    }

    @Override
    public int getCanal() {
        return canal;
    }

    @Override
    public void setCanal(int canal) {
        if (canal >= FREQUENCIA_MIN && canal <= FREQUENCIA_MAX) {
            this.canal = canal;
            System.out.println("[Rádio] Frequência ajustada para: " + this.canal + " MHz");
        } else {
            System.out.println("[Rádio] Frequência inválida! Deve ser entre " + FREQUENCIA_MIN + " e " + FREQUENCIA_MAX + " MHz");
        }
    }

    @Override
    public String getStatus() {
        return String.format("Rádio | Ligado: %s | Volume: %d | Frequência: %d MHz",
                ligado, volume, canal);
    }
}
