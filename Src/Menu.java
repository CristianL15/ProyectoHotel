package Src;
import java.util.ArrayList;

public class Menu {
    private String name;
    private ArrayList<FoodItem> menuList = new ArrayList<FoodItem>();

    public void addFoodItem(FoodItem foodItem) {
        menuList.add(foodItem);
    }

    public void showMenu() {
        for (int i = 0; i < menuList.size(); i++){
            FoodItem foodItem = menuList.get(i);
            System.out.println("[" + (i + 1) + "] " + foodItem);
        }
    }

    public ArrayList<FoodItem> getMenu() {
        return menuList;
    }
}
