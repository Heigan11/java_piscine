import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int number;
        int i = 2;
        int count = 0;


        Scanner input = new Scanner(System.in);
        if (!input.hasNextInt()){
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
        number = input.nextInt();
        if (number > 1) {
            if (number == 2 || number == 3) {
                System.out.println("true " + 1);
                System.exit(0);
            }
            int res = 0;
            while (res < number) {
                res = i * i;
                count++;
                if (number % i == 0) {
                    System.out.println("false " + count);
                    System.exit(0);
                }
                i++;
            }
            System.out.println("true " + count);
            System.exit(0);
        } else {
            System.err.println("Illegal Argument");
            System.exit(-1);
        }
    }
}
