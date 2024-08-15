public class NodeTransaction {
    Transaction transaction ;
    NodeTransaction next = null;
    NodeTransaction(Transaction transaction){
        this.transaction = transaction ;
    }
}
