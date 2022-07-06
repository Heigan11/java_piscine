import java.util.UUID;
public class Program {

    public static void main(String[] args) {

        User john = new User("John", 1000);

        User mike = new User();
        mike.setName("Mike");
        mike.setBalance(2000);

        TransactionsLinkedList transactionsLinkedList = new TransactionsLinkedList();
        transactionsLinkedList.addTransaction(new Transaction(john, mike, Transaction.Category.CREDITS, -500));
        transactionsLinkedList.addTransaction(new Transaction(john, mike, Transaction.Category.DEBITS, 1000));

        Transaction[] array = transactionsLinkedList.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }

        transactionsLinkedList.deleteById(array[0].getIdentifier());

        System.out.println("after delete:");
        array = transactionsLinkedList.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
        try {
            transactionsLinkedList.deleteById(UUID.randomUUID());
        } catch (TransactionNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}
