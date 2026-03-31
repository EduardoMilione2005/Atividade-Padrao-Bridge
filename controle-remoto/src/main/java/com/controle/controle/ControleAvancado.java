package com.controle.controle;

import com.controle.dispositivo.Dispositivo;

public class ControleAvancado extends ControleRemoto {

    private boolean mudo = false;
    private int volumeAntesMudo = 0;
    private int canalFavorito = 1;

    public ControleAvancado(Dispositivo dispositivo) {
        super(dispositivo);
    }

    public void silenciar() {
        if (!mudo) {
            volumeAntesMudo = dispositivo.getVolume();
            dispositivo.setVolume(0);
            mudo = true;
            System.out.println("[Controle Avançado] Dispositivo mutado.");
        } else {
            dispositivo.setVolume(volumeAntesMudo);
            mudo = false;
            System.out.println("[Controle Avançado] Mudo desativado. Volume restaurado para: " + volumeAntesMudo);
        }
    }

    public void salvarCanalFavorito() {
        canalFavorito = dispositivo.getCanal();
        System.out.println("[Controle Avançado] Canal favorito salvo: " + canalFavorito);
    }

    public void irParaCanalFavorito() {
        dispositivo.setCanal(canalFavorito);
        System.out.println("[Controle Avançado] Indo para o canal favorito: " + canalFavorito);
    }

    public boolean isMudo() {
        return mudo;
    }

    public int getCanalFavorito() {
        return canalFavorito;
    }

    public void ajustarVolume(int volume) {
        dispositivo.setVolume(volume);
    }

    public void definirCanalFavorito(int canal) {
        this.canalFavorito = canal;
        System.out.println("[Controle Avançado] Canal favorito definido como: " + canal);
    }
}
