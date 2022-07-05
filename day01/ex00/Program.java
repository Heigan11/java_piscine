import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        User john = new User(1, "John", 1000);

        System.out.println("User 1 init:");
        System.out.println("Identifier: " + john.getIdentifier());
        System.out.println("Name: " + john.getName());
        System.out.println("Balance: " + john.getBalance());

        User mike = new User(2, "Mike", 2000);

        System.out.println("User 2 init:");
        System.out.println("Identifier: " + mike.getIdentifier());
        System.out.println("Name: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());

        Transaction debits = new Transaction(john, mike, Transaction.Category.CREDITS, -500);
        System.out.println(debits.getSender() + " -> " + debits.getRecipient() + ", " + debits.getAmount()
                + ", " + debits.getCategory() + ", transaction ID");

        Transaction credits = new Transaction(mike, john, Transaction.Category.DEBITS, 500);
        System.out.println(credits.getSender() + " -> " + credits.getRecipient() + ", " + credits.getAmount()
                + ", " + credits.getCategory() + ", transaction ID");

    }
}