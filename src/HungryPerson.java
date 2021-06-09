import java.util.Scanner;

public class HungryPerson {
    public static void main (String [] args) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        FoodDeliveryService foodDeliveryService = new FoodDeliveryService();
        do {
            System.out.print("What food would you like to eat today?: ");
            input = sc.nextLine();
            foodDeliveryService.deliver(input);
        } while (!input.contains("full"));
    }
}
