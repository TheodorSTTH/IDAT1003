import java.util.Scanner;

public class App {
    static double readDouble(String prompt) {
        @SuppressWarnings("resource") // Ignore warning about resource leak System.in is supposed to stay open
        final Scanner inputScanner = new Scanner(System.in);
        System.out.println(prompt);
        final double outputDouble = inputScanner.nextDouble();
        return outputDouble;
    }
    static double positiveReadDouble(String prompt) {
        double out = -1;
        while (out < 0) {
            out = readDouble(prompt); 
            if (out < 0) System.out.println("You must enter a number over or equal to 0");
        }
        return out;
    }
    public static void task1() {
        final int year = (int) readDouble("Hvilket år vil du sjekke om er skuddår?");
        final boolean isExactCentury = year % 100 == 0;
        boolean isLeapyear = false;
        if (isExactCentury) {
            isLeapyear = year % 400 == 0;
        }
        else {
            isLeapyear = year % 4 == 0;
        }
        if (isLeapyear) {
            System.out.println(Integer.toString(year) + " et et skuddår");
            if (isExactCentury) System.out.println(Integer.toString(year) + " men også et hundreår");
        }
        else System.out.println(Integer.toString(year) + " er ikke et skuddår");
    }
    public static void task2() {
        final double productACost = readDouble("Hvor mye koster produkt A i NOK?"); // NOK
        final double productAGrams = readDouble("Hvor mye veier produkt A i gram?"); // gram
        final double productBCost = readDouble("Hvor mye koster produkt B i NOK?"); // NOK
        final double productBGrams = readDouble("Hvor mye veier produkt B i gram?"); // gram
        final double costPerGramA = productACost / productAGrams;
        final double costPerGramB = productBCost / productBGrams;
        if (costPerGramA < costPerGramB) System.out.println("Produkt A er billigere enn produkt B");
        else System.out.println("Produkt B er billigere enn produkt A");
    }
    public static void main(String[] args) throws Exception {
        task1();
        // task2();
    }
}
