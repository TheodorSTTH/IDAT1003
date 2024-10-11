public class MinRandom {
    private java.util.Random tilfeldigTallGenerator;
    public MinRandom(java.util.Random randomNumberGenerator) {
        this.tilfeldigTallGenerator = randomNumberGenerator;
    }
    public int nesteHeltall(int nedre, int ovre) { // intervallet (nedre, ovre)
        int tilfeldigHeltall = tilfeldigTallGenerator.nextInt(nedre, ovre + 1);
        return tilfeldigHeltall;
    }
    public double nesteDesimaltall(double nedre, double ovre) { // intervallet >nedre, ovre>
        double tilfeldigDesimaltall = tilfeldigTallGenerator.nextDouble();
        double utvidetTilfeldigDesimaltall = tilfeldigDesimaltall * (ovre - nedre) + nedre;
        return utvidetTilfeldigDesimaltall;
    }
}
