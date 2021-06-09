import java.util.*;
import java.util.stream.Collectors;

public class FoodDeliveryService {
    private Map<String, Restaurant> restaurantMap;
    private RestaurantDatabase database = RestaurantDatabase.getInstance();

    public FoodDeliveryService() {
        this.restaurantMap = new HashMap<>();
    }

    public void deliver(String foodInput) {
        Food food = RestaurantUtility.getFood(foodInput);
        Restaurant restaurant = database.getRestaurant(foodInput);

        restaurant.cook(food);

        int stock = restaurant.getStock();
        restaurant.setStock(--stock);
        displayStock();
    }


    public void displayStock() {
        this.restaurantMap.values().forEach(Restaurant::displayStock);
    }





}
