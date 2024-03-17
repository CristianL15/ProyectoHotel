package Hotel;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Menu {
    private String name;
    private ArrayList<FoodItem> menu = new ArrayList<FoodItem>();

    public void addFoodItem(FoodItem foodItem) {
        menu.add(foodItem);
    }

    public void removeFoodItem(int id) {
        FoodItem item = menu.stream().filter(foodItem -> foodItem.getId() == id).findFirst().orElse(null);
        menu.remove(item);
    }

    public void showMenu() {
        for (FoodItem foodItem : menu){
            System.out.println(foodItem);
        }
    }
}
