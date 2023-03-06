package it.epicode.esercizi.settimana2;

public class Product {
    private long id;
    private String name;
    private double price;
    private String category;

    public Product(long id, String name, double price, String category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
    
    @Override
    public String toString() {
    	return "product n: " + id + " titolo: " + name;
    }

	
}