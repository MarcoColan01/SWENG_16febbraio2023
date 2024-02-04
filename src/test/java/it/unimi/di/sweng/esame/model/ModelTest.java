package it.unimi.di.sweng.esame.model;

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
}