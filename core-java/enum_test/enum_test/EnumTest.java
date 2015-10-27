package enum_test;

import java.util.Scanner;

public class EnumTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter size: SMALL or MEDIUM or LARGE or EXTRA_LARGE?");
        try {
            Size output = Enum.valueOf(Size.class, in.next().toUpperCase());
            System.out.println("The size you entered is : " + output);
            System.out.println("The abbreviation = " + output.getAbbr());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        in.close();

    }

}
