public class Transaction {
    String type;
    double amount;
    String formClient;
    String toClient;

    public Transaction(String type, double amount) { //Constructor for deposit and withdraw operation
        this.type = type;
        this.amount = amount;
    }
    public Transaction(String type, double amount, String formClient, String toClient) {
        this.type = type;
        this.amount = amount;
        this.formClient = formClient;
        this.toClient = toClient;
    }
    
    @Override
    public String toString() {
        if(type.equalsIgnoreCase("deposit")||type.equalsIgnoreCase("withdraw"))
            return  "Transaction{" +
                    "type='" + type + '\'' +
                    ", amount=" + amount +
                    '}';
        else
            return "Transaction{" +
                    "type='" + type + '\'' +
                    ", amount=" + amount +
                    ", formClient='" + formClient + '\'' +
                    ", toClient='" + toClient + '\'' +
                    '}';
    }
}
