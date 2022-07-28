import java.util.Scanner;
import java.util.ArrayList;

public class Admin extends Person{
	static Scanner input = new Scanner(System.in);
	
	public Admin(String id, String name, String pass) {
		super(id, name, pass);
	}
	
	
	public static void login(ArrayList<Admin> admins, ArrayList<Student> students, ArrayList<Librarian> librarians) {
		System.out.print(admins.get(0).id + "Enter your id: ");
		String id = input.next();
		
		
		boolean found = false;
		
		for(Admin admin : admins) {
			System.out.println(admin.getId().equals(id));
			if(!admin.getId().equals(id)) continue;
			
			found = true;
			System.out.print("Enter your password: ");
			String pass = input.next();
			
			while(admin.getPass().equals(pass)) {
				System.out.println("Wrong password, please try again.\n Enter your password: ");
				pass = input.next();
			}
			break;
		}
		
		if(!found) {
			System.out.printf("user id %s not found", id);
			return;
		}

		int op;
		
		while(true) {
			print_ops();
			op = input.nextInt();
			
			if(op > 7 || op < 0) {
				System.out.print("Please enter a valid input");
				continue;
			}
			
			if(op == 1) {
				add_student(students);
			}
			else if(op == 2) {
				remove_student(students);
			}
			else if(op == 3) {
				add_librarian(librarians);
			}
			else if(op == 4) {
				remove_librarian(librarians);
			}
			else if(op == 5) {
				add_admin(admins);
			}
			else if(op == 6) {
				remove_admin(admins);
			}
			else {
				System.out.println("loged out");
				return ;
			}
		}
		
		
	}
    
	
	private static void add_student(ArrayList<Student> students) {
		System.out.print("Enter your name: ");
		String name = input.next();
		
		while(!verify_name(name)) {
			System.out.print("Please enter a name with characters only: ");
			name = input.next();
		}
		
		System.out.print("Enter a unique id: ");
		String id = input.next();

		while(!verify_studentid(students, id)) {
			System.out.print("Please enter a unique id: ");
			id = input.next();
		}
		
		System.out.print("Please enter your phone number: ");
		String phone = input.next();
		

		System.out.print("Please enter your e-mail: ");
		String email = input.next();
		
		System.out.print("Please enter your birth date: ");
		String birth = input.next();
		
		// creating a new student
		Student student = new Student(name, id, birth, email, phone);
		
		// adding the student to the students table
		students.add(student);
		
	}
	
	
	private static void remove_student(ArrayList<Student> students) {
		System.out.print("Enter student id: ");
		String id = input.next();
		int student_idx=0;

		while(!verify_studentid(students, id)) {
			System.out.print("Please enter a correct id: ");
			id = input.next();
		}
		
		// removing a student from the students table
		for(Student student : students) {
			if(student.getId() == id) {
				break;
			}
			student_idx++;
		}
		students.remove(student_idx);
		System.out.println("Student removed succesfully.");
	}
	
	
	private static void add_librarian(ArrayList<Librarian> librarians) {
		System.out.print("Enter your name: ");
		String name = input.next();
		
		while(!verify_name(name)) {
			System.out.print("Please enter a name with characters only: ");
			name = input.next();
		}
		
		System.out.print("Enter a unique id: ");
		String id = input.next();

		while(!verify_libid(librarians, id)) {
			System.out.print("Please enter a unique id: ");
			id = input.next();
		}
		System.out.print("Enter a password: ");
		String password=input.next();
		
		
		// creating a new student
		Librarian librarian = new Librarian(id, name,password);
		
		// adding the student to the students table
		librarians.add(librarian);
		
	}
	
	
	private static void remove_librarian(ArrayList<Librarian> librarians) {
		System.out.print("Enter librarian id: ");
		String id = input.next();
		int librarian_idx=0;

		while(!verify_libid(librarians, id)) {
			System.out.print("Please enter a unique id: ");
			id = input.next();
		}
		
		// removing a student from the students table
		for(Librarian librarian : librarians) {
			if(librarian.getId() == id) {
				break;
			}
			librarian_idx++;
		}
		librarians.remove(librarian_idx);
		System.out.println("Librarian removed succesfully.");
	}
	
	private static void add_admin(ArrayList<Admin> admins) {
		System.out.print("Enter your name: ");
		String name = input.next();
		
		while(!verify_name(name)) {
			System.out.print("Please enter a name with characters only: ");
			name = input.next();
		}
		
		System.out.print("Enter a unique id: ");
		String id = input.next();

		while(!verify_admid(admins, id)) {
			System.out.print("Please enter a unique id: ");
			id = input.next();
		}
		System.out.print("Enter a password: ");
		String password=input.next();
		
		
		// creating a new student
		Admin admin = new Admin(id, name,password);
		
		// adding the student to the students table
		admins.add(admin);
		
	}
	
	
	private static void remove_admin(ArrayList<Admin> admins) {
		System.out.print("Enter Admin id: ");
		String id = input.next();
		int admin_idx=0;

		while(!verify_admid(admins, id)) {
			System.out.print("Please enter a correct id: ");
			id = input.next();
		}
		
		// removing a student from the students table
		for(Admin admin : admins) {
			if(admin.getId() == id) {
				break;
			}
			admin_idx++;
		}
		admins.remove(admin_idx);
		System.out.println("Admin removed succesfully.");
	}
	
	
	// a method to verify that the name contains letters and spaces only
	static boolean verify_name(String name) {
		for(int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i) ;
			if(!Character.isLetter(ch) && ch != ' ') return false;
		}
		
		return true;
	}

	
	// a method to verify that the name doesn't contain digits
	 static boolean verify_studentid(ArrayList<Student> students, String id) {
		for(Student student : students) {
			if(student.getId() == id) return false;
		}
		
		return true;
	}
	
	static boolean verify_libid(ArrayList<Librarian> librarians, String id) {
		for(Librarian librarian : librarians) {
			if(librarian.getId() == id) return false;
		}
		
		return true;
	}
	
	static boolean verify_admid(ArrayList<Admin> admins, String id) {
		for(Admin admin : admins) {
			if(admin.getId() == id) return false;
		}
		
		return true;
	}
	
	
	static void print_ops() {
		System.out.println("Choose an operation: ");
		System.out.println("1- add student");
		System.out.println("2- remove student");
		System.out.println("3- add librarian");
		System.out.println("4- remove librarian");
		System.out.println("5- add admin");
		System.out.println("6- remove admin");
		System.out.println("7- log out");
	}
}
