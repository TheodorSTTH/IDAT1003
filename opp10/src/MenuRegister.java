import java.util.ArrayList;

public class MenuRegister {

    private ArrayList<Dish> dishes;
    private ArrayList<Menu> menus;

    public MenuRegister(ArrayList<Dish> dishes, ArrayList<Menu> menus) {
        this.dishes = dishes;
        this.menus = menus;
    }

    public void addNewDish(Dish newDish) {
        this.dishes.add(newDish);
    }

    public Dish getDishFromName(String name) {
        for (Dish dish : dishes) {
            if (dish.getName().equals(name)) return dish;
        }
        return null;
    }

    public ArrayList<Dish> getAllDishesOfType(DishType targetType) {
        ArrayList<Dish> allDishesOfType = new ArrayList<Dish>();
        for (Dish currentDish : dishes) {
            if (currentDish.getType() == targetType) {
                allDishesOfType.add(currentDish);
            }
        }
        return allDishesOfType;
    }

    public void addNewMenu(Menu newMenu) {
        this.menus.add(newMenu);
    }

    public ArrayList<Menu> getAllMenusInPriceRange(double lowerBound, double upperBound) {
        ArrayList<Menu> menusInPriceRange = new ArrayList<Menu>();
        for (Menu currentMenu : menus) {
            System.out.println("currentMenu: " + currentMenu.toString() + ", " + (currentMenu.getTotalPrice() > lowerBound && currentMenu.getTotalPrice() < upperBound));
            if (currentMenu.getTotalPrice() > lowerBound && currentMenu.getTotalPrice() < upperBound) {
                menusInPriceRange.add(currentMenu);
            }
        }
        return menusInPriceRange;
    }

    public ArrayList<Dish> getDishes() {
        return this.dishes;
    }
    public ArrayList<Menu> getMenus() {
        return this.menus;
    }
}
