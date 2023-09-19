import org.junit.jupiter.api.*;

import java.security.Provider.Service;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {

    RestaurantService service;
    Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        service = new RestaurantService();
        // Create a restaurant and add it to the service before each test
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup", 119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    @AfterEach
    public void tearDown() throws restaurantNotFoundException{
        // Remove the restaurant from the service after each test
        if(service.getRestaurants().size() > 0){
            service.removeRestaurant("Amelie's cafe");
        }
    }

    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() throws restaurantNotFoundException {
        Restaurant foundRestaurant = service.findRestaurantByName("Amelie's cafe");
        assertNotNull(foundRestaurant);
    }

    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() {
        assertThrows(restaurantNotFoundException.class, () -> service.findRestaurantByName("Pantry d'or"));
    }

    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() throws restaurantNotFoundException {
        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants - 1, service.getRestaurants().size());
    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception() {
        assertThrows(restaurantNotFoundException.class, () -> service.removeRestaurant("Pantry d'or"));
    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1() {
        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.addRestaurant("Pumpkin Tales", "Chennai", LocalTime.parse("12:00:00"), LocalTime.parse("23:00:00"));
        assertEquals(initialNumberOfRestaurants + 1, service.getRestaurants().size());
    }
}
