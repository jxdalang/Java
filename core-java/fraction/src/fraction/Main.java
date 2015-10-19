package fraction;

import java.util.Scanner;
//import static java.lang.Math.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(),in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}

}

class Fraction {
	private int a = 1;
	private int b = 1;

	// constructor
	Fraction(int a, int b) {
		this.a = a;
		this.b = b;
		this.formalize();
	}

	// 用于类内部辅助的方法可以设为private
	private void formalize() {

		// 处理特殊情况
		if (b == 0)
			return;
		else if (a == 0) {
			b = 1;
			return;
		}

		// 判断正负
		boolean positive = (a * b) > 0;
		a = a > 0 ? a : -a;
		b = b > 0 ? b : -b;
		int gcd = gcd(a, b);
		if (positive)
			a = a / gcd;
		else
			a = -(a / gcd);
		b = b / gcd;
	}

	private int gcd(int a, int b) {
		int min = a;
		int max = b;
		if (a > b) {
			min = b;
			max = a;
		}
		if (min == 0)
			return max;
		else
			return gcd(min, max - min);
	}

	// methods
	public double toDouble() {
		return (1.0 * a) / b;
	}

	public Fraction plus(Fraction r) {
		Fraction result = new Fraction(1, 1);
		result.a = a * r.b + b * r.a;
		result.b = b * r.b;
		result.formalize();

		return result;
	}

	public Fraction multiply(Fraction r) {
		Fraction result = new Fraction(1, 1);
		result.a = a * r.a;
		result.b = b * r.b;
		result.formalize();

		return result;
	}

	public void print() {
		if (b == 0)
			System.out.println("infinite");
		else if (b == 1)
			System.out.println(a);
		else
			System.out.println(a + "/" + b);
	}

}