public class Dish {
    private double price;
    private DishType type;
    private String name;
    
    public Dish(String name, DishType type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
    public DishType getType() {
        return this.type;
    }
    public String getName() {
        return this.name;
    }
    @Override
    public String toString() {
        return this.type + " | " + this.price + " | " + this.name;
    }
}
