/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

import java.util.Scanner;

/**
 *
 * @author braun1792
 */
public class JavaBank {
    
   Scanner input;
//    private ArrayManager accounts;
//    private ArrayManager customers;
    private BankAccount[] accounts;
    private Customer[] customers;
    private ArrayManager accountHolders;
    private ArrayManager accountsArray;
    private ArrayManager customersArray;
    
    
    public void initData(){
    
    //establish customer array
    customers = new Customer[3];
    customers[0] = new Customer("Bob", "Smith", 'J', 123);
    customers[1] = new Customer("Sue", "Shard", 'S', 234);
    customers[2] = new Customer("Pat", "Jones", 'R', 345);
    
    //create ArrayManager for customer array
    customersArray = new ArrayManager(customers);
     
    //establish Bank Accounts Array
    accounts = new BankAccount[4];
    accounts[0] = new SavingsAccount(111,345.45f,100f,0);
    accounts[1] = new SavingsAccount(222,325.55f,10f,0);
    accounts[2] = new ChequingAccount(333,700.50f,2.25f,250f);
    accounts[3] = new ChequingAccount(444,700.55f,2.25f,100f);
    
    //Associate Bank Accounts with Customers
    
    //Account 0 - savings
    Customer[] temp = new Customer[] {customers[0], customers[2]};
    accountHolders = new ArrayManager(temp);
    accounts[0].setCustomers(accountHolders);
    //Account 1
    temp = new Customer[] {customers[1]};
    accountHolders = new ArrayManager(temp);
    accounts[1].setCustomers(accountHolders);
    // Account 2
    temp = new Customer[] {customers[0], customers[2]};
    accountHolders = new ArrayManager(temp);
    accounts[2].setCustomers(accountHolders);
    //Account 3
    temp = new Customer[] {customers[1]};
    accountHolders = new ArrayManager(temp);
    accounts[3].setCustomers(accountHolders);
    
    // create ArrayManager for accounts array
    accountsArray = new ArrayManager(accounts);
    

    
//    customers = new ArrayManager(3);
//    customers.add(new Customer("Bob", "Smith", 'J', 123));
//    customers.add(new Customer("Sue", "Shard", 'S', 234));
//    customers.add(new Customer("Pat", "Jones", 'R', 345));
//    
//    accounts = new ArrayManager(4);
//    
//    accounts = new ArrayManager(4);
//    accounts.add(new SavingsAccount(111,345.45f,100f,0));
//    
//    Object[] accountHolders = {customers.getElementAt(0), customers.getElementAt(2)};
//    //accounts[0].setCustomers(accountHolders);
//    
//    accounts.add(new SavingsAccount(222,325.55f,10f,0));
//    accountHolders = new Customer[1];
//    accountHolders[0] = customers[1];
//    accounts[1].setCustomers(accountHolders);
//    
//    accounts[2] = new ChequingAccount(333,700.50f,2.25f,250f);
//    accountHolders = new Customer[2];
//    accountHolders[0] = customers[0];
//    accountHolders[1] = customers[2];
//    accounts[2].setCustomers(accountHolders);
//    
//    accounts[3] = new ChequingAccount(444,700.55f,2.25f,100f);
//    accountHolders = new Customer[1];
//    accountHolders[0] = customers[1];
//    accounts[3].setCustomers(accountHolders);
//    
    }
    
    public int showActionMenu(){
       
        int option = 0;
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Transfer");
        System.out.println("4. Add Customer");
        System.out.println("5. Add Customer to Account");
        System.out.println("Selection: ");
        option = input.nextInt();
        return option;
    }
    
    public BankAccount getBankAccountByAccountNumber(int accountNo){
        BankAccount ba = null;
        try{
            for (int i =0; i < accountsArray.size(); i++){
               BankAccount temp = (BankAccount)accountsArray.getElementAt(i);
               if(temp.getAccountNo() == accountNo){
                   ba = temp;
               }
        }
        }catch(OutOfBoundsException oobe){
            System.out.println(oobe.getMessage());
        }
        
        return ba;
    }
    
