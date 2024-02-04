package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.presenters.Voto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void readFileTest(){
        Model SUT = new Model();
        SUT.readFile();
        assertThat(SUT.getNazioni()).hasSize(16);
    }

    @Test
    void testAddVoto(){
        Model SUT = new Model();
        Voto voto = Voto.creaVoto("Grecia", "IT ES PL NL EE");
        SUT.addVoto(voto);
        assertThat(SUT.getVoti()).contains(voto);
    }

    @Test
    void testGetPunti(){
        Model SUT = new Model();
        Voto voto = Voto.creaVoto("Grecia", "IT ES PL NL EE");
        SUT.addVoto(voto);
        assertThat(SUT.getPunti("IT")).isEqualTo(5);
        assertThat(SUT.getPunti("PL")).isEqualTo(3);
    }

}