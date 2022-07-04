import java.util.Scanner;
import java.lang.String;

public class Program {

    public static void main(String[] args) {
        String week;
        int num_week = 0;
        int min_grade;
        int cur_grade;
        int i;
        long storage = 0;
        int check = 1;
        long multiple;

        Scanner input = new Scanner(System.in);
        while (true) {
            i = 0;
            min_grade = 9;
            multiple = 1;
            week = input.next();
            if (week.equals("42")) {
                show_res(storage, num_week);
                System.exit(0);
            }
            if (!week.equals("Week")) {
                System.err.println("\nIllegal Argument1");
                System.exit(-1);
            }
            num_week = input.nextInt();
            if (num_week < 1 || num_week > 18 || num_week != check){
                System.err.println("\nIllegal Argument2");
                System.exit(-1);
            }
            while (i < 5) {
                cur_grade = input.nextInt();
                if (cur_grade < 1 || cur_grade > 9) {
                    System.err.println("\nIllegal Argument3");
                    System.exit(-1);
                }
                if (min_grade > cur_grade)
                    min_grade = cur_grade;
                i++;
            }
            i = num_week;
            while (i > 1)
            {
                multiple *= 10;
                i--;
            }
            storage += multiple * min_grade;
            check++;
        }
    }
    public static void show_res(long storage, int num_week) {
        long len;
        int i = 1;

        while (num_week >= 1) {
            System.out.print("Week " + i + " ");
            len = storage % 10;
            while (len > 0) {
                System.out.print("=");
                len--;
            }
            System.out.println(">");
            storage /= 10;
            num_week--;
            i++;
        }
    }
}
