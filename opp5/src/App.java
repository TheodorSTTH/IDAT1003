public class App {
    public static void task1() {
        final Fraction A = new Fraction(1, 4);
        final Fraction B = new Fraction(2, 4);
        A.sumWithOtherFraction(B);
        final Fraction C = new Fraction(1, 2);
        final Fraction D = new Fraction(1, 4);
        C.subtractOtherFraction(D);
        final Fraction E = new Fraction(1, 8);
        final Fraction F = new Fraction(1, 8);
        E.multiplyWithOtherFraction(F);
        final Fraction G = new Fraction(3, 8);
        final Fraction H = new Fraction(1, 8);
        G.divideWithOtherFraction(H);
    }
    public static void task2() {
        final MinRandom tilfeldigTallGenerator = new MinRandom(new java.util.Random());
        System.out.println("-- DESIMALTALL --");
        for(int i = 0; i < 50; i++) {
            System.out.println(tilfeldigTallGenerator.nesteDesimaltall(1, 10));
        }
        System.out.println("-- HELTALL --");
        for(int i = 0; i < 50; i++) {
            System.out.println(tilfeldigTallGenerator.nesteHeltall(1, 10));
        }
    }
    public static void main(String[] args) throws Exception {
        task1();
        // task2();
    }
}
