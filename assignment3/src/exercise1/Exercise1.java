package exercise1;

import java.util.*;
public class Exercise1 {
 public static void main( String [] args ) {
  // Create a set called mySet
  Set<String> mySet = new HashSet<>();
  // Ensure that this set contains an interesting selection of fruit 
  String fruit1 = "pear", fruit2 = "banana", fruit3 = "tangerine",
              fruit4 = "strawberry", fruit5 = "blackberry";
  mySet.add( fruit1 );
  mySet.add(fruit2);
  mySet.add( fruit3 );
  mySet.add( fruit2 );
  mySet.add( fruit4 );
  mySet.add( fruit5 );
  // Display contents of mySet
  System.out.println("mySet now contains:");
  System.out.println(mySet);
  System.out.println("There are " + mySet.size() + " in mySet.");
  mySet.remove("strawberry");
  mySet.remove("blackberry");
  System.out.println("Removed sttrawberry and blackberry.");
  System.out.println(mySet);
  mySet.removeAll(Arrays.asList("pear", "banana", "tangerine"));
  System.out.println("MySet is empty: " + mySet.isEmpty());
 }
}
