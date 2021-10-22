import java.util.ArrayList;
import java.util.Optional;
import java.util.function.*;

public class Java8Features1 {

	public static void main(String[] args) {		
		ArrayList<Integer> listInt = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			listInt.add(i);
		}
	
		//with method reference
		listInt.stream().forEach(System.out::println);
		System.out.println();
		
		//with lambda expression
		listInt.stream().forEach(e -> System.out.println(e));
		System.out.println();
		
		//with Anonymous implementation of functional interface
		Consumer<Integer> printVal = new Consumer<Integer>() {
			public void accept(Integer e) {
				System.out.print(e+" ");
			}		
		};
				
		listInt.stream().forEach(printVal);		
		System.out.println();
		
		//with lambda expression
		Consumer<Integer> printVal2 =  e -> System.out.print(e+" ");
				
		listInt.stream().forEach(printVal2);
		
		//count number of elements
		long count = listInt.stream().count();
		
		System.out.println("\ncount = "+ count + "\n");
		
		//print even numbers
		
		//with lambda expression
		listInt.stream().filter(x -> x%2==0 ).forEach(System.out::println);
		System.out.println();
		
		//with Anonymous implementation of functional interface
		Predicate<Integer> isEven1 = new Predicate<Integer>() {
			public boolean test(Integer e) {
				return e%2==0;
			}		
		};
				
		listInt.stream().filter(isEven1).forEach(System.out::println);
		
		System.out.println();
		
		//with lambda expression
		Predicate<Integer> isEven2 = e -> e%2==0;
				
		listInt.stream().filter(isEven2).forEach(System.out::println);
		
		//find max 
		Optional<Integer> max = listInt.stream().max((x, y) -> x-y);
		System.out.println("\nmax = "+ max.get());
		
		//find min
		Optional<Integer> min = listInt.stream().min((x, y) -> x-y);
		System.out.println("\nmin = "+ min.get() + "\n");		
		
		//multiply each element by 100
		listInt.stream().map(x -> x*100).forEach(System.out::println);
		System.out.println();
		
		//sort the stream
		listInt.add(-2);
		listInt.stream().sorted().forEach(System.out::println);
		System.out.println();
		
		//reverse sort the stream using provided comparator
		listInt.stream().sorted((a,b)-> b - a).forEach(System.out::println);
		System.out.println();
		
		//use customized functional interface
		MyInterface printHello = () -> System.out.println("Hello");
		printHello.print();
	
	}	
}


@FunctionalInterface
interface MyInterface{
		
	void print();
	
	default void defaultMethod() {
		System.out.println("This is the default implementation of this method");
	}
	
	static void staticMethod() {
		System.out.println("This is a static method: final implementation of this method");
	}
}