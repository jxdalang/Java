import java.util.*;

public class Main5 {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        StringBuilder encode = new StringBuilder();
        int left = -90;
        int right = 90;

        for (int i = 0; i < 6; i++) {
            int mid = (left + right) / 2;
            if (x < mid) {
                encode.append(0);
                right = mid;
            } else {
                encode.append(1);
                left = mid;
            }
        }

        System.out.print(encode.toString());
        in.close();
    }
}