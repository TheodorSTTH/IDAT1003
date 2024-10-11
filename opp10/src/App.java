import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class App {
    public static void task1() {
        Arrangement avgangssermoniEldrehjemmet = new Arrangement("Hamar", "sermoni", 1724928940001L);
        Arrangement bursdagsfest = new Arrangement("Oslo", "bursdag", 1724928940091L);
        Arrangement begravelse = new Arrangement("Oslo", "trist", 1724928950091L);
        Arrangement y2k = new Arrangement("New York", "fellesfest", 1700928950091L);
        Arrangement fest1970sTema = new Arrangement("Bergen", "fellesfest", 0);
        
        List<Arrangement> arrangementListe = new ArrayList<Arrangement>();
        arrangementListe.add(avgangssermoniEldrehjemmet);
        arrangementListe.add(bursdagsfest);
        arrangementListe.add(begravelse);
        arrangementListe.add(y2k);
        arrangementListe.add(fest1970sTema);
        
        ArrangementRegister eventhouseArrangementRegister = new ArrangementRegister(arrangementListe);
        Arrangement fest1990sTema = new Arrangement("Sola", "fellesfest", 100928950091L);
        eventhouseArrangementRegister.registrerNyttArrangement(fest1990sTema);
        System.out.println(eventhouseArrangementRegister.toString());

        List<Arrangement> arrangementerIOslo = eventhouseArrangementRegister.finnAlleArrangementPåSted("Oslo");
        System.out.println("-- Arrangementer I Oslo --");
        arrangementerIOslo.forEach(arrangement -> {
            System.out.println(arrangement.toString());
        });
        
        List<Arrangement> arrangementerIDag = eventhouseArrangementRegister.finnAlleArrangementPåDato(new Date());
        System.out.println("-- Arrangementer I Dag --");
        arrangementerIDag.forEach(arrangement -> {
            System.out.println(arrangement.toString());
        });
        
        List<Arrangement> arrangementerForLengeSiden = eventhouseArrangementRegister.finnAlleArrangementMellomDatoer(0, 1700928950091L);
        System.out.println("-- Arrangementer for lenge siden --");
        arrangementerForLengeSiden.forEach(arrangement -> {
            System.out.println(arrangement.toString());
        });
    }
    public static void main(String[] args) throws Exception {
        task1();
    }
}
