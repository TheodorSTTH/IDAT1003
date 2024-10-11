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
    static double inchesToCm(double inches) {
        final double cmInOneInch = 2.54;
        return inches * cmInOneInch;
    }
    static void task1() {
        final double inches = readDouble("How many cm is X inches? ");
        final double convertedCm = inchesToCm(inches);
        System.out.println(Double.toString(inches) + " inches equals " + Double.toString(convertedCm));

    }
    static double hoursMinutesAndSecondsToSeconds(double hours, double minutes, double seconds) {
        final double secondsInHours = 3600 * hours;
        final double secondsInMinutes = 60 * minutes;
        final double totalSeconds = secondsInHours + secondsInMinutes + seconds;
        return totalSeconds;
    }
    static void task2() {
        final double hours = readDouble("How many hours do you want to convert to seconds?");
        final double minutes = readDouble("How many minutes do you want to convert to seconds?");
        final double seconds = readDouble("How many seconds do you want to convert to seconds?");
        final double total = hoursMinutesAndSecondsToSeconds(hours, minutes, seconds);
        System.out.println(Double.toString(hours) + " hours, " + Double.toString(minutes) + " minutes and " + Double.toString(seconds) + " seconds equals " + total + " seconds");
    }
    static void task3() {
        double secondsIn = positiveReadDouble("How many seconds do you want to convert into hours, minutes and seconds?");
        final SecondsToHoursMinutesAndSecondsConverter hoursMinutesAndSeconds = new SecondsToHoursMinutesAndSecondsConverter(secondsIn);
        System.err.println("-------- \n");
        System.out.println("Hours: " + hoursMinutesAndSeconds.getHours());
        System.out.println("Minutes: " + hoursMinutesAndSeconds.getMinutes());
        System.out.println("Seconds: " + hoursMinutesAndSeconds.getSeconds());
    }
    public static void main(String[] args) throws Exception {
        task1();
        // task2();
        // task3();
    }
}
