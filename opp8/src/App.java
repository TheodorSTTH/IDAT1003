import java.util.List;
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
    static double lesDesimaltall(String prompt) {
        try {
            @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
            final Scanner inputScanner = new Scanner(System.in);
            System.out.println(prompt);
            final double outputDouble = inputScanner.nextDouble();
            return outputDouble;
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt. Skriv kun inn desimaltall.");
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
    public static void task1() {
        do {
            final Person Kari = new Person(
                lesBrukerGenerertTekst("Fornavn: "), 
                lesBrukerGenerertTekst("Etternavn: "), 
                lesHeltall("Fødselsår: "));
            final ArbTaker KariPåJobb = new ArbTaker(
                Kari,
                lesHeltall("Arbtaker nummer: "), 
                lesHeltall("Ansettelsesår: "), 
                lesDesimaltall("Månedslønn: "), 
                lesDesimaltall("Skatteprosent: ")
            );
            
            System.out.println("Kari skattetrekk i desember " + KariPåJobb.skattetrekkMåned(Måned.DESEMBER) + " kr");
            System.out.println("Kari bruttolønn per år " + KariPåJobb.skaffBruttolønnPerÅr() + " kr");
            System.out.println("Kari skattetrekk per år " + KariPåJobb.skattetrekkHeltÅr() + " kr");
            System.out.println("Kari heter " + KariPåJobb.skaffFormatertNavn());
            System.out.println("Kari sin alder er " + KariPåJobb.skaffAlder() + " år");
            System.out.println("Kari har jobba i bedriften " + KariPåJobb.skaffAntallÅrAnsattIBedriften() + " år");
            System.out.println("Har Kari vært ansatt mer enn 4 år? " + (KariPåJobb.harVærtAnsattMerEnnÅr(4) ? "Ja" : "Nei"));
            if(lesBrukerGenerertTekst("skriv: 'exit' for å avslutte, eller trykk 'enter' for å fortsette").contains("exit")) break;
        } while (true);
    }
    public static void main(String[] args) throws Exception {
        task1();
    }
}
