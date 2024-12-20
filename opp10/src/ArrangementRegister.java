import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

public class ArrangementRegister {
    private List<Arrangement> arrangementer;
    public ArrangementRegister(List<Arrangement> arrangementer) {
        this.arrangementer = arrangementer;
    }
    public void registrerNyttArrangement(Arrangement nyttArrangement) {
        this.arrangementer.add(nyttArrangement);
    }
    public List<Arrangement> finnAlleArrangementPåSted(String sted) {
        List<Arrangement> arrangementerPåSted = new ArrayList<Arrangement>();
        for (Arrangement arrangement : arrangementer) {
            if (arrangement.skaffSted().equals(sted)) arrangementerPåSted.add(arrangement);
        }
        return arrangementerPåSted;
    }
    public List<Arrangement> finnAlleArrangementPåDato(Date dato) {
        List<Arrangement> arrangementerPåDato = new ArrayList<Arrangement>();
        for (Arrangement arrangement : arrangementer) {
            Date arrangementDato = arrangement.skaffDato();
            if (
                arrangementDato.getYear() + 1900 == dato.getYear() && 
                arrangementDato.getMonth() + 1 == dato.getMonth() &&
                arrangementDato.getDate() == dato.getDate() 
            ) {
                arrangementerPåDato.add(arrangement);
            }
        }
        return arrangementerPåDato;
    }
    public List<Arrangement> finnAlleArrangementMellomDatoer(long startDato, long sluttDato) {
        List<Arrangement> arrangementerMellomDatoer = new ArrayList<Arrangement>();
        for (Arrangement arrangement : arrangementer) {
            if (startDato <= new Date(arrangement.skaffTidspunkt()).getTime() && new Date(arrangement.skaffTidspunkt()).getTime() <= sluttDato) {
                arrangementerMellomDatoer.add(arrangement);
            }
        }
        return ArrangementRegister.skaffTidsSortertListeOverArrangementer(arrangementerMellomDatoer);
    }
    public static List<Arrangement> skaffTidsSortertListeOverArrangementer(List<Arrangement> arrangementer) {
        List<Arrangement> sorterteArrangementer = new ArrayList<Arrangement>(arrangementer);
        Collections.sort(sorterteArrangementer, new ArrangementComparitorOnTime());
        return sorterteArrangementer;
    }
    public ArrayList<Arrangement> skaffFultSortertListe() {
        Comparator<Arrangement> fullComparator = Comparator
                .comparing(Arrangement::skaffSted)
                .thenComparing(Arrangement::skaffType)
                .thenComparing(Arrangement::skaffTidspunkt);
     
        ArrayList<Arrangement> sorterteArrangementer = (ArrayList<Arrangement>) this.arrangementer.stream()
            .sorted(fullComparator)
            .collect(Collectors.toList());
        
        return sorterteArrangementer;
    }
    public String toString() {
        String utTekst = "";
        for (Arrangement arrangement : ArrangementRegister.skaffTidsSortertListeOverArrangementer(arrangementer)) {
            utTekst += arrangement.toString() + "\n";
        }
        return utTekst;
    }
}
