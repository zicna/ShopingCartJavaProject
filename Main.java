import models.Item;
import models.Cart;
import models.Store;

public class Main{
    public static void main(String[] args) {
        Item itemOne = new Item("Celery", -0.99);
        Item itemTwo = new Item(itemOne);
        itemTwo.setName("Spinach");
        System.out.println(itemOne + "\n" + itemTwo);
    }
}