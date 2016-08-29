import java.util.Scanner;
import java.util.HashSet;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<String> mats = new HashSet<String>();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.length() == 0)
                break;
            String[] mat = line.split(" ");
            for (String s : mat) {
                mats.add(s);
            }

        }
        in.close();

        System.out.print(mats.size());

    }

}
