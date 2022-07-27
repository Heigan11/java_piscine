package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number){
        int div = 3;

        if (number <= 1)
            throw new IllegalNumberException("IllegalNumberException");
        if (number == 2)
            return (true);
        if (number % 2 == 0)
            return (false);
        while (div <= (number / 2 + 1))
        {
            if (number % div == 0)
                return (false);
            div += 2;
        }
        return (true);
    }

    class IllegalNumberException extends RuntimeException {
        public IllegalNumberException(String msg) {
            super(msg);
        }
    }

    public int digitsSum(int number) {
        int tmp = 0;

        while (number >= 10) {
            tmp += number % 10;
            number /= 10;
        }
        tmp += number % 10;
        return(tmp);
    }
}
