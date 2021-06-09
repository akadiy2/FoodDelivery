import java.util.List;

public abstract class Restaurant {
    protected int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        int stock = getStock();
        return this.getClass().getName() + " with stock: " + stock;
    }


    public void cook(Food food) {
        food.cook();
        System.out.println(food + " cooked.");
    }

    public void displayStock() {
        System.out.println("Remaining stock in: " + this.getClass().getName() + " : " + this.stock);
    }

    public static Restaurant getRestaurantFromFood(Food food) {
        if (food instanceof Pizza) {
            return new PizzaHut();
        } else if (food instanceof Burger) {
            return new McDonalds();
        } else {
            throw new Error("An error occurred, unable to find restaurant for the given food: " + food.getClass().getName());
        }
    }
}
