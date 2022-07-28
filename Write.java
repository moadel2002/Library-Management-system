import java.io.File;
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;
import java.util.ArrayList;

public class Write {
	public static void write_admins(ArrayList<Admin> admins) {
		String file_name = "./data_files/admins.csv";
		
		try {
			FileWriter admins_file = new FileWriter(file_name);
			
			
			for(Admin admin : admins) {
				String line = createLine(admin);
				admins_file.write(line);
			}
			
			admins_file.close();
		} 
		catch (IOException e) {
			System.out.println("Can't find file " + file_name);
		      System.out.println("An error occurred.");
		      e.printStackTrace();
	    }
	}
	
	
	static String createLine(Admin admin) {
		return new String(admin.getId() + ", " + admin.getName() + ", " + admin.getPass() + "\n");
	}
}
