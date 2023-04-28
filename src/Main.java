import Meniu.*;
import Persoane.*;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Servicii servicii = new Servicii();

        Meniu[] meniu = {
                new Desert("Papanasi", 28, "gem de fructe"),
                new Desert("Lava Cake", 32, "ciocolata"),
                new Desert("Clatite cu ciocolata", 24, "ciocolata"),
                new Desert("Cheesecake", 30, "fructe"),
                new Desert("Tortul casei", 25, "vanilie"),

                new Bauturi("Apa", 6, "nonalcoolic"),
                new Bauturi("Pepsi", 7, "nonalcoolic"),
                new Bauturi("Sprite", 7, "nonalcoolic"),
                new Bauturi("Limonada", 20, "nonalcoolic"),
                new Bauturi("Fresh de portocale", 22, "nonalcoolic"),
                new Bauturi("Aperol Spritz", 25, "alcoolic"),
                new Bauturi("Martini", 27, "alcoolic"),
                new Bauturi("Hugo", 28, "alcoolic"),
                new Bauturi("Mojito", 25, "alcoolic"),

                new Mancare("Bruschete cu busuioc", 23, 10),
                new Mancare("Bruschete cu somon", 25, 10),
                new Mancare("Bruschete asortate", 25, 12),
                new Mancare("Pizza Margerita", 35, 30),
                new Mancare("Pizza Quattro Formaggi", 40, 30),
                new Mancare("Pizza Capriciosa", 33, 30),
                new Mancare("Pizza Diavola", 35, 30),
                new Mancare("Pizza Prosciutto", 39, 30),
                new Mancare("Penne Arrabiata", 40, 25),
                new Mancare("Spaghete Carbonara", 43, 25),
                new Mancare("Penne Quattro Formaggi", 42, 25),
                new Mancare("Spaghete cu fructe de mare", 47, 25),
                new Mancare("Salata Caesar", 35, 20),
                new Mancare("Salata Halloumi", 34, 20),
                new Mancare("Salata Vegetariana", 37, 20),
                new Mancare("Risotto cu ciuperci", 25, 30),
                new Mancare("Risotto cu creveti", 26, 30)
        };

        int[] a = {1, 3};
        int[] b = {2, 4, 5, 7};
        int[] c = {6, 8, 9};
        String[] d = {"Comunicare", "Organizare", "Responsabilitate"};
        Angajat[] angajati = {
                new Ospatar("Popescu", "Alexandru", "0755647489", 2100, "01.09.2021", "0", a, 350),
                new Ospatar("Dumitru", "Maria", "0756421578", 2500, "15.03.2020", "0", b, 500),
                new Ospatar("Balan", "Andreea", "0759865485", 2200, "20.02.2021", "0", c, 420),
                new Bucatar("Constantinescu", "Sorin", "0759645622", 5200, "01.04.2019", "0", 29),
                new Bucatar("Apostol", "Catalin", "0756231545", 5500, "25.05.2018", "0", 32),
                new Manager("Mihai", "Ana", "07558421440", 4000, "15.06.2020", "0", d)
        };

        Client[] clienti = new Client[20];


        // MENIU INTERACTIV
        Scanner sc = new Scanner(System.in);
        int numar = -1;
        while (numar != 0) {
            int var = 0;
            System.out.println("------------------ALEGETI UNA DIN URMATOARELE VARIANTE-----------------");
            System.out.println("0. EXIT.");
            System.out.println("1. Afisare meniul restaurantului.");
            System.out.println("2. Adaugare in meniu.");
            System.out.println("3. Stergere din meniu.");
            System.out.println("4. Client nou al restaurantului si alegere servire.");
            System.out.println("5. Nota de plata pentru client.");
            System.out.println("6. Afisare client si comanda acestuia.");
            System.out.println("7. Anagajat nou.");
            System.out.println("8. Afisare angajat.");
            System.out.println("9. Calcul salariu angajat.");
            System.out.println("10. Ordonare angajati dupa salariu.");
            System.out.println("11. Afisare lista angajati.");


            numar = sc.nextInt();

            switch (numar) {
                case 0 -> {
                    numar = 0;
                }
                case 1 -> {
                    servicii.printAllMeniu(meniu);
                }
                case 2 -> {
                    System.out.println("Ce tip de produs doriti sa adaugati? [DESERT/BAUTURA/MANCARE]");
                    String tip = sc.next();
                    sc.nextLine();

                    Meniu[] newMeniu = new Meniu[meniu.length + 1];
                    for (int i = 0; i < meniu.length; i++) {
                        newMeniu[i] = meniu[i];
                    }

                    newMeniu[meniu.length] = servicii.addMeniu(tip);

                    meniu = newMeniu;
                    System.out.println("Produsul a fost adaugat cu succes!");
                }
                case 3 -> {
                    System.out.println("Numele produsului:");
                    String nume = sc.next();
                    sc.nextLine();

                    int v = 0;
                    Meniu[] newMeniu2 = new Meniu[meniu.length - 1];
                    for (int i = 0; i < meniu.length; i++) {
                        if(!Objects.equals(meniu[i].getNume(), nume)) {
                            newMeniu2[v++] = meniu[i];
                        }
                    }
                    meniu = newMeniu2;
                    System.out.println("Produsul a fost eliminat cu succes!");
                }
                case 4 -> {
                    clienti[var++] = servicii.addClient(angajati, meniu);
                }
                case 5 -> {
                    System.out.println("Numele clientului:");
                    String nume = sc.next();
                    sc.nextLine();
                    System.out.println("Doriti sa lasati bacsis? [DA/SAU]");
                    String optiune = sc.next();
                    sc.nextLine();
                    if(Objects.equals(optiune, "DA")){
                        System.out.println("Cat doriti sa lasati?");
                        int bacsis = sc.nextInt();
//                        // adauga bacsisul la angajatul(ospatarul) care a servit
//                        for(Angajat elem : angajati){
//                            if(elem instanceof Ospatar){
//                                for(int i : ((Ospatar) elem).getMese()){
//                                    if(nr_masa == i){
//                                        System.out.println(elem.getNume() + " " + elem.getPrenume() + " o sa va serveasca!");
//                                    }
//                                }
//                            }
//                        }
//
//
//                        for (Client elem : clienti) {
//                            if (elem.getNr_masa() == ) {
//
//                            }
//                        }
//                        for (Angajat elem : angajati) {
//                            if (Objects.equals(elem.getNume(), nume)) {
//
//                            }
//
//                        }
                        System.out.println("Nota de plata este in valoarea de: " + (servicii.nota_de_plata(nume, clienti) + bacsis));
                    }
                    else {
                        System.out.println("Nota de plata este in valoarea de: " + servicii.nota_de_plata(nume, clienti));
                    }
                }
                case 6 -> {
                    System.out.println("Numele clientului:");
                    String nume = sc.next();
                    sc.nextLine();
                    for (Client client : clienti){
                        if(Objects.equals(client.getNume(), nume)){
                            servicii.printClient(client);
                            break;
                        }
                    }
                }
                case 7 -> {
                    System.out.println("Introduceti tipul angajatului: [OSPATAR/BUCATAR/MANAGER]");
                    String tip = sc.next();
                    sc.nextLine();

                    Angajat[] newAngajati = new Angajat[angajati.length + 1];
                    for (int i = 0; i < angajati.length; i++) {
                        newAngajati[i] = angajati[i];
                    }

                    newAngajati[angajati.length] = servicii.addAngajat(tip);

                    angajati = newAngajati;
                    System.out.println("Anagajat adaugat cu succes!");
                }
                case 8 -> {
                    System.out.println("Introduceti numele angajatului:");
                    String nume = sc.next();
                    sc.nextLine();

                    for (Angajat elem : angajati){
                        if(Objects.equals(elem.getNume(), nume)){
                            if(elem instanceof Ospatar){
                                servicii.printOspatar((Ospatar) elem);
                            }
                            if(elem instanceof Bucatar){
                                servicii.printBucatar((Bucatar) elem);
                            }
                            if(elem instanceof Manager){
                                servicii.printManager((Manager) elem);
                            }
                            break;
                        }
                    }
                }
                case 9 -> {
                    System.out.println("Introduceti numele angajatului:");
                    String nume = sc.next();
                    sc.nextLine();

                    for (Angajat elem : angajati) {
                        if(Objects.equals(elem.getNume(), nume)) {
                            System.out.println("Salariul calculat cu spor este: " + elem.calc_salariu(elem.getSalariu()));
                        }
                    }
                }
                case 10 -> {
                    Arrays.sort(angajati);
                    System.out.println("Angajatii au fost ordonati!");
                }
                case 11 -> {
                    for(Angajat elem : angajati){
                        if(elem instanceof Ospatar){
                            servicii.printOspatar((Ospatar) elem);
                        }
                        if(elem instanceof Bucatar){
                            servicii.printBucatar((Bucatar) elem);
                        }
                        if(elem instanceof Manager){
                            servicii.printManager((Manager) elem);
                        }
                    }
                }
                default -> {
                    System.out.println("Ati introdus gresit numarul.");
                }
            }
        }
    }
}