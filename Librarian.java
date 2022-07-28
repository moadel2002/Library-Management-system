import java.util.ArrayList;
import java.util.Scanner;
public class Librarian extends Person{

	static Scanner input = new Scanner(System.in);

	public Librarian(String id, String name, String pass) {
		super(id, name, pass);
	}
	
	public static void login(ArrayList<Book> books, ArrayList<Issuedbooks> issued_books, ArrayList<Librarian> librarians) {
		System.out.print("Enter your id: ");
		String id = input.next();
		

		System.out.print("Enter your password: ");
		String pass = input.next();
		
		boolean found = false;
		
		for(Librarian librarian: librarians) {
			if(librarian.getId() != id) continue;
			
			found = true;
			while(librarian.getPass() != pass) {
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
				add_book(books);
			}
			else if(op == 2) {
				remove_book(books);
			}
			else if(op == 3) {
				issue_book(issued_books, books);
			}
			else if(op == 4) {
				return_book(issued_books, books);
			}
			else if(op == 5) {
				view_books(books);
			}
			else if(op == 6) {
				view_issued_books(issued_books);
			}
			else if(op == 7) {
				search_for_book(books);
			}
			else {
				System.out.println("loged out");
				return ;
			}
		}
		
		
	}
	
	private static void add_book(ArrayList<Book> books) {
		System.out.print("Enter Book's name: ");
		String name = input.next();
		System.out.print("Enter a unique id: ");
		String id = input.next();

		while(!verify_book_id(books, id)) {
			System.out.print("Please enter a unique id: ");
			id = input.next();
		}
		System.out.print("Please enter Book's author: ");
		String author = input.next();
		
		System.out.print("Please enter Available quantity: ");
		int available_quantity = input.nextInt();
		
		// creating a new Book
		Book book = new Book(id,name,author,available_quantity,0);
		
		// adding the book to the books table
		books.add(book);
		
	}
	
	private static void remove_book(ArrayList<Book> books) {
		System.out.print("Enter book id: ");
		String id = input.next();
		int book_idx=0;

		while(!verify_book_id(books, id)) {
			System.out.print("Please enter a correct id: ");
			id = input.next();
		}
		
		// removing a student from the students table
		for(Book book: books) {
			if(book.getId() == id) {
				break;
			}
			book_idx++;
		}
		books.remove(book_idx);
		System.out.println("Admin removed succesfully.");
	}
	
	public static void view_books(ArrayList<Book> books) {
		for(Book book: books) {
			System.out.println(book.toString());
		}
	}

	public static void view_issued_books(ArrayList<Issuedbooks> books) {
		for(Issuedbooks book: books) {
			System.out.println(book.toString());
		}
	}
	
	public static boolean verify_book_id(ArrayList<Book> books, String id) {
		for(Book book : books) {
			if(book.getId() == id) return false;
		}
		
		return true;
	}
	
	
	public static void search_for_book(ArrayList<Book> books) {
		System.out.println("1- Search by id");
		System.out.println("2- Search by name");
		
		int op = input.nextInt();
		
		if(op == 1) {
			System.out.println("Enter id");
			String id = input.next();
			
			for(Book book : books) {
				if(book.getId() == id) {
					System.out.println(book.toString());
					break;
				}
			}
		}
		else {
			System.out.println("Enter name");
			String name = input.next();
			
			for(Book book : books) {
				if(book.getBookName() == name) {
					System.out.println(book.toString());
				}
			}
		}
	}
	
	public static void issue_book(ArrayList<Issuedbooks> issued_books, ArrayList<Book> books ) {
		System.out.print("Enter Book's ID: ");
		String id = input.next();

		while(!verify_book_id(books, id)) {
			System.out.print("Please enter a unique id: ");
			id = input.next();
		}
		
		for (Book book : books) {
			if (book.getId()==id) {
				book.setAvailable_quantity(book.getAvailable_quantity()-1);
				book.setIssued_quantitiy(book.getIssued_quantitiy()+1);
			}
		}
		System.out.print("Please enter Student's ID: ");
		String std_id = input.next();
		
		String pro_id= Integer.toString(issued_books.size()+1);
		
		// creating a new Book
		Issuedbooks issued = new Issuedbooks(id,pro_id,std_id,false);
		
		// adding the book to the books table
		issued_books.add(issued);
	}

	

	public static void return_book(ArrayList<Issuedbooks> issued_books, ArrayList<Book> books ) {
		System.out.print("Enter Book's ID: ");
		String id = input.next();

		while(!verify_book_id(books, id)) {
			System.out.print("Please enter a unique id: ");
			id = input.next();
		}
		
		for (Book book : books) {
			if (book.getId()==id) {
				book.setAvailable_quantity(book.getAvailable_quantity()+1);
				book.setIssued_quantitiy(book.getIssued_quantitiy()-1);
				break;
			}
		}

		int idx=0;
		for(int i = 0; i < issued_books.size(); i++) {
			if(issued_books.get(i).getBookid() == id) {
				idx = i;
				break;
			}
		}
		
		// remove the book to the books table
		issued_books.remove(idx);
	}

	
	public static void print_ops() {
		System.out.println("Choose an operation: ");
		System.out.println("1- add book");
		System.out.println("2- remove book");
		System.out.println("3- issue book");
		System.out.println("4- return book");
		System.out.println("5- view books");
		System.out.println("6- view issued books");
		System.out.println("7- search for a book");
		System.out.println("8- log out");
	}

}
