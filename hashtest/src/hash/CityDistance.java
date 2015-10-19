package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CityDistance {

	public static void main(String[] args) {
		HashMap<String, Integer> cityDistance = new HashMap<>();
		ArrayList<String> city = new ArrayList<>();

		Scanner in = new Scanner(System.in);
		String s = in.next();
		// 判断字符串内容相同要用equals方法而不是“==”
		while (!s.equals("###")) {
			city.add(s);
			s = in.next();
		}

		int[][] distance = new int[city.size()][city.size()];
		for (int i = 0; i < city.size(); i++) {
			for (int j = 0; j < city.size(); j++) {
				distance[i][j] = in.nextInt();
				cityDistance.put(city.get(i) + city.get(j), distance[i][j]);
			}
		}

		System.out.println(cityDistance.get(in.next() + in.next()));

		in.close();

	}

}
