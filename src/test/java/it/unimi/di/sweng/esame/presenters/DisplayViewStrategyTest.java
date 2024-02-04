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
        Punteggio p1 = new Punteggio(Nazione.valueOf("IT"), 10,0);
        Punteggio p2 = new Punteggio(Nazione.valueOf("ES"), 5,0);
        Punteggio p3 = new Punteggio(Nazione.valueOf("UK"), 17,0);
        punti.add(p1);
        punti.add(p2);
        punti.add(p3);
        SUT.sortNazioni(punti);
        assertThat(punti).containsExactly(p3, p1, p2);
    }

    @Test
    void testBestSongsDisplay(){
        DisplayViewStrategy SUT = new BestSongsStrategy();
        List<Punteggio> punti = new ArrayList<>();
        Voto voto = Voto.creaVoto("Italia", "ES UK PL NL PT");
        Punteggio p1 = new Punteggio(Nazione.valueOf("ES"), 5,0);
        Punteggio p2 = new Punteggio(Nazione.valueOf("UK"), 4,0);
        Punteggio p3 = new Punteggio(Nazione.valueOf("PL"), 3,0);
        Punteggio p4 = new Punteggio(Nazione.valueOf("NL"), 2,0);
        Punteggio p5 = new Punteggio(Nazione.valueOf("PT"), 1,0);
        punti.add(p1);
        punti.add(p2);
        punti.add(p3);
        punti.add(p4);
        punti.add(p5);
        assertThat(SUT.printNazioni(punti, voto).get(0)).isEqualTo("Spagna\t[5] [5]");
    }

    @Test
    void testWorstSongsStrategy(){
        DisplayViewStrategy SUT = new WorstSongsStrategy();
        List<Punteggio> punti = new ArrayList<>();
        Punteggio p1 = new Punteggio(Nazione.valueOf("IT"), 10,0);
        Punteggio p2 = new Punteggio(Nazione.valueOf("ES"), 5,0);
        Punteggio p3 = new Punteggio(Nazione.valueOf("UA"), 5,0);
        Punteggio p4 = new Punteggio(Nazione.valueOf("UK"), 17,0);
        punti.add(p1);
        punti.add(p2);
        punti.add(p3);
        punti.add(p4);
        SUT.sortNazioni(punti);
        assertThat(punti).containsExactly(p2, p3, p1, p4);
    }

    @Test
    void testWorstSongsDisplay(){
        DisplayViewStrategy SUT = new WorstSongsStrategy();
        List<Punteggio> punti = new ArrayList<>();
        Voto voto = Voto.creaVoto("Italia", "ES UK PL NL PT");
        Punteggio p1 = new Punteggio(Nazione.valueOf("ES"), 5,0);
        Punteggio p2 = new Punteggio(Nazione.valueOf("UK"), 4,0);
        Punteggio p3 = new Punteggio(Nazione.valueOf("PL"), 3,0);
        Punteggio p4 = new Punteggio(Nazione.valueOf("NL"), 2,0);
        Punteggio p5 = new Punteggio(Nazione.valueOf("PT"), 1,0);
        punti.add(p1);
        punti.add(p2);
        punti.add(p3);
        punti.add(p4);
        punti.add(p5);
        assertThat(SUT.printNazioni(punti, voto).get(0)).isEqualTo("Portogallo\t1");
    }

    @Test
    void testPodioStrategy(){
        DisplayViewStrategy SUT = new PodioStrategy();
        List<Punteggio> punti = new ArrayList<>();
        Punteggio p1 = new Punteggio(Nazione.valueOf("IT"), 10, 1);
        Punteggio p2 = new Punteggio(Nazione.valueOf("ES"), 5, 0);
        Punteggio p3 = new Punteggio(Nazione.valueOf("UA"), 5, 1);
        Punteggio p4 = new Punteggio(Nazione.valueOf("UK"), 17, 2);
        punti.add(p1);
        punti.add(p2);
        punti.add(p3);
        punti.add(p4);
        SUT.sortNazioni(punti);
        assertThat(punti).containsExactly(p4, p1, p2, p3);
    }
}