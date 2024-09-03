import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of elements you wish to enter: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcd = greatestCommonDivisor(a,b);
        //int gcd = findGCD(a,b);

        System.out.println("The greatest common divisor is: " + gcd);
    }

    public static int greatestCommonDivisor(int a, int b) {
        //find divisors of a
        ArrayList<Integer> list_a = new ArrayList<>();
        for(int i = 1; i <= a; i++) {
            if(a % i == 0) {
                list_a.add(i);
            }
        }
        //find divisors of b
        ArrayList<Integer> list_b = new ArrayList<>();
        for(int i = 1; i <= b; i++) {
            if(b % i == 0) {
                list_b.add(i);
            }
        }

        //compare similar divisors
        ArrayList<Integer> list_c = new ArrayList<>();
        for(int number : list_a) {
            for (int i = 0; i < list_a.size(); i++) {
                if (number == list_b.get(i)) {
                    list_c.add(number);
                }
            }
        }
        //get largest divisor
        int gcd = largestnumber(list_c);

        return gcd;
    }

    //function to find the largestnumber in an array.
    public static int largestnumber(ArrayList<Integer> list) {
        int largest = 0;
        if (list.isEmpty()) {
            System.out.println("There are no common divisors");
        } else {
            largest = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > largest) {
                    largest = list.get(i);
                }
            }
        }
        return largest;
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}