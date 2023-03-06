package it.epicode.esercizi.settimana2;

import java.time.LocalDate;
import java.util.List;

public class Order {

	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	public List<Product> product;
	private Customer customer;
	
	public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> product, Customer customer) {
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate= deliveryDate;
		this.product = product;
		this.customer = customer;
	}
	
	public long getId() {
		return id;
	}
	
	public String getStatus() {
		return status;
	}
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	
	public List<Product> getProduct() {
		return product;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	 @Override
	    public String toString() {
	    	return "order n: " + id + " con customer di livello 2";
	    }

}
