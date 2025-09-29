# Function to deposit money
def deposit(balance):
    amount = float(input("Enter amount to deposit: "))
    if amount > 0:
        balance += amount
        print(f"Deposit successful. New balance: {balance:.2f}")
    else:
        print("Invalid amount. Deposit failed.")
    return balance

# Function to withdraw money
def withdraw(balance):
    amount = float(input("Enter amount to withdraw: "))
    if amount <= 0:
        print("Invalid amount. Withdrawal failed.")
    elif amount > balance:
        print("Insufficient Amount!")
    else:
        balance -= amount
        print(f"Withdrawal successful. New balance: {balance:.2f}")
    return balance

# Function to check the balance
def check_balance(balance):
    print(f"Your current balance is: {balance:.2f}")

# Main banking function
def banking_system():
    print("Welcome to the Simple Banking System")
    name = input("Enter your name: ")
    balance_input = input("Enter initial balance: ")
    balance = float(balance_input)

    while True:
        print("\nMenu:")
        print("1. Deposit")
        print("2. Withdraw")
        print("3. Check Balance")
        print("4. Exit")

        choice = input("Enter your choice (1-4): ")

        if choice == '1':
            balance = deposit(balance)
        elif choice == '2':
            balance = withdraw(balance)
        elif choice == '3':
            check_balance(balance)
        elif choice == '4':
            print(f"Thank you for using the banking system!")
            break
        else:
            print("Invalid choice. Please enter a number between 1 and 4.")

# Run the program
banking_system()
