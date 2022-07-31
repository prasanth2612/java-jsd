import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Operations {
	public static void writeFileUsingNIO() throws IOException{
		String path = "src//file_handling//writeFileUsingNIO.txt";
		String data = "From writeFileUsingNIO";
		Files.write(Paths.get(path), data.getBytes());
		
		ArrayList<String> al = new ArrayList<String>();
		al.add("\nThis is 1st line");
		al.add("This is 2nd line");
		al.add("This is 3rd line");
		Files.write(Paths.get(path), 
				al,
				StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
	}
	
	private static void readFileUsingNIO() throws IOException{
		String path = "src//file_handling//writeFileUsingNIO.txt";
		List<String> l = new ArrayList<String>();
		
		l = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		
		Iterator itr = l.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
;	}
	
	
	private static void deleteFileNIO(){
		String path = "src//file_handling//writeFileUsingNIaddO.txt";
		try {
			Files.delete(Paths.get(path));
		} catch(NoSuchFileException e) {
			System.out.println("There is no such file in the directory");
		} catch (DirectoryNotEmptyException e) {
			System.out.println("Invalid permissions...");
		}
		catch (IOException e) {
			System.out.println("Invalid permissions...");
		}	
	}

	public static void main(String[] args) throws IOException{
		String path = "src//file_handling//FileWriter.txt";
		File file = new File(path);
		
		//Writing the file using FileWriter
		FileWriter writer = new FileWriter(file);
		writer.write("This is written by Filewriter class");
		writer.close();
		
		
		
		try (//Overwriting the file
		FileWriter writer2 = new FileWriter(file)) {
			writer2.write("My name is Nandha kumar\n");
		}
		
		//Reading the file using FileReader
		FileReader reader = new FileReader(path);
		
		//You can read this way but it gives only bytes value
//				System.out.println(reader.read());
		
		//Correct way is using loop
		int i;
		while((i = reader.read()) != -1)
			System.out.print((char)i);
		reader.close();
		
		//Calling functions
		writeFileUsingNIO();
		
		//reading the file Written by the above function call
		readFileUsingNIO();
		
		//Deleting the file used by above function calls
		deleteFileNIO();
	}


}