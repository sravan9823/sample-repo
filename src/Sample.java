import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sample {

	public static void main(String[] args) {

		List<List<String>> myList = Arrays.asList(Arrays.asList("1", "3", "99", "2", "14", "2"),
				Arrays.asList("111", "7", "199", "92", "14", "20"), Arrays.asList("10", "31", "9", "21", "243", "432"),
				Arrays.asList("31", "13", "999", "5", "41", "222"), Arrays.asList("10", "31", "401", "42", "11", "77"));
		
		
		Stream<List<String>> stream1 = myList.stream();
		
		Stream<String> flatMap = stream1.flatMap( S -> S.stream().map(num->num));
		
		Stream<Integer> map = flatMap.map( s -> Integer.parseInt(s));
		
		
		List<Integer> collect = map.filter( num -> num % 2==1).collect(Collectors.toList());
		System.out.println(collect);
		
		Long collect2 = collect.stream().collect(Collectors.summingLong(num ->num));
		System.out.println(collect2);
		
		/*myList.stream()
				.flatMap( S -> S.stream().map(num->num)).map(s -> Integer.parseInt(s))*/
		
		

	}

}
