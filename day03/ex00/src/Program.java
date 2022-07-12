public class Program {

    public static void main(String[] args) throws InterruptedException {
        int count;
        int i;

        if (args.length != 1)
            System.exit(-1);

        count = get_count(args[0]);

        Runnable task1 = new Runnable() {
            public void run() {
                int j = 0;
                while (j < count)
                {
                    System.out.println("Egg");
                    j++;
                }
            }
        };

        Runnable task2 = new Runnable() {
            public void run() {
                int j = 0;
                while (j < count)
                {
                    System.out.println("Hen");
                    j++;
                }
            }
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException ex) {
            System.out.println("InterruptedException found");
        }

        i = 0;
        while (i < count)
        {
            System.out.println("Human");
            i++;
        }
    }

    static public int get_count(String args){
        int count;

        try {
            if (!args.startsWith("--count="))
                throw new Exception();
            count = Integer.parseInt(args.substring(8));
            if (count <= 0)
                throw new Exception();
            return (count);
        }
        catch (Exception ex){
            System.out.println("Wrong args");
        }
        return (-1);
    }
}
