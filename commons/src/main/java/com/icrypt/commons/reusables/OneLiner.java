package com.icrypt.commons.reusables;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class OneLiner {

	// Testing Functional Interface

	// Testing BiConsumer

//	 BiConsumer<List<Integer>, List<Integer> >

	// Testing TriConsumer

//	BiConsumer<UtilClassForOneLiner>

	public static void main(String [] args) {
		// Create the first list		
				codeValueTest("Suketu");
				tmpBiConsumerTest();
				tmpWithUserDefineClass();
		
	}
	
	public static void tmpWithUserDefineClass()
	{
		List<Integer> lista = new ArrayList<Integer>();
	lista.add(2);
	lista.add(5);
	lista.add(1);
		
		UtilClassForOneLiner testClass = new UtilClassForOneLiner();
		BiConsumer<List<Integer>, UtilClassForOneLiner> tmp = (list1, tmp1) -> {
			
			list1.stream().forEach(lis1 -> tmp1.setTmpString(lis1.toString())); 
			tmp1.printTest();
		};
		tmp.accept(lista, testClass);
	}
	
	
	public static void tmpBiConsumerTest() {
		List<Integer> lista = new ArrayList<Integer>();
		lista.add(2);
		lista.add(1);
		lista.add(3);
		List<Integer> listb = new ArrayList<Integer>();
		listb.add(2);
		listb.add(1);
		listb.add(2);
	
		
		// Create the second list
				BiConsumer<List<Integer>, List<Integer>> equals = (list1, list2) -> {
					if (list1.size() != list2.size()) {
						System.out.println("False");
					} else {
						for (int i = 0; i < list1.size(); i++)
							if (list1.get(i) != list2.get(i)) {
								System.out.println("False");
								return;
							}
						System.out.println("True");
					}
				};
				// BiConsumer to print 2 lists
				BiConsumer<List<Integer>, List<Integer>> disp = (list1, list2) -> {
					list1.stream().forEach(a -> System.out.print(a + " "));
					System.out.println();
					list2.stream().forEach(a -> System.out.print(a + " "));
					System.out.println();
				};
				try {
		            disp.andThen(equals).accept(lista, listb);
		        }
		        catch (Exception e) {
		            System.out.println("Exception : " + e);
		        }
				
				// Using addThen() method
				equals.andThen(disp).accept(lista, listb);
	}
	
	public static void IntConsumerTest() {
		  
        // Create a IntConsimer Instance
        IntConsumer display = a -> System.out.println(a * 10);
        IntConsumer mul = a -> a *= 10;
  
        // Using andThen() method
        IntConsumer composite = mul.andThen(display);
        composite.accept(3);
	}
	
	public static void codeValueTest(String str) {
        IntStream stream = str.codePoints();
        
        System.out.println("ASCII Values are: ");
  
        // Print the code points
        stream.forEach(System.out::println);
	}
}
