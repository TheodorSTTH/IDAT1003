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
    static String readString(String prompt) {
        try {
            @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
            final Scanner inputScanner = new Scanner(System.in);
            System.out.println(prompt);
            final String outputInt = inputScanner.nextLine();
            return outputInt;
        }
        catch (Exception e) {
            System.out.println("Noe gikk galt.");
            return readString(prompt);
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
    public static void printMutplicationTable(int multiplicationTableStart, int multiplicationTableEnd, int printFrom, int printTo) {
        for (int i = multiplicationTableStart; i < multiplicationTableEnd + 1; i++) {
            for (int j = printFrom; j < printTo + 1; j++) {
                System.out.println(Integer.toString(i) + " * " + Integer.toString(j) + " = " + Integer.toString(i * j));
            }
        }
    }
    public static void task1() {
        final int multiplicationTableStart = positiveReadInt("Hvilken multiplikasjonstabell vil du starte fra?");
        final int multiplicationTableEnd = positiveReadInt("Hvilken multiplikasjonstabell vil du ende på?");
        final int printFrom = positiveReadInt("Hvilken verdi vil starte å printe hver multiplikasjonstabell fra?");
        final int printTo = positiveReadInt("Hvilken verdi vil starte å printe hver multiplikasjonstabell til?");
        if (multiplicationTableStart > multiplicationTableEnd) {
            System.err.println("Den multiplikasjonstabellen du vil du starte fra kan ikke være storre enn den som du ender på.");
            return;
        }
        if (printFrom > printTo) {
            System.err.println("Den verdien du start å skrive hver multiplikasjonstabell fra  kan ikke være storre enn den som du ender på.");
        }
        printMutplicationTable(multiplicationTableStart, multiplicationTableEnd, printFrom, printTo);
    }
    public static boolean isPrimeNumber(int numberToBeChecked) {
        if (numberToBeChecked < 2) return false;
        for (int i = 2; i < numberToBeChecked; i++) {
            // System.out.println(Integer.toString(numberToBeChecked) + " % " + Integer.toString(i) + " = " + Double.toString((double) numberToBeChecked % (double) i));
            if (numberToBeChecked % i == 0) return false;
        }
        return true;
    }
    public static void task2() {
        while (true) {
            final int numberToBeChecked = readInt("Hvilket heltall vil du sjekke om er et primtall?");
            final boolean numberToBeCheckedIsPrime = isPrimeNumber(numberToBeChecked);
            if (numberToBeCheckedIsPrime) System.err.println(Integer.toString(numberToBeChecked) + " er et primtall");
            else System.out.println(Integer.toString(numberToBeChecked) + " er ikke et primtall");
            final String in = readString("Skriv 'x' for å avslutte");
            if (in.charAt(0) == 'x') break;
        }
    }
    public static void main(String[] args) throws Exception {
        // task1();
        task2();
    }
}
