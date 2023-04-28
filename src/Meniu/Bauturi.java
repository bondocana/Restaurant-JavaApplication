package Meniu;

public final class Bauturi extends Meniu {
    private static int nr_bauturi = 0;
    private String tip;

    public Bauturi(String nume, int pret, String tip) {
        super(nume, pret);
        this.tip = tip;
        nr_bauturi ++;
    }

    public static int getNr_bauturi() {
        return nr_bauturi;
    }
    public static void setNr_bauturi(int nr_bauturi) {
        Bauturi.nr_bauturi = nr_bauturi;
    }
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
    }

    // cand vreau sa sterg un obiect
    public static void stergere_bautura(){
        nr_bauturi --;
    }
}
