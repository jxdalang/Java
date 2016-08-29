import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();

        if (num % 1111 == 0 || num == 6174) {
            System.out.print(num + " - " + num + " = 0000");
            return;
        }

        while (num != 6174) {
            int[] digits = new int[4];
            for (int i = 0; i < 4; i++) {
                digits[i] = num % 10;
                num /= 10;
            }
            Arrays.sort(digits);

            int large = 0, small = 0;
            StringBuilder l= new StringBuilder() ;
            StringBuilder s= new StringBuilder() ;
            for (int i = 3; i >= 0; i--) {
                large = large * 10 + digits[i];
                l.append(digits[i]);
            }
            for (int i = 0; i <= 3; i++) {
                small = small * 10 + digits[i];
                s.append(digits[i]);
            }

            System.out.println(l + " - " + s + " = " + (large - small));

            num = large - small;

        }

    }
}