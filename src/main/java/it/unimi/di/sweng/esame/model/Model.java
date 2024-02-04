package it.unimi.di.sweng.esame.model;


import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.presenters.Nazione;
import it.unimi.di.sweng.esame.presenters.Voto;
import org.jetbrains.annotations.NotNull;


import java.io.InputStream;

import java.util.*;

public class Model {

  private final @NotNull List<Nazione> nazioni = new ArrayList<>();
  private final @NotNull Map<Nazione, Voto> voti = new HashMap<>();
  private final @NotNull Map<Nazione, Integer> punti = new HashMap<>();

  public void readFile() {
    InputStream is = Main.class.getResourceAsStream("/FinalistNations");
    assert is != null;
    Scanner s = new Scanner(is);

    while (s.hasNextLine()) {
      String linea = s.nextLine();
      String[] el = linea.split(";");
      String name = el[0];
      String cod = el[1];
      nazioni.add(Nazione.valueOf(cod));
    }
  }

  public List<Nazione> getNazioni() {
    return new ArrayList<>(nazioni);
  }

  public void addVoto(@NotNull Voto voto) {
   if(!voti.containsKey(voto.nazione())) voti.put(voto.nazione(), voto);
   int points = 5;
   for(Nazione nazione: voto.votate()){
     punti.put(nazione, points);
     points--;
   }
  }

  public List<Voto> getVoti() {
    return new ArrayList<>(voti.values());
  }

  public int getPunti(@NotNull String nazione) {
    return punti.get(Nazione.valueOf(nazione));
  }
}
