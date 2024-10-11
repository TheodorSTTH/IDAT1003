import java.util.List;

public class Oppgaveoversikt {
    private List<Student> studenter;
    private int antStud = 0;
    public Oppgaveoversikt(List<Student> studenter) {
        this.studenter = studenter;
        this.antStud = studenter.size();
    }
    public int antStud() {
        return this.antStud;
    }
    public int finnAntallOppgaverLøstAvStudent(String navnMål) {
        int antallOppgaverLøstAvStudent = -1;
        for (Student student : this.studenter) {
            if (student.getNavn().equals(navnMål)) {
                antallOppgaverLøstAvStudent = student.getAntOppg();
            }
        }
        if (antallOppgaverLøstAvStudent == -1) throw new Error("Student " + navnMål + " finnes ikke");
        return antallOppgaverLøstAvStudent;
    }
    public int økAntallOppgaverTilStudent(String navnMål, int økning) {
        int antallOppgaverLøstAvStudent = -1;
        for (Student student : this.studenter) {
            if (student.getNavn().equals(navnMål)) {
                student.økAntOppg(økning);
                antallOppgaverLøstAvStudent = student.getAntOppg();
            }
        }
        if (antallOppgaverLøstAvStudent == -1) throw new Error("Student " + navnMål + " finnes ikke");
        return antallOppgaverLøstAvStudent;
    }
    public void registrerStudent(Student student) {
        this.studenter.add(student);
        this.antStud += 1;
    }
    public String toString() {
        String utTekst = "";
        for (Student student : this.studenter) {
            utTekst += student.toString() + "\n";
        }
        return utTekst;
    }
}