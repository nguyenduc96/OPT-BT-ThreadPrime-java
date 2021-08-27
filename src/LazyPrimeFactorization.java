public class LazyPrimeFactorization implements Runnable {
    private int number;

    public LazyPrimeFactorization(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int num = 0;
        int count = 0;
        long startTime = System.currentTimeMillis();

        while (this.number > count) {
            if (isPrime(num)) {
                System.out.println(num + ", ");
                num++;
                count++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("Luồng bị gián đoạn");
                }
                continue;
            }
            num++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("\nTổng thời gian luồng 2 chạy : " + (endTime - startTime) / 1000 + " giây");
    }

    private boolean isPrime(int numbers) {
        boolean flag = true;
        if (numbers < 2) {
            flag = false;
        } else {
            for (int i = 2; i < numbers; i++) {
                if (numbers % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
