package it.unimi.di.sweng.esame.presenters;

import it.unimi.di.sweng.esame.views.NextNationView;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class NextNationPresenter implements Presenter {
    private final @NotNull NextNationView view;

    public NextNationPresenter(@NotNull NextNationView view) {
        this.view = view;
        view.addHandlers(this);
    }

    @Override
    public void action(String nazioneCorrente, String voto) {
        try {
            Voto v = Voto.creaVoto(voto, nazioneCorrente);
            view.showSuccess();
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}
