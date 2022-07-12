public class Program {

    public static void main(String[] args) throws InterruptedException {

        int arraySize = 0;
        int threadsCount = 0;
        int result = 0;

        try {
            arraySize = Integer.parseInt(args[0].substring(12));
            threadsCount = Integer.parseInt(args[1].substring(15));
        } catch (Exception ex) {
            System.out.println("Wrong args");
        }

        int[] array = new int[arraySize];
        int standardSumOfArrayElements = 0;
        for (int i = 0; i < arraySize; i++) {
            array[i] = (int) (Math.random() * 1000);
            standardSumOfArrayElements += array[i];
        }
        System.out.println("Sum: " + standardSumOfArrayElements);

        int arraysLength;
        if (arraySize % threadsCount != 0) {
            arraysLength = arraySize / threadsCount + 1;
        } else
            arraysLength = arraySize / threadsCount;

        Thread[] arrayThread = new Thread[threadsCount];

        Calculator[] calculators = new Calculator[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            if ((i + 1) * arraysLength > arraySize) {
                calculators[i] = new Calculator(arraySize, i * arraysLength, array);
            } else {
                calculators[i] = new Calculator((i + 1) * arraysLength, i * arraysLength, array);
            }
            arrayThread[i] = calculators[i];
            arrayThread[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            try {
                arrayThread[i].join();
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException found");
            }
            result += calculators[i].getResult();
        }
        System.out.println("Sum by threads: " + result);
    }

}
