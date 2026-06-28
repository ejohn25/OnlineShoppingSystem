// Elijah Johnson
import java.util.ArrayList;

// Interface
interface Payment {
    void pay(double amount);
}

// Credit Card Payment Class
class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made using Credit Card.");
    }
}

// PayPal Payment Class
class PayPalPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made using PayPal.");
    }
}

// Product Class
class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Shopping Cart Class
class ShoppingCart {

    private ArrayList<Product> cart = new ArrayList<>();

    public void addProduct(Product product) {
        cart.add(product);
    }

    public double calculateTotal() {
        double total = 0;

        for (Product product : cart) {
            total += product.getPrice();
        }

        return total;
    }

    public void displayCart() {
        System.out.println("===== Online Shopping Cart =====");

        for (Product product : cart) {
            System.out.println(product.getName() + " - $" + product.getPrice());
        }

        System.out.println("-------------------------------");
        System.out.println("Total: $" + calculateTotal());
    }
}

// Main Class
public class OnlineShoppingSystem {

    public static void main(String[] args) {

       
        Product laptop = new Product("Laptop", 850.00);
        Product headphones = new Product("Headphones", 120.00);
        Product mouse = new Product("Wireless Mouse", 35.00);

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Add products to cart
        cart.addProduct(laptop);
        cart.addProduct(headphones);
        cart.addProduct(mouse);

        // Display shopping cart
        cart.displayCart();

        System.out.println();

       
        Payment payment;

        payment = new CreditCardPayment();
        payment.pay(cart.calculateTotal());

        payment = new PayPalPayment();
        payment.pay(cart.calculateTotal());
    }
}


