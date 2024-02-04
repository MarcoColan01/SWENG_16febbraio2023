package it.unimi.di.sweng.esame.model;


import it.unimi.di.sweng.esame.Main;
import it.unimi.di.sweng.esame.presenters.Voto;


import java.io.InputStream;

import java.util.*;

public class Model {

  //TODO completare la classe

  public void readFile() {
    InputStream is = Main.class.getResourceAsStream("/FinalistNations");
    assert is != null;
    Scanner s = new Scanner(is);

    while (s.hasNextLine()) {
      String linea = s.nextLine();
      String[] el = linea.split(";");
      String name = el[0];
      String cod = el[1];

      System.out.printf("cod: [%s] name: [%s]\n", cod, name);
    }
  }

  public List<Voto> getVotesByNation() {
    return null;
  }
}
