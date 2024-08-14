public class Request {
    double amount;
    Client fromClient;
    Client toClient;

    public Request(double amount, Client fromClient, Client toClient) {
        this.amount = amount;
        this.fromClient = fromClient;
        this.toClient = toClient;
    }

    @Override
    public String toString() {
        return "Request{" +
                "amount=" + amount +
                ", fromClient=" + fromClient.name +
                ", toClient=" + toClient.name +
                '}';
    }
}
