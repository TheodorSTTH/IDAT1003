public abstract class Animal {
    private int age;
    private String species;
    public Animal(int age, String species) {
        this.age = age;
        this.species = species;
    }
    public String getSpecies() {
        return species;
    }
}
