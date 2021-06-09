import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtility {
    public static Restaurant getRestaurantFromFood(Food food) {

        if (food instanceof Pizza) {
            return new PizzaHut();
        } else if (food instanceof Burger) {
            return new McDonalds();
        } else {
            throw new Error("An error occurred, unable to find restaurant for the given food: " + food.getClass().getName());
        }
    }


    public static Restaurant getRestaurantFromFood(String foodInput) {
        Food food = getFood(foodInput);
        return getRestaurantFromFood(food);
    }

    public static Food getFood(String food) {
        String foodName = food.split(":")[0].toLowerCase();
        String toppingString = food.split(":")[1].toLowerCase();
        List<String> toppings = Arrays.stream(toppingString.split(",")).collect(Collectors.toList());
        if (foodName.contains("pizza")) {
            Pizza p = new Pizza(toppings);
            return p;
        } else if (foodName.contains("burger")) {
            return new Burger(toppings);
        } else {
            throw new Error("An error occurred, unable to find restaurant for the given food: " + food.getClass().getName());
        }
    }
}
