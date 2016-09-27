import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int y = in.nextInt();

        in.close();

        System.out.print(rev(rev(x) + rev(y)));

    }

    private static int rev(int x) {
        int res = 0;

        while (x > 0) {
            int digit = x % 10;
            x = x / 10;

            res = res * 10 + digit;
        }

        return res;
    }
}