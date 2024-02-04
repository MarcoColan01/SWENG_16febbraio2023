package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Punteggio;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class DisplayViewStrategyTest {

    @Test
    void testBestSongsStrategy(){
        DisplayViewStrategy SUT = new BestSongsStrategy();
        List<Punteggio> punti = new ArrayList<>();
        Punteggio p1 = new Punteggio(Nazione.valueOf("IT"), 10);
        Punteggio p2 = new Punteggio(Nazione.valueOf("ES"), 5);
        Punteggio p3 = new Punteggio(Nazione.valueOf("UK"), 17);
        punti.add(p1);
        punti.add(p2);
        punti.add(p3);
        SUT.sortNazioni(punti);
        assertThat(punti).containsExactly(p2, p1, p3);
    }
}