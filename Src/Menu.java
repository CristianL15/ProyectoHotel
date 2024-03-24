package Src;
import java.util.ArrayList;

public class Menu {
    private String name;
    private ArrayList<FoodItem> menu = new ArrayList<FoodItem>();

    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public void removeFoodItem(int id) {
        FoodItem item = menu.stream().filter(foodItem -> foodItem.getId() == id).findFirst().orElse(null);
        if (item != null) {
            menu.remove(item);
        }
    }

    public void showMenu() {
        for (int i = 0; i < menu.size(); i++){
            FoodItem foodItem = menu.get(i);
            System.out.println("[" + (i + 1) + "] " + foodItem + " --- " + foodItem.getPrice());
        }
    }

    public ArrayList<FoodItem> getMenu() {
        return menu;
    }
}
