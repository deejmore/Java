
//--------------------------------------------
// version 3: break, add to list
import java.util.ArrayList;
import java.util.Scanner;

//version 1
public class Primes {

	public static void main(String[] args) {

		int max = 100;
		System.out.println("Prime numbers less than 100:");
		for (int x = 2; x <= max; x++) {
			if (isPrime(x))
				System.out.print(" " + x);
		}

		System.out.println();
		System.out.println("Check a number: ");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if (isPrime(num))
			System.out.println("prime:" + num);

	}

	public static boolean isPrime(int number)
	{
		boolean isPrime = true;
		if ((number == 0) | (number == 1))
		{
			isPrime = false;
		}
		else
		{
		for(int divisor = 2; divisor < number; divisor++) {
		    if (number % divisor == 0) {
		        isPrime = false;
		    }
		}
		}
		return isPrime;
	}

}
/*
 * //-------------------------------------------- //version 2: break public
 * class Primes2 {
 * 
 * public static void main(String[] args) { int max = 10; for (int x = 2; x <=
 * max; x++) { boolean isPrime = true; for (int y = 2; y < x; y++) if (x % y ==
 * 0) { isPrime = false; break; } if (isPrime) System.out.println(x); } } }
 * 
 * 
 * public class Primes3 {
 * 
 * public static void main(String[] args) { ArrayList<Integer> primeList = new
 * ArrayList<>();
 * 
 * int max = 10000; for (int x = 2; x <= max; x++) { boolean isPrime = true; for
 * (int y = 2; y < x; y++) if (x % y == 0) { isPrime = false; break; } if
 * (isPrime) primeList.add(x); } System.out.println(primeList); } }
 * //-------------------------------------------- // version 4: break, add to
 * list, square root
 * 
 * 
 * public class Primes4 {
 * 
 * public static void main(String[] args) { ArrayList<Integer> primeList = new
 * ArrayList<>();
 * 
 * int max = 200000; for (int x = 2; x <= max; x++) { boolean isPrime = true;
 * for (int y = 2; y < Math.sqrt(x); y++) if (x % y == 0) { isPrime = false;
 * break; } if (isPrime) primeList.add(x); } System.out.println(primeList); } }
 */