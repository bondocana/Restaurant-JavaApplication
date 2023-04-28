package Persoane;

import Meniu.Meniu;
import Persoane.Persoana;

public class Client extends Persoana {
    private String ziua_rezervare;
    private String ora_rezervare;
    private int nr_masa;
    private Meniu[] comanda;

    public Client(String nume, String prenume, String nr_telefon, String ziua_rezervare, String ora_rezervare, int nr_masa, Meniu[] comanda) {
        super(nume, prenume, nr_telefon);
        this.ziua_rezervare = ziua_rezervare;
        this.ora_rezervare = ora_rezervare;
        this.nr_masa = nr_masa;
        this.comanda = comanda;
    }

    public String getZiua_rezervare() {
        return ziua_rezervare;
    }
    public void setZiua_rezervare(String ziua_rezervare) {
        this.ziua_rezervare = ziua_rezervare;
    }
    public String getOra_rezervare() {
        return ora_rezervare;
    }
    public void setOra_rezervare(String ora_rezervare) {
        this.ora_rezervare = ora_rezervare;
    }
    public int getNr_masa() {
        return nr_masa;
    }
    public void setNr_masa(int nr_masa) {
        this.nr_masa = nr_masa;
    }
    public Meniu[] getComanda() {
        return comanda;
    }
    public void setComanda(Meniu[] comanda) {
        this.comanda = comanda;
    }
}
