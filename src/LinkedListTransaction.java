public class LinkedListTransaction {
    private NodeTransaction first;
    public LinkedListTransaction(){
        first = null;
    }
    public void displayList(){
        NodeTransaction current = first;
        while (current != null){
            System.out.print(current.transaction.toString()+" ");
            current = current.next;
            System.out.println();
        }
    }
    public void insert(Transaction transaction){
        NodeTransaction newClient = new NodeTransaction(transaction);
        if(first==null)
            first = newClient;
        else {
            NodeTransaction current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = newClient;
        }
    }

}
