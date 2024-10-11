import java.io.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    static String lesBrukerGenerertTekst(String prompt) {
        try {
            @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
            final Scanner inputScanner = new Scanner(System.in);
            System.out.println(prompt);
            final String outputString = inputScanner.nextLine();
            return outputString;
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt.");
            return lesBrukerGenerertTekst(prompt);
        }
    }
    public static void task1() {
        java.util.Random randomNumberGenerator = new java.util.Random();
        int[] antall = new int[10];
        for(int i = 0; i < 10_000; i++) {
            int tilfeldigHeltall = randomNumberGenerator.nextInt(10);            
            antall[tilfeldigHeltall] += 1;
        }
        System.out.println(Arrays.toString(antall));
    }
    public static void task2() {
        do {
            final String brukerTekst = javax.swing.JOptionPane.showInputDialog("Skriv inn teksten din");

            final Tekstanalyse minTekstanalyse = new Tekstanalyse(brukerTekst);
            final int antallBokstaver = minTekstanalyse.antallBokstaver();
            final double prosentIkkeBokstaver = minTekstanalyse.prosentIkkeBokstaver();
            final List<Character> hvilkeBokstaverRepeteresOftest = minTekstanalyse.hvilkeBokstaverRepeteresOftest();
            System.out.println("Antall bokstaver = " + Integer.toString(antallBokstaver));
            System.out.println("Prosent ikke bokstaver = " + Double.toString(prosentIkkeBokstaver) + " %");
    
            System.out.println("Hvilke bokstaver som repeteres oftest:");
            hvilkeBokstaverRepeteresOftest.forEach((Character bokstav) -> {
                System.out.println("--: " + bokstav);
            });
            if(lesBrukerGenerertTekst("skriv: 'exit' for å avslutte, eller trykk 'enter'").contains("exit")) break;
        } while (true);
    }
    public static void task3() {
        final Matrise minMatrise = new Matrise(new int[][] {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        });
        System.out.println("Orginal: " + Arrays.deepToString(minMatrise.skaffMatrise()));
        final int[][] minMatriseAddert = minMatrise.adderMedMatrise(new int[][] {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1},
        });
        System.out.println("Addert: " + Arrays.deepToString(minMatriseAddert));
        final int[][] minMatriseMultiplisert = minMatrise.multipliserMedMatrise(new int[][] {
            {2, 0, 0}, 
            {0, 2, 0}, 
            {0, 0, 2}
        });
        System.out.println("Multiplisert: " + Arrays.deepToString(minMatriseMultiplisert));
        final int[][] transponert = minMatrise.transponer();
        System.out.println("Transponert: " + Arrays.deepToString(transponert));
    }
    public static void main(String[] args) throws Exception {
        task1();
        task2();
        task3();
    }
}
