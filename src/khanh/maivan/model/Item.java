package khanh.maivan.model;

public class Item{
    private int id;
    private String name;
    private int amount;
    private int price;
    public Item(int id, String name, int amount, int price) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }
    public void setId(int id) { this.id = id; }
    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(int amount) {
        this.amount = amount ;
    }
    public void setPrice(int price) { this.price = price ; }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAmount(){
        return amount;
    }
    public int getPrice() { return price; }

    public String toString() {
        return "Item " +
                "id=" + id +
                " name=" + name +
                " price=" + price +
                " amount=" + amount ;
    }

}

