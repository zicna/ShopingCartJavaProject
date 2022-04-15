import models.Item;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import models.Cart;
import models.Store;

public class Main{

    static Cart cart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {
        try {
            loadItems("products.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            manageItems();
        }
    }
    public static void  loadItems(String fileName) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(fileName);
        Scanner scanItems = new Scanner(fis);

            for (int i = 0; i < 7; i++) {
                String line = scanItems.nextLine();
                String[] row = line.split(";");
                for (int ii = 0; ii < row.length; ii++) {
                    String[] column = row[ii].split("=");
                    for (int j = 0; j < column.length; j++) {
                        String itemName = column[0];
                        double itemPrice = Double.parseDouble(column[1]);
    
                        store.setItem(i, ii, new Item(itemName, itemPrice));
                    }
                }
            }
        scanItems.close();
    }

    public static void manageItems(){
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("\n\t******************************JAVA GROCERS******************************\n");
            System.out.println(store);

            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String response = scan.nextLine();

            if(!(response.equals("a") || response.equals("b") || response.equals("c"))){
                System.out.println("Wrong input please choose a, b or c. Thank you!");
                continue;
            }
            switch(response){
                case "a": 
                    System.out.println("\nChoose an row number between: 1 – 7: ");
                    int row = scan.hasNextInt() ? scan.nextInt() -1 : 404;
                    scan.nextLine();

                    System.out.println("Choose an item number between: 1 – 3: ");
                    int column = scan.hasNextInt() ?  scan.nextInt() -1 : 404;
                    scan.nextLine();

                    if(row == 404 || column == 404){
                        continue;
                    }else if(row < 0 || row > 6 || column < 0 || column > 2){
                        continue;
                    }
                    Item item = new Item(store.getItem(row, column));

                    if(cart.add(item)){
                        System.out.println(item.getName() + " was added to your shopping cart.");
                    }else{
                        System.out.println(item.getName() + " is already in your shopping cart.");
                    }

                    break;
                case "b": 
                    if(cart.isEmpty()){
                        continue;
                    }
                    System.out.print("Enter the item you'd like to remove: ");
                    cart.remove(scan.nextLine());
                    break;
                case "c": 
                    if(cart.isEmpty()){
                        continue;
                    }
                    System.out.println(cart.checkout());
                    scan.close();
                    return;
            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.println("Enter anything to continue: ");
            scan.nextLine();
        }
    }
}