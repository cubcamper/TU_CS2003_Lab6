/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/



// line 11 "something.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String name;
  private String primaryAddress;
  private int phoneNumber;
  private int creditCardNumber;

  //Customer Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aName, String aPrimaryAddress, int aPhoneNumber, int aCreditCardNumber, Account aAccount)
  {
    name = aName;
    primaryAddress = aPrimaryAddress;
    phoneNumber = aPhoneNumber;
    creditCardNumber = aCreditCardNumber;
    if (aAccount == null || aAccount.getCustomer() != null)
    {
      throw new RuntimeException("Unable to create Customer due to aAccount");
    }
    account = aAccount;
  }

  public Customer(String aName, String aPrimaryAddress, int aPhoneNumber, int aCreditCardNumber, Customer aHolderForAccount, Order aOrderForAccount, float aBalanceForAccount, acctNumber aIntForAccount)
  {
    name = aName;
    primaryAddress = aPrimaryAddress;
    phoneNumber = aPhoneNumber;
    creditCardNumber = aCreditCardNumber;
    account = new Account(aHolderForAccount, aOrderForAccount, aBalanceForAccount, aIntForAccount, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrimaryAddress(String aPrimaryAddress)
  {
    boolean wasSet = false;
    primaryAddress = aPrimaryAddress;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNumber(int aPhoneNumber)
  {
    boolean wasSet = false;
    phoneNumber = aPhoneNumber;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreditCardNumber(int aCreditCardNumber)
  {
    boolean wasSet = false;
    creditCardNumber = aCreditCardNumber;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getPrimaryAddress()
  {
    return primaryAddress;
  }

  public int getPhoneNumber()
  {
    return phoneNumber;
  }

  public int getCreditCardNumber()
  {
    return creditCardNumber;
  }

  public Account getAccount()
  {
    return account;
  }

  public void delete()
  {
    Account existingAccount = account;
    account = null;
    if (existingAccount != null)
    {
      existingAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "primaryAddress" + ":" + getPrimaryAddress()+ "," +
            "phoneNumber" + ":" + getPhoneNumber()+ "," +
            "creditCardNumber" + ":" + getCreditCardNumber()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}