
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class FileHandling
{
	private static void writeFile(Scanner sc, String path) throws IOException {
		int i = 1;
		int n;
		
		List<String> dataList = new ArrayList<String>();
		
		System.out.println("How many lines you want to write:");
		n = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter what you want to write: ");
		while(i<=n) {
			dataList.add(sc.nextLine()+'\n');
			i++;
		}

		Files.write(Paths.get(path), dataList);
 	}
	
	private static void readFile(String path) throws IOException {
		List<String> r = new ArrayList<String>();
		
		r = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		
		Iterator<String> itr = r.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
	}
	
	private static void appendFile(Scanner sc, String path) throws IOException {
		int i = 1;
		int n1;
		
		List<String> newtext = new ArrayList<String>();
		
		System.out.println("How many lines you want to append:");
		n1 = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter what you want to append: ");
		while(i<=n1) {
			newtext.add(sc.nextLine()+'\n');
			i+=1;
		}
		
		Files.write(Paths.get(path),
				newtext,
				StandardCharsets.UTF_8,
				StandardOpenOption.CREATE,
				StandardOpenOption.APPEND);
	}
	
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		String path = "C:\\Users\\Logesh\\Desktop\\eve\\file_handle"
				+ "";
		
		//Creating and writing to the file
		try {
			writeFile(sc, path);
			System.out.println("Data written successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reading the file
		try {
			readFile(path);
			System.out.println("Data read successfully");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		//Appending to the file
		try {
			appendFile(sc, path);
			System.out.println("Appended successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Reading the file
		try {
			readFile(path);
			System.out.println("Data read successfully");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		

		
	}
	}

