import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Client {
    String name;
    double balance;
    LinkedListTransaction transactions = new LinkedListTransaction();
    Stack<Transaction> stackTransactions = new Stack<>();
    Queue<Request> requests = new LinkedList<>();
    public Client(String name) {
        this.name = name;
        this.balance = 0;
    }
    public void deposit(double amount){
        balance += amount;
        Transaction transaction = new Transaction("Deposit",amount,this.name);
        transactions.insert(transaction);
        stackTransactions.push(transaction);
    }
    public void withdraw(double amount){
        if(balance>=amount){
            balance -=amount;
            Transaction transaction = new Transaction("Withdraw",amount,this.name);
            transactions.insert(transaction);
            stackTransactions.push(transaction);
        }else {
            System.out.println("You dont have enough money in your account");
        }
    }
    public void transferCredit(Client toClient,double amount){
        if(amount<=balance){
            this.balance -= amount;
            toClient.balance += amount;
            Transaction transaction = new Transaction("Transfer",amount,this.name,toClient.name);
            transactions.insert(transaction);
            stackTransactions.push(transaction);
        }
        else {
            System.out.println("You dont have enough money");
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
