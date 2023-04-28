package Persoane;

public abstract class Persoana {
    private String nume;
    private String prenume;
    private String nr_telefon;

    public Persoana(String nume, String prenume, String nr_telefon) {
        this.nume = nume;
        this.prenume = prenume;
        this.nr_telefon = nr_telefon;
    }

    // getter
    public String getNume() {
        return nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public String getNr_telefon() {
        return nr_telefon;
    }

    // setter
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    // CNP nu are setter pt ca este final
    public void setNr_telefon(String nr_telefon) {
        this.nr_telefon = nr_telefon;
    }


    // metoda care foloseste regex pentru a verifica daca nr de telefon este corect
    public static boolean matchesNr_telefon(String nr_telefon){
        return nr_telefon.matches("(07)[0-9]{8}");
    }
}
