public class Calculator extends Thread {
    private int last;
    private int first;
    private int[] array;
    private int result = 0;

    public Calculator(int last, int first, int[] array) {
        this.last = last;
        this.first = first;
        this.array = array;
    }

    public int getResult() {
        return result;
    }

    @Override
    public void run() {
        int tmp = first;
        while (tmp != last){
            result += array[tmp];
            tmp++;
        }
        System.out.println(this.getName() + ": from " + first + " to " + (last - 1) + " sum is " + result);
    }
}
