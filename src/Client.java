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
        Transaction transaction = new Transaction("Deposit",amount,this);
        transactions.insert(transaction);
        stackTransactions.push(transaction);
    }
    public void withdraw(double amount){
        if(balance>=amount){
            balance -=amount;
            Transaction transaction = new Transaction("Withdraw",amount,this);
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
            Transaction transaction = new Transaction("Transfer",amount,this,toClient);
            transactions.insert(transaction);
            stackTransactions.push(transaction);
        }
        else {
            System.out.println("You dont have enough money");
        }
    }
    public void undoLastTransaction(){
        Transaction transaction = stackTransactions.pop();
        switch (transaction.type){
            case "Deposit":
                this.balance-= transaction.amount;
                break;
            case "Withdraw":
                this.balance+= transaction.amount;
                break;
            case "Transfer":
                Client recipient = transaction.toClient;
                double amount = transaction.amount;
                this.balance += amount;
                recipient.balance -= amount;
                break;
        }
        transactions.deleteLast();
    }
    public void acceptRequest(Request request){
        if(requests.contains(request)) {
            Client fromClient = request.fromClient ;
            this.transferCredit(fromClient,request.amount);
            requests.remove(request);
        }else {
            System.out.println("Not Found!!!");
        }
    }
    public void makeRequest(Client toClient , double amount){
        Request request = new Request(amount,this,toClient);
        toClient.requests.add(request);
    }
    public void declinRequest(Request request){
        if(requests.contains(request)){
            requests.remove(request);
        }else {
            System.out.println("Not Found!!!");
        }
    }
    public void showAllRequests(){
            System.out.println(requests.iterator());
    }
    @Override
    public String toString() {
        return "Client{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
