package com.controle;

import com.controle.controle.ControleAvancado;
import com.controle.controle.ControleBasico;
import com.controle.implementacao.Radio;
import com.controle.implementacao.TV;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  Sistema de Controle de Dispositivos   ");
        System.out.println("     Padrão Bridge - Demonstração       ");
        System.out.println("========================================\n");

        // --- Controle Básico com TV ---
        System.out.println(">>> Controle Básico + TV <<<");
        TV tv = new TV();
        ControleBasico controleTV = new ControleBasico(tv);

        controleTV.ligar();
        controleTV.mudarCanal(5);
        controleTV.ajustarVolume(50);
        controleTV.aumentarVolume();
        controleTV.proximoCanal();
        controleTV.exibirStatus();
        controleTV.desligar();

        System.out.println();

        // --- Controle Avançado com Rádio ---
        System.out.println(">>> Controle Avançado + Rádio <<<");
        Radio radio = new Radio();
        ControleAvancado controleRadio = new ControleAvancado(radio);

        controleRadio.ligar();
        controleRadio.getDispositivo().setCanal(98);
        controleRadio.ajustarVolume(40);
        controleRadio.salvarCanalFavorito();
        controleRadio.silenciar();
        System.out.println("Está mudo? " + controleRadio.isMudo());
        controleRadio.silenciar(); // desmutar
        controleRadio.getDispositivo().setCanal(100);
        controleRadio.irParaCanalFavorito();
        controleRadio.exibirStatus();
        controleRadio.desligar();

        System.out.println();

        // --- Demonstração do Bridge: trocar dispositivo sem mudar o controle ---
        System.out.println(">>> Controle Avançado + TV (Bridge em ação) <<<");
        TV tv2 = new TV();
        ControleAvancado controleAvancadoTV = new ControleAvancado(tv2);

        controleAvancadoTV.ligar();
        controleAvancadoTV.getDispositivo().setCanal(10);
        controleAvancadoTV.definirCanalFavorito(10);
        controleAvancadoTV.getDispositivo().setCanal(1);
        controleAvancadoTV.irParaCanalFavorito();
        controleAvancadoTV.silenciar();
        controleAvancadoTV.exibirStatus();
        controleAvancadoTV.desligar();

        System.out.println("\n========================================");
        System.out.println("  Demonstração concluída com sucesso!   ");
        System.out.println("========================================");
    }

    // Método auxiliar para ControleAvancado acessar ajustarVolume
    // (reutilizando ControleBasico inline)
}
