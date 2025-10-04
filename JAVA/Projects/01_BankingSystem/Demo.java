public class Demo{

	public static void main(String[] args){
		BankAccount client1 = new BankAccount();
		client1.depositAmount(50000); 
		client1.withdraw(20000); 
		client1.withdraw(35000);
		System.out.println(client1);
		System.out.println("-----------------------------------------\n");

		BankAccount client2 = new BankAccount("CUL002345", "Arham", 90000);
		client2.depositAmount(180000); 
		client2.withdraw(11000);
		System.out.println(client2);
		System.out.println("-----------------------------------------\n");

		System.out.printf("Client1: %s %s %,.2f\n", client1.getAccountNo(), client1.getClientName(), client1.getBalance());
		System.out.printf("Client2: %s %s %,.2f\n", client2.getAccountNo(), client2.getClientName(), client2.getBalance());

		client1.setClientName("Abdullah");
		System.out.println("-----------------------------------------\n");
		System.out.println(client1);
		System.out.println(client2);

	}
}