package lab6;

/**
 * 
 * @author george-patterson
 *
 */

public class Account {

	Customer holder;
	Order order;
	float balance;
	int acctNumber;
	
	public int getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(int acctNumber) {
		this.acctNumber = acctNumber;
	}

	public Customer getHolder() {
		return holder;
	}

	public void setHolder(Customer holder) {
		this.holder = holder;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public void bill(Customer c) {
		balance-=this.getOrder().getPrice();
		System.out.println(c.getName() + ", we charged your card: " + c.getCreditCardNumber() + this.getOrder().getPrice());
	}
	


}
