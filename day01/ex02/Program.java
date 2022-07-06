
public class Program {

    public static void main(String[] args) {
        int i = 0;

        User john = new User("John", 1000);

        User mike = new User();
        mike.setName("Mike");
        mike.setBalance(2000);

        System.out.println("UsersArrayList:");
        UsersArrayList user_array = new UsersArrayList();

        user_array.addUser(john);
        user_array.addUser(mike);
        System.out.println("arraySize: " + user_array.arraySize());
        while (i++ < 10)
            user_array.addUser(new User());

        System.out.println("arraySize: " + user_array.arraySize());
        System.out.println("numOfUsers: " + user_array.getSize());
        try {
            System.out.println("getByIndex: " + user_array.getByIndex(0).getName());
            System.out.println("getById: " + user_array.getById(2).getName());
        }
        catch (UserNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("getById: " + user_array.getById(50).getName());
        }
        catch (UserNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        try {
            System.out.println("getByIndex: " + user_array.getByIndex(50).getName());
        }
        catch (UserNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }
}
