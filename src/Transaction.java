public class Transaction {
    String type;
    double amount;
    Client fromClient;
    Client toClient;

    public Transaction(String type, double amount,Client fromClient) { //Constructor for deposit and withdraw operation
        this.type = type;
        this.amount = amount;
        this.fromClient = fromClient;
    }
    public Transaction(String type, double amount, Client formClient, Client toClient) {
        this.type = type;
        this.amount = amount;
        this.fromClient = formClient;
        this.toClient = toClient;
    }
    
    @Override
    public String toString() {
        if(type.equalsIgnoreCase("deposit")||type.equalsIgnoreCase("withdraw"))
            return  "Transaction{" +
                    "type='" + type + '\'' +
                    ", amount=" + amount +
                    ", from client='" + fromClient.name + '\'' +
                    '}';
        else
            return "Transaction{" +
                    "type='" + type + '\'' +
                    ", amount=" + amount +
                    ", formClient='" + fromClient.name + '\'' +
                    ", toClient='" + toClient.name + '\'' +
                    '}';
    }

}
