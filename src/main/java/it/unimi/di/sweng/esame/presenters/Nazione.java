package it.unimi.di.sweng.esame.presenters;

import org.jetbrains.annotations.NotNull;

public enum Nazione {
    AU("Australia"),
            AZ("Azerbaijan"),
            EE("Estonia"),
            ES("Spagna"),
            GR("Grecia"),
            IT("Italia"),
            LT("Lituania"),
            MD("Moldavia"),
            NL("Paesi_Bassi"),
            NO("Norvegia"),
            PL("Polonia"),
            PT("Portogallo"),
            RS("Serbia"),
            SE("Svezia"),
            UA("Ucraina"),
            UK("Regno_Unito");
    private final String nome;
    Nazione(@NotNull String nome){
        this.nome = nome;
    }
    public String nome(){
        return nome;
    }

    @Override
    public String toString(){
        String[] nazione = nome.split("_");
        if(nazione.length > 1) return nazione[0] + " " + nazione[1];
        else return nazione[0];
    }
}
