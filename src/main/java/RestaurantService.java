import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equals(restaurantName)) {
                return restaurant;
            }
        }
        throw new restaurantNotFoundException("Restaurant not found: " + restaurantName);
    }

}
