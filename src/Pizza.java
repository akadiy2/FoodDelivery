import java.util.ArrayList;
import java.util.List;

public class Pizza implements Food {

    private List<String> toppings;

    public Pizza() {
        toppings = new ArrayList<>();
    }

    public Pizza (List<String> toppings) {
        this.toppings = toppings;
    }

    public static class Builder {
        private List<String> toppings;

        public Builder() {
            toppings = new ArrayList<>();
        }

        public Builder(List<String> toppings) {
            this.toppings = toppings;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            return new Pizza(this.toppings);
        }
    }

    @Override
    public Food cook() {
        if (this.toppings.isEmpty()) {
            throw new Error("Unable to cook " + this.getClass().getName() + " due to the given requirements");
        } else {
            return new Builder(this.toppings).build();
        }
    }

    public String toString() {
        return this.getClass().getName() + " cooked with: " + this.toppings;
    }

}
