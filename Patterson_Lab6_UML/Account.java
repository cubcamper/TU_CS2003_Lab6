/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/


import java.util.*;

// line 1 "something.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private Customer holder;
  private Order order;
  private float balance;
  private acctNumber int;

  //Account Associations
  private Customer customer;
  private List<Order> orders;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(Customer aHolder, Order aOrder, float aBalance, acctNumber aInt, Customer aCustomer)
  {
    holder = aHolder;
    order = aOrder;
    balance = aBalance;
    int = aInt;
    if (aCustomer == null || aCustomer.getAccount() != null)
    {
      throw new RuntimeException("Unable to create Account due to aCustomer");
    }
    customer = aCustomer;
    orders = new ArrayList<Order>();
  }

  public Account(Customer aHolder, Order aOrder, float aBalance, acctNumber aInt, String aNameForCustomer, String aPrimaryAddressForCustomer, int aPhoneNumberForCustomer, int aCreditCardNumberForCustomer)
  {
    holder = aHolder;
    order = aOrder;
    balance = aBalance;
    int = aInt;
    customer = new Customer(aNameForCustomer, aPrimaryAddressForCustomer, aPhoneNumberForCustomer, aCreditCardNumberForCustomer, this);
    orders = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setHolder(Customer aHolder)
  {
    boolean wasSet = false;
    holder = aHolder;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrder(Order aOrder)
  {
    boolean wasSet = false;
    order = aOrder;
    wasSet = true;
    return wasSet;
  }

  public boolean setBalance(float aBalance)
  {
    boolean wasSet = false;
    balance = aBalance;
    wasSet = true;
    return wasSet;
  }

  public boolean setInt(acctNumber aInt)
  {
    boolean wasSet = false;
    int = aInt;
    wasSet = true;
    return wasSet;
  }

  public Customer getHolder()
  {
    return holder;
  }

  public Order getOrder()
  {
    return order;
  }

  public float getBalance()
  {
    return balance;
  }

  public acctNumber getInt()
  {
    return int;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(float aWeight, String aItem, String aOrigin, float aPrice)
  {
    return new Order(aWeight, aItem, aOrigin, aPrice, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Account existingAccount = aOrder.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aOrder.setAccount(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a account
    if (!this.equals(aOrder.getAccount()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Customer existingCustomer = customer;
    customer = null;
    if (existingCustomer != null)
    {
      existingCustomer.delete();
    }
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "balance" + ":" + getBalance()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "holder" + "=" + (getHolder() != null ? !getHolder().equals(this)  ? getHolder().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "order" + "=" + (getOrder() != null ? !getOrder().equals(this)  ? getOrder().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "int" + "=" + (getInt() != null ? !getInt().equals(this)  ? getInt().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}