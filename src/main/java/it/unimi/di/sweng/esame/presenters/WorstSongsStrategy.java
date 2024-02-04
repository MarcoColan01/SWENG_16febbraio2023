package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Punteggio;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorstSongsStrategy implements DisplayViewStrategy {
    @Override
    public void sortNazioni(@NotNull List<Punteggio> punti) {
        punti.sort((o1, o2) -> {
            int res = Integer.compare(o1.punti(), o2.punti());
            if (res == 0) return o1.nazione().nome().compareTo(o2.nazione().nome());
            return res;
        });
    }

    @Override
    public List<String> printNazioni(@NotNull List<Punteggio> punti, @NotNull Voto voto) {
        List<String> nazioni = new ArrayList<>();
        sortNazioni(punti);
        int i = 0;
        System.out.println(punti);
        for (Nazione nazione : voto.votate()) {
            nazioni.add(String.format("%s\t%d", punti.get(i).nazione().nome(), punti.get(i).punti()));
            i++;
        }
        return nazioni;
    }
}
