package exam;
import java.math.BigInteger;

public class IntegerOverflow {

    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        long w1 = (long) M - (long) K, h1 = (long) N - (long) L, w2 = (long) R - (long) P, h2 = (long) S - (long) Q;
        System.out.println(w1);
        System.out.println(h1);
        System.out.println(w2);
        System.out.println(h2);
        BigInteger area1 = BigInteger.valueOf(w1).multiply(BigInteger.valueOf(h1));
        System.out.println(area1);
        BigInteger area2 = BigInteger.valueOf(w2).multiply(BigInteger.valueOf(h2));
        System.out.println(area2);
        BigInteger area = area1.add(area2);
        System.out.println(area);
        BigInteger intersect;
        if (S < L || P > M || Q > N || R < K) {
            intersect = BigInteger.valueOf(0);
        } else {
            long w3 = (long)Math.min(M, R) - (long)Math.max(K, P);
            long h3 = (long)Math.min(N, S) - (long)Math.max(L, Q);
            intersect = BigInteger.valueOf(w3).multiply(BigInteger.valueOf(h3));
        }
        System.out.println(intersect);

        area = area.subtract(intersect);

        if (area.compareTo(BigInteger.valueOf(2147483647)) > 0) {
            return -1;
        } else {
            return area.intValue();
        }
    }

    public static void main(String[] args) {
        IntegerOverflow test = new IntegerOverflow();
        System.out.print(test.solution(Integer.MIN_VALUE, -2, 3, -1, 2, 2, 3, 4));

    }

}
