import java.util.*;
public class Test {
	public static void main(String[] args) {
		MaxStack stack = new MaxStack();
		stack.isDebug = true;
		stack.push(5); 
		stack.push(1);
		stack.push(5);
		stack.top(); 
		stack.popMax(); 
		stack.top(); 
		stack.peekMax();
		stack.pop(); 
		stack.top(); 
	}
}
