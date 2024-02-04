package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Punteggio;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class WorstSongsStrategy implements DisplayViewStrategy {
    @Override
    public void sortNazioni(@NotNull List<Punteggio> punti) {

    }

    @Override
    public List<String> printNazioni(@NotNull List<Punteggio> punti, @NotNull Voto voto) {
        return null;
    }
}
