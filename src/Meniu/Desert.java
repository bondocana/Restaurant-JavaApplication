package Meniu;

public final class Desert extends Meniu {
    private static int nr_deserturi = 0;
    private String aroma;

    public Desert(String nume, int pret, String aroma) {
        super(nume, pret);
        this.aroma = aroma;
        nr_deserturi ++;
    }

    public static int getNr_deserturi() {
        return nr_deserturi;
    }
    public static void setNr_deserturi(int nr_deserturi) {
        Desert.nr_deserturi = nr_deserturi;
    }
    public String getAroma() {
        return aroma;
    }
    public void setAroma(String aroma) {
        this.aroma = aroma;
    }

    // cand vreau sa sterg un obiect
    public static void stergere_bautura(){
        nr_deserturi --;
    }
}
