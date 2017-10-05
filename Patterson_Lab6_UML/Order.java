/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 19 "something.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private float weight;
  private String item;
  private String origin;
  private float price;

  //Order Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(float aWeight, String aItem, String aOrigin, float aPrice, Account aAccount)
  {
    weight = aWeight;
    item = aItem;
    origin = aOrigin;
    price = aPrice;
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create order due to account");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWeight(float aWeight)
  {
    boolean wasSet = false;
    weight = aWeight;
    wasSet = true;
    return wasSet;
  }

  public boolean setItem(String aItem)
  {
    boolean wasSet = false;
    item = aItem;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrigin(String aOrigin)
  {
    boolean wasSet = false;
    origin = aOrigin;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(float aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public float getWeight()
  {
    return weight;
  }

  public String getItem()
  {
    return item;
  }

  public String getOrigin()
  {
    return origin;
  }

  public float getPrice()
  {
    return price;
  }

  public Account getAccount()
  {
    return account;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    if (aAccount == null)
    {
      return wasSet;
    }

    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    account.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Account placeholderAccount = account;
    this.account = null;
    placeholderAccount.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "weight" + ":" + getWeight()+ "," +
            "item" + ":" + getItem()+ "," +
            "origin" + ":" + getOrigin()+ "," +
            "price" + ":" + getPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}