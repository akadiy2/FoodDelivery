import java.util.HashMap;
import java.util.Map;

public class RestaurantDatabase {
    public static RestaurantDatabase instance;

    public static RestaurantDatabase getInstance() {
        if (instance == null) {
            instance = new RestaurantDatabase();

        }

        return  instance;
    }

    private Map<String, Restaurant> restaurantMap;

    private RestaurantDatabase() {
        restaurantMap = new HashMap<>();
    }

    public Restaurant getRestaurant(String foodInput) {
        Restaurant restaurant;
        if (restaurantMap.containsKey(foodInput)) {
            restaurant = restaurantMap.get(foodInput);
        } else {
            restaurant = RestaurantUtility.getRestaurantFromFood(foodInput);
            restaurantMap.put(foodInput, restaurant);
        }

        return restaurant;
    }
}
