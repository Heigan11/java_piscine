import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        int sum = 0;
        int count;
        int num = 0;

        count = 0;
        Scanner input = new Scanner(System.in);

        while (true) {
            num = input.nextInt();
            if (num == 42)
                break;
            sum = get_sum(num);
            if (is_prime(sum) == true)
                count++;
        }
        System.out.println("Count of coffee-request – " + count);
    }

    public static int get_sum(int number) {
        int tmp = 0;

        while (number >= 10) {
            tmp += number % 10;
            number /= 10;
        }
        tmp += number % 10;
        return (tmp);
    }

    public static boolean is_prime(int number) {
        int i = 2;
        if (number == 2 || number == 3)
            return true;
        int res = 0;
        while (res < number) {
            res = i * i;
            if (number % i == 0)
                return false;
            i++;
        }
        return true;
    }
}
