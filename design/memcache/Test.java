import java.util.*;
public class Test {
	public static void main(String[] args) {
		Memcache mem = new Memcache();

		System.out.println(mem.get(1,0));
		mem.set(2,1,1,2);
		System.out.println(mem.get(3,1));
		System.out.println(mem.get(4,1));
		System.out.println(mem.incr(5,1,1));
		mem.set(6, 1, 3, 0);
		System.out.println(mem.incr(7, 1, 1));
		System.out.println(mem.decr(8, 1, 1));
		System.out.println(mem.get(9, 1));
		mem.delete(10, 1);
		System.out.println(mem.get(11, 1));
		System.out.println(mem.incr(12, 1, 1));
	}
}
