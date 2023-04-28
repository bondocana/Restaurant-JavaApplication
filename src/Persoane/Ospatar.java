package Persoane;

public class Ospatar extends Angajat {
    private int[] mese;
    private int bacsis;
    private static int spor = 5;

    public Ospatar(String nume, String prenume, String nr_telefon, int salariu, String data_contract, String CNP, int[] mese, int bacsis) {
        super(nume, prenume, nr_telefon, salariu, data_contract, CNP);
        this.mese = mese;
        this.bacsis = bacsis;
    }

    public int[] getMese() {
        return mese;
    }
    public void setMese(int[] mese) {
        this.mese = mese;
    }
    public int getBacsis() {
        return bacsis;
    }
    public void setBacsis(int bacsis) {
        this.bacsis = bacsis;
    }
    public static int getSpor() {
        return spor;
    }
    public static void setSpor(int spor) {
        Ospatar.spor = spor;
    }

    @Override
    public int calc_salariu(int salariu){
        return salariu + salariu * (spor / 100) + bacsis;
    }

}
