public class SecondsToHoursMinutesAndSecondsConverter {
    private double hours;
    private double minutes;
    private double seconds;
    public SecondsToHoursMinutesAndSecondsConverter(double seconds) {
        final double doesNotFitInHours = seconds % 3600;
        this.hours = (seconds - doesNotFitInHours) / 3600;
        final double doesNotFitInMinutes = doesNotFitInHours % 60;
        this.minutes = (doesNotFitInHours - doesNotFitInMinutes) / 60;
        this.seconds = doesNotFitInMinutes;
    }
    public double getHours() {
        return hours;
    }
    public double getMinutes() {
        return minutes;
    }
    public double getSeconds() {
        return seconds;
    }
}
