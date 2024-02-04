package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.views.DisplayView;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class BestSongsPresenterTest {
    @Test
    void updateReadFileTest(){
        Model model = mock(Model.class);
        DisplayView view = mock(DisplayView.class);
        BestSongsPresenter SUT = new BestSongsPresenter(model, view, new BestSongsStrategy());
        model.readFile();
        verify(view).set(0, "Australia\t0");
        verify(view).set(1, "Azerbaijan\t0");
    }
}