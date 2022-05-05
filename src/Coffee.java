import java.util.ArrayList;

public class Coffee extends Menu {
    private int size;
    private String type;
    
    private ArrayList<ArrayList<String>> coffeeOrder = new ArrayList<ArrayList<String>>();

    // Calculate the SIZE price
    private int sizePrice() {
        return this.size * 5000;
    }
    
    // Calculate the TOTAL price of the coffee
    @Override
    protected int totalPrice() {
        return (this.basePrice() + this.sizePrice()) * quantity;
    }

    // Add the coffee to the order
    public void addCoffee(String name, String size, int rating, int quantity, String type) {
        ArrayList<String> coffee = new ArrayList<String>();

        this.name = name;
        this.size = size == "small" ? 1 : size == "medium" ? 2 : 3;
        this.rating = rating;
        this.quantity = quantity;
        this.type = type;

        this.price = totalPrice();

        coffee.add(name);
        coffee.add(size);
        coffee.add(type);
        coffee.add(Integer.toString(quantity));
        coffee.add(Integer.toString(rating));
        coffee.add(Integer.toString(this.price));
        coffeeOrder.add(coffee);
    }

    // Print the coffee order
    public void coffeeOrder () {
        final String barrier = "========================================================================";
        System.out.println("Coffee Order");
        System.out.println(barrier);
        System.out.println("| Name               | Size   | Type | Quantity | Rating | Total Price |");
        System.out.println(barrier);

        if(coffeeOrder.size() == 0){
            System.out.printf("| %43s%-24s  |\n", "No Coffee Order", "");
        }

        for (int i = 0; i < coffeeOrder.size(); i++) {
            System.out.printf("| %-18s ", coffeeOrder.get(i).get(0));
            System.out.printf("| %-6s ", coffeeOrder.get(i).get(1));
            System.out.printf("| %-4s ", coffeeOrder.get(i).get(2));
            System.out.printf("| %-8s ", coffeeOrder.get(i).get(3));
            System.out.printf("| %-6s ", coffeeOrder.get(i).get(4));
            System.out.printf("| %-11s |\n", coffeeOrder.get(i).get(5));
        }
        System.out.println(barrier);
    }
}
