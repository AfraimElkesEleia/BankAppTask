public class Client {
    String name;
    double balance;
    static int counter = 0;
    LinkedListTransaction transactions = new LinkedListTransaction();

    public Client(String name) {
        this.name = name;
        this.balance = 0;
        counter++;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", transactions=" + transactions.toString() +
                '}';
    }
}
