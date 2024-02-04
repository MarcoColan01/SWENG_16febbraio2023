package it.unimi.di.sweng.esame.model;


import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.Observable;
import it.unimi.di.sweng.esame.Observer;
import it.unimi.di.sweng.esame.presenters.Nazione;
import it.unimi.di.sweng.esame.presenters.Voto;
import org.jetbrains.annotations.NotNull;


import java.io.InputStream;

import java.util.*;

public class Model implements Observable<List<Voto>> {

    //private final @NotNull Map<Nazione, Voto> voti = new HashMap<>();
    private final @NotNull Map<Nazione, Punteggio> punti = new HashMap<>();

    private final @NotNull List<Observer<List<Voto>>> observers = new ArrayList<>();

    public void readFile() {
        InputStream is = Main.class.getResourceAsStream("/FinalistNations");
        assert is != null;
        Scanner s = new Scanner(is);

        while (s.hasNextLine()) {
            String linea = s.nextLine();
            String[] el = linea.split(";");
            String name = el[0];
            String cod = el[1];
            punti.put(Nazione.valueOf(cod), new Punteggio(Nazione.valueOf(cod), 0));
        }
    }

    public void addVoto(@NotNull Voto voto) {
        int points = 5;
        for (Nazione nazione : voto.votate()) {
            punti.put(nazione, new Punteggio(nazione, points));
            points--;
        }
    }

    public List<Punteggio> getPunti() {
        return new ArrayList<>(punti.values());
    }

    public int getPunti(@NotNull String nazione) {
        return punti.get(Nazione.valueOf(nazione)).punti();
    }

    @Override
    public void notifyObservers() {
        for (Observer<List<Voto>> observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void addObserver(@NotNull Observer<List<Voto>> observer) {
        observers.add(observer);
    }
}
