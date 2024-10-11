import java.util.ArrayList;
import java.util.List;

public class App {
    public static void task1() {
        final Student oskar = new Student("Oskar", 1);
        oskar.økAntOppg(3);
        System.out.println("getAntOppg      " + oskar.getAntOppg());
        System.out.println("getNavn         " + oskar.getNavn());
        System.out.println("toString        " + oskar.toString());
        
        Student johannes = new Student("Johannes", 10);
        Student jesper = new Student("Jesper", 50);
        Student marianne = new Student("Marianne", 5);
        Student trude = new Student("Trude", 100);
        Student finn = new Student("Finn", 5);

        System.out.println("-- Oppgaveoversikt --");
        
        List<Student> studentListe = new ArrayList<Student>();
        studentListe.add(johannes);
        studentListe.add(jesper);
        studentListe.add(marianne);
        studentListe.add(trude);
        studentListe.add(finn);

        Oppgaveoversikt skoleklasse5dVålerengaSkole = new Oppgaveoversikt(studentListe);
        System.out.println(skoleklasse5dVålerengaSkole.toString());
        skoleklasse5dVålerengaSkole.økAntallOppgaverTilStudent("Jesper", 6);
        System.out.println("Oppgaver løst av Jesper: " + skoleklasse5dVålerengaSkole.finnAntallOppgaverLøstAvStudent("Jesper"));
        Student kåre = new Student("Kåre", 0);
        skoleklasse5dVålerengaSkole.registrerStudent(kåre);
        System.out.println(skoleklasse5dVålerengaSkole.toString());
    }
    public static void main(String[] args) throws Exception {
        task1();
    }
}
