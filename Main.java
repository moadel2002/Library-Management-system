import java.util.ArrayList;
import java.util.Scanner;


class Main{

     public static void main(String[] args) {
    	 Scanner input = new Scanner(System.in);
    	 
    	 ArrayList<Admin> admins = new ArrayList<Admin>();
    	 ArrayList<Student> students = new ArrayList<Student>();
    	 ArrayList<Librarian> librarians = new ArrayList<>();
    	 ArrayList<Book> books = new ArrayList<Book>();
    	 ArrayList<Issuedbooks> issuedBooks = new ArrayList<Issuedbooks>();
    	 
    	 Read.read_admins(admins);
    	 Read.read_librarians(librarians);
    	 
    	 int op = 0;
    	 System.out.println("1- Admin Log in");
    	 System.out.println("2- Librarian Log in");
    	 System.out.println("3- Exit");
    	 op = input.nextInt();
    	 
    	 if(op == 1) {
    		 Admin.login(admins, students, librarians);
    	 }
    	 else if(op == 2) {
    		 Librarian.login(books, issuedBooks, librarians);
    	 }
    	 else {
    		 System.out.println("Exit Program");
    		 return;
    	 }
    	 
    	 Write.write_admins(admins);
    }
}