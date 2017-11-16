import java.util.*;
public class Test {
	public static void main(String[] args) {

		TwoSum obj = new TwoSum();
		int[] numbers = {1,3,5};
		int[] tests = {4, 7};
		for (int num: numbers) {
			obj.add(num);
		}

		for (int value: tests) {
			System.out.println(obj.find(value));
		}
	} 
}
