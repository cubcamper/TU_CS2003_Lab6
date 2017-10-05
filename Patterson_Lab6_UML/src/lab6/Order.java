package lab6;

/**
 * 
 * @author george-patterson
 *
 */

public class Order {
	
	float weight;
	String item;
	String origin;
	float price;
	
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public void shipMe(Customer r) {
		System.out.println("I'm headed to " + r.getName() + " at " + r.getPrimaryAddress());
	}
	
	public void cancel(Customer r) {
		System.out.println(r.getName() + " doesn't want me anymore!");
	}
	
	
}
