package models;

public class Item{
    private String name;
    private double price;

    public Item(String name, double price){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        if(price <= 0){
            throw new IllegalArgumentException("Price cannot be less than or zero.");
        }
        this.name = name;
        this.price = price;
    }

    public Item(Item source){
        this.name = source.name;
        this.price = source.price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if(price < 0){
            throw new IllegalArgumentException("Price cannot be less than zero.");
        }
        this.price = price;
    }
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(!(obj instanceof Item)){
            return false;
        }
        Item item = (Item)obj;
        return this.getName().equals(item.getName()) && this.getPrice() == item.getPrice();

    }

    public String toString(){
        return (this.name + ": $" + this.price + " ");
    }

}