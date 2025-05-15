package order.dto;

public class OrderDTO {
	private int item_id;
	private String name;
	private  int quantity;
	private double price;
	private double total_price;
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setTotal_price(double per_price) {
		this.total_price =  total_price ;
	}
	public double getTotal_price() {
		return total_price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
