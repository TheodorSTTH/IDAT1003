public class Spiller {
    private int sumPoeng;
    public Spiller() {
        this.sumPoeng = 0;
    }
    public int getSumPoeng() {
        return this.sumPoeng;
    }
    public void kastTerningen() {
        java.util.Random tering= new java.util.Random(); 
        int terningkast = tering.nextInt(6) + 1;
        this.sumPoeng += terningkast; // gjør det her pga programbeskrivelse
        if (terningkast == 1) {
            this.sumPoeng = 0;
            System.out.println("KAPAWWWW");
        }
    }
    public boolean erFerdig() {
        return sumPoeng >= 100;
    }
}
