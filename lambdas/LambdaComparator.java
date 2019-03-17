package lambdas;

import java.util.Comparator;

public class LambdaComparator {

	public static void main(String[] args) {
		
		Comparator<String> stringComparator = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		};
	
		int comparison = stringComparator.compare("hello","mabuhay");
		System.out.println(comparison);
		
		Comparator<String> stringComparatorLambda = 
				(String o1, String o2) -> { return o1.compareTo(o2); };
				
		int lambdaComparator = stringComparatorLambda.compare("mabuhay", "hello");
		System.out.println(lambdaComparator);
		
		Comparator<String> shortStringComparatorLambda =
				(o1,o2) -> o1.compareTo(o2);
				
		int shortLambdaComparator = shortStringComparatorLambda.compare("arigato","hello");
		System.out.println(shortLambdaComparator);
		
				
	}
}
