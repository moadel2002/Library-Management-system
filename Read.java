import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;



public class Read {
	

	public static void read_librarians(ArrayList<Librarian> librarians) {
		String file_name = "./data_files/librarians.csv";
		
		try {
			File librarians_file = new File(file_name);
			
			
			Scanner input = new Scanner(librarians_file);
			while(input.hasNextLine()) {
				String line = input.nextLine();
				
				
				Librarian librarian = create_librarian(line);
				
				librarians.add(librarian);
			}
			
			input.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Can't find file " + file_name);
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
	}
	
	public static void read_admins(ArrayList<Admin> admins) {
		String file_name = "./data_files/admins.csv";
		
		try {
			File admins_file = new File(file_name);
			
			
			Scanner input = new Scanner(admins_file);
			while(input.hasNextLine()) {
				String line = input.nextLine();
				
				
				Admin admin = create_admin(line);
				
				admins.add(admin);
			}
			
			input.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Can't find file " + file_name);
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
	}

	
	public static Admin create_admin(String line) {
		String[] data = line.split(","); 		
		return new Admin(data[0], data[1], data[2]);
	}
	
	public static Librarian create_librarian(String line) {
		String[] data = line.split(","); 		
		return new Librarian(data[0], data[1], data[2]);
	}
	
}
