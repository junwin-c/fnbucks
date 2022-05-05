import java.util.ArrayList;

public class Cake extends Menu {
    private ArrayList<ArrayList<String>> cakeOrder = new ArrayList<ArrayList<String>>();

    public void addCake(String name, int rating, int quantity) {
        ArrayList<String> cake = new ArrayList<String>();

        this.name = name;
        this.rating = rating;
        this.quantity = quantity;
        this.price = totalPrice();

        cake.add(name);
        cake.add(Integer.toString(quantity));
        cake.add(Integer.toString(rating));
        cake.add(Integer.toString(price));
        cakeOrder.add(cake);
    }

    public void cakeOrder() {
        final String barrier = "========================================================";
        System.out.println("Cheese Cake Order");
        System.out.println(barrier);
        System.out.println("| Name               | Quantity | Rating | Total Price |");
        System.out.println(barrier);

        if(cakeOrder.size() == 0) {
            System.out.printf("| %33s%-20s|\n", "No Cheese Cake Order", " ");
        }

        for (int i = 0; i < cakeOrder.size(); i++) {
            System.out.printf("| %-18s ", cakeOrder.get(i).get(0));
            System.out.printf("| %-8s ", cakeOrder.get(i).get(1));
            System.out.printf("| %-6s ", cakeOrder.get(i).get(2));
            System.out.printf("| %-11s |\n", cakeOrder.get(i).get(3));
        }
        System.out.println(barrier);
    }
}
