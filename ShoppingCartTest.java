import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Product {
    String name;
    double up;
    int gst;
    int qu;
    double totalGST;
    double totalPrice;
    Product(String name, double up, int gst, int qu) {
    this.name = name;
    this.up = up;
    this.gst = gst;
    this.qu = qu;
    this.totalGST = (up * gst / 100.0) * qu;
    this.totalPrice = up * qu;
    if (up >= 500) {
    this.totalPrice *= 0.95;
        }
    } }
public class ShoppingCartTest{
public static void main(String[] args) {
    List<Product> basket = new ArrayList<>();
    basket.add(new Product("Leather wallet", 1100, 18, 1));
    basket.add(new Product("Umbrella", 900, 12, 4));
    basket.add(new Product("Cigarette", 200, 28, 3));
    basket.add(new Product("Honey", 100, 0, 2));
    Product maxGSTProduct = Collections.max(basket, (a, b) -> Double.compare(a.totalGST, b.totalGST));
    double totalAmountToPay = basket.stream()
    .mapToDouble(product -> product.totalPrice + product.totalGST)
    .sum();
    System.out.println("maxGST item= " + maxGSTProduct.name + " gst is " + maxGSTProduct.totalGST);
    System.out.println("Total amt = " + totalAmountToPay);
    }
}