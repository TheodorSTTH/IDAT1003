public class Student {
    private String navn; // entydig
    private int antOppg; // antall godkjente oppgaver levert inn
    public Student(String navn, int antOppg) {
        this.navn = navn;
        this.antOppg = antOppg;
    }
    public String getNavn() {
        return this.navn;
    }
    public int getAntOppg() {
        return this.antOppg;
    }
    public void økAntOppg(int økning) {
        this.antOppg += økning;
    }
    public String toString() {
        return this.navn + " | " + this.antOppg;
    }
}