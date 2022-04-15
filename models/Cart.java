package models;

import java.util.ArrayList;

public class Cart{
    ArrayList<Item> items;

    public Cart(){
        items = new ArrayList<Item>();
    }

    public Item getItem(int index){
        return new Item(items.get(index));
    }

    public void setItem(int index, Item item){
        items.set(index, new Item(item));
    }

    public boolean add(Item item){
        if(items.contains(item)){
            return false;
        }
        items.add(new Item(item));
        return true;
    }

    

    public void remove(String name){
        if(items.size() < 1){
            throw new IllegalStateException("Items array is empty, you cannot remove anything ");
        }
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(name)){
                items.remove(i);
            }
        }
    }

    public String checkout(){
        if(items.size() < 1){
            throw new IllegalStateException("Items array is empty, you cannot remove anything ");
        }
        double subtotal = 0;
        for (int i = 0; i < items.size(); i++) {
            subtotal += items.get(i).getPrice();
        }
        double tax = subtotal * .13;
        double total = tax + subtotal;

        return "\tRECEIPT\n\n" +
        "\tSubtotal: $" + subtotal + "\n" +
        "\tTax: $" + tax + "\n" +
        "\tTotal: $" + total + "\n";
    }

    public String toString(){
        String temp = "";
        for (int i = 0; i < items.size(); i++) {
            temp += items.get(i).toString();
            temp += "\n";
        }
        return temp;
    }


}