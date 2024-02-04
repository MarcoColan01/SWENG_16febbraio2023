package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Punteggio;

import java.util.List;

public interface DisplayViewStrategy {
    void sortNazioni(List<Punteggio> punti);
}
