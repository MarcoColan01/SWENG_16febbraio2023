package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.views.NextNationView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class NextNationPresenterTest {

    @Test
    void testVotoLength(){
        NextNationView view = mock(NextNationView.class);
        NextNationPresenter SUT = new NextNationPresenter(view);
        SUT.action("Grecia", "IT EE PL ES");
        verify(view).showError("Invalid number of votes");
    }

    @Test
    void testVotoNazioneNonPresente(){
        NextNationView view = mock(NextNationView.class);
        NextNationPresenter SUT = new NextNationPresenter(view);
        SUT.action("Grecia", "IT EE PL ES DF");
        verify(view).showError("Invalid vote code: DF");
    }

    @Test
    void testVotoNazioneSeStessa(){
        NextNationView view = mock(NextNationView.class);
        NextNationPresenter SUT = new NextNationPresenter(view);
        SUT.action("Spagna", "IT EE AU ES NL");
        verify(view).showError("You cannot vote for yourself");
    }

    @Test
    void testVotoDuplicato(){
        NextNationView view = mock(NextNationView.class);
        NextNationPresenter SUT = new NextNationPresenter(view);
        SUT.action("Grecia", "IT EE PL ES EE");
        verify(view).showError("Duplicated votes");
    }

    @Test
    void testVotoOk(){
        NextNationView view = mock(NextNationView.class);
        NextNationPresenter SUT = new NextNationPresenter(view);
        SUT.action("Spagna", "IT EE PL SE UA");
        verify(view).showSuccess();
    }
}