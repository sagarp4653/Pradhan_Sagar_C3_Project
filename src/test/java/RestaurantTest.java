import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantTest {
    @Mock
    Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        
        // Create a restaurant with a menu before each test
        LocalTime openingTime = LocalTime.parse("10:30:00");
        LocalTime closingTime = LocalTime.parse("22:00:00");
        restaurant = new Restaurant("Amelie's cafe", "Chennai", openingTime, closingTime);
        restaurant.addToMenu("Sweet corn soup", 119);
        restaurant.addToMenu("Vegetable lasagne", 269);
    }

    // OPEN/CLOSED TEST CASES
    @Test // part2
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time() {
        LocalTime currentTime = LocalTime.parse("12:00:00");
        assertTrue(restaurant.isRestaurantOpen(currentTime));
    }

    @Test // part2
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time() {
        LocalTime currentTime = LocalTime.parse("23:30:00");
        assertFalse(restaurant.isRestaurantOpen(currentTime));
    }
}
