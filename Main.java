import models.Item;
import models.Cart;
import models.Store;

public class Main{
    public static void main(String[] args) {
        // Item itemOne = new Item("Celery", 1);
        // Item itemTwo = new Item(itemOne);
        // itemTwo.setName("Spinach");
        // System.out.println(itemOne + "\n" + itemTwo);

        // Cart cart = new Cart();
        // cart.add(new Item("Celery", 0.99));
        // cart.add(new Item("Celery", 0.99));
        // cart.add(new Item("Spinach", 0.99));
        // cart.add(new Item("Coriander", 1.29));

        // System.out.println(cart);

        Item[][] inventory = new Item[][] { 
            { new Item("Pepsi", 1.99), new Item("Crush", 1.99), new Item("Cola", 1.99) },
            { new Item("Honey Oats", 3.99), new Item("Fruit Loops", 1.99), new Item("Cheerios", 2.99) },
            { new Item("Milk", 4.99), new Item("Eggs", 0.99), new Item("Cheese", 1.89) },
            { new Item("Pepperoni", 2.99), new Item("Salami", 4.49), new Item("Mortadella", 4.99) },
            { new Item("Celery", 0.99), new Item("Spinach", 0.99), new Item("Coriander", 1.29) },
            { new Item("Shirt", 12.99), new Item("Pants", 24.99), new Item("Sweater", 18.99) }, 
            { new Item("Phone", 549.99), new Item("Printer", 349.99), new Item("Television", 1099) } 
        };

        Store store = new Store();
        for (int i = 0; i < inventory.length; i++) {
            for (int j = 0; j < inventory[i].length; j++) {
                store.setItem(i, j, new Item(inventory[i][j]));
            }
        }

        System.out.println(store);

    }
}