package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Punteggio;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface DisplayViewStrategy {
    void sortNazioni(@NotNull List<Punteggio> punti);

    List<String> printNazioni(@NotNull List<Punteggio> punti, @NotNull Voto voto);
}
