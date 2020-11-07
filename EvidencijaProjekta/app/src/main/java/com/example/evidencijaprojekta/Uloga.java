package com.example.evidencijaprojekta;

public class Uloga {
    int IdUloge;
    String NazUloge;

    public Uloga(String NazUloge){
        this.setNazUloge(NazUloge);

    }

    // NazUloge -> getter and setter
    public String getNazUloge() {
        return this.NazUloge;
    }
    public void setNazUloge(String NazUloge) {
        this.NazUloge = NazUloge;
    }
}
