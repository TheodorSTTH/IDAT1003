public class Cat extends Animal implements IPet {
    private String name;
    public Cat(int age, String name) {
        super(age, "Cat");
        this.name = name;
    }
    public void play() {
        System.out.println("MEOWWW");
    }
    public String getName() {
        return name;
    }
}
