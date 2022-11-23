package Praktika.Praktika4.Einkaufswagen;

public class EinkaufswagenTest {
    public static void main(String[] args) {
        Einkaufswagen cart = new Einkaufswagen();
        cart.addToCart("Birne");
        cart.addToCart("Salat");
        cart.addToCart("Paprika");
        cart.showContent();
        cart.removeFromCart("Salat");
        cart.showContent();
        cart.size();

    }
}
