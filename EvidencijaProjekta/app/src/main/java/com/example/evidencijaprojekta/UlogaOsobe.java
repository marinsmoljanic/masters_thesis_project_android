package com.example.evidencijaprojekta;

public class UlogaOsobe {
    int SifProjekta, IdOsobe, IdUloge, DatDodjele;

    public UlogaOsobe(int SifProjekta, int IdOsobe, int IdUloge, int DatDodjele){
        this.setSifProjekta(SifProjekta);
        this.setIdOsobe(IdOsobe);
        this.setIdUloge(IdUloge);
        this.setDatDodjele(DatDodjele);
    }

    // SifProjekta -> getter and setter
    public int getSifProjekta() {
        return this.SifProjekta;
    }
    public void setSifProjekta(int SifProjekta) {
        this.SifProjekta = SifProjekta;
    }

    // IdOsobe -> getter and setter
    public int getIdOsobe() {
        return this.IdOsobe;
    }
    public void setIdOsobe(int IdOsobe) {
        this.IdOsobe = IdOsobe;
    }

    // IdUloge -> getter and setter
    public int getIdUloge() {
        return this.IdUloge;
    }
    public void setIdUloge(int IdUloge) {
        this.IdUloge = IdUloge;
    }

    // DatDodjele -> getter and setter
    public int getDatDodjele() {
        return this.DatDodjele;
    }
    public void setDatDodjele(int DatDodjele) {
        this.DatDodjele = DatDodjele;
    }
}
