import Persoane.*;
import Meniu.*;

import javax.swing.text.DefaultEditorKit;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class Servicii {

    public Angajat addAngajat (String tip){
        Scanner sc = new Scanner(System.in);
        // PERSOANA
        System.out.println("Introduceti datele despre persoana:");

        System.out.println("Nume:");
        String nume = sc.next();
        sc.nextLine();

        System.out.println("Prenume:");
        String prenume = sc.next();
        sc.nextLine();

        System.out.println("Numar de telefon:");
        String nr_telefon = sc.next();
        sc.nextLine();

        while(!Persoana.matchesNr_telefon(nr_telefon)){
            System.out.println("Numar de telefon invalid! Introduceti din nou:");
            nr_telefon = sc.next();
            sc.nextLine();
        }

        // ANGAJAT
        System.out.println("Introduceti datele despre angajat:");

        System.out.println("Salariu:");
        int salariu = sc.nextInt();

        System.out.println("Data contractului:");
        String data_contract = sc.next();
        sc.nextLine();

        System.out.println("CNP:");
        String CNP = sc.next();
        sc.nextLine();

        while(!Angajat.matchesCNP(CNP)){
            System.out.println("CNP invalid! Introduceti din nou:");
            CNP = sc.next();
            sc.nextLine();
        }

        // OSPATAR
        if (Objects.equals(tip, "OSPATAR")) {
            System.out.println("Introduceti datele despre Ospatar:");

            System.out.println("Numarul de mese de care o sa se ocupe:");
            int n = sc.nextInt();
            int[] mese = new int[n];
            System.out.println("Mese:");
            for (int i = 0; i < n; i++) {
                mese[i] = sc.nextInt();
            }

            System.out.println("Bacsis:");
            int bacsis = sc.nextInt();

            Ospatar o = new Ospatar(nume, prenume,nr_telefon, salariu, data_contract, CNP, mese, bacsis);
            return o;
        }

        // BUCATAR
        if (Objects.equals(tip, "BUCATAR")) {
            System.out.println("Introduceti datele despre Bucatar:");

            System.out.println("Anii de experienta:");
            int ani_experienta = sc.nextInt();

            Bucatar b = new Bucatar(nume, prenume, nr_telefon, salariu, data_contract, CNP, ani_experienta);
            return b;
        }

        // MANAGER
        if (Objects.equals(tip, "MANAGER")) {
            System.out.println("Introduceti datele despre Manager:");

            System.out.println("Aptitudini:");
            System.out.println("Numarul de aptitudini:");
            int m = sc.nextInt();
            String[] aptitudini = new String[m];
            System.out.println("Aptitudini:");
            for (int i = 0; i < m; i++) {
                aptitudini[i] = sc.next();
            }

            Manager ma = new Manager(nume, prenume, nr_telefon, salariu, data_contract, CNP,  aptitudini);
            return ma;
        }

        return null;
    }
    public Client addClient (Angajat[] angajati, Meniu[] meniu){
        Scanner sc = new Scanner(System.in);
        // PERSOANA
        System.out.println("Introduceti datele despre persoana:");

        System.out.println("Nume:");
        String nume = sc.next();
        sc.nextLine();

        System.out.println("Prenume:");
        String prenume = sc.next();
        sc.nextLine();

        System.out.println("Numar de telefon:");
        String nr_telefon = sc.next();
        sc.nextLine();

        while(!Persoana.matchesNr_telefon(nr_telefon)){
            System.out.println("Numar de telefon invalid! Introduceti din nou:");
            nr_telefon = sc.next();
            sc.nextLine();
        }

        // CLIENT
        System.out.println("Introduceti datele despre Client:");
        System.out.println("Ziua in care doriti rezervarea:");
        String ziua_rezervare = sc.next();
        sc.nextLine();

        System.out.println("Ora la care doriti rezervarea:");
        String ora_rezervare = sc.next();
        sc.nextLine();

        System.out.println("Numarul mesei: [1 - 9]");
        int nr_masa = sc.nextInt();

        // afisare ospatarul care serveste la masa aleasa
        for(Angajat elem : angajati){
            if(elem instanceof Ospatar){
                for(int i : ((Ospatar) elem).getMese()){
                    if(nr_masa == i){
                        System.out.println(elem.getNume() + " " + elem.getPrenume() + " o sa va serveasca!");
                    }
                }
            }
        }

        // afisare meniu
        printAllMeniu(meniu);

        // alegere mancare si punere in comanda[]
        System.out.println("Cate produse serviti?");
        int nr_produse = sc.nextInt();
        System.out.println("Ce doriti sa serviti? (numele)");
        String[] comanda = new String[nr_produse];
        sc.nextLine();
        Meniu[] comanda2 = new Meniu[nr_produse];
        int a = 0;
        for (int i = 0; i < nr_produse; i++) {
            comanda[i] = sc.nextLine();
        }
        System.out.println("Va multumim pentru comanda!");

        // creare comanda2 in care pune obiectele in array
        for (int i = 0; i < nr_produse; i++) {
            for(Meniu elem : meniu){
                if(Objects.equals(elem.getNume(), comanda[i])){
                    comanda2[i] = elem;
                }
            }
        }

        Client c  = new Client(nume, prenume, nr_telefon, ziua_rezervare, ora_rezervare, nr_masa, comanda2);
        return c;

    }

    public void printClient (Client c){
        System.out.println(c.getNume() + " " + c.getPrenume() + ", nr telefon: " + c.getNr_telefon() + ", ziua rezervarii: "
                + c.getZiua_rezervare() + " , ora rezervarii: " + c.getOra_rezervare() + ", nr masa: " + c.getNr_masa());
        System.out.print("Comanda: ");
        for(Meniu elem : c.getComanda()){
            System.out.print(elem.getNume() + ", ");
        }
        System.out.println(" ");

    }
    public void printOspatar (Ospatar o){
        System.out.println("OSPATAR " + o.getNume() + " " + o.getPrenume() + ", nr telefon: "
                + o.getNr_telefon() + ", salariu: " + o.getSalariu() + ", data contractului: " + o.getData_contract()
                + ", CNP:" + o.getCNP() +", bacsis: " + o.getBacsis() + ", spor: " + o.getSpor());
        System.out.print("mese: ");
        for(int elem : o.getMese())
        {
            System.out.print(elem + " ");
        }
        System.out.println(" ");
    }
    public void printBucatar (Bucatar b){
        System.out.println("BUCATAR " + b.getNume() + " " + b.getPrenume() + ", nr telefon: "
                + b.getNr_telefon() + ", salariu: " + b.getSalariu() + ", data contractului: " + b.getData_contract()
                + ", CNP:" + b.getCNP() +", ani de experienta: " + b.getAni_experienta() + ", spor: " + b.getSpor());
    }
    public void printManager (Manager m){
        System.out.println("MANAGER " + m.getNume() + " " + m.getPrenume() + ", nr telefon: "
                + m.getNr_telefon() + ", salariu: " + m.getSalariu() + ", data contractului: " + m.getData_contract()
                + ", CNP:" + m.getCNP() + ", spor: " + m.getSpor());
        System.out.print("Aptitudini: ");
        for(String elem : m.getAptitudini())
        {
            System.out.print(elem + " ");
        }
        System.out.println(" ");
    }

    public Meniu addMeniu (String tip){
        Scanner sc = new Scanner(System.in);

        System.out.println("Nume:");
        String nume = sc.next();
        sc.nextLine();

        System.out.println("Pret:");
        int pret = sc.nextInt();

        if(Objects.equals(tip, "DESERT")){
            System.out.println("Aroma:");
            String aroma = sc.next();
            sc.nextLine();

            Desert d = new Desert(nume, pret, aroma);
            return d;
        }

        if(Objects.equals(tip, "BAUTURA")){
            System.out.println("Tipul bauturii: [Alcoolic/Nonalcoolic]:");
            String tip2 = sc.next();
            sc.nextLine();

            Bauturi b = new Bauturi(nume, pret, tip2);
            return b;
        }

        if(Objects.equals(tip, "MANCARE")){
            System.out.println("Durata prepararii (minute):");
            int minute = sc.nextInt();

            Mancare m = new Mancare(nume, pret, minute);
            return m;
        }
        return null;
    }
    public void printDesert (Desert d){
        System.out.println(d.getNume() + ", pret: " + d.getPret() + ", aroma: " + d.getAroma());
    }
    public void printBautura (Bauturi b){
        System.out.println(b.getNume() + ", pret: " + b.getPret() + ", tip: " + b.getTip());
    }
    public void printMancare (Mancare m){
        System.out.println(m.getNume() + ", pret: " + m.getPret() + ", durata: " + m.getMinute() + " minute");
    }
    public void printAllMeniu (Meniu[] array){
        System.out.println("-----------------MENIUL RESTAURANTULUI: -----------------");
        System.out.println("-----------------BAUTURI: ");
        for(Meniu elem : array){
            if(elem instanceof Bauturi){
                printBautura((Bauturi)elem);
            }
        }
        System.out.println("-----------------FELURI DE MANCARE: ");
        for(Meniu elem : array){
            if(elem instanceof Mancare){
              printMancare((Mancare)elem);
            }
        }
        System.out.println("-----------------DESERTURI: ");
        for(Meniu elem : array){
            if(elem instanceof Desert){
                printDesert((Desert)elem);
            }
        }
        System.out.println("-----------------------------------------------------------");

    }

    public int nota_de_plata (String nume, Client[] clienti){
        int suma = 0;
        for (Client elem : clienti){
            if(Objects.equals(elem.getNume(), nume)){
                for (Meniu m : elem.getComanda()){
                    suma += m.getPret();
                }
                break;
            }
        }
        return suma;
    }

}
