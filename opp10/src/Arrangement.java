import java.util.Date;
public class Arrangement {
    private String sted;
    private String type;
    private long tidspunkt;
    public Arrangement(String sted, String type, long tidspunkt) {
        this.sted = sted;
        this.type = type;
        this.tidspunkt = tidspunkt;
    }
    public String skaffSted() {
        return this.sted;
    }
    public long skaffTidspunkt() {
        return this.tidspunkt;
    }
    public Date skaffDato() {
        Date dato = new Date(tidspunkt);
        return dato;
    }
    public String toString() {
        return this.sted + " | " + this.tidspunkt;
    }
}
