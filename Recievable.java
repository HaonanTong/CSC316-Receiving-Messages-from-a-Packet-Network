import java.util.Scanner;
import java.io.*;

public class Recievable {
	private static File fileIn;
	private static File fileOut;
	private static SinglyLinkedList list;

	/**
	 * Main method that reads and writes the data into a file.
	 * @param args data input and output names.
	 * @throws IOException if file can't be written or read.
	 */
	public static void main(String[] args) throws IOException {
		fileIn = new File(args[0]);
		fileOut = new File(args[1]);
		list = new SinglyLinkedList();
		
		read(fileIn);
		write(fileOut);
	}
	
	/**
	 * Reads the file name and inputs the data into a list.
	 * @param name of file.
	 * @throws IOException if file can't be written or read.
	 */
	public static void read(File fileIn) throws IOException {
		Scanner scan = new Scanner(fileIn);
		String tmp;
		
		while(scan.hasNextLine()){
			tmp = scan.nextLine();
			Scanner scanLine = new Scanner(tmp);
			
			int tmp_int_1 = -1, tmp_int_2 = 0; 
			String tmp_string = null;

			if(scanLine.hasNextInt())
				tmp_int_1 = scanLine.nextInt();

			if(scanLine.hasNextInt())
				tmp_int_2 = scanLine.nextInt();
			

			if(scanLine.hasNext())
				tmp_string = scanLine.next();

			if( tmp_int_2 > 0 && tmp_string != null)
				list.addNode(tmp_int_1, tmp_int_2, tmp_string);
			
			scanLine.close();
		}
		scan.close();
	}
	
	/**
	 * Reads the file name and outputs the list into a file.
	 * @param name of file.
	 * @throws IOException if file can't be written or read.
	 */
	public static void write(File fileOut) throws IOException{
		FileWriter fileWriter = new FileWriter(fileOut);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.print(list.print());
		printWriter.close();
	}

}
