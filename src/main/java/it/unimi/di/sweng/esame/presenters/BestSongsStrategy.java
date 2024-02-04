package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Punteggio;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class BestSongsStrategy implements DisplayViewStrategy {

    @Override
    public void sortNazioni(List<Punteggio> punti) {
        punti.sort((o1, o2) -> {
            int res = Integer.compare(o1.punti(), o2.punti());
            if(res == 0) return o1.nazione().nome().compareTo(o2.nazione().nome());
            return res;
        });

    }

    @Override
    public List<String> printNazioni(@NotNull List<Punteggio> punti, @NotNull Voto voto) {
        return null;
    }
}
