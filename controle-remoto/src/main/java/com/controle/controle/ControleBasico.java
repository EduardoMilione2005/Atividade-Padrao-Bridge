package com.controle.controle;

import com.controle.dispositivo.Dispositivo;

public class ControleBasico extends ControleRemoto {

    public ControleBasico(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void mudarCanal(int canal) {
        System.out.println("[Controle Básico] Mudando para o canal " + canal);
        dispositivo.setCanal(canal);
    }

    public void ajustarVolume(int volume) {
        System.out.println("[Controle Básico] Ajustando volume para " + volume);
        dispositivo.setVolume(volume);
    }
}
