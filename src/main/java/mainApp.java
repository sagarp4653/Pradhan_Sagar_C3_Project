import java.time.LocalTime;

public class mainApp {

  public static void main(String[] args) {
    Restaurant restaurant = new Restaurant("South Indian", "Delhi", LocalTime.of(9, 0), LocalTime.of(22, 0));
    restaurant.addToMenu("Sweet corn soup", 119);
    restaurant.displayDetails();
    
  }
}