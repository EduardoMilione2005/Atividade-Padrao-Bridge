# Sistema de Controle de Dispositivos — Padrão Bridge

## Visão Geral

Este projeto implementa o **Padrão de Projeto Bridge** em Java aplicado a um
sistema de controle remoto de dispositivos (TV e Rádio).

## Estrutura do Padrão Bridge

O padrão Bridge **separa a abstração da implementação**, permitindo que ambos
evoluam de forma independente.

```
ABSTRAÇÃO                       IMPLEMENTAÇÃO
─────────────────               ──────────────────────
ControleRemoto (abstract)  ───> Dispositivo (interface)
  ├─ ControleBasico               ├─ TV
  └─ ControleAvancado             └─ Radio
```

### Papéis no Padrão

| Papel                   | Classe/Interface        |
|-------------------------|-------------------------|
| Abstraction             | `ControleRemoto`        |
| RefinedAbstraction (x2) | `ControleBasico`, `ControleAvancado` |
| Implementor             | `Dispositivo`           |
| ConcreteImplementor (x2)| `TV`, `Radio`           |

## Estrutura de Pastas

```
controle-remoto/
├── pom.xml
├── diagrama/
│   └── diagrama-classes.mermaid
└── src/
    ├── main/java/com/controle/
    │   ├── Main.java
    │   ├── dispositivo/
    │   │   └── Dispositivo.java          ← Interface (Implementor)
    │   ├── implementacao/
    │   │   ├── TV.java                   ← ConcreteImplementor
    │   │   └── Radio.java                ← ConcreteImplementor
    │   └── controle/
    │       ├── ControleRemoto.java       ← Abstraction (abstract)
    │       ├── ControleBasico.java       ← RefinedAbstraction
    │       └── ControleAvancado.java     ← RefinedAbstraction
    └── test/java/com/controle/
        ├── TVTest.java
        ├── RadioTest.java
        ├── ControleBasicoTest.java
        └── ControleAvancadoTest.java
```

## Como Executar

### Compilar e rodar a aplicação
```bash
mvn compile exec:java -Dexec.mainClass="com.controle.Main"
```

### Executar os testes
```bash
mvn test
```

### Compilar tudo
```bash
mvn package
```

## Funcionalidades

### ControleBasico
- Ligar / Desligar
- Aumentar / Diminuir volume (em passos de 10)
- Próximo canal / Canal anterior
- Mudar para canal específico
- Ajustar volume específico

### ControleAvancado (herda do Básico, adiciona)
- **Silenciar / Desmutar** (preserva o volume anterior)
- **Salvar canal favorito**
- **Ir para canal favorito**
- **Definir canal favorito**

## Tecnologias
- Java 17
- JUnit 5 (Jupiter)
- Maven 3.x
