import java.util.*;
public class Test {
    public static void main(String[] args) {
	RandomizedSet rSet = new RandomizedSet();
	System.out.println( rSet.insert(3) );
	System.out.println( rSet.insert(3) );
	System.out.println( rSet.getRandom() );
	System.out.println( rSet.getRandom() );	
	System.out.println( rSet.insert(1) );
	System.out.println( rSet.remove(3) );
	System.out.println( rSet.getRandom() );
	System.out.println( rSet.getRandom() );
	System.out.println( rSet.insert(0) );
	System.out.println( rSet.remove(0) );
	
    }
}
