package Persoane;

public class Bucatar extends Angajat {
    private int ani_experienta;
    private static int spor = 20;


    public Bucatar(String nume, String prenume, String nr_telefon, int salariu, String data_contract, String CNP, int ani_experienta) {
        super(nume, prenume, nr_telefon, salariu, data_contract, CNP);
        this.ani_experienta = ani_experienta;
    }

    public int getAni_experienta() {
        return ani_experienta;
    }
    public int getSpor() {
        return spor;
    }
    public void setAni_experienta(int ani_experienta) {
        this.ani_experienta = ani_experienta;
    }
    public void setSpor(int spor) {
        this.spor = spor;
    }

    @Override
    public int calc_salariu(int salariu){
        return salariu + salariu * (spor / 100);
    }
}
