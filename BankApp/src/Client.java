public class Client {
    String name;
    double balance;

    public Client(String name) {
        this.name = name;
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
