import java.util.Date;
public class Arrangement {
    private String sted;
    private String name;
    private String type;
    private long tidspunkt;
    public Arrangement(String name, String sted, String type, long tidspunkt) {
        this.name = name; 
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
    public String skaffType() {
        return this.type;
    }
    public String toString() {
        return new Date(this.tidspunkt).toString() + " | " + this.sted + " | " + this.type + " | " + this.name;
    }
}
