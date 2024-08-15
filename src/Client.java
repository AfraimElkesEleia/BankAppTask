public class Client {
    String name;
    double balance;
    LinkedListTransaction transactions = new LinkedListTransaction();

    public Client(String name) {
        this.name = name;
        this.balance = 0;
    }
    public void deposit(double amount){
        balance += amount;
        Transaction transaction = new Transaction("Deposit",amount,this.name);
        transactions.insert(transaction);
    }
    public void withdraw(double amount){
        if(balance>=amount){
            balance -=amount;
            Transaction transaction = new Transaction("Withdraw",amount,this.name);
            transactions.insert(transaction);
        }else {
            System.out.println("You dont have enough money in your account");
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
