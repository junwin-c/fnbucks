public class Menu {
    protected String name;
    protected int rating;
    protected int quantity;
    protected int price;

    protected int basePrice() {
        return this.rating * 10000;
    }

    protected int totalPrice() {
        return basePrice() * this.quantity;
    }
}
