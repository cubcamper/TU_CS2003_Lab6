package lab6;

/**
 * 
 * @author george-patterson
 *
 */


public class Customer {

	private String name;
	private String primaryAddress;
	private int phoneNumber;
	private int creditCardNumber;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

}
