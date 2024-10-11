public class Valuta {
    private String navn; 
    private String forkortelse;
    private double norskKroneVerdi;
    public Valuta(String navn, String forkortelse, double norskKroneVerdi) {
        this.navn = navn;
        this.forkortelse = forkortelse;
        this.norskKroneVerdi = norskKroneVerdi;
    }
    public double tilNorskeKroner(double mengdePenger) {
        return mengdePenger * norskKroneVerdi;
    }
    public double fraNorskeKronerTilValuta(double norskeKroner) {
        return norskeKroner / norskKroneVerdi;
    }
    public String skaffNavn() {
        return this.navn;
    }
    public String skaffForkortelse() {
        return this.forkortelse;
    }
}
