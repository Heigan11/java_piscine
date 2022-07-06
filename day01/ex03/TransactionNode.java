public class TransactionNode {
    private Transaction data;
    private TransactionNode next;

    public TransactionNode(Transaction transaction, TransactionNode next) {
        this.data = transaction;
        this.next = next;
    }

    public TransactionNode getNext() {
        return this.next;
    }

    public void setNext(TransactionNode next) {
        this.next = next;
    }

    public Transaction getData() {
        return this.data;
    }

    public void setData(Transaction data) {
        this.data = data;
    }
}