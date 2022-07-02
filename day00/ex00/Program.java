public class Program {

    public static void main(String[] args) {
        int number = 479598;
        int tmp = 0;

        tmp += number % 10;
        number /= 10;
        tmp += number % 10;
        number /= 10;
        tmp += number % 10;
        number /= 10;
        tmp += number % 10;
        number /= 10;
        tmp += number % 10;
        number /= 10;
        tmp += number % 10;
        System.out.println(tmp);
    }
}