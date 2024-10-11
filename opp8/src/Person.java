public class Person {
    private String fornavn;
    private String etternavn;
    private int fødselsår;
    public Person(String fornavn, String etternavn, int fødselsår) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fødselsår = fødselsår;
    }
    public String skaffFornavn() {
        return this.fornavn;
    }
    public String skaffEtternavn() {
        return this.etternavn;
    }
    public int skaffFødselsår() {
        return this.fødselsår;
    }
}
