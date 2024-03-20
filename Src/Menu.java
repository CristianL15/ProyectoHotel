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
        for (FoodItem foodItem : menu){
            System.out.println(foodItem);
        }
    }
}
