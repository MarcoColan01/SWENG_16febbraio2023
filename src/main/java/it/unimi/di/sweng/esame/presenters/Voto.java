package it.unimi.di.sweng.esame.presenters;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public record Voto(@NotNull Nazione nazione, @NotNull Nazione[] votate) {
    public static Voto creaVoto(@NotNull String voto, @NotNull String votante) {
        String[] voti = voto.split(" ");
        if (voti.length != 5)
            throw new IllegalArgumentException("Invalid number of votes");
        Map<String, Boolean> presenze = new HashMap<>();
        String err = "";
        Nazione[] nazioni = new Nazione[5];
        int i = 0;
        for (String nazione : voti) {
            err = nazione;
            try {
                Nazione n = Nazione.valueOf(nazione);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format("Invalid vote code: %s", err));
            }
            if (nazione.equals(Nazione.getCodice(votante)))
                throw new IllegalArgumentException("You cannot vote for yourself");
            if (presenze.containsKey(nazione))
                throw new IllegalArgumentException("Duplicated votes");
            else presenze.put(nazione, true);
            nazioni[i++] = Nazione.valueOf(nazione);
        }

        return new Voto(Nazione.valueOf(Nazione.getCodice(votante)), nazioni);
    }
}
