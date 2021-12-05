import java.io.*;
import java.util.*;
import java.text.*;

public class StudentList {
	public static void main(String[] args) {
		try (BufferedReader scanner = new BufferedReader(new InputStreamReader(new FileInputStream(C.FILENAME)))) {
			String students = scanner.readLine();
			String[] studentlist = students.split(", ");
			for (int len = 0; len < args.length; ++len) {
				if (args[len].equals("a")) {
					System.out.println(C.LOADING);
					for (String studentName : studentlist) {
						System.out.println(studentName);
					}
					System.out.println(C.LOADED);
				} else if (args[len].equals("r")) {
					System.out.println(C.LOADING);
					Random rand = new Random(System.currentTimeMillis());
					int id = rand.nextInt(0, 4);
					System.out.println(studentlist[id]);
					System.out.println(C.LOADED);
				} else if (args[len].contains("+")) {
					add(args[len]);
				} else if (args[len].contains("?")) {
					System.out.println(C.LOADING);
					String newStudent = args[len].substring(1);
					for (int id = 0; id < studentlist.length; ++id) {
						if (studentlist[id].contains(newStudent)) {
							System.out.println(C.FOUND);
							break;
						}
					}
					System.out.println(C.LOADED);
				} else if (args[len].contains("c")) {
					System.out.println(C.LOADING);
					System.out.println(studentlist.length + " word(s) found");
					System.out.println(C.LOADED);
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Argument");
		}
	}

	static void add(String str) {
		try (BufferedWriter bout = new BufferedWriter(new FileWriter(C.FILENAME, true))) {
			System.out.println(C.LOADING);
			String newStudent = str.substring(1);
			Date d = new Date();
			String df = "dd/mm/yyyy-hh:mm:ss a";
			DateFormat dateFormat = new SimpleDateFormat(df);
			String fd = dateFormat.format(d);
			bout.write("," + newStudent + "\nList last updated on " + fd);
			System.out.println(C.LOADED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}