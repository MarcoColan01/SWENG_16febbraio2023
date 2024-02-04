package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.views.NextNationView;
import org.jetbrains.annotations.NotNull;

public class NextNationPresenter implements Presenter{
    private final @NotNull NextNationView view;
    public NextNationPresenter(@NotNull NextNationView view) {
        this.view = view;
        view.addHandlers(this);
    }

    @Override
    public void action(String comando, String voto) {
        String[] voti = voto.split(" ");
        if(voti.length != 5){
            view.showError("Invalid number of votes");
            return;
        }
    }
}
