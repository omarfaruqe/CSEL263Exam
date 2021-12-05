import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String file_content = bufferReader.readLine();
			String file_content_array[] = file_content.split(", ");			
			for(String j : file_content_array) { System.out.println(j); }
			} catch (Exception e){} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String file_content = bufferReader.readLine();
			String file_content_array[] = file_content.split(", ");	
			Random random_value = new Random();
			int y = Math.abs(random_value.nextInt()%4);
			System.out.println(file_content_array[y]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
			BufferedWriter bufferReader = new BufferedWriter(
					new FileWriter("students.txt", true));
			String t = args[0].substring(1);
	        Date date = new Date();
	        String currentdate = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(currentdate);
	        String dateformat= dateFormat.format(date);
			bufferReader.write(", "+t+"\nList last updated on "+dateformat);
			bufferReader.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String file_content = bufferReader.readLine();
			String file_content_array[] = file_content.split(",");	
			boolean done = false;
			String t = args[0].substring(1);
			for(int idx = 0; idx<file_content_array.length && !done; idx++) {
				if(file_content_array[idx].equals(t)) {
					System.out.println("We found it!");
						done=true;
				}
			}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try {
			BufferedReader bufferReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String file_content = bufferReader.readLine();
			char file_content_array[] = file_content.toCharArray();			
			boolean in_word = false;
			int count=0;
			for(char c:file_content_array) {
				if(c ==' ') 
				{
					if (!in_word) {	count++; in_word =true;	}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found " + file_content_array.length);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains(null))
		{
			System.out.println("No argument or wrong argument passed");							
		}
		else
		{
			System.out.println("No argument or wrong argument passed");							
		}
	}
}