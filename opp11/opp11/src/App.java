import java.util.Scanner;

public class App {
    static int lesHeltall(String prompt) {
        try {
            @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
            final Scanner inputScanner = new Scanner(System.in);
            System.out.println(prompt);
            final int outputInt = inputScanner.nextInt();
            return outputInt;
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt. Skriv kun inn heltall.");
            return lesHeltall(prompt);
        }
    }
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

    public static void main(String[] args) throws Exception {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
