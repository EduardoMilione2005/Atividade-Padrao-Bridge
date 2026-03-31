package com.controle.controle;

import com.controle.dispositivo.Dispositivo;

public abstract class ControleRemoto {

    // Referência para o Implementor - núcleo do padrão Bridge
    protected Dispositivo dispositivo;

    public ControleRemoto(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public void ligar() {
        dispositivo.ligar();
    }

    public void desligar() {
        dispositivo.desligar();
    }

    public void aumentarVolume() {
        dispositivo.setVolume(dispositivo.getVolume() + 10);
    }

    public void diminuirVolume() {
        dispositivo.setVolume(dispositivo.getVolume() - 10);
    }

    public void proximoCanal() {
        dispositivo.setCanal(dispositivo.getCanal() + 1);
    }

    public void canalAnterior() {
        dispositivo.setCanal(dispositivo.getCanal() - 1);
    }

    public void exibirStatus() {
        System.out.println("Status: " + dispositivo.getStatus());
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }
}
