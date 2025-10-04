public class BankAccount{

	// Attributes
	private String accountNo;
	private double balance;
	private String clientName;

	// Constructor
	public BankAccount(){
		this("ABC123");
	}

	public BankAccount(String accountNo){
		this(accountNo, "No Name");
	}

	public BankAccount(String accountNo, String clientName){
		this(accountNo, clientName, 0.0);
	}

	public BankAccount(String accountNo, String clientName, double balance){
		this.accountNo = accountNo;
		this.clientName = clientName;
		this.balance = balance;

		System.out.printf("Hey %s! Welcome to HBL Bank.\n\nAccount No: %s\nAccount Holder: %s\nBalance: %,.2f\n", clientName, accountNo, clientName, balance);
	}

	// Getters
	public String getAccountNo(){
		return accountNo;
	}

	public String getClientName(){
		return clientName;
	}

	public double getBalance(){
		return balance;
	}

	// Setters
	public void setAccountNo(String accountNo){
		this.accountNo = accountNo;
	}

	public void setClientName(String clientName){
		this.clientName = clientName;
	}

	public void setBalance(double balance){
		this.balance = balance;
	}

	// Methods
	public void withdraw(double withdrawAmount){
		if(withdrawAmount <= balance){
			balance-=withdrawAmount;
			String msg = String.format("\nYou have successfully withdraw %,.2fPKR.\nYour Balance: %,.2fPKR", withdrawAmount, balance);
			System.out.println(msg);
		}else
			System.out.println("\nWithdraw amount should be less than or equal balance.");
	}

	public void depositAmount(double depositAmount){
		if(depositAmount > 0){
			balance+=depositAmount;
			String msg = String.format("\nYou have successfully deposit %,.2fPKR.\nYour Balance: %,.2fPKR", depositAmount, balance);
			System.out.println(msg);
		}else
			System.out.println("\nDeposit amount should be greater than zero.");
	}

	@Override
	public String toString(){
		String str = String.format("\nBalance: %,.2fPKR", balance);
		return str;
	}
}