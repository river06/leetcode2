import java.io.*;
import java.util.*;
class ScannerTest {
	public static void main (String[] args) throws FileNotFoundException {
		String file = "./test.txt";

		Scanner scanner = new Scanner(new File(file));
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			System.out.println(line);
		}

		scanner.close();
	}
}

