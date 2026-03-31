package com.controle.dispositivo;

public interface Dispositivo {

    boolean isLigado();

    void ligar();

    void desligar();

    int getVolume();

    void setVolume(int volume);

    int getCanal();

    void setCanal(int canal);

    String getStatus();
}
