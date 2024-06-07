package mini.spaceport;
import mini.promy.*;

import java.util.*;

public class KomputerKontrolny {
    static void losowyWypadek(int prawdopodobienstwo) throws WyjatekUsterka {
        Random rand = new Random();
        if (rand.nextInt(101) < prawdopodobienstwo) {
            switch (rand.nextInt(2)) {
                case 0:
                    throw new WyjatekKolizja("Zderzenie z Marsjanami, bez paniki");
                case 1:
                    throw new WyjatekUsterka("Problem z silnikiem grawitacyjnym, na zwykłym będziemy lecieć 1353 lata…");
            }
        }
    }

    public static void main(String[] args) {

        //gotowe
        Random rand = new Random();
        String planety[] = {"Mars", "Neptun", "Jowisz", "Alfa Centauri", "Kepler 17"};



        System.out.println("----------PRZYGOTOWANIE RAKIET----------------");

        Map<Integer, Rakieta> mapaRakiet = new HashMap<>();
        List<Rakieta> listaRakiet = new ArrayList<>();

        int i = 0;
        while (i < 10) {
            try {
                PromKosmiczny prom = new PromKosmiczny(1000 + rand.nextInt(100), rand.nextInt(9) + 2, planety[rand.nextInt(planety.length)], 500, rand.nextInt(501));
                mapaRakiet.put(i, prom);
                i++;
            } catch (WyjatekTransportu e) {
                System.out.println("Błąd podczas tworzenia rakiety: " + e.getMessage());
            }
        }

        for (Map.Entry<Integer, Rakieta> entry : mapaRakiet.entrySet()) {
            listaRakiet.add(entry.getValue());
        }


        System.out.println("----------W KOSMOSIE----------------");
        //todo
        while (!listaRakiet.isEmpty()) {
            Iterator<Rakieta> iterator = listaRakiet.iterator();
            while (iterator.hasNext()) {
                Rakieta rakieta = iterator.next();
                try {
                    rakieta.zuzycieTlenu(70);
                    rakieta.getIloscTlenu();
                    losowyWypadek(10);
                    rakieta.kolejnyDzien();

                } catch (WyjatekBrakTlenu e) {
                    System.out.println(e.getMessage());
                    iterator.remove();
                } catch (WyjatekUsterka e) {
                    System.out.printf(e.getMessage());
                }
            }

            for (Rakieta rakieta : listaRakiet) {
                System.out.println(rakieta);
            }
        }
    }
}
