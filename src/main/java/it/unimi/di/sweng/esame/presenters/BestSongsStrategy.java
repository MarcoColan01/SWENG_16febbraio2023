package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Punteggio;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BestSongsStrategy implements DisplayViewStrategy {

    @Override
    public void sortNazioni(List<Punteggio> punti) {
        punti.sort((o1, o2) -> {
            int res = Integer.compare(o2.punti(), o1.punti());
            if(res == 0) return o1.nazione().nome().compareTo(o2.nazione().nome());
            return res;
        });

    }

    @Override
    public List<String> printNazioni(@NotNull List<Punteggio> punti, @NotNull Voto voto) {
        List<String> nazioni = new ArrayList<>();
        sortNazioni(punti);
        int i = 0;
        for(Nazione nazione: voto.votate()){
            nazioni.add(String.format("%s\t[%d] [%d]", nazione.nome(), 5-i, punti.get(i).punti()));
        }
        return nazioni;
    }
}
