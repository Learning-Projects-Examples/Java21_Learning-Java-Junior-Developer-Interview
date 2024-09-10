# Design Patterns in Java

## 1. Singleton Pattern

Il Singleton è un pattern creazionale che garantisce che una classe abbia una sola istanza e fornisce un punto di accesso globale a questa istanza.

### Caratteristiche principali:
- Costruttore privato per prevenire l'istanziazione diretta
- Metodo statico che restituisce l'unica istanza della classe
- L'istanza è memorizzata in un campo privato statico

### Esempio di implementazione:

```java
public class Singleton {
    private static Singleton instance;
    
    private Singleton() {}
    
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Utilizzo:
- Gestione di risorse condivise (es. pool di connessioni al database)
- Configurazioni globali dell'applicazione
