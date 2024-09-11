

## 2. Factory Pattern

Il Factory Pattern è un pattern creazionale che fornisce un'interfaccia per creare oggetti in una superclasse, permettendo alle sottoclassi di decidere quale classe istanziare.

### Caratteristiche principali:
- Definisce un'interfaccia per creare un oggetto
- Lascia alle sottoclassi la decisione su quale classe istanziare
- Riferimento agli oggetti attraverso la loro interfaccia comune

### Esempio di implementazione:

```java
interface Product { }
class ConcreteProductA implements Product { }
class ConcreteProductB implements Product { }

abstract class Creator {
    abstract Product factoryMethod();
}

class ConcreteCreatorA extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB extends Creator {
    @Override
    Product factoryMethod() {
        return new ConcreteProductB();
    }
}
```

### Utilizzo:
- Creazione di oggetti senza specificare la classe esatta
- Gestione di famiglie di prodotti correlati
 