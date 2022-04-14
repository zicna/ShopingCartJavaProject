import models.Item;
import models.Cart;
import models.Store;

public class Main{
    public static void main(String[] args) {
        Item itemOne = new Item("Celery", 1);
        Item itemTwo = new Item(itemOne);
        itemTwo.setName("Spinach");
        System.out.println(itemOne + "\n" + itemTwo);

        Cart cart = new Cart();
        cart.add(new Item("Celery", 0.99));
        cart.add(new Item("Celery", 0.99));
        cart.add(new Item("Spinach", 0.99));
        cart.add(new Item("Coriander", 1.29));

        System.out.println(cart);

    }
}