import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tekstanalyse {
    private int[] antallTegn;
    // private String alfabet = "abcdefghijklmnopqrstuvwxyz";
    private int finnIndeksAvTegn(char tegn) {
        final char brukbartTegn = Character.toLowerCase(tegn);
        System.out.println("brukbartTegn: " + brukbartTegn);
        final int asciiVerdi= (int) brukbartTegn - 97;
        int indeks = asciiVerdi;
        if (asciiVerdi < 0 || asciiVerdi > 26) indeks = 29;
        switch (asciiVerdi) {
            case 133: // æ
                indeks = 26;
                break;
            case 151: // ø
                indeks = 27;
                break;
            case 132: // å
                indeks = 28;
                break;
            default:
                break;
        }
        return indeks;
    }
    private char finnIndeksSittTegn(int indeks) {
        char tegn = (char) (indeks + 97);
        if (indeks == 26) return 'æ';
        if (indeks == 27) return 'ø';
        if (indeks == 28) return 'å';
        if (indeks < 0 || indeks > 28) return '.'; 
        return tegn;
    }
    public Tekstanalyse(String tekst) {
        this.antallTegn = new int[30];
        for(int i = 0; i < tekst.length(); i++) {
            final char currentCharacter = Character.toLowerCase(tekst.charAt(i));
            int indeksVerdi = finnIndeksAvTegn(currentCharacter);
            System.out.println(currentCharacter + ", " + Integer.toString(indeksVerdi));
            this.antallTegn[indeksVerdi] += 1;
        }
        System.out.println("Rådata av bokstavfordeling: " + Arrays.toString(this.antallTegn));
    }
    public int[] skaffAntallTegn() {
        return this.antallTegn;
    }
    public int skaffAntallRepitisjonerAvTegn(char tegn) {
        final int indeksAvTegn = this.finnIndeksAvTegn(tegn);
        if (indeksAvTegn == 29) return -1; // oppgave sa vi ikke skulle inkludere alt utafor a-z / A-Z
        int antallRepitisjoner = this.antallTegn[indeksAvTegn];
        return antallRepitisjoner;
    }
    public int antallBokstaver() {
        int antall = Arrays.stream(this.antallTegn).sum() - antallTegn[29];
        return antall;
    }
    public double prosentIkkeBokstaver() {
        // int antallBokstaver = this.antallBokstaver();
        double antallIkkeBokstaver = (double) antallTegn[29];
        double antall = (double) Arrays.stream(this.antallTegn).sum();
        return (antallIkkeBokstaver / antall) * 100;
    }
    public List<Character> hvilkeBokstaverRepeteresOftest() {
        List<Character> bokstaverSomRepeteresOftest = new ArrayList<Character>();
        int hoyesteAntallRepitisjonerFunnet = 0; 
        for(int i = 0; i < this.antallTegn.length - 1; i++) {
            int antallRepitisjoner = this.antallTegn[i];
            char tegn = finnIndeksSittTegn(i);
            if (hoyesteAntallRepitisjonerFunnet < antallRepitisjoner) {
                hoyesteAntallRepitisjonerFunnet = this.antallTegn[i];
                bokstaverSomRepeteresOftest = new ArrayList<Character>();
                bokstaverSomRepeteresOftest.add(tegn);
            }
            else if (hoyesteAntallRepitisjonerFunnet == antallRepitisjoner) {
                bokstaverSomRepeteresOftest.add(tegn);
            }
        }
        return bokstaverSomRepeteresOftest;
    }
}
