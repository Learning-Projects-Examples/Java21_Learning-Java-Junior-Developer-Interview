
## 3. Observer Pattern

L'Observer è un pattern comportamentale che definisce una dipendenza uno-a-molti tra oggetti, in modo che quando un oggetto cambia stato, tutti i suoi dipendenti vengano notificati e aggiornati automaticamente.

### Caratteristiche principali:
- Soggetto (Observable): mantiene una lista di osservatori e li notifica dei cambiamenti
- Osservatori: oggetti interessati ai cambiamenti del soggetto

### Esempio di implementazione:

```java
import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObservers();
    }
}

class ConcreteObserver implements Observer {
    private String name;

    ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}
```

### Utilizzo:
- Implementazione di sistemi di eventi
- Aggiornamento di interfacce utente in tempo reale
- Gestione di dipendenze tra componenti in sistemi distribuiti
