import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        char choice;
        int quantity, rating;
        String menu;
        String name, size, type;

        // Create a new instance of the coffee class
        Coffee coffee = new Coffee();
        // Create a new instance of the cake class
        Cake cake = new Cake();

        // Display the menu
        do{
            System.out.println("Fnbucks Coffee Shop");
            System.out.println("===================\n");

            menu = inputValidateMenu();

            switch (menu) {
                case "Coffee":
                    name = inputValidateName();
                    size = inputValidateSize();
                    type = inputValidateType();
                    rating = inputValidateRating();
                    quantity = inputValidateQuantity();
                    coffee.addCoffee(name, size, rating, quantity, type);
    
                    System.out.println("Order Coffee Success!");
                    sc.nextLine();
                    clearTerminal();
    
                    coffee.coffeeOrder();
                    break;
                case "Cheese Cake":
                    name = inputValidateName();
                    rating = inputValidateRating();
                    quantity = inputValidateQuantity();
                    cake.addCake(name, rating, quantity);

                    System.out.println("Order Cake Success!");
                    sc.nextLine();
                    clearTerminal();
    
                    cake.cakeOrder();
                    break;
            }

            System.out.print("Want to order another[Y | N]?: ");
            choice = sc.next().charAt(0);
            clearTerminal();
            sc.nextLine();
        }while(choice == 'Y');
        
        System.out.println("------------------ Total Order ------------------");
        coffee.coffeeOrder();
        System.out.println("");
        cake.cakeOrder();
        System.out.println("\nThank you for your order!");
    }

    // Validate Menu
    public static String inputValidateMenu(){
        String order;
        do{
            System.out.print("Choose menu you want to order [Coffee | Cheese Cake]: ");
            order = sc.nextLine();
        }while(!order.equals("Coffee") && !order.equals("Cheese Cake"));
        return order;
    }

    // Validate Quantity
    public static int inputValidateQuantity() {
        int quantity = 0;
        int flag = 0;
        do{
            try {
                System.out.print("Input order quantity: ");
                quantity = sc.nextInt();
                if(quantity > 0){
                    flag = 1;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Input must be number!\n");
                sc.nextLine();
            }
        }while(flag != 1);
        return quantity;
    }

    // Validate Rating
    public static int inputValidateRating() {
        int rating = 0;
        int flag = 0;
        do{
            try {
                System.out.print("Input order rating [1..5]: ");
                rating = sc.nextInt();
                if(rating >= 1 && rating <= 5){
                    flag = 1;
                }
            } catch (Exception e) {
                sc.nextLine();
                System.out.println("Input must be number between 1 - 5!\n");
                sc.nextLine();
            }
        }while(flag != 1);
        return rating;
    }

    // Validate Type
    public static String inputValidateType() {
        String type;
        
        do{
            System.out.print("Input Order Type [Cold, Hot]: ");
            type = sc.next();
        }while(!type.equals("Hot") && !type.equals("Cold"));

        return type;
    }

    // Validate Order Size
    public static String inputValidateSize(){
        String size = "";
        int flag = 0;
        do{
            System.out.print("Input order size [Small, Medium, Large]: ");
            size = sc.next();
        }while(!size.equals("Small") && !size.equals("Medium") && !size.equals("Large"));
        return size;
    }

    // Validate Menu Name
    public static String inputValidateName(){
        String name = "";
        int flag = 0;

        do{
            System.out.print("Input order name [5..20 Characters]: ");
            name = sc.nextLine();
            if(name.length() >= 5 && name.length() <= 20){
                flag = 1;
            }
        }while(flag != 1);
        return name;
    }

    // Clear Terminal
    public static void clearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
