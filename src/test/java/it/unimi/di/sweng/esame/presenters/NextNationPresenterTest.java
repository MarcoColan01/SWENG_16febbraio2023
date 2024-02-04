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
        SUT.action("", "IT EE PL ES");
        verify(view).showError("Invalid number of votes");
    }

    @Test
    void testVotoNazioneNonPresente(){
        NextNationView view = mock(NextNationView.class);
        NextNationPresenter SUT = new NextNationPresenter(view);
        SUT.action("", "IT EE PL ES DF");
        verify(view).showError("Invalid vote code: DF");
    }

    @Test
    void testVotoNazioneSeStessa(){
        NextNationView view = mock(NextNationView.class);
        NextNationPresenter SUT = new NextNationPresenter(view);
        SUT.action("", "IT EE AU ES NL");
        verify(view).showError("You cannot vote for yourself");
    }
}