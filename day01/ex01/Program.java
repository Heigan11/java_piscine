import java.util.UUID;

public class Program {

    public static void main(String[] args) {
        User john = new User("John", 1000);

        System.out.println("User 1 init:");
        System.out.println("Identifier: " + john.getId());
        System.out.println("Name: " + john.getName());
        System.out.println("Balance: " + john.getBalance());

        User mike = new User("Mike", 2000);
        System.out.println("User 2 init:");
        System.out.println("Identifier: " + mike.getId());
        System.out.println("Name: " + mike.getName());
        System.out.println("Balance: " + mike.getBalance());
    }
}