    public Customer getCustomerByCustomerNumber(int id){
        Customer cust= null;
        try{
            for(int i = 0; i < customersArray.size(); i++){
                Customer c = (Customer)customersArray.getElementAt(i);
                
                if (c.getCustomerID() == id ){
                    
                    cust = c;
                }
            }
            
        }catch(OutOfBoundsException oobe){
            oobe.getMessage();
        }
         
            return cust;
        }
        
    
    
    public void displayAccountsByCustomerID(int customerID){
        
        try{ 
        for (int i=0; i < accountsArray.size(); i++) {
            
            BankAccount temp = (BankAccount)accountsArray.getElementAt(i);
            ArrayManager c = temp.getCustomers();
            
            for (int j=0; j < c.size(); j++) {
                
                Customer cust = (Customer)c.getElementAt(j);
                
                if (cust.getCustomerID() == customerID) {
                    
                    System.out.println(temp.getAccountNo());
                }
            }
        }
        }catch(OutOfBoundsException oobe){
            System.out.println(oobe.getMessage());
        }
    }
    
    public void addCustomer(String first, String last, char mid, int id){
        Customer c = new Customer(first,last,mid,id);
        customersArray.add(c);
    }
    
    public void addCustomerToAccount(int custID, int accountID){
       
       BankAccount ba = getBankAccountByAccountNumber(accountID);
       Customer c = getCustomerByCustomerNumber(custID);
       
       if(ba != null || c != null){
           
       ba.getCustomers().add(c);
       
       }else{
           
           System.out.println("Incorrect customer or account ID.");
       }
       
    }
    public void executeAction( int action, BankAccount ba){
        
        switch (action) {
            case 1:
                {   
                    System.out.println("Starting balance: " + String.format("$%.2f", ba.getBalance()));
                    System.out.println("Deposit amount: ");
                    float amount = input.nextFloat();
                    ba.deposit(amount);
                    System.out.println("Ending balance: " + String.format("$%.2f", ba.getBalance()));
                    break;
                }
            case 2:
                {   
                    System.out.println("Starting balance: " + String.format("$%.2f", ba.getBalance()));
                    System.out.println("Withdraw amount: ");
                    float amount = input.nextFloat();
                    try{
                        ba.withdraw(amount);
                    }catch(Exception e){
                        System.out.println("Error: Insufficient funds");
                    }  
                    System.out.println("Ending balance: " + String.format("$%.2f", ba.getBalance()));
                    break;
                }
            case 3:
                {   
                    System.out.println("Starting balance: " + String.format("$%.2f", ba.getBalance()));
                    System.out.println("Transfer amount: ");
                    float amount = input.nextFloat();
                    System.out.println("Account Number: ");
                    int account = input.nextInt();
                    try{
                    ba.transfer(getBankAccountByAccountNumber(account), amount);
                    }catch(Exception e){
                        System.out.println("Error: Insufficient funds");
                    }
                    System.out.println("Ending balance: " + String.format("$%.2f", ba.getBalance()));
                    break;
                }
            case 4:
                {
                    System.out.println("Enter first name:");
                    String first = input.next();
                    System.out.println("Enter last name:");
                    String last = input.next();
                    System.out.println("Enter middle initial:");
                    char mid = input.next().charAt(0);
                    System.out.println("Enter customer ID:");
                    int id = input.nextInt();
                    addCustomer(first,last,mid,id);
                    break;
                }
            case 5:
                {
                    System.out.println("Enter customer ID:");
                    int custID = input.nextInt();
                    System.out.println("Enter account ID:");
                    int accountID = input.nextInt();
                    addCustomerToAccount(custID, accountID);
                    break;
                }
            default:
                {
                    System.out.println("Error: Incorrect option");
                    break;
                }
        }
        
    }
    
    public void run(){
        
        System.out.println("Enter Customer ID: ");
        int custID = input.nextInt();
        displayAccountsByCustomerID(custID);
        System.out.print("Select Account: ");
        int acctID = input.nextInt();
        BankAccount ba = getBankAccountByAccountNumber(acctID);
        int option = showActionMenu();
        executeAction(option, ba);
    }
    
    public JavaBank(){
        input = new Scanner(System.in);
       
    }
}
