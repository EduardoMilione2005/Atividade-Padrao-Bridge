package com.controle.implementacao;

import com.controle.dispositivo.Dispositivo;

public class TV implements Dispositivo {

    private boolean ligada = false;
    private int volume = 30;
    private int canal = 1;
    private static final int VOLUME_MAX = 100;
    private static final int VOLUME_MIN = 0;

    @Override
    public boolean isLigado() {
        return ligada;
    }

    @Override
    public void ligar() {
        ligada = true;
        System.out.println("[TV] Ligando a televisão...");
    }

    @Override
    public void desligar() {
        ligada = false;
        System.out.println("[TV] Desligando a televisão...");
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
        System.out.println("[TV] Volume ajustado para: " + this.volume);
    }

    @Override
    public int getCanal() {
        return canal;
    }

    @Override
    public void setCanal(int canal) {
        if (canal >= 1) {
            this.canal = canal;
            System.out.println("[TV] Canal alterado para: " + this.canal);
        }
    }

    @Override
    public String getStatus() {
        return String.format("TV | Ligada: %s | Volume: %d | Canal: %d",
                ligada, volume, canal);
    }
}
