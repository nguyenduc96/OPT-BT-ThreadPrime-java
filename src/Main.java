import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số lượng số nguyên tố muốn in ra : ");
        int number = scanner.nextInt();

        LazyPrimeFactorization lz = new LazyPrimeFactorization(number);
        OptimizedPrimeFactorization op = new OptimizedPrimeFactorization(number);
        Thread thread1 = new Thread(op);
        Thread thread = new Thread(lz);
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Luồng đang bị gián đoạn");
        }
        thread.start();
    }
}
