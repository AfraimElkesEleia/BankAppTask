import java.util.LinkedList;
import java.util.Scanner;

class Main {
    static LinkedListClients list = new LinkedListClients(); //List to store clients
    static LinkedList<Admin> admins = new LinkedList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        admins.add(new Admin("Pavly", "12345678"));
        admins.add(new Admin("Marko", "089200222"));
        char choice;
        do {
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as Client");
            System.out.println("3. Exit");
            choice = input.next().charAt(0);
            switch (choice) {
                case '1':
                    adminFunc();
                    break;
                case '2':
                    clientFunc();
                    break;
            }
        } while (choice != '3');
    }

    static void adminFunc() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name : ");
        String userName = input.next();
        Admin admin = null;
        for (int i = 0; i < admins.size(); i++) {
            if (admins.get(i).getName().equalsIgnoreCase(userName)) {
                admin = admins.get(i);
                break;
            }
        }
        if (admin == null) {
            System.out.println("Error!!there is no admin with this name 😥😥");
            return;
        }
        System.out.print("Enter your Password : ");
        int counter = 3;

        do {
            String userPassword = input.next();
            if (userPassword.equals(admin.getPassword())) {
                System.out.println("Correct Password Enter numbers between 1 to 6 from this menu");
                break;
            } else {
                counter--;
                if (counter == 0) {
                    System.out.println("Try Again!!");
                    return;
                }
                System.out.println("Wrong Password!!..Please try again you have " + counter + " attempts");
            }
        } while (true);

        char choice;
        do {
            System.out.println("1. Add Client");
            System.out.println("2. Remove Client");
            System.out.println("3. Edit Client info");
            System.out.println("4. Show All Clients");
            System.out.println("5. Show All Transactions");
            System.out.println("6. Exit");
            String name;
            choice = input.next().charAt(0);
            switch (choice) {
                case '1':
                    System.out.print("Enter client name : ");
                    name = input.next();
                    Client newClient = new Client(name);
                    list.insert(newClient);
                    break;
                case '2':
                    String nameD;
                    System.out.print("Enter client name to delete : ");
                    nameD = input.next();
                    list.delete(nameD);
                    break;
                case '3':
                    String nameEdit;
                    String nameToSearch;
                    System.out.print("Enter name that you want to edit : ");
                    nameToSearch = input.next();
                    System.out.print("Edit name : ");
                    nameEdit = input.next();
                    Client client = list.findName(nameToSearch);
                    if (client == null) {
                        System.out.println("There is no client with this name.");
                    } else {
                        client.name = nameEdit;
                    }
                    break;
                case '4':
                    list.displayList();
                    break;
                case '5':
                    list.showTransaction();
                    break;
                case '6':
                    break;
                default:
                    System.out.println("You should enter number between 1 to 6");
            }
        } while (choice != '6');
    }

    static void clientFunc() {
        Scanner input = new Scanner(System.in);
        char choice;
        Client client;
        System.out.print("Enter your name to open your account : ");
        String clientName = input.next();
        client = list.findName(clientName);
        if (client == null) {
            System.out.println("There no profile with this name");
            return;
        }
        do {
            System.out.println("Your current balance in your account is : " + client.balance);
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer Credit");
            System.out.println("4. Request Money");
            System.out.println("5. Accept Request");
            System.out.println("6. Decline Request");
            System.out.println("7. Show Transactions");
            System.out.println("8. Show Request");
            System.out.println("9. Undo Last Transaction");
            System.out.println("0. Exit");
            choice = input.next().charAt(0);
            double amount;
            switch (choice) {
                case '1':
                    System.out.print("Enter amount that you want to deposit : ");
                    amount = input.nextDouble();
                    client.deposit(amount);
                    break;
                case '2':
                    System.out.print("Enter amount that you want to withdraw : ");
                    amount = input.nextDouble();
                    client.withdraw(amount);
                    break;
                case '3':
                    System.out.print("Enter name of client to transfer : ");
                    String nameOfClient = input.next();
                    Client client2 = list.findName(nameOfClient);
                    if (client2 == null) {
                        break;
                    }
                    System.out.print("Enter amount you want to transfer : ");
                    amount = input.nextDouble();
                    client.transferCredit(client2, amount);
                    break;
                case '4':
                    System.out.print("Enter client name that you want to request from : ");
                    String clientToSearch = input.next();
                    if (clientToSearch.equals(client.name)) {
                        System.out.println("That is not available !!!");
                        break;
                    }
                    Client toClient = list.findName(clientToSearch);
                    if (toClient != null) {
                        System.out.print("Enter amount you want to request : ");
                        amount = input.nextDouble();
                        client.makeRequest(toClient, amount);
                    }
                    break;
                case '5':
                    client.acceptRequest(client.requests.peek());
                    break;
                case '6':
                    client.declinRequest(client.requests.peek());
                    break;
                case '7':
                    client.showTransactions();
                    break;
                case '8':
                    client.showAllRequests();
                    break;
                case '9':
                    client.undoLastTransaction();
                    break;
                case '0':
                    break;
                default:
                    System.out.println("You should enter number between 1 to 6");
            }
        } while (choice != '0');
    }
}
