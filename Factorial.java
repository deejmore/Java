import java.util.Scanner;

public class Factorial {

	private static String space = " ";

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		Scanner in = new Scanner(System.in);
		int num = 0;
		do
		{
			num = in.nextInt();
		System.out.println(factorial.getRecursiveFactorial(num));
		System.out.println(factorial.getIterativeFactorial(num));
		}
		while (num != 0);
	}

	public int getRecursiveFactorial(int n) {
		System.out.print(n);
		System.out.print(space);
		if (n < 0)
			return -1;
		else if (n < 2)
			return 1;
		else
			return (n * getRecursiveFactorial(n - 1));
	}

	public int getIterativeFactorial(int n) {
		System.out.print(n);
		System.out.print(space);
		if (n < 0)
			return -1;
		int fact = 1;
		for (int i = 1; i <= n; i++)
			fact *= i;
		return fact;
	}
}