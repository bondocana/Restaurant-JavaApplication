package Meniu;

public final class Mancare extends Meniu {
    private static int nr_feluri = 0;
    private int minute;

    public Mancare(String nume, int pret, int minute) {
        super(nume, pret);
        this.minute = minute;
        nr_feluri ++;
    }

    public static int getNr_feluri() {
        return nr_feluri;
    }
    public static void setNr_feluri(int nr_feluri) {
        Mancare.nr_feluri = nr_feluri;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }

    // cand vreau sa sterg un obiect
    public static void stergere_bautura(){
        nr_feluri --;
    }
}
