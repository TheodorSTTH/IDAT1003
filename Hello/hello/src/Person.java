public class Person extends Animal {
    private String name;
    private String lastName;
    private static String commonDna = "abc-dna";
    public Person(String name, String lastName, int age) {
        super(age, "Homo Sapiens");
        this.name = name;
        this.lastName = lastName;
    }
    public void talk(String message) {
        System.out.println(getFullName() + " - " + message);
    }
    public String getFullName() {
        return name + " " + lastName;
    }
    public static void scream() {
        System.out.println("Wææææææææ - " + commonDna);
    }
}