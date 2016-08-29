import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        String[] line = new String[n];
        for (int i = 0; i < n; i++) {
            line[i] = in.nextLine();
        }
        in.close();
        int[][] value = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                value[i][j] = line[i].charAt(j) - '0';
            }
        }
        
        
        
        
        
        

    }

}
