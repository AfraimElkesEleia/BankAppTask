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
        NodeTransaction newTransaction = new NodeTransaction(transaction);
        if(first==null)
            first = newTransaction;
        else {
            NodeTransaction current = first;
            while(current.next != null){
                current = current.next;
            }
            current.next = newTransaction;
        }
    }
    public void deleteLast(){
        if(first==null)
            return;
        else {
            NodeTransaction current = first;
            while (current.next.next != null)
                current = current.next;
            current.next = null;
        }
    }

}
