import java.util.ArrayList;

public class Menu {
    private ArrayList<Dish> dishes;
    public Menu(ArrayList<Dish> dishes) {
        this.dishes = dishes;
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Dish currentDish : this.dishes) {
            totalPrice += currentDish.getPrice();
        }
        return totalPrice;
    }

    public ArrayList<Dish> getDishes() {
        return this.dishes;
    }

    @Override
    public String toString() {
        final StringBuilder out = new StringBuilder("");
        int count = 0;
        for (Dish currentDish : this.dishes) {
            out.append(count);
            out.append("\tMENU: ");
            out.append(currentDish.getType());
            out.append("\t\t");
            out.append(currentDish.getPrice());
            out.append("\t\t");
            out.append(currentDish.getName());
            out.append("\n");
            count++;
        }
        return out.toString();
    }
}
