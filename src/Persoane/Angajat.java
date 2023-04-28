package Persoane;

import Persoane.Persoana;

public abstract class Angajat extends Persoana implements Comparable<Angajat>{
    private int salariu;
    private String data_contract;
    private String CNP;

    public Angajat(String nume, String prenume, String nr_telefon, int salariu, String data_contract, String CNP) {
        super(nume, prenume, nr_telefon);
        this.salariu = salariu;
        this.data_contract = data_contract;
        this.CNP = CNP;
    }

    public int getSalariu() {
        return salariu;
    }
    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }
    public String getData_contract() {
        return data_contract;
    }
    public void setData_contract(String data_contract) {
        this.data_contract = data_contract;
    }
    public String getCNP() {
        return CNP;
    }
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    // metoda abstracta pt calcularea salariului impreuna cu sporul
    public abstract int calc_salariu(int salariu);
    // regex pt CNP
    public static boolean matchesCNP(String CNP){
        return CNP.matches("[0-9]{13}");
    }

    @Override
    public int compareTo(Angajat angajat) {
        if(this.salariu != angajat.salariu)
        {
            if(this.salariu - angajat.getSalariu() > 0)
                return 1;
            else
                return -1;
        }
        return 0;
    }
}
