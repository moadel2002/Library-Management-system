
public class Book {
    private String bookId;
    private String bookName;
    private String authorName;
    private int available_quantity;
    private int issued_quantitiy;
    
    
    public Book(String bookId,String bookName , String authorName, int available_quantity,int issued_quantitiy){
    
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.available_quantity=available_quantity;
        this.issued_quantitiy = issued_quantitiy;
    
    }



    public String getId() {
        return this.bookId;
    }

    public void setId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getAvailable_quantity() {
        return this.available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public int getIssued_quantitiy() {
        return this.issued_quantitiy;
    }

    public void setIssued_quantitiy(int issued_quantitiy) {
        this.issued_quantitiy = issued_quantitiy;
    }


    


    

        
}
