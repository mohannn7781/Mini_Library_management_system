import java.util.ArrayList;

class Book{
private final String bookId;
private String title;
private String author;
private boolean available;
public Book(String bookId,String title,String author){
    this.bookId=bookId;
    this.title=title;
    this.author=author;
    this.available=true;
}
public String getBookId(){
    return this.bookId;
}

public boolean issueBook(){
    if(!available){
        return false;
    }
    available=false;
    return true;

}
public boolean returnBook()
{
if(!available){
    available=true;
    return true;
}
else{
    return false;
}
}
public boolean isAvailable(){
    return available;

}

}
class Member {
    private String memberId;
    private String name;
    private final int borrowLimit;
    private ArrayList<Book> borrowedBooks;
    public Member(String memberId,String name){
        this.memberId=memberId;
        this.name=name;
        this.borrowLimit=3;
        borrowedBooks=new ArrayList<>();
    }
    public boolean borrowBook(Book book){
        if(borrowedBooks.size()<borrowLimit && !borrowedBooks.contains(book)){
        borrowedBooks.add(book);
        return true;
    }
    else{
        return false;
    }
}
public ArrayList<Book> getBorrowedBooks(){
    return borrowedBooks;
}
public boolean findBorrowedBooks(Book book)
{
    return borrowedBooks.contains(book);
}
public boolean returnBook(Book book){
    if(borrowedBooks.contains(book)){
        borrowedBooks.remove(book);
        return true;
    }
    else{
    return false;
    }
   }

public String getMemberId(){
    return memberId;
}
public String getName(){
    return name;
}
}

class Library{
    private ArrayList<Book> books;
    private ArrayList<Member> members;
    public Library(){
        books=new ArrayList<>();
        members=new ArrayList<>();
    }
    public void addBook(Book book){
        if(books.contains(book)){
            System.out.println("book exists");
        }
        else{
            books.add(book);
        }
    }
    public void addMember(Member member){
        if(members.contains(member)){
            System.out.println("already exists");
        }
        else{
            members.add(member);
        }
    }
     public Member findMember(String memberId){
        for (Member member : members) {
            if(member.getMemberId().equals(memberId)){
                return member;
            }
            
        }
        return null;
     }

    public void issueBook(String memberId,String bookId){
        Member member_Object;
        Book book_Object;
        // if(members.contains(memberId)){
        //    if(books.contains(bookId)){
            member_Object=findMember(memberId);
            if(member_Object==null){
                System.out.println("member not exists");
                return ;

            }
            book_Object=findBook(bookId);
            if(book_Object==null){
                System.out.println("book not found");
                return;
            }
            boolean book_Validation=book_Object.isAvailable();
            if(book_Validation==false){
                System.out.println("book currently unavailable!!");
                return;
            }
            
            boolean issued= book_Object.issueBook();
            if(issued){
                boolean member_validation=member_Object.borrowBook(book_Object);
                if(member_validation){
                System.out.println("request sucsessfull");
                return;
            }
                
            }
            System.out.println("Request Failed");
            
            
        }
    
public Book findBook(String bookId){
    for (Book book : books) {
        if(book.getBookId().equals(bookId)){
            return book;
        }   
    }
    return null;
}
    
public void returnBook(String memberId,String bookId){
            Member member_Object;
            Book book_Object;
            member_Object=findMember(memberId);
            if(member_Object==null){
                System.out.println("member not exists");
                return;
            }
            book_Object=findBook(bookId);
            if(book_Object==null){
                System.out.println("boook currently unavailable!!!");
                return;
            }
            boolean confirming_borrowList=member_Object.findBorrowedBooks(book_Object);
            if(confirming_borrowList==false){
                System.out.println("this book was not Borrowed");
                return;
            }

            boolean confirmingIssueList=book_Object.isAvailable();
            if(confirmingIssueList==true){
                System.out.println("this Book was not issued");
                return;
            }
            boolean bookRe= book_Object.returnBook();
            if(bookRe==false){
                System.out.println("Transaction failed");
                return;
            }
            boolean memberre= member_Object.returnBook(book_Object);
            if(memberre==false){
                System.out.println("Transaction failed");
                return;
            }
            System.out.println("Book was sussesfully returned");          
             
        }
    }
public class LibraryManagement {
    public static void main(String[] args) {
        
        Library library=new Library();
        
        Book b1=new Book("A101", "love in <3 ways", "Bodhidharma");
        Book b2=new Book("A102","learn Chinese in 3 days","paul");
        Book b3=new Book("A103","kirraak panda","not me");

        Member m1=new Member("771", "mahi");
        Member m2=new Member("772", "Jadeja");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.addMember(m1);
        library.addMember(m2);

        library.issueBook("772","A101");
        library.returnBook("772", "A101");
        
    }

}
