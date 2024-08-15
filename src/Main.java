import java.util.Scanner;

class Main{
   static LinkedList list = new LinkedList(); //List to store clients
    public static void main(String[] args){
       Scanner input = new Scanner(System.in);
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
       }while (choice != '3');
    }
    static void adminFunc(){
        Scanner input = new Scanner(System.in);
        char choice ;
        do {
            System.out.println("1. Add Client");
            System.out.println("2. Remove Client");
            System.out.println("3. Edit Client info");
            System.out.println("4. Show All Clients");
            System.out.println("6. Exit");
            String name;
            choice = input.next().charAt(0);
            switch (choice){
                case '1':
                    System.out.print("Enter client name : ");
                    name = input.next();
                    Client newClient = new Client(name);
                    list.insert(newClient);
                    break;
                case '2' :
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
                    list.editInfo(nameToSearch,nameEdit);
                    break;
                case '4':
                    list.displayList();
                    break;
            }
        }while (choice != '6');
    }
    static void clientFunc(){
        Scanner input = new Scanner(System.in);
        char choice ;
        Client client ;
        System.out.print("Enter your name to open your account : ");
        String clientName = input.next();
        client = list.findName(clientName);
        if(client == null) {
            System.out.println("There no profile with this name");
            return;
        }
        do {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer Credit");
            System.out.println("4. Request Money");
            System.out.println("5. Accept Request");
            System.out.println("6. Show Transaction");
            System.out.println("7. Show Request");
            System.out.println("8. Undo Last Transaction");
            System.out.println("9. Exit");
            choice = input.next().charAt(0);
        }while (choice != '9');
    }
}
