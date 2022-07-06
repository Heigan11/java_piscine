import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    TransactionNode head = null;
    int lenght = 0;

    public void addTransaction(Transaction transaction) {
        TransactionNode transactionNode = new TransactionNode(transaction, head);
        head = transactionNode;
        ++lenght;
    }

    public void deleteById(UUID id) throws TransactionNotFoundException{
        TransactionNode tmp = head;
        if (head.getData().getIdentifier().equals(id)) {
            head = head.getNext();
            --lenght;
            return;
        }
        else if (lenght > 1){
            while (tmp.getNext().getNext() != null) {
                if (tmp.getNext().getData().getIdentifier().equals(id)) {
                    tmp.setNext(tmp.getNext().getNext());
                    --lenght;
                    return;
                }
                tmp = tmp.getNext();
            }
        }
        throw new TransactionNotFoundException("TransactionNotFoundException");
    }

    public Transaction[] toArray(){
        TransactionNode tmp = head;
        Transaction[] transactions = new Transaction[lenght];
        for (int i = 0; i < lenght; i++) {
            transactions[i] = tmp.getData();
            tmp = tmp.getNext();
        }
        return transactions;
    }
}