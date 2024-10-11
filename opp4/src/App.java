import java.util.Scanner;

public class App {
    static int readInt(String prompt) {
        try {
            @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
            final Scanner inputScanner = new Scanner(System.in);
            System.out.println(prompt);
            final int outputInt = inputScanner.nextInt();
            return outputInt;
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt. Skriv kun inn heltall.");
            return readInt(prompt);
        }
    }
    static int positiveReadInt(String prompt) {
        int out = -1;
        while (out < 0) {
            out = readInt(prompt); 
            if (out < 0) System.out.println("You must enter a number over or equal to 0");
        }
        return out;
    }
    public static void task1() {
        final Valuta usd = new Valuta("Amerikanske Dollar", "USD", 10.49);
        final Valuta euro = new Valuta("Euro", "EUR", 11.73);
        final Valuta britishPound = new Valuta("Britisk pund", "GBP", 13.84);
        do {
            System.out.println("Hvilken valuta vil du regne til NOK? (skriv tall i konsollen for å velge)");
            System.out.println("1: Amerikanske dollar");
            System.out.println("2: Euro");
            System.out.println("3: Britisk pund");
            System.out.println("1000: Avslutt");
            final int choice = positiveReadInt("Velg: "); 
            if (choice == 1000) break;
            final double amount = positiveReadInt("Hvor mye av valgt valuta vil du omregne til NOK?"); 
            switch (choice) {
                case 1:
                    System.out.println(Double.toString(amount) + usd.skaffForkortelse() + " er lik " +  usd.tilNorskeKroner(amount) + " NOK");
                    break;
                case 2:
                    System.out.println(Double.toString(amount) + euro.skaffForkortelse() + " er lik " +  euro.tilNorskeKroner(amount) + " NOK");
                    break;
                case 3:
                    System.out.println(Double.toString(amount) + britishPound.skaffForkortelse() + " er lik " +  britishPound.tilNorskeKroner(amount) + " NOK");
                    break;
                default:
                    break;
            }
        }
        while (true);
    }
    public static void task2() {
        final Spiller A = new Spiller();
        final Spiller B = new Spiller();
        int rundeNummer = 1;
        while (!A.erFerdig() && !B.erFerdig()) {
            A.kastTerningen();
            B.kastTerningen();
            System.out.println("runde: " + rundeNummer);
            System.out.println("A: " + A.getSumPoeng());
            System.out.println("B: " + B.getSumPoeng());
            rundeNummer++;
        }
        if (A.erFerdig()) System.out.println("A har vunnet!");
        else System.out.println("B har vunnet!");
    }
    public static void main(String[] args) throws Exception {
        task1();
        // task2();
    }
}
