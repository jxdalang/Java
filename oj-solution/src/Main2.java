import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int s = in.nextInt();
        int L = in.nextInt();
        in.close();

        if (s == 0) {
            System.out.print(0);
            return;
        }

        int cnt = L / s;

        if (cnt == 1) {
            System.out.print(n);
            return;
        }

        while (cnt > 1) {
            if (cnt * s + (cnt - 1) <= L && (cnt % 13) != 0) {
                break;
            } else
                cnt--;
        }

        // 向上取整
        int res = (n + cnt - 1) / cnt;
        // 如果最后多出来的一张要放13的倍数首歌
        if (n % cnt != 0 && (n % cnt) % 13 == 0) {
            // 下面这种情况不能从别的专辑匀一首歌到最后一张
            if (n % cnt == cnt - 1)
                res++;
        }

        System.out.print(res);

    }

}
