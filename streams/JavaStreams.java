package streams;

import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class JavaStreams {

	public static void main(String[] args) throws IOException {

	int number = 0;
	do
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a number to run an example:");
		number = in.nextInt();
		System.out.println("Running Example:" + number);
		switch (number) {
		case 0: {
			System.out.println("End of examples.");
			break;
		}
		case 1: {
			exampleIntegerStream();
			System.out.println("End of Example Integer Stream");
			break;
		}
		case 2: {
			exampleIntegerStreamWithSkip();
			System.out.println("End of Example Integer Stream With Skip");
			break;
		}
		case 3: {
			exampleIntegerStreamWithSum();
			System.out.println("End of Example Integer Stream With Sum");
			break;
		}
		case 4: {
			exampleStreamSortedFindFirst();
			System.out.println("End of Example Stream Sorted Find First");
			break;
		}
		case 5: {
			exampleStreamFromArraySortedFiltered();
			System.out.println("End of Example Stream From Array Sorted Filtered");
			break;
		}
		case 6: {
			exampleStreamSquaresofIntegerArray();
			System.out.println("End of Example Stream Square of Integer Array");
			break;
		}
		case 7: {
			exampleStreamFromListFilter();
			System.out.println("End of Example From List Filter");
			break;
		}
		case 8: {
			exampleStreamFromTextFileSortFilter();
			System.out.println("End of Example From Text File Sort Filter");
			break;
		}
		case 9: {
			exampleStreamRowsFromTextFileSaveToList();
			System.out.println("End of Example Streams From Text File Save To List");
			break;
		}
		case 10: {
			exampleStreamRowsFromCSVFileAndCount();
			System.out.println("End of Example From CSV File and Count");
			break;
		}
		case 11: {
			exampleStreamRowsFromCSVFileParseDataFromRows();
			System.out.println("End of Example Stream Rwos From CSV File Parse Data From Rows");
			break;
		}
		case 12: {
			exampleStreamFromCSVFileStoreFieldsinHashMap();
			System.out.println("End of Example Stream From CSV File Store Fields in Hash Map");
			break;
		}
		case 13: {
			exampleStreamReductionSum();
			System.out.println("End of Example Stream Reduction Sum");
			break;
		}
		case 14: {
			exampleStreamtReductionSummaryStatistics();
			System.out.println("End of Example Stream Reduction Summary Statistics");
			break;
		}
		default: {
			System.out.println("Please enter a number to run a sample");

		}
			break;
		}
	}
	while (number != 0);

	}

	// 1. Integer Stream
	private static void exampleIntegerStream() {
		IntStream.range(1, 10).forEach(System.out::print);
		System.out.println();
	}

	// 2. Integer Stream with skip
	private static void exampleIntegerStreamWithSkip() {

		IntStream.range(1, 10).skip(5).forEach(x -> System.out.println(x));
		System.out.println();

	}

	// 3. Integer Stream with sum
	private static void exampleIntegerStreamWithSum() {
		System.out.println(IntStream.range(1, 5).sum());
		System.out.println();
	}

	// 4. Stream.of, sorted and findFirst
	private static void exampleStreamSortedFindFirst() {
		Stream.of("Ava", "Aneri", "Alberto").sorted().findFirst().ifPresent(System.out::println);
	}

	// 5. Stream from Array, sort, filter and print
	private static void exampleStreamFromArraySortedFiltered() {
		String[] names = { "Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah" };
		Arrays.stream(names) // same as Stream.of(names)
				.filter(x -> x.startsWith("S")).sorted().forEach(System.out::println);
	}

	// 6. average of squares of an int array
	private static void exampleStreamSquaresofIntegerArray() {
		Arrays.stream(new int[] { 2, 4, 6, 8, 10 }).map(x -> x * x).average().ifPresent(System.out::println);
	}

	// 7. Stream from List, filter and print
	private static void exampleStreamFromListFilter() {
		List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sarah");
		people.stream().map(String::toLowerCase).filter(x -> x.startsWith("a")).forEach(System.out::println);
	}

	// 8. Stream rows from text file, sort, filter, and print
	private static void exampleStreamFromTextFileSortFilter() throws IOException {
		Stream<String> bands = Files.lines(Paths.get("bands.txt"));
		bands.sorted().filter(x -> x.length() > 13).forEach(System.out::println);
		bands.close();
	}

	// 9. Stream rows from text file and save to List
	private static void exampleStreamRowsFromTextFileSaveToList() throws IOException {
		List<String> bands2 = Files.lines(Paths.get("bands.txt")).filter(x -> x.contains("jit"))
				.collect(Collectors.toList());
		bands2.forEach(x -> System.out.println(x));
	}

	// 10. Stream rows from CSV file and count
	private static void exampleStreamRowsFromCSVFileAndCount() throws IOException {
		Stream<String> rows1 = Files.lines(Paths.get("data.txt"));
		int rowCount = (int) rows1.map(x -> x.split(",")).filter(x -> x.length == 3).count();
		System.out.println(rowCount + " rows.");
		rows1.close();
	}

	// 11. Stream rows from CSV file, parse data from rows
	private static void exampleStreamRowsFromCSVFileParseDataFromRows() throws IOException {
		Stream<String> rows2 = Files.lines(Paths.get("data.txt"));
		rows2.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.forEach(x -> System.out.println(x[0] + "  " + x[1] + "  " + x[2]));
		rows2.close();
	}

	// 12. Stream rows from CSV file, store fields in HashMap
	private static void exampleStreamFromCSVFileStoreFieldsinHashMap() throws IOException {
		Stream<String> rows3 = Files.lines(Paths.get("data.txt"));
		Map<String, Integer> map = new HashMap<>();
		map = rows3.map(x -> x.split(",")).filter(x -> x.length == 3).filter(x -> Integer.parseInt(x[1]) > 15)
				.collect(Collectors.toMap(x -> x[0], x -> Integer.parseInt(x[1])));
		rows3.close();
		for (String key : map.keySet()) {
			System.out.println(key + "  " + map.get(key));
		}
	}

	// 13. Reduction - sum
	private static void exampleStreamReductionSum() {
		double total = Stream.of(7.3, 1.5, 4.8).reduce(0.0, (Double a, Double b) -> a + b);
		System.out.println("Total = " + total);
	}

	// 14. Reduction - summary statistics
	private static void exampleStreamtReductionSummaryStatistics() {
		IntSummaryStatistics summary = IntStream.of(7, 2, 19, 88, 73, 4, 10).summaryStatistics();
		System.out.println(summary);
	}

}