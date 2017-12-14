import java.io.*;
class BufferedReaderTest {
	public static void main (String[] args) throws IOException {
		String path = "./test.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
