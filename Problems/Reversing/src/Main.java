import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();
        int revNumber = 0;
        while (number != 0) {
            int rem = number % 10;
            revNumber = revNumber * 10 + rem;
            number /= 10;
        }
        System.out.println(revNumber);
    }
}