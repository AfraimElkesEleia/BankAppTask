public class LinkedList {
    private Node first;
    public LinkedList(){
        first = null;
    }
    public void displayList(){
        Node current = first;
            while (current != null){
                System.out.print(current.client+" ");
                current = current.next;
                System.out.println();
            }
    }
    public void insert(Client client){
        Node newClient = new Node(client);
        if(first==null)
            first = newClient;
        else {
            Node current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = newClient;
        }
    }
    public void delete(String name){
        Node current = first ;
        Node previous = first;
        while(!current.client.name.equalsIgnoreCase(name)){
           if(current.next == null){
               System.out.println("Not Found");
               return;
           }
           else {
               previous = current;
               current = current.next;
           }
        }
        if(current == first){
            current = current.next;
        }
        else
        previous.next = current.next;
    }
    public void editInfo(String name , String editName){
        Node current = first;
        while (!current.client.name.equalsIgnoreCase(name)){
            if(current.next == null) {
                System.out.println("Not found");
                return;
            }
            else {
                current = current.next;
            }
        }
        current.client.name = editName;
    }


}
