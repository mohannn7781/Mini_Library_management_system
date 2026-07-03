import java.util.ArrayList;

abstract class Account{
    private final String AccNO;
    protected double balance;
    public Account(String AccNO,double balance){
        this.AccNO=AccNO;
        this.balance=balance;
    }
    public String getaccountNumber(){
        return this.AccNO;
    }
    public void deposit(double amnt){
        balance=amnt+balance;
    }
    public double getbalance(){
        return this.balance;
    }
    abstract void withdraw(double amnt);


    
}
class SavingsAccount extends Account{
    public SavingsAccount(String AccNO,double balance){
        super(AccNO,balance);
    }
    private int minbalnce=350;
    private int withdrawLimit=50000;
    @Override
    public void withdraw(double amnt){
        if(amnt<=0){
            System.out.println("invalid amount");
            return;
        }
        else if(balance-amnt<minbalnce){
            System.out.println("Min Balance required");
        }
        else if(amnt>balance){
            System.out.println("insufficiant funds");
        }
        else if(amnt> withdrawLimit){
            System.out.println("limit exceed");
        }
        else 
        {
            balance -=amnt;
            System.out.println("withdrawl sucsessfully");
        }

    }
}

class CurrentAccount extends Account{
    CurrentAccount(String AccNO,double balance){
        super(AccNO, balance);
    }
    
    @Override
    public void withdraw(double amnt){
        if(amnt<=0){
            System.out.println("invalid amount");
        }
        else if(amnt>balance){
            System.out.println("insufficiant funds");
        }
        else{
            balance -=amnt;
            System.out.println("withdrawl sucsessfull");
        }
    }
}
class Customer{
    private ArrayList <Account> accounts;
    private String customerID;
    private String name;
    public Customer(String name, String customerID){
        this.name=name;
        this.customerID=customerID;
        accounts=new ArrayList<>();
    }
    public String getCustomerId(){
        return customerID;
    }
    public void addaccount(Account acc){
        accounts.add(acc);
    }
    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public Account findaccount(String acc){
        for(Account account:accounts){
            if(account.getaccountNumber().equals(acc)){
                return account;
            }
            
          }
          return null;

    } 
    public String getName(){
        return name;
    }
}

class Bank{
    ArrayList<Customer> customers;
    Bank(){
        customers=new ArrayList();    
    }

    public void addCustomer(Customer cus){
        customers.add(cus);
    }
    public void createAccount(
        String customerID,
        String accountType,
        String accountNumber,
        int inittialBalance){
         Account acc;
            Customer customer=findCustomer(customerID);
            if(customer==null){
                System.out.println("not a valid customer" );
                return;
            }
              if(accountType.equals("savings")){
                acc=new SavingsAccount(accountNumber,inittialBalance);
              }
              else if(accountType.equals("current")){
                acc=new CurrentAccount(accountNumber,inittialBalance);
              }
              else{
                System.out.println("invalid account type");
                return;
              }
             
            
            customer.addaccount(acc);
            System.out.println("Account Created succesfully");
            }

    

    public Customer findCustomer(String customerID){
        for ( Customer customer : customers) {
            if(customer.getCustomerId().equals(customerID)){
                return customer;
            }
            
        }
        return null;
    
}

}



public class Main {
    public static void main(String[] args) {
        // creating bank
        Bank bank=new Bank();

        // creating customers
        Customer c1=new Customer("mahi","c101");
        Customer c2= new Customer("mohan","c102");

        //adding customers in bank
        bank.addCustomer(c1);
        bank.addCustomer(c2);

        // creating account for customer c1
        bank.createAccount("c101", "current","0007", 18000);
        // creating account for customer c2
        bank.createAccount("c102", "savings", "540",6214);
        //finding customer
        Customer findCustomer1=bank.findCustomer("c101");
        if(findCustomer1!=null){
            System.out.println(findCustomer1.getName());
        }

        //another of finding customer
        Customer findCustomer2=bank.findCustomer("c107");
        if(findCustomer2!=null){
            System.out.println("exists");
        }
        else{
            System.out.println("not exists");
        }



        Customer customer= bank.findCustomer("c102");
        if(customer!=null){
            Account account=customer.findaccount("540");
            if(account!=null){
                account.deposit(500);
                account.withdraw(700);
                System.out.println("Balance"+account.getbalance());
            }
        }
    }
}
    
