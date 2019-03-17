package lambdas;

public class SimpleLambda {
	
	public static void main(String[] args) {
	
	/*
	SimpleFunction simpleFunction = (text1,text2) ->  System.out.println(text1 + " + " + text2); 
	simpleFunction.apply("Hello", "World");
	*/
		
		SimpleFunction simpleFunction = (text1,text2) -> {
			System.out.println(text1 + " + " + text2); 
			return text1 + " + " + text2;
		};
		
		String returnValue = simpleFunction.apply("Hello hello","world");
		simpleFunction.apply("Hello", "World");
		
		System.out.println(returnValue);
		
		System.out.println(simpleFunction.apply("Bye bye", "world"));
		
	}
}
