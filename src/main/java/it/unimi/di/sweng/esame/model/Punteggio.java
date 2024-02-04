package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.presenters.Nazione;
import org.jetbrains.annotations.NotNull;

public record Punteggio(@NotNull Nazione nazione, int punti) {
}
