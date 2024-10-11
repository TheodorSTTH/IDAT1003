import java.util.Comparator;

public class ArrangementComparitorOnTime implements Comparator<Arrangement> {
    public int compare(Arrangement a1, Arrangement a2) {
        return Long.compare(a1.skaffTidspunkt(), a2.skaffTidspunkt());
    }
}