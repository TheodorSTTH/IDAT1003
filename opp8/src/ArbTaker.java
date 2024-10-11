import java.util.Date;
import java.util.Calendar;

public class ArbTaker {
    private Person personalia;
    private int arbtakernr;
    private int ansettelsesår;
    private double månedslønn;
    private double skatteprosent;
    public ArbTaker(Person personalia, int arbtakernr, int ansettelsesår, double månedslønn, double skatteprosent) {
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesår = ansettelsesår;
        this.månedslønn = månedslønn;
        this.skatteprosent = skatteprosent;
    }
    public Person skaffPersonlia() {
        return this.personalia;
    }
    public int skaffArbtakernr() {
        return this.arbtakernr;
    }
    public int skaffAnsettelsesår() {
        return this.ansettelsesår;
    }
    public double skaffMånedslønn() {
        return this.månedslønn;
    }
    public double skaffSkatteprosent() {
        return this.skatteprosent;
    }
    public double settMånedslønn(double nyMånedslønn) {
        this.månedslønn = nyMånedslønn;
        return this.månedslønn;
    }
    public double settSkatteprosent(double nySkatteprosent) {
        this.skatteprosent = nySkatteprosent;
        return this.skatteprosent;
    }
    public double skaffBruttolønnPerÅr() {
        return this.månedslønn * 12;
    }
    public double skattetrekkMåned(Måned måned) {
        if (måned == Måned.JUNI) return 0;
        if (måned == Måned.DESEMBER) return månedslønn * (skatteprosent / 100) / 2;
        return månedslønn * (skatteprosent / 100);
    }
    public double skattetrekkHeltÅr() {
        return månedslønn * (skatteprosent / 100) * 10.5; // december half taxes, june no taxes
    }
    public String skaffFormatertNavn() {
        return this.personalia.skaffEtternavn() + ", " + this.personalia.skaffFornavn();
    }
    public int skaffAlder() {
        final int fødselsår = this.personalia.skaffFødselsår();
        final int nåværendeÅr = Calendar.getInstance().get(Calendar.YEAR);
        return nåværendeÅr - fødselsår;
    }
    public int skaffAntallÅrAnsattIBedriften() {
        final int ansettelsesår = this.ansettelsesår;
        final int nåværendeÅr = Calendar.getInstance().get(Calendar.YEAR);
        return nåværendeÅr - ansettelsesår;
    }
    public boolean harVærtAnsattMerEnnÅr(int gittAntallÅr) {
        return skaffAntallÅrAnsattIBedriften() > gittAntallÅr;
    }
}
