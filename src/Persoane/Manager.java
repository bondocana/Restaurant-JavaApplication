package Persoane;

public class Manager extends Angajat {
    private String[] aptitudini;
    private static int spor = 30;

    public Manager(String nume, String prenume, String nr_telefon, int salariu, String data_contract, String CNP, String[] aptitudini) {
        super(nume, prenume, nr_telefon, salariu, data_contract, CNP);
        this.aptitudini = aptitudini;
    }

    public String[] getAptitudini() {
        return aptitudini;
    }
    public int getSpor() {
        return spor;
    }
    public void setAptitudini(String[] aptitudini) {
        this.aptitudini = aptitudini;
    }
    public void setSpor(int spor) {
        this.spor = spor;
    }

    @Override
    public int calc_salariu(int salariu){
        return salariu + salariu * (spor / 100);
    }
}